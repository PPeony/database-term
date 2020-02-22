package orm;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Strategy {
    public<T>T strategy(ResultSet resultSet)throws SQLException;
}
