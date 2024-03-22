package org.example.turistguidedel2.repository;

import org.example.turistguidedel2.model.TouristAttraction;
import org.example.turistguidedel2.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

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
        String sql = "SELECT *, cityName FROM Attractions, cities WHERE Attractions.cityID = Cities.cityID;";
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
        TouristAttraction touristAttraction = null;
        String sql = "SELECT *, cityName FROM Attractions, cities WHERE Attractions.cityID = cities.cityID AND attractionName LIKE ?";
        Connection connection = ConnectionManager.getConnection(url, user, password);
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, searchString);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                touristAttraction = createAttraction(rs);
            }
            return touristAttraction;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public TouristAttraction addAttraction(TouristAttraction touristAttraction){
        String SQL = "INSERT INTO Attractions(touristAttraction) values ?;";
        Connection connection = ConnectionManager.getConnection(url,user,password);

        try(PreparedStatement pstmt = connection.prepareStatement(SQL)){
            pstmt.setString(1, touristAttraction.getName());
            pstmt.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }return touristAttraction;
    }

    public void deleteAttraction(int attractionID) {
        String sql_deleteAttraction = "DELETE FROM attractions WHERE attractionID = ?;";
        String sql_deleteTagReference = "DELETE FROM attractionID_tagID WHERE attractionID = ?;";
        Connection connection = ConnectionManager.getConnection(url, user, password);

        try(PreparedStatement pstmtAttraction = connection.prepareStatement(sql_deleteAttraction);
            PreparedStatement pstmtTagReference = connection.prepareStatement(sql_deleteTagReference)) {
            pstmtAttraction.setInt(1, attractionID);
            pstmtTagReference.setInt(1, attractionID);
            pstmtAttraction.executeUpdate();
            pstmtTagReference.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getTagList(int attractionID) {
        List<String> tags = new ArrayList<>();
        String sql_getTagList = "SELECT tags.tagName\n" +
                "FROM attractions\n" +
                "JOIN attractionid_tagid ON attractions.attractionID = attractionid_tagid.attractionID\n" +
                "JOIN tags ON attractionid_tagid.tagID = tags.tagID\n" +
                "WHERE attractions.attractionID = ?;";
        Connection connection = ConnectionManager.getConnection(url, user, password);

        try (PreparedStatement pstmt = connection.prepareStatement(sql_getTagList)) {
            pstmt.setInt(1, attractionID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tags.add(rs.getString("tagName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tags;
    }

    private TouristAttraction createAttraction(ResultSet rs) throws SQLException {
        TouristAttraction attraction = new TouristAttraction(
                rs.getInt("attractionID"),
                rs.getString("attractionName"),
                rs.getString("attractionDescription"),
                rs.getString("cityName"),
                rs.getInt("ticketPrice"));
        return attraction;
    }
}
