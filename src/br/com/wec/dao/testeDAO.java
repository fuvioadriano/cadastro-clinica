/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author arodrigues
 */
public class testeDAO {

    public boolean inserir() throws Exception {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = false;

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "insert into classe_aula values (12,'teste java',123)";
                ps = conn.prepareStatement(sql);
                //  ps.setInt(1, pessoaInserir.getCodPessoa());
                //ps.setString(1, pessoaInserir.getNome());
                //ps.setString(2, pessoaInserir.getSexo());
                //ps.setString(3, pessoaInserir.getEmail());
                ps.executeUpdate();
                retorno = true;
            } catch (SQLException ex) {
                throw new Exception("Ocorreu um Exception " + ex.getMessage() + " " + ex.getCause() + " " + ex.getErrorCode());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    throw new Exception("Ocorreu um Exception " + ex.getMessage() + " " + ex.getCause() + " " + ex.getErrorCode());
                }
            }
        }
        return retorno;
    }

}
