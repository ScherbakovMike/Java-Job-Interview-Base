package com.mikescherbakov.jobinterviewbase.runner;

import com.mikescherbakov.jobinterviewbase.model.*;

import java.sql.*;
import java.util.*;

public class Utility {

    public static List<Author> getAuthors() throws SQLException {
        var authors = new ArrayList<Author>();
        var url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE";
        var username = "sa";
        var password = "";

        try (var connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM authors");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                // Assuming courses and books are fetched separately or are not needed for this example
                authors.add(new Author(id, name, new ArrayList<>(), new ArrayList<>()));
            }
        }
        return authors;
    }
}
