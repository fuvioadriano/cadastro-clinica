/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.wec.view;

import br.com.wec.dao.MedicoDAO;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Beto
 */
public class JFrameMedicos extends javax.swing.JFrame {

    /**
     * Creates new form JFrameMedicos
     */
    MedicoDAO mdao = new MedicoDAO();
    
    public JFrameMedicos() {
        initComponents();
        
        getLista();
    }
    
    
        public void getLista() throws HeadlessException {
        try {
            jtbLista.setModel(mdao.getLista());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMedicos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbLista = new javax.swing.JTable();
        jButtonFecharPaciente = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonNovoPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medicos");

        jLabelMedicos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelMedicos.setText("Lista de Medicos");

        jtbLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtbLista);

        jButtonFecharPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wec/img/Close.png"))); // NOI18N
        jButtonFecharPaciente.setToolTipText("Fechar");
        jButtonFecharPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharPacienteActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wec/img/Trash.png"))); // NOI18N
        jButton2.setToolTipText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wec/img/Pen.png"))); // NOI18N
        jButton1.setToolTipText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonNovoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wec/img/Add.png"))); // NOI18N
        jButtonNovoPaciente.setToolTipText("Novo");
        jButtonNovoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMedicos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFecharPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMedicos)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonNovoPaciente)
                            .addComponent(jButton1))
                        .addComponent(jButton2))
                    .addComponent(jButtonFecharPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabelMedicos.getAccessibleContext().setAccessibleName("Lista de Medicos");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharPacienteActionPerformed
        dispose();// fecha a tela de pacientes
    }//GEN-LAST:event_jButtonFecharPacienteActionPerformed

    private void jButtonNovoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoPacienteActionPerformed
        
        JFrameNovoMedico frmNM = new JFrameNovoMedico(this);
        frmNM.setVisible(true);
        
        
    }//GEN-LAST:event_jButtonNovoPacienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int id = Integer.parseInt((String) jtbLista.getValueAt(jtbLista.getSelectedRow(), 0));

        JFrameNovoMedico fnm = new JFrameNovoMedico(this, "alt", id);

        fnm.setVisible(true);

        getLista();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int reply = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {

            int id = Integer.parseInt((String) jtbLista.getValueAt(jtbLista.getSelectedRow(), 0));
            try {
                mdao.excluir(id);

                getLista();

                JOptionPane.showMessageDialog(null, "Paciente excluido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonFecharPaciente;
    private javax.swing.JButton jButtonNovoPaciente;
    private javax.swing.JLabel jLabelMedicos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbLista;
    // End of variables declaration//GEN-END:variables
}
