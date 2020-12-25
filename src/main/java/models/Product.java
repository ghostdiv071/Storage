package models;

public class Product extends Entity {

    private String name;
    private String type;
    private int provider;
    private int customer;

    public Product() {
    }

    public Product(String name, String type, int provider, int customer) {
        this.name = name;
        this.type = type;
        this.provider = provider;
        this.customer = customer;
    }

    public Product(int id, String name, String type, int provider, int customer) {
        setId(id);
        this.name = name;
        this.type = type;
        this.provider = provider;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {

        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", provider=" + provider +
                ", customer=" + (customer == 0 ? "" : customer) +
                '}';
    }
}
