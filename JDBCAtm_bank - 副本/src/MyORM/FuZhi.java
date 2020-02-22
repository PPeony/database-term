package MyORM;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface FuZhi {
    public <T>T fuzhi(ResultSet resultSet)throws SQLException;
}
