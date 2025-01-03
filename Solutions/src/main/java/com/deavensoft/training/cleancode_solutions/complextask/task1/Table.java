package com.deavensoft.training.cleancode_solutions.complextask.task1;

import com.deavensoft.training.cleancode_solutions.complextask.task1.thirdpartyjar.DataSet;
import java.util.List;

class Table {
    private int maxColumnSize;
    private int columnCount;
    private List<DataSet> tableData;
    private int rowsCount;

    int getRowsCount() {
        return rowsCount;
    }

    void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }

    int getMaxColumnSize() {
        return maxColumnSize;
    }

    void setMaxColumnSize(int maxColumnSize) {
        this.maxColumnSize = maxColumnSize;
    }

    int getColumnCount() {
        return columnCount;
    }

    List<DataSet> getTableData() {
        return tableData;
    }

    void setTableData(List<DataSet> tableData) {
        this.tableData = tableData;
    }

    void setColumnCountFromDataSet(Table table) {
        this.columnCount = table.getTableData().get(0).getColumnNames().size();
    }

    List<String> getColumnNames() {
        return getTableData().get(0).getColumnNames();
    }

    int calculateTableMaxSize(Table table) {
        int columnMaxLength = 0;
        int valueMaxLenght = 0;

        if (isNotEmptyTable(table)) {
            columnMaxLength = getColumnNameMaxLength(table);
            valueMaxLenght = getValueMaxLength(table);
        }

        return compareResults(columnMaxLength, valueMaxLenght);
    }

    private int getColumnNameMaxLength(Table table) {
        int maxLength = 0;

        for (String columnName : table.getTableData().getFirst().getColumnNames()) {

            if (columnName.length() > maxLength) {
                maxLength = columnName.length();
            }
        }

        return maxLength;
    }

    private int getValueMaxLength(Table table) {
        int maxLength = 0;

        for (Object value : table.getTableData().get(0).getValues()) {

            if (String.valueOf(value).length() > maxLength) {
                maxLength = String.valueOf(value).length();
            }
        }

        return maxLength;
    }

    private int compareResults(int columnMaxLength, int valueMaxLenght) {
        return Math.max(columnMaxLength, valueMaxLenght);
    }

    private boolean isNotEmptyTable(Table table) {
        return !table.getTableData().isEmpty();
    }
}
