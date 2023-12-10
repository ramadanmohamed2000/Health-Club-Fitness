package HealthAndFitnessClub;

import java.sql.*;
import java.util.*;
public class DatabaseManager {
    private Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/fitness-club"; // Replace with your database URL
    private final String user = "postgres"; // Replace with your username
    private final String password = "root"; // Replace with your password

    public DatabaseManager() {
        try {
            // Establishing the database connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL database!");
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection to the PostgreSQL database closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example method to execute a SQL query
    public Map<String, String> executeQuery(String sqlQuery) {
        Map<String, String> resultMap = new HashMap<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Retrieve metadata to get column names
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Process the ResultSet or do something with the data
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = resultSet.getMetaData().getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    resultMap.put(columnName, columnValue);
                }
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultMap;
    }
    public Map<String, List<String>> executeQueryAsKeyAndArray(String sqlQuery) {
        Map<String, List<String>> resultMap = new HashMap<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = resultSet.getMetaData().getColumnName(i);
                    String columnValue = resultSet.getString(i);

                    // Check if the key already exists in the resultMap
                    if (!resultMap.containsKey(columnName)) {
                        resultMap.put(columnName, new ArrayList<>());
                    }
                    resultMap.get(columnName).add(columnValue);
                }
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultMap;
    }
    public boolean isLoginExist(String tableName, String email, String password) {
        boolean loginExists = false;
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName + " WHERE Email = '" + email + "' AND Password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                // If a row is found, the login credentials exist
                loginExists = true;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginExists;
    }

    
    // Example method to execute an update (INSERT, UPDATE, DELETE)
    public int executeUpdate(String sqlUpdate) {
        try {
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(sqlUpdate);

            System.out.println(rowsAffected + " row(s) affected.");

            statement.close();
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();

        // Example usage:
        dbManager.executeQuery("SELECT * FROM member");

        dbManager.closeConnection();
    }
}
