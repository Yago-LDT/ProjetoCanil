/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.visao;

import br.com.controle.Canil;
import br.com.entidade.ManterCanil;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yago
 */
public class Listar_Todos_Cães extends javax.swing.JFrame {
    
Canil c = new Canil();
    /**
     * Creates new form Listar_Cães
     */
    public Listar_Todos_Cães() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton3 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jBlistar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTlista2 = new javax.swing.JTable();
        jRtodos = new javax.swing.JRadioButton();
        jRraça = new javax.swing.JRadioButton();
        jRviralata = new javax.swing.JRadioButton();

        jRadioButton3.setText("Vira-lata");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("LISTAR CÃES");

        jBlistar.setText("LISTAR");
        jBlistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlistarActionPerformed(evt);
            }
        });

        jTlista2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Raça", "Peso", "Porte", "Origem", "Gênero", "Idade", "Data_admissão", "Revacinação"
            }
        ));
        jScrollPane1.setViewportView(jTlista2);

        buttonGroup1.add(jRtodos);
        jRtodos.setText("Todos");
        jRtodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRtodosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRraça);
        jRraça.setText("Raça");

        buttonGroup1.add(jRviralata);
        jRviralata.setText("Vira-lata");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(343, 343, 343)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(382, 382, 382)
                                .addComponent(jBlistar)))
                        .addGap(0, 363, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jRviralata)
                .addGap(18, 18, 18)
                .addComponent(jRtodos)
                .addGap(18, 18, 18)
                .addComponent(jRraça)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRtodos)
                    .addComponent(jRraça)
                    .addComponent(jRviralata))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBlistar)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBlistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlistarActionPerformed
        // TODO add your handling code here:
           if(jRtodos.isSelected()){
               try {
                
        
        ManterCanil ca = new ManterCanil();
        DefaultTableModel cãespesque = (DefaultTableModel)   jTlista2.getModel();
        ArrayList<Canil> canis = ca.Listar_Todos_Cães();  
        for (int i = 0; i < canis.size(); i++) {                
            c = canis.get(i);
            cãespesque.addRow(new Object[]{c.getID(),c.getNome(),c.getRaça(),c.getPeso(),c.getPorte(),
            c.getOrigem(),c.getGênero(),c.getIdade(),c.getData_admissão(),c.getRevacinacao()});
                }
                }catch(Exception e){
        System.out.println("Erro " + e.getMessage());
        }
            }
            
            if (jRviralata.isSelected()){
                try{
             
        ManterCanil ca = new ManterCanil();
        DefaultTableModel cãesviralatapesque = (DefaultTableModel)   jTlista2.getModel();
        ArrayList<Canil> canis = ca.Listar_viralatas();  
        for (int i = 0; i < canis.size(); i++) {                
            c = canis.get(i);
            cãesviralatapesque.addRow(new Object[]{c.getID(),c.getNome(),c.getRaça(),c.getPeso(),c.getPorte(),
            c.getOrigem(),c.getGênero(),c.getIdade(),c.getData_admissão(),c.getRevacinacao()});
                }
                }catch(Exception e){
        System.out.println("Erro " + e.getMessage());
        }
            
            
            }
            
            
            if (jRraça.isSelected()){
                try{
             
        ManterCanil ca = new ManterCanil();
        DefaultTableModel cãesraçapesque = (DefaultTableModel)   jTlista2.getModel();
        ArrayList<Canil> canis = ca.Listar_raça();  
        for (int i = 0; i < canis.size(); i++) {                
            c = canis.get(i);
            cãesraçapesque.addRow(new Object[]{c.getID(),c.getNome(),c.getRaça(),c.getPeso(),c.getPorte(),
            c.getOrigem(),c.getGênero(),c.getIdade(),c.getData_admissão(),c.getRevacinacao()});
                }
                }catch(Exception e){
        System.out.println("Erro " + e.getMessage());
        }
            
            
            }
            
            
            
            
            
    }//GEN-LAST:event_jBlistarActionPerformed

    private void jRtodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRtodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRtodosActionPerformed

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
            java.util.logging.Logger.getLogger(Listar_Todos_Cães.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Todos_Cães.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Todos_Cães.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Todos_Cães.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar_Todos_Cães().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBlistar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRraça;
    private javax.swing.JRadioButton jRtodos;
    private javax.swing.JRadioButton jRviralata;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTlista2;
    // End of variables declaration//GEN-END:variables
}
