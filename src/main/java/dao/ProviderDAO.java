package dao;

import models.Provider;
import mappers.ProviderMapper;
import queries.ProviderQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProviderDAO implements DAO<Provider> {

    private final Connection connection;

    public ProviderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Provider get(int id) {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(ProviderQueries.GET + id))
            {
                while (resultSet.next()){
                    return ProviderMapper.mapEntityToModel(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new NoSuchElementException("Record with id: " + id + " not found");
    }

    @Override
    public List<Provider> getAll() {
        final List<Provider> result = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(ProviderQueries.GET_ALL))
            {
                while (resultSet.next()){
                    result.add(ProviderMapper.mapEntityToModel(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void create(Provider item) {
        try (PreparedStatement statement = connection.prepareStatement(
                ProviderQueries.CREATE))
        {
            statement.setInt(1, item.getId());
            ProviderMapper.mapModelToEntity(item, statement, 2);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Provider item) {
        try (PreparedStatement statement = connection.prepareStatement(
                ProviderQueries.UPDATE))
        {
            ProviderMapper.mapModelToEntity(item, statement, 1);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                ProviderQueries.DELETE))
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
