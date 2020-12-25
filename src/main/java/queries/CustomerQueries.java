package queries;

public class CustomerQueries {

    public static final String GET = "select id, name, purchase_amount" +
            "from customer " +
            "where id = ";

    public static final String GET_ALL = "select id, name, purchase_amount" +
            "from customer";

    public static final String CREATE = "insert into customer" +
            "(id, name, purchase_amount) values (?,?,?)";

    public static final String UPDATE = "update customer set name = ?, " +
            "purchase_amount = ? where id = ?";

    public static final String DELETE = "delete from customer where id = ?";
}
