package hu.nive.ujratervezes.kepesitovizsga.dictionary;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dictionary {

    private DataSource dataSource;

    public Dictionary(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getEnglishWord(String word) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select angol as result from words where magyar = ?")){
            stmt.setString(1, word);
            return getResult(stmt);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query");
        }
    }

    private String getResult(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()){

            if (rs.next()) {
                return rs.getString("result");
            }
            throw new IllegalArgumentException("No such word in dictionary.");

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query");
        }
    }

    public String getHungarianWord(String word) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select magyar as result from words where angol = ?")){
            stmt.setString(1, word);
            return getResult(stmt);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query");
        }
    }
}
