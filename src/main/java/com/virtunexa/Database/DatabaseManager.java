package com.virtunexa.Database;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:h2:file:./data/binaryconverterdb;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS conversion_history ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "username VARCHAR(255), "
                + "binary_input VARCHAR(255), "
                + "decimal_result INT, "
                + "conversion_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ");";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertConversion(String username, String binaryInput, int decimalResult) {
        String insertSQL = "INSERT INTO conversion_history (username, binary_input, decimal_result) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, username);
            pstmt.setString(2, binaryInput);
            pstmt.setInt(3, decimalResult);
            pstmt.executeUpdate();
            System.out.println("Conversion record inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showConversionHistory() {
        String query = "SELECT * FROM conversion_history ORDER BY conversion_date DESC";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("----- Conversion History -----");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String binary = rs.getString("binary_input");
                int decimal = rs.getInt("decimal_result");
                String conversionDate = rs.getString("conversion_date");

                System.out.printf("ID: %d | User: %s | Binary: %s | Decimal: %d | Date: %s%n",
                        id, username, binary, decimal, conversionDate);
            }
            System.out.println("------------------------------");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
