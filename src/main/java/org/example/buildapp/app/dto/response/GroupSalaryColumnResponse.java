package org.example.buildapp.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupSalaryColumnResponse {
    private Long id ;
    private String code;
    private String name;
    private String description;
    private String groupColumnType;
    private OffsetDateTime createdAt;
}
