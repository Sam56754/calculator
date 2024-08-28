/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator2;

/**
 *
 * @author silver
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculationHistory {

    public static void saveCalculation(int num1, String operand, int num2, long result) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            String sql = "INSERT INTO calculations (num_1, operand, num_2, result) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, num1);
                statement.setString(2, operand);
                statement.setInt(3, num2);
                statement.setLong(4, result);

                statement.executeUpdate();
                System.out.println("Calculation saved to history.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
