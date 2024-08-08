package org.example.buildapp.core.port.mapper;

import org.example.buildapp.app.dto.request.GroupSalaryColumnUpdateRequest;
import org.example.buildapp.app.dto.request.GroupSalaryColumnsCreateRequest;
import org.example.buildapp.app.dto.response.GroupSalaryColumnResponse;
import org.example.buildapp.core.domain.entity.GroupSalaryColumnsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface GroupSalaryCoumnMapper {

    GroupSalaryColumnsEntity getGroupSalaryColumnEntityBy(GroupSalaryColumnsCreateRequest groupSalaryColumnsCreateRequest);

    GroupSalaryColumnResponse getResponseGroupSalaryBy(GroupSalaryColumnsEntity groupSalaryColumnsEntity);

    void updateGroupSalaryColumns(@MappingTarget GroupSalaryColumnsEntity groupSalaryColumnsEntity,
                                  GroupSalaryColumnUpdateRequest groupSalaryColumnUpdateRequest);
}
