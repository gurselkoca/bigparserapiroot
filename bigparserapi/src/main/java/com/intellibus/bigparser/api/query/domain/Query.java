package com.intellibus.bigparser.api.query.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
public class Query {

        private GlobalFilterContainer globalFilter;

        private ColumnFilterContainer columnFilter;
        private  FiltersJoinOperator globalColumnFilterJoinOperator = FiltersJoinOperator.OR;

        private Set<Integer> selectColumnIndexes = new HashSet<>();

        private Set<String> selectColumnNames = new HashSet<>();

        private Map<String, SortOrder> sort = new HashMap<>();

        private Pagination pagination;

        private boolean sendRowIdsInResponse =false;

        private boolean showColumnNamesInResponse = true;






}
