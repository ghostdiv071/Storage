package services;

import dao.CustomerDAO;
import dao.ProductDAO;
import dao.ProviderDAO;
import models.Product;

public class StorageController {

    private final CustomerDAO customerDAO;
    private final ProductDAO productDAO;
    private final ProviderDAO providerDAO;

    public StorageController(CustomerDAO customerDAO,
                             ProductDAO productDAO,
                             ProviderDAO providerDAO)
    {
        this.customerDAO = customerDAO;
        this.productDAO = productDAO;
        this.providerDAO = providerDAO;
    }

    public void sellProduct(int customer, int product) {
        productDAO.get(product).setCustomer(customerDAO.get(customer).getId());
    }

    public void addProduct(Product newProduct) {
        productDAO.getAll().add(newProduct);
    }

    public boolean inStock(int id) {
        return productDAO.get(id) != null;
    }

    public void printInfo() {
        for (Product product : productDAO.getAll()) {
            System.out.println(product.toString());
        }
    }

}
