package dao;

import mappers.ProductMapper;
import models.Product;
import queries.ProductQueries;
import queries.ProviderQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductDAO implements DAO<Product>{

    private final Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Product get(int id) {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(ProductQueries.GET + id))
            {
                while (resultSet.next()){
                    return ProductMapper.mapEntityToModel(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new NoSuchElementException("Record with id: " + id + " not found");
    }

    @Override
    public List<Product> getAll() {
        final List<Product> result = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(ProductQueries.GET_ALL))
            {
                while (resultSet.next()){
                    result.add(ProductMapper.mapEntityToModel(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void create(Product item) {
        try (PreparedStatement statement = connection.prepareStatement(
                ProductQueries.CREATE))
        {
            statement.setInt(1, item.getId());
            ProductMapper.mapModelToEntity(item, statement, 2);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Product item) {
        try (PreparedStatement statement = connection.prepareStatement(
                ProductQueries.UPDATE))
        {
            ProductMapper.mapModelToEntity(item, statement, 1);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                ProductQueries.DELETE))
        {
            statement.setInt(1, id);
            if (statement.executeUpdate() == 0) {
                throw new NoSuchElementException("Record with id = " + id + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
