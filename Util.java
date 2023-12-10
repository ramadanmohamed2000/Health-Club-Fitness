package HealthAndFitnessClub;

import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Util {
	public static void populateTable(JTable table, Map<String, List<String>> dataMap) {
        DefaultTableModel model = new DefaultTableModel();

        // Set the model to the table
        table.setModel(model);

        // Add columns to the model with column identifiers (column names)
        for (String columnName : dataMap.keySet()) {
            model.addColumn(columnName);
        }

        // Add rows to the model
        int rowCount = dataMap.values().stream().findFirst().orElse(List.of()).size();
        for (int i = 0; i < rowCount; i++) {
            Object[] rowData = new Object[dataMap.size()];
            int j = 0;
            for (List<String> columnValues : dataMap.values()) {
                rowData[j++] = columnValues.get(i);
            }
            model.addRow(rowData);
        }
        
        // Set column names (column identifiers) in the table headers
        for (int i = 0; i < model.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(model.getColumnName(i));
        }
    }
}
