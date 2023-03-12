package com.intellibus.bigparser.api.query.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ColumnFilter {
    private ColumnOperator operator = ColumnOperator.LIKE;
    @NonNull
    private String keyword;

    @NonNull
    private String column;
}
