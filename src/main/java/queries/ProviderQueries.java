package queries;

public class ProviderQueries {

    public static final String GET = "select id, name " +
            "from provider " +
            "where id = ";

    public static final String GET_ALL = "select id, name  " +
            "from provider";

    public static final String CREATE = "insert into provider(id, name) values (?,?)";

    public static final String UPDATE = "update provider set name = ? where id = ?";

    public static final String DELETE = "delete from provider where id = ?";
}
