package mappers;

import models.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {

    public static Customer mapEntityToModel(ResultSet set){
        try {
            return new Customer(set.getInt("id"),
                    set.getString("name"),
                    set.getDouble("purchase_amount")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void mapModelToEntity(Customer model,
                                        PreparedStatement statement, int start)
    {
        try {
            statement.setString(start++, model.getName());
            statement.setDouble(start, model.getPurchaseAmount());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
