package mappers;

import models.Provider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProviderMapper {

    public static Provider mapEntityToModel(ResultSet set){
        try {
            return new Provider(set.getInt("id"),
                    set.getString("name")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void mapModelToEntity(Provider model,
                                        PreparedStatement statement, int start)
    {
        try {
            statement.setString(start, model.getName());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
