package com.deavensoft.training.cleancode_solutions.complextask.task1.thirdpartyjar;

import java.util.List;

public interface DataSet {
    void put(String columnName, Object value);

    List<String> getColumnNames();

    List<Object> getValues();

}