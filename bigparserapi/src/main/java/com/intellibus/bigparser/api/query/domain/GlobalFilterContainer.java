package com.intellibus.bigparser.api.query.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class GlobalFilterContainer {

    private Set<ColumnFilter> filters = new HashSet<>();

    private FiltersJoinOperator filtersJoinOperator=FiltersJoinOperator.OR;

}
