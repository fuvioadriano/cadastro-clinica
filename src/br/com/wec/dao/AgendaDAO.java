/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.wec.dao;

import br.com.wec.model.Agenda;
import br.com.wec.model.Medico;
import br.com.wec.model.Paciente;
import java.sql.Connection;
import java.sql.Date;
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
public class AgendaDAO {
    
    
     public List<Medico> getListaMedico() throws Exception {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        boolean retorno = false;

        List<Medico> lista = new LinkedList<Medico>();
        Medico m = new Medico();

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM MEDICO";

                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    m = new Medico();
                    m.setId(rs.getInt("MED_ID"));
                    m.setNome(rs.getString("MED_NOME"));
                    lista.add(m);
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
     
     
     
     public List<Paciente> getListaPaciente() throws Exception {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        boolean retorno = false;

        List<Paciente> lista = new LinkedList<Paciente>();
        Paciente p = new Paciente();

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM PACIENTE";

                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    p = new Paciente();
                    p.setId(rs.getInt("PAC_ID"));
                    p.setNome(rs.getString("PAC_NOME"));
                    lista.add(p);
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
     
     public boolean inserir(Agenda a) throws Exception {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = false;

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "insert into AGENDA"
                        + "("
                        +"AGE_NUMERO" +
                        ",AGE_DATA" +
                        ",AGE_DTHORA" +
                        ",AGE_HI" +
                        ",AGE_HF" +
                        ",AGE_PACIENTE" +
                        ",AGE_MEDICO" +
                        ",AGE_STATUS"
                        + ")"
                        + "VALUES"
                        + "(SQ_AGENDA.nextval,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setDate(1, a.getData());
                ps.setDate(2, a.getDthora());
                ps.setDate(3, a.getHi());
                ps.setDate(4, a.getHf());
                ps.setInt(5, a.getPaciente());
                ps.setInt(6, a.getMedico());
                ps.setInt(7, a.getStatus());
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
     
     
     
     public boolean horarios(int id, Date dt) throws Exception {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = false;

        conn = ConnectionDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "insert into HORARIOS"
                        + "("
                        +"HAG_ID_AGENDA" +
                        ",HAG_HORA" 
                        + ")"
                        + "VALUES"
                        + "(?,?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setDate(2, dt);
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
     
     
     
     
      public DefaultTableModel getListaAgenda(String data) throws Exception {
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
                String sql = 
                        "select \n" +
                        "a.AGE_NUMERO\n" +
                        ",m.MED_NOME\n" +
                        ",p.PAC_NOME\n" +
                        ",TO_CHAR(a.AGE_DATA, 'DD/MM/YYYY') AGE_DATA\n" +
                        ",TO_CHAR(a.AGE_HI, 'HH24:mi') AGE_HI\n" +
                        ",TO_CHAR(a.AGE_HF, 'HH24:mi') AGE_HF\n" +
                        "from agenda a\n" +
                        "inner join MEDICO m on m.MED_ID=a.AGE_MEDICO\n" +
                        "inner join PACIENTE p on p.PAC_ID=a.AGE_PACIENTE\n" +
                        "where TO_CHAR(a.AGE_DATA, 'yyyy-mm-dd') = '"+data+"'";

                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                //adiciona as colunas  
                dtm.addColumn("NUMERO");
                dtm.addColumn("MEDICO");
                dtm.addColumn("PACIENTE");
                dtm.addColumn("DATA");
                dtm.addColumn("INICIO");
                dtm.addColumn("FIM");


                while (rs.next()) {

                    dtm.addRow(new String[]{
                        rs.getString("AGE_NUMERO"),
                        rs.getString("MED_NOME"),
                        rs.getString("PAC_NOME"),
                        rs.getString("AGE_DATA"),
                        rs.getString("AGE_HI"),
                        rs.getString("AGE_HF")
                        
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
    
    
}
