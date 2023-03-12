package com.intellibus.bigparser.api.query.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pagination {

    private int startRow;
    private int rowCount;
}
