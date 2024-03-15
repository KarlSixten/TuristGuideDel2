package org.example.turistguidedel2.repository;

import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository_DB {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    public List<TouristAttraction> getAttractionList(){
        List<TouristAttraction> touristAttractionList = new ArrayList<>();
        String sql = "SELECT * FROM Attractions";
        Connection connection = ConnectionManager.getConnection(url, user, password);
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()){
                touristAttractionList.add(createAttraction(rs));
            }
            return touristAttractionList;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public TouristAttraction findAttraction(String searchString) {
        try(Connection connection = ConnectionManager.getConnection(url, user, password)){
            String SQL = "SELECT * FROM Attractions WHERE attractionName LIKE ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, searchString);
            ResultSet rs = ps.executeQuery();
            TouristAttraction touristAttraction;
            if (rs.next()) {
                return createAttraction(rs);
            } else {
                return null;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public TouristAttraction addAttraction(TouristAttraction touristAttraction){
        try(Connection connection = ConnectionManager.getConnection(url, user, password)){
            String SQL = "INSERT INTO Attractions(touristAttraction) values ?;";
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setString(1,touristAttraction.getName());
            pstmt.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }return touristAttraction;
    }

    private TouristAttraction createAttraction(ResultSet rs) throws SQLException {
        TouristAttraction attraction = new TouristAttraction(
                rs.getInt("attractionID"),
                rs.getString("attractionName"),
                rs.getString("attractionDescription"),
                rs.getInt("cityID"),
                rs.getInt("ticketPrice"));
        return attraction;
    }
}
