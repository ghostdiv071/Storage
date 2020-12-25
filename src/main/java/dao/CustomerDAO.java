package dao;

import mappers.CustomerMapper;
import mappers.ProviderMapper;
import models.Customer;
import queries.CustomerQueries;
import queries.ProviderQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomerDAO implements DAO<Customer> {

    private final Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Customer get(int id) {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(CustomerQueries.GET + id))
            {
                while (resultSet.next()){
                    return CustomerMapper.mapEntityToModel(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new NoSuchElementException("Record with id: " + id + " not found");
    }

    @Override
    public List<Customer> getAll() {
        final List<Customer> result = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(CustomerQueries.GET_ALL))
            {
                while (resultSet.next()){
                    result.add(CustomerMapper.mapEntityToModel(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void create(Customer item) {
        try (PreparedStatement statement = connection.prepareStatement(
                CustomerQueries.CREATE))
        {
            statement.setInt(1, item.getId());
            CustomerMapper.mapModelToEntity(item, statement, 2);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Customer item) {
        try (PreparedStatement statement = connection.prepareStatement(
                CustomerQueries.UPDATE))
        {
            CustomerMapper.mapModelToEntity(item, statement, 2);
            statement.setInt(3, item.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                CustomerQueries.DELETE))
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
