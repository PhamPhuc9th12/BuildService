package org.example.buildapp.app.rest;

import org.example.buildapp.app.api.GroupSalaryColumnsApi;
import org.example.buildapp.app.dto.request.GroupSalaryColumnUpdateRequest;
import org.example.buildapp.app.dto.request.GroupSalaryColumnsCreateRequest;
import org.example.buildapp.app.dto.response.GroupSalaryColumnResponse;
import org.example.buildapp.core.service.GroupSalaryColumnService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/group-salary")
public class GroupSalaryColumnController implements GroupSalaryColumnsApi {

    private final GroupSalaryColumnsApi groupSalaryColumnService;

    @Override
    public void createGroupColumnsType( GroupSalaryColumnsCreateRequest groupSalaryColumnsCreateRequest) {
        groupSalaryColumnService.createGroupColumnsType(groupSalaryColumnsCreateRequest);
    }

    @Override
    public Page<GroupSalaryColumnResponse> getListGroupSalaryResponse(String name, String code, Pageable pageable) {
        return groupSalaryColumnService.getListGroupSalaryResponse(name,code,pageable);
    }

    @Override
    public void updateGroupColumnsType(GroupSalaryColumnUpdateRequest groupSalaryColumnUpdateRequest, Long columId) {
        groupSalaryColumnService.updateGroupColumnsType(groupSalaryColumnUpdateRequest,columId);
    }

    @Override
    public void deleteGroupColumnSalary(Long columnId) {
        groupSalaryColumnService.deleteGroupColumnSalary(columnId);
    }

    @Override
    public GroupSalaryColumnResponse getColumnById(Long columnId) {
        return groupSalaryColumnService.getColumnById(columnId);
    }


}
