package com.collaborators.dao;

import com.collaborators.infra.ConnectionFactory;
import com.collaborators.model.Collaborator;

import java.sql.*;
import java.util.*;

public class CollaboratorDAO implements ICollaboratorDAO {

  public void register(Collaborator collaborator) {

    String sql =
        "INSERT INTO TB_COLLABORATOR(ID, NAME, EMAIL, WAGE, HIRING) " +
        "VALUES (SQ_COLLABORATOR.NEXTVAL, ?, ?, ?, ?)";

    try (Connection connection = ConnectionFactory.getConnection()) {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, collaborator.getName());
      statement.setString(2, collaborator.getEmail());
      statement.setDouble(3, collaborator.getWage());
      java.sql.Date date = new java.sql.Date(collaborator.getHiring().getTimeInMillis());
      statement.setDate(4, date);
      statement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public List<Collaborator> findAll() {

    List<Collaborator> list = new ArrayList<Collaborator>();
    String sql = "SELECT * FROM TB_COLLABORATOR";

    try (Connection connection = ConnectionFactory.getConnection()) {
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String email = rs.getString("EMAIL");
        double wage = rs.getDouble("WAGE");
        java.sql.Date date = rs.getDate("HIRING");
        Calendar hiring = Calendar.getInstance();
        hiring.setTimeInMillis(date.getTime());
        Collaborator collaborator = new Collaborator(id, name, email, wage, hiring);
        list.add(collaborator);
      }

      return list;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public void remove(int id) {

    try (Connection connection = ConnectionFactory.getConnection()) {
      String sql = "DELETE FROM TB_COLLABORATOR WHERE ID = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      statement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public Collaborator findId(int id) {

    Collaborator collaborator = null;
    try (Connection connection = ConnectionFactory.getConnection()) {
      String sql = "SELECT * FROM TB_COLLABORATOR WHERE ID = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        int idRs = rs.getInt("ID");
        String name = rs.getString("NAME");
        String email = rs.getString("EMAIL");
        double wage = rs.getDouble("WAGE");
        java.sql.Date data = rs.getDate("HIRING");
        Calendar hiring = Calendar.getInstance();
        hiring.setTimeInMillis(data.getTime());
        collaborator = new Collaborator(idRs, name, email, wage, hiring);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return collaborator;

  }

  public void update(Collaborator collaborator) {

    try (Connection connection = ConnectionFactory.getConnection()) {
      String sql = "UPDATE TB_COLLABORATOR SET NAME = ?, EMAIL = ?, WAGE = ?, HIRING = ? WHERE ID = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, collaborator.getName());
      statement.setString(2, collaborator.getEmail());
      statement.setDouble(3, collaborator.getWage());
      java.sql.Date date = new java.sql.Date(collaborator.getHiring().getTimeInMillis());
      statement.setDate(4, date);
      statement.setInt(5, collaborator.getId());
      statement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

  }

}
