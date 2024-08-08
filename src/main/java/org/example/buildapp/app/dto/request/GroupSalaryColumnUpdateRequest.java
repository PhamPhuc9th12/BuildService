package org.example.buildapp.app.dto.request;

import org.example.buildapp.core.domain.constant.ErrorCode;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GroupSalaryColumnUpdateRequest {
    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\S*$", message = "Username must not contain whitespace")
    @Size(max = 50, message = ErrorCode.MORE_THAN_FIFTY_CHARACTER)
    private String code;

    @Size(min = 5, message = ErrorCode.MORE_THAN_FIVE_CHARACTER)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = ErrorCode.IS_SPECIAL_CHARACTER)
    private String name;
    private String description;
    @NotNull
    private String groupColumnType;
}
