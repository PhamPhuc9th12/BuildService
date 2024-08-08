package org.example.buildapp.core.service;

import org.example.buildapp.app.api.GroupSalaryColumnsApi;
import org.example.buildapp.app.dto.request.GroupSalaryColumnUpdateRequest;
import org.example.buildapp.app.dto.request.GroupSalaryColumnsCreateRequest;
import org.example.buildapp.app.dto.response.GroupSalaryColumnResponse;
import org.example.buildapp.core.domain.constant.ErrorCode;
import org.example.buildapp.core.domain.entity.GroupSalaryColumnsEntity;
import org.example.buildapp.core.port.mapper.GroupSalaryCoumnMapper;
import org.example.buildapp.core.port.repository.GroupSalaryColumnRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Objects;

@Service
@AllArgsConstructor
public class GroupSalaryColumnService implements GroupSalaryColumnsApi {
    private final GroupSalaryCoumnMapper groupSalaryCoumnMapper;
    private final GroupSalaryColumnRepository groupSalaryColumnRepository;
    @Override
    @Transactional
    public void createGroupColumnsType(GroupSalaryColumnsCreateRequest groupSalaryColumnsCreateRequest) {
        checkSameRecordCreate(groupSalaryColumnsCreateRequest);
        GroupSalaryColumnsEntity groupSalaryColumnsEntity = groupSalaryCoumnMapper
                .getGroupSalaryColumnEntityBy(groupSalaryColumnsCreateRequest);

        groupSalaryColumnsEntity.setCreatedAt(OffsetDateTime.now());
        groupSalaryColumnRepository.save(groupSalaryColumnsEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GroupSalaryColumnResponse> getListGroupSalaryResponse(String name, String code, Pageable pageable) {
        Page<GroupSalaryColumnResponse> groupSalaryColumnResponsePage = null;
        if(Objects.nonNull(name) || Objects.nonNull(code)){
            Page<GroupSalaryColumnsEntity> groupSalaryColumnsEntitiesSearch = groupSalaryColumnRepository
                    .findAllByNameOrCode(name,code,pageable);
            groupSalaryColumnResponsePage = getListGroup(groupSalaryColumnsEntitiesSearch);
        }else{
            Page<GroupSalaryColumnsEntity> groupSalaryColumnsEntities = groupSalaryColumnRepository.findAll(pageable);
            groupSalaryColumnResponsePage = getListGroup(groupSalaryColumnsEntities);
        }

        return groupSalaryColumnResponsePage;
    }

    @Override
    @Transactional
    public void updateGroupColumnsType(GroupSalaryColumnUpdateRequest groupSalaryColumnUpdateRequest, Long id) {
        checkSameRecordUpdate(groupSalaryColumnUpdateRequest);
        GroupSalaryColumnsEntity groupSalaryColumnsEntity = groupSalaryColumnRepository.findById(id).orElseThrow(
                () -> new RuntimeException(ErrorCode.NOT_FOUND)
        );
        groupSalaryCoumnMapper.updateGroupSalaryColumns(groupSalaryColumnsEntity,groupSalaryColumnUpdateRequest);

        groupSalaryColumnsEntity.setUpdatedAt(OffsetDateTime.now());
        groupSalaryColumnRepository.save(groupSalaryColumnsEntity);
    }

    @Override
    @Transactional
    public void deleteGroupColumnSalary(Long columnId) {
        GroupSalaryColumnsEntity groupSalaryColumnsEntity =  groupSalaryColumnRepository.findById(columnId).orElseThrow(
                () -> new RuntimeException(ErrorCode.NOT_FOUND)
        );
        if(Objects.nonNull(groupSalaryColumnsEntity)) groupSalaryColumnRepository.deleteById(columnId);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupSalaryColumnResponse getColumnById(Long columnId) {
        GroupSalaryColumnsEntity groupSalaryColumnsEntity =  groupSalaryColumnRepository.findById(columnId).orElseThrow(
                () -> new RuntimeException(ErrorCode.NOT_FOUND)
        );
        return groupSalaryCoumnMapper.getResponseGroupSalaryBy(groupSalaryColumnsEntity);
    }

    private void checkSameRecordCreate(GroupSalaryColumnsCreateRequest groupSalaryColumnsCreateRequest){
        if(Boolean.TRUE.equals(groupSalaryColumnRepository.
                existsByNameContainingIgnoreCaseOrCodeContainingIgnoreCase(
                        groupSalaryColumnsCreateRequest.getName(),
                        groupSalaryColumnsCreateRequest.getCode()
                )
        )) throw new RuntimeException(ErrorCode.SAME_RECORD);
    }
    private void checkSameRecordUpdate(GroupSalaryColumnUpdateRequest groupSalaryColumnUpdateRequest){
        if(Boolean.TRUE.equals(groupSalaryColumnRepository.
                existsByNameContainingIgnoreCaseAndCodeContainingIgnoreCase(
                        groupSalaryColumnUpdateRequest.getName(),
                        groupSalaryColumnUpdateRequest.getCode()
                )
        )) throw new RuntimeException(ErrorCode.SAME_RECORD);
    }
    private Page<GroupSalaryColumnResponse> getListGroup(Page<GroupSalaryColumnsEntity> groupSalaryColumnsEntities){
        if(Boolean.TRUE.equals(groupSalaryColumnsEntities.isEmpty())) throw new RuntimeException(ErrorCode.NOT_FOUND);
        return groupSalaryColumnsEntities.map(groupSalaryCoumnMapper::getResponseGroupSalaryBy);
    }
}
