package com.deavensoft.training.cleancode_solutions.complextask.task1;

import com.deavensoft.training.cleancode_solutions.complextask.task1.thirdpartyjar.Command;
import com.deavensoft.training.cleancode_solutions.complextask.task1.thirdpartyjar.DataSet;
import com.deavensoft.training.cleancode_solutions.complextask.task1.thirdpartyjar.DatabaseManager;
import com.deavensoft.training.cleancode_solutions.complextask.task1.thirdpartyjar.View;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;


public class TablePrinter implements Command {
    private final View view;
    private final DatabaseManager manager;
    private String tableName;

    TablePrinter(View view, DatabaseManager manager) {
        this.view = view;
        this.manager = manager;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("print ");
    }

    @Override
    public void process(String input) {
        String[] command = input.split(" ");
        checkInputArguments(command);
        tableName = command[1];
        view.write(createTable());
    }

    private void checkInputArguments(String[] command) {
        if (command.length != 2) {
            throw new IllegalArgumentException("incorrect number of parameters. Expected 1, but is " + (command.length - 1));
        }
    }

    private String createTable() {
        List<DataSet> tableDataSetList = manager.getTableData(tableName);
        int maxColumnSize;

        Table table = new Table();
        table.setTableData(tableDataSetList);
        maxColumnSize = table.calculateTableMaxSize(table);
        table.setMaxColumnSize(maxColumnSize);
        table.setRowsCount(tableDataSetList.size());

        return printTable(table);
    }

    private String printTable(Table table) {
        if (table.getMaxColumnSize() == 0) {
            return buildEmptyTable(tableName);
        } else {
            table.setColumnCountFromDataSet(table);
            return buildNotEmptyTable(table);
        }

    }

    private String buildNotEmptyTable(Table table) {
        List<String> columnNames = table.getColumnNames();
        return printUpperBorder(table) + printValues(columnNames, table) + printMediumBorder(table) + iterateRows(table);
    }

    private String iterateRows(Table table) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < table.getRowsCount(); i++) {
            List<String> values = new ArrayList<>();
            List<Object> rowList = table.getTableData().get(i).getValues();
            rowList.forEach(value -> values.add(value.toString()));
            result.append(printValues(values, table));

            if (i < table.getRowsCount() - 1) {
                result.append(printMediumBorder(table));

            } else {
                result.append(printLowerBorder(table));
            }
        }

        return result.toString();
    }

    private String buildEmptyTable(String tableName) {
        String textEmptyTable = "║ Table '" + tableName + "' is empty or does not exist ║";
        String line = getHorizontalBorderLine(textEmptyTable.length() - 2);
        return String.format("╔%s╗\n%s\n╚%s╝\n", line, textEmptyTable, line);
    }

    private String printValues(List<String> valueList, Table table) {
        int maxColumnSize = table.getMaxColumnSize();
        maxColumnSize = getAdditionalSpaceForOddorEvenSize(maxColumnSize);

        List<String> stringValueList = new ArrayList<>();

        for (String value : valueList) {
            int columnNamesLength = value.length();
            int indentSize = (maxColumnSize - columnNamesLength) / 2;
            String indentBeforeValue = getIndent(indentSize);
            String indentAfterValue = getIndent(indentSize);

            if (columnNamesLength % 2 != 0) {
                indentAfterValue = getIndent(indentSize + 1);
            }

            stringValueList.add(String.format("%s%s%s", indentBeforeValue, value, indentAfterValue));
        }

        return stringValueList.stream().collect(joining("║", "║", "║\n"));
    }

    private String printUpperBorder(Table table) {
        String horizontalBorderLineWithDelimeter = getHorizontalBorderLineWithDelimeter(table, "╦");

        return String.format("╔%s╗\n", horizontalBorderLineWithDelimeter);
    }

    private String printMediumBorder(Table table) {
        String result = null;

        if (!table.getTableData().isEmpty()) {
            String horizontalBorderLineWithMediumDelimeter = getHorizontalBorderLineWithDelimeter(table, "╬");
            result = String.format("╠%s╣\n", horizontalBorderLineWithMediumDelimeter);
        }

        return result;
    }

    private String printLowerBorder(Table table) {
        String horizontalBorderLineWithLowerDelimeter = getHorizontalBorderLineWithDelimeter(table, "╩");
        return String.format("╚%s╝\n", horizontalBorderLineWithLowerDelimeter);
    }

    private String getIndent(int indentSize) {
        return " ".repeat(Math.max(0, indentSize));
    }

    private String getHorizontalBorderLineWithDelimeter(Table table, String delimeterSymbol) {
        StringBuilder lineWithDelimeter = new StringBuilder();
        int maxColumnSize = table.getMaxColumnSize();
        int columnCount = table.getColumnCount();

        maxColumnSize = getAdditionalSpaceForOddorEvenSize(maxColumnSize);

        for (int j = 1; j < columnCount; j++) {
            lineWithDelimeter.append(getHorizontalBorderLine(maxColumnSize)).append(delimeterSymbol);
        }

        lineWithDelimeter.append(getHorizontalBorderLine(maxColumnSize));
        return lineWithDelimeter.toString();
    }

    private int getAdditionalSpaceForOddorEvenSize(int maxColumnSize) {
        if (maxColumnSize % 2 == 0) {
            maxColumnSize += 2;
        } else {
            maxColumnSize += 3;
        }

        return maxColumnSize;
    }

    private String getHorizontalBorderLine(int lenght) {
        return "═".repeat(Math.max(0, lenght));
    }
}
