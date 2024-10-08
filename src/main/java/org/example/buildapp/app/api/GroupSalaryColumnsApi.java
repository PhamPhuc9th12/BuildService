package org.example.buildapp.app.api;

import org.example.buildapp.app.dto.request.GroupSalaryColumnUpdateRequest;
import org.example.buildapp.app.dto.request.GroupSalaryColumnsCreateRequest;
import org.example.buildapp.app.dto.response.GroupSalaryColumnResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface GroupSalaryColumnsApi {
    @PostMapping("/create")
    @Operation(summary = "Create new group salary column type ")
    void createGroupColumnsType( @Valid @RequestBody GroupSalaryColumnsCreateRequest groupSalaryColumnsCreateRequest);

    @GetMapping("/list")
    @Operation(summary = "Get list group salary column type ")
    Page<GroupSalaryColumnResponse> getListGroupSalaryResponse(@RequestParam(required = false) String name,
                                                               @RequestParam(required = false) String code,
                                                               @ParameterObject Pageable pageable);

    @PutMapping("/update")
    @Operation(summary = "Update group column type")
    void updateGroupColumnsType(@RequestBody @Valid GroupSalaryColumnUpdateRequest groupSalaryColumnUpdateRequest,
                                @RequestParam Long columId);

    @DeleteMapping("/delete")
    @Operation(summary = "Delete group salary column")
    void deleteGroupColumnSalary(@RequestParam Long columnId);

    @GetMapping("/column/id")
    @Operation(summary = "Get column salary by id")
    GroupSalaryColumnResponse getColumnById(@RequestParam Long columnId);
}
