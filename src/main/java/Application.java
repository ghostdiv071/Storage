import dao.CustomerDAO;
import dao.ProductDAO;
import dao.ProviderDAO;
import services.StorageController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        try (Connection connection = DriverManager.getConnection(
                ConnectionUtils.URL.value,
                ConnectionUtils.USER.value,
                ConnectionUtils.PASSWORD.value)
        ){
            StorageController controller = new StorageController(
                    new CustomerDAO(connection),
                    new ProductDAO(connection),
                    new ProviderDAO(connection)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
