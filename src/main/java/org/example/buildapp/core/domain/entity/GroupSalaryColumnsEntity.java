package org.example.buildapp.core.domain.entity;

import lombok.*;

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
    private String groupColumnType;
    private Long branchId;
    private OffsetDateTime createdAt;
    private Long createdBy;
    private OffsetDateTime updatedAt;
    private Long updatedBy;
}
