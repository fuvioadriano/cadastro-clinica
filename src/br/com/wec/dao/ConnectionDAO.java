/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author arodrigues
 */
public class ConnectionDAO {

    private static final String USUARIO = "system";
    private static final String SENHA = "123";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static Connection conexao;

    public static Connection getConnection() {
        conexao = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (SQLException e) {
            throw new Exception("Erro na conexão!" + e.getMessage());
            
            /*JOptionPane.showMessageDialog(null, "Ocorreu um Exception: " + e.getMessage()
                    + " " + e.getErrorCode());*/
        } finally {
            return conexao;
        }
    }
}
