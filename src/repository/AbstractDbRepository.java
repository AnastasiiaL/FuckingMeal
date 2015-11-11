package repository;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Кроха on 30.10.2015.
 */
public class AbstractDbRepository {
    private MysqlConnectionPoolDataSource mysqlDS;

    public AbstractDbRepository() {
        mysqlDS = new MysqlConnectionPoolDataSource();
        mysqlDS.setURL("jdbc:mysql://localhost:3306/fucking_meal");
        mysqlDS.setUser("root");
        mysqlDS.setPassword("3324447");
    }

    protected Connection getConnection() {

        try {
            return mysqlDS.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
