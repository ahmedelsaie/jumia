package application.repositories;

import application.repositories.customSqlFunctions.GETREGEX;
import application.repositories.customSqlFunctions.REGEXP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.Function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class RepositoriesBeans {

    @Bean
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");

        Function.create(conn, "REGEXP", new REGEXP());
        Function.create(conn, "GETREGEX", new GETREGEX());

        return conn;
    }
}
