package queries;

public class ProductQueries {
    public static final String GET = "select id, name, type, provider, customer" +
            "from product " +
            "where id = ";

    public static final String GET_ALL = "select id, name, type, provider, customer" +
            "from product";

    public static final String CREATE = "insert into product" +
            "(id, name, type, provider, customer) values (?,?,?,?)";

    public static final String UPDATE = "update product set name = ?, " +
            "type = ?, provider = ?, customer = ? where id = ?";

    public static final String DELETE = "delete from product where id = ?";
    
}
