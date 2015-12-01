package repository;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ����� on 30.10.2015.
 */
public abstract class AbstractDbRepository {
 //   @Autowired
    protected MysqlConnectionPoolDataSource mysqlDS;

    public MysqlConnectionPoolDataSource getMysqlDS() {
        return mysqlDS;
    }

    public void setMysqlDS(MysqlConnectionPoolDataSource mysqlDS) {
        this.mysqlDS = mysqlDS;
    }

    protected Connection getConnection() {

        try {
            return mysqlDS.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected int getMaxID(){
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int maxID;
        try {
            ps = connection.prepareStatement("SELECT MAX(id) FROM " + getTableName());
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, ps, rs);
        }
        throw new IllegalStateException("Can't get max ID for the table " + getTableName());
    }

    protected void closeConnection(Connection connection, PreparedStatement ps) {
        closeConnection(connection, ps, null);
    }
    protected void closeConnection(Connection connection, PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract String getTableName();

    public void delete(int id) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM " + getTableName() +" WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, ps);
        }
    }
}
