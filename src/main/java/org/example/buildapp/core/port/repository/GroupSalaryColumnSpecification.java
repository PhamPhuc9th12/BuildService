package org.example.buildapp.core.port.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.buildapp.core.domain.common.SearchCriteria;
import org.example.buildapp.core.domain.entity.GroupSalaryColumnsEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
@AllArgsConstructor
@NoArgsConstructor
public class GroupSalaryColumnSpecification implements Specification<GroupSalaryColumnsEntity> {
   private SearchCriteria searchCriteria;
    @Override
    public Predicate toPredicate(Root<GroupSalaryColumnsEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (searchCriteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(criteriaBuilder.lower(
                        root.<String>get(searchCriteria.getKey())), "%" +
                        searchCriteria.getValue().toLowerCase() + "%");
            } else {
                return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
        return null;
    }
}
