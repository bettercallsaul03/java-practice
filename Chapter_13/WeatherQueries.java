import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeatherQueries {


    public void printWeatherInfoByRegion(String regionName) {
        String sql = "SELECT w.date, w.temperature, w.precipitation " +
                "FROM weather w " +
                "JOIN regions r ON w.region_id = r.id " +
                "WHERE r.name = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, regionName);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Сведения о погоде в регионе '" + regionName + "':");
            while (rs.next()) {
                String date = rs.getString("date");
                double temperature = rs.getDouble("temperature");
                String precipitation = rs.getString("precipitation");
                System.out.println("Дата: " + date + ", Температура: " + temperature + "°C, Осадки: " + precipitation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void printSnowDates(String regionName, double maxTemperature) {
        String sql = "SELECT date " +
                "FROM weather w " +
                "JOIN regions r ON w.region_id = r.id " +
                "WHERE r.name = ? AND w.precipitation = 'снег' AND w.temperature < ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, regionName);
            stmt.setDouble(2, maxTemperature);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Даты, когда в регионе '" + regionName + "' был снег и температура ниже " + maxTemperature + "°C:");
            while (rs.next()) {
                String date = rs.getString("date");
                System.out.println(date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void printWeatherInfoByLanguage(String language) {
        String sql = "SELECT w.date, w.temperature, w.precipitation, r.name " +
                "FROM weather w " +
                "JOIN regions r ON w.region_id = r.id " +
                "JOIN population_types pt ON r.population_type_id = pt.id " +
                "WHERE pt.language = ? AND w.date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, language);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Информация о погоде за прошедшую неделю в регионах, где жители общаются на языке '" + language + "':");
            while (rs.next()) {
                String regionName = rs.getString("name");
                String date = rs.getString("date");
                double temperature = rs.getDouble("temperature");
                String precipitation = rs.getString("precipitation");
                System.out.println("Регион: " + regionName + ", Дата: " + date + ", Температура: " + temperature + "°C, Осадки: " + precipitation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void printAverageTemperatureByArea(double minArea) {
        String sql = "SELECT r.name, AVG(w.temperature) AS avg_temperature " +
                "FROM weather w " +
                "JOIN regions r ON w.region_id = r.id " +
                "WHERE r.area > ? AND w.date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) " +
                "GROUP BY r.name";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, minArea);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Средняя температура за прошедшую неделю в регионах с площадью больше " + minArea + " кв. км:");
            while (rs.next()) {
                String regionName = rs.getString("name");
                double avgTemperature = rs.getDouble("avg_temperature");
                System.out.println("Регион: " + regionName + ", Средняя температура: " + avgTemperature + "°C");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
