CREATE TABLE group_salary_columns
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    code              VARCHAR(50)  NOT NULL,
    name              VARCHAR(255) NOT NULL,
    description       TEXT,
    group_column_type varchar(50),
    branch_id         BIGINT,
    created_at        TIMESTAMP,
    created_by        BIGINT,
    updated_at        TIMESTAMP,
    updated_by        BIGINT
);