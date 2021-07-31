package com.collaborators.infra;

import java.sql.*;

public class ConnectionFactory {

  public static Connection getConnection() {

    final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final String USER = "RM87803";
    final String PASSWORD = "021002";

    try {
      return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

  }

}