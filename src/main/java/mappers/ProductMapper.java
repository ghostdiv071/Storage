package mappers;

import models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {

    public static Product mapEntityToModel(ResultSet set){
        try {
            return new Product(set.getInt("id"),
                    set.getString("name"),
                    set.getString("type"),
                    set.getInt("provider"),
                    set.getInt("customer")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void mapModelToEntity(Product model,
                                        PreparedStatement statement, int start)
    {
        try {
            statement.setString(start++, model.getName());
            statement.setString(start++, model.getType());
            statement.setInt(start++, model.getProvider());
            statement.setInt(start, model.getCustomer());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
