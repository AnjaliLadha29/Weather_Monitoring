import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class UIAdd
{
    public void add(String s, String s1, Double d, int i, int i1, Double d1, Double d2, Double d3, Double d4)
    {
        String sql = "INSERT INTO weather_records (city, weather, temperaturek, temperaturec, humidity, wind_speed, min_temp, max_temp, avg_temp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseHelper.getConnection(); PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1,s);
            ps.setString(2,s1);
            ps.setDouble(3,d);
            ps.setInt(4,i);
            ps.setInt(5,i1);
            ps.setDouble(6,d1);
            ps.setDouble(7,d2);
            ps.setDouble(8,d3);
            ps.setDouble(9,d4);
            ps.addBatch();
            ps.executeUpdate();
            System.out.println("Weather records inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
class DatabaseHelper {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/weather_records";
        String user = "";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}
