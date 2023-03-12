package com.intellibus.bigparser.api.query.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class GlobalFilter {
    private GlobalOperator operator= GlobalOperator.LIKE;
    @NonNull
    private String keyword;
}
