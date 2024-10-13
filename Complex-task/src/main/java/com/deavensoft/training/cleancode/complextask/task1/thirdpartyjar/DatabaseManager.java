package com.deavensoft.training.cleancode.complextask.task1.thirdpartyjar;

import java.util.List;

public interface DatabaseManager {


    List<DataSet> getTableData(String tableName);

}