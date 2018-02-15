/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wec.dao;

import br.com.wec.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arodrigues
 */
public class PacienteDAO {

    public boolean inserir(Paciente p) throws Exception {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = false;

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO PACIENTE"
                        + "("
                        + "PAC_ID"
                        + ",PAC_CPF"
                        + ",PAC_NOME"
                        + ",PAC_DTNASC"
                        + ",PAC_EMAIL"
                        + ",PAC_ESTADO"
                        + ",PAC_CIDADE"
                        + ",PAC_BAIRRO"
                        + ",PAC_ENDERECO"
                        + ",TELEFONE"
                        + ")"
                        + "VALUES"
                        + "(SQ_PACIENTE.nextval,?,?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, p.getCpf());
                ps.setString(2, p.getNome());
                ps.setDate(3, p.getDtnasc());
                ps.setString(4, p.getEmail());
                ps.setString(5, p.getEstado());
                ps.setString(6, p.getCidade());
                ps.setString(7, p.getBairro());
                ps.setString(8, p.getEndereco());
                ps.setString(9, p.getTelefone());
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
    
    public boolean atualizar(Paciente p) throws Exception {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = false;

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE PACIENTE SET "
                        + " PAC_CPF=?"
                        + ",PAC_NOME=?"
                        + ",PAC_DTNASC=?"
                        + ",PAC_EMAIL=?"
                        + ",PAC_ESTADO=?"
                        + ",PAC_CIDADE=?"
                        + ",PAC_BAIRRO=?"
                        + ",PAC_ENDERECO=?"
                        + ",TELEFONE=?"
                        + " WHERE PAC_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, p.getCpf());
                ps.setString(2, p.getNome());
                ps.setDate(3, p.getDtnasc());
                ps.setString(4, p.getEmail());
                ps.setString(5, p.getEstado());
                ps.setString(6, p.getCidade());
                ps.setString(7, p.getBairro());
                ps.setString(8, p.getEndereco());
                ps.setString(9, p.getTelefone());
                ps.setInt(10, p.getId());
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
    
    
    
     public boolean excluir(int id) throws Exception {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = false;

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM PACIENTE "
                                + " WHERE PAC_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
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

    public DefaultTableModel getLista() throws Exception {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        boolean retorno = false;

        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM PACIENTE";

                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                //adiciona as colunas  
                dtm.addColumn("ID");
                dtm.addColumn("CPF");
                dtm.addColumn("NOME ");
                dtm.addColumn("NASC");
                dtm.addColumn("EMAIL");
                dtm.addColumn("ESTADO");
                dtm.addColumn("CIDADE");
                dtm.addColumn("BAIRRO");
                dtm.addColumn("ENDERECO");
                dtm.addColumn("TELEFONE");

                while (rs.next()) {

                    dtm.addRow(new String[]{
                        rs.getString("PAC_ID"),
                        rs.getString("PAC_CPF"),
                        rs.getString("PAC_NOME"),
                        rs.getString("PAC_DTNASC"),
                        rs.getString("PAC_EMAIL"),
                        rs.getString("PAC_ESTADO"),
                        rs.getString("PAC_CIDADE"),
                        rs.getString("PAC_BAIRRO"),
                        rs.getString("PAC_ENDERECO"),
                        rs.getString("TELEFONE")
                    });
                }

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
        return dtm;
    }
    
     public Paciente getPaciente(int id) throws Exception {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
  
        Paciente p = new Paciente();

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM PACIENTE where pac_id=?";

                ps = conn.prepareStatement(sql);
                 ps.setInt(1, id);
                rs = ps.executeQuery();

             

                while (rs.next()) {

                    p.setId(Integer.parseInt(rs.getString("PAC_ID")));
                    p.setCpf(rs.getString("PAC_CPF"));
                    p.setNome(rs.getString("PAC_NOME"));
                                      
                    p.setDtnasc(rs.getDate("PAC_DTNASC"));
                    p.setEmail(rs.getString("PAC_EMAIL"));
                    p.setEstado(rs.getString("PAC_ESTADO"));
                    p.setCidade(rs.getString("PAC_CIDADE"));
                    p.setBairro(rs.getString("PAC_BAIRRO"));
                    p.setEndereco(rs.getString("PAC_ENDERECO"));
                    p.setTelefone(rs.getString("TELEFONE"));
                 
                }

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
        return p;
    }
}
