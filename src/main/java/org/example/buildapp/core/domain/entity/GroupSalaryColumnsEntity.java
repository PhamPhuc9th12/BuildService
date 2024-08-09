package org.example.buildapp.core.domain.entity;

import lombok.*;
import org.example.buildapp.core.domain.enums.GroupColumnTypeEnums;

import javax.persistence.*;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "group_salary_columns")
public class GroupSalaryColumnsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String code;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private GroupColumnTypeEnums groupColumnType;
    private Long branchId;
    private OffsetDateTime createdAt;
    private Long createdBy;
    private OffsetDateTime updatedAt;
    private Long updatedBy;
}
