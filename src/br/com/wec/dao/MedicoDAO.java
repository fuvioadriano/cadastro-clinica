/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wec.dao;

import br.com.wec.model.Especialidade;
import br.com.wec.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arodrigues
 */
public class MedicoDAO {

    public boolean inserir(Medico m) throws Exception {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = false;

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "insert into medico"
                        + "("
                        + "MED_ID"
                        + ",MED_NOME"
                        + ",MED_CPF"
                        + ",MED_CRM"
                        + ",MED_DTCONTRATO"
                        + ",MED_SEXO"
                        + ",MED_ESTADO"
                        + ",MED_DTNASC"
                        + ",MED_EMAIL"
                        + ",MED_BAIRRO"
                        + ",MED_ENDERECO"
                        + ",MED_CIDADE"
                        + ",MED_TELEFONE"
                        + ",MED_ID_ESPECIALIDADE"
                        + ")"
                        + "VALUES"
                        + "(SQ_MEDICO.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, m.getNome());
                ps.setString(2, m.getCpf());
                ps.setString(3, m.getCrm());
                ps.setDate(4, m.getDtcontrato());
                ps.setString(5, m.getSexo());
                ps.setString(6, m.getEstado());
                ps.setDate(7, m.getDtnasc());
                ps.setString(8, m.getEmail());
                ps.setString(9, m.getBairro());
                ps.setString(10, m.getEndereco());
                ps.setString(11, m.getCidade());
                ps.setString(12, m.getTelefone());
                ps.setInt(13, m.getEspecialidade());
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

    public boolean atualizar(Medico m) throws Exception {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = false;

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE MEDICO SET "
                        + "MED_NOME=?"
                        + ",MED_CPF=?"
                        + ",MED_CRM=?"
                        + ",MED_DTCONTRATO=?"
                        + ",MED_SEXO=?"
                        + ",MED_ESTADO=?"
                        + ",MED_DTNASC=?"
                        + ",MED_EMAIL=?"
                        + ",MED_BAIRRO=?"
                        + ",MED_ENDERECO=?"
                        + ",MED_CIDADE=?"
                        + ",MED_TELEFONE=?"
                        + ",MED_ID_ESPECIALIDADE=?"
                        + " WHERE MED_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, m.getNome());
                ps.setString(2, m.getCpf());
                ps.setString(3, m.getCrm());
                ps.setDate(4, m.getDtcontrato());
                ps.setString(5, m.getSexo());
                ps.setString(6, m.getEstado());
                ps.setDate(7, m.getDtnasc());
                ps.setString(8, m.getEmail());
                ps.setString(9, m.getBairro());
                ps.setString(10, m.getEndereco());
                ps.setString(11, m.getCidade());
                ps.setString(12, m.getTelefone());
                ps.setInt(13, m.getEspecialidade());
                ps.setInt(14, m.getId());
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
                String sql = "DELETE FROM MEDICO "
                        + " WHERE MED_ID=?";
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
                String sql = "SELECT * FROM MEDICO";

                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                //adiciona as colunas  
                dtm.addColumn("ID");
                dtm.addColumn("NOME");
                dtm.addColumn("CPF");
                dtm.addColumn("CRM");
                dtm.addColumn("DTCONTRATO");
                dtm.addColumn("SEXO");
                dtm.addColumn("ESTADO");
                dtm.addColumn("DTNASC");
                dtm.addColumn("EMAIL");
                dtm.addColumn("BAIRRO");
                dtm.addColumn("ENDERECO");
                dtm.addColumn("CIDADE");
                dtm.addColumn("TELEFONE");
                dtm.addColumn("ID_ESPECIALIDADE");

                while (rs.next()) {

                    dtm.addRow(new String[]{
                        rs.getString("MED_ID"),
                        rs.getString("MED_NOME"),
                        rs.getString("MED_CPF"),
                        rs.getString("MED_CRM"),
                        rs.getString("MED_DTCONTRATO"),
                        rs.getString("MED_SEXO"),
                        rs.getString("MED_ESTADO"),
                        rs.getString("MED_DTNASC"),
                        rs.getString("MED_EMAIL"),
                        rs.getString("MED_BAIRRO"),
                        rs.getString("MED_ENDERECO"),
                        rs.getString("MED_CIDADE"),
                        rs.getString("MED_TELEFONE"),
                        rs.getString("MED_ID_ESPECIALIDADE")
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

    public Medico getMedico(int id) throws Exception {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;

        Medico m = new Medico();

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM MEDICO where MED_ID=?";

                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();

                while (rs.next()) {

                    m.setId(Integer.parseInt(rs.getString("MED_ID")));
                    m.setNome(rs.getString("MED_NOME"));
                    m.setCpf(rs.getString("MED_CPF"));
                    m.setCrm(rs.getString("MED_CRM"));
                    m.setDtcontrato(rs.getDate("MED_DTCONTRATO"));
                    m.setSexo(rs.getString("MED_SEXO"));
                    m.setDtnasc(rs.getDate("MED_DTNASC"));
                    m.setEmail(rs.getString("MED_EMAIL"));
                    m.setBairro(rs.getString("MED_BAIRRO"));
                    m.setEndereco(rs.getString("MED_ENDERECO"));
                    m.setCidade(rs.getString("MED_CIDADE"));
                    m.setTelefone(rs.getString("MED_TELEFONE"));
                    m.setEspecialidade(rs.getInt("MED_ID_ESPECIALIDADE"));
                    m.setEstado(rs.getString("MED_ESTADO"));

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
        return m;
    }

    public List<Especialidade> getListaEspecialidades() throws Exception {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        boolean retorno = false;

        List<Especialidade> lista = new LinkedList<Especialidade>();
        Especialidade e = new Especialidade();

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM ESPECIALIDADE";

                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    e = new Especialidade();
                    e.setId(rs.getInt("ESP_ID"));
                    e.setDescricao(rs.getString("ESP_DESCRICAO"));
                    lista.add(e);
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
        return lista;
    }

    public Especialidade getListaEspecialidades(String descricao) throws Exception {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        boolean retorno = false;

        Especialidade e = new Especialidade();

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM ESPECIALIDADE where ESP_DESCRICAO=?";

                ps = conn.prepareStatement(sql);
                ps.setString(1, descricao);
                rs = ps.executeQuery();

                while (rs.next()) {
                    e = new Especialidade();
                    e.setId(rs.getInt("ESP_ID"));
                    e.setDescricao(rs.getString("ESP_DESCRICAO"));;
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
        return e;
    }
    
    
    public Especialidade getListaEspecialidades(int id) throws Exception {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        boolean retorno = false;

        Especialidade e = new Especialidade();

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM ESPECIALIDADE where ESP_ID=?";

                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();

                while (rs.next()) {
                    e = new Especialidade();
                    e.setId(rs.getInt("ESP_ID"));
                    e.setDescricao(rs.getString("ESP_DESCRICAO"));;
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
        return e;
    }

}
