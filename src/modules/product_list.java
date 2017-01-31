/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import config.config;
import crud.crud;
import form.combobox;
import form.layout;
import form.textfield;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felismelo
 */
public class product_list extends javax.swing.JFrame {
    config connect = new config();
    crud crud = new crud();
    layout layout = new layout();
    int limit = 16;
    
    private void loadLayout(){
        crud.tableData(jTable1, "product AS p LEFT JOIN suplier AS s ON(p.suplier_id=s.id)", "p.code,p.name AS product_name,p.price,p.discount,p.qty,s.name", "ORDER BY p.id DESC LIMIT 0,"+limit);
        String total = crud.getOne("SELECT count(id) FROM product");
        double totalData = Double.parseDouble(total);
        int totPage = (int) Math.ceil(totalData/limit);
        total = String.valueOf(totPage);
        totalPage.setText(total);
        layout.pagination(jButton1,jButton2,page,totalPage);
        jTable1.setUpdateSelectionOnSort(false);        
    }
    
    
    /**
     * Creates new form product_list
     */
    public product_list() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadLayout();
        combobox combobox = new combobox(comboSearch,"product,code");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        page = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalPage = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        gotoPage = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        comboSearch = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("< previous");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("next >");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("page");

        page.setText("1");
        page.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pagePropertyChange(evt);
            }
        });

        jLabel2.setText("of");

        totalPage.setText("0");

        jButton3.setText("go to page");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        gotoPage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gotoPageKeyReleased(evt);
            }
        });

        jButton4.setText("Cari");

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(page)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gotoPage, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(page)
                    .addComponent(jLabel2)
                    .addComponent(totalPage)
                    .addComponent(jButton3)
                    .addComponent(gotoPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int curentPage = Integer.parseInt(page.getText());
        int labelPage = curentPage;
        curentPage = (limit*curentPage);
        crud.tableData(jTable1,"product AS p LEFT JOIN suplier AS s ON(p.suplier_id=s.id)", "p.code,p.name AS product_name,p.price,p.qty,s.name", "ORDER BY p.id DESC LIMIT "+curentPage+","+limit);
        labelPage++;
        page.setText(String.valueOf(labelPage));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int curentPage = Integer.parseInt(page.getText());
        curentPage--;
        int labelPage = curentPage;
        curentPage = curentPage-1;
        curentPage = (limit*curentPage);
        crud.tableData(jTable1,"product AS p LEFT JOIN suplier AS s ON(p.suplier_id=s.id)", "p.code,p.name AS product_name,p.price,p.qty,s.name", "ORDER BY p.id DESC LIMIT "+curentPage+","+limit);
        page.setText(String.valueOf(labelPage));        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pagePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pagePropertyChange
        // TODO add your handling code here:
        layout.pagination(jButton1,jButton2,page,totalPage);
    }//GEN-LAST:event_pagePropertyChange

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int gopage = Integer.parseInt(gotoPage.getText());
        int totPage = Integer.parseInt(totalPage.getText());
        if(gopage > totPage){
            JOptionPane.showMessageDialog(null, "Out of Maximum Page");
        }else if(gopage < 1){
            JOptionPane.showMessageDialog(null, "Out of Minimum Page");
        }else{
            int curentPage = gopage;
            int labelPage = curentPage;
            curentPage = curentPage-1;
            curentPage = (limit*curentPage);
            crud.tableData(jTable1,"product AS p LEFT JOIN suplier AS s ON(p.suplier_id=s.id)", "p.code,p.name AS product_name,p.price,p.qty,s.name", "ORDER BY p.id DESC LIMIT "+curentPage+","+limit);
            page.setText(String.valueOf(labelPage));            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void gotoPageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gotoPageKeyReleased
        // TODO add your handling code here:
        textfield textfield = new textfield();
        textfield.isNumeric(gotoPage);
    }//GEN-LAST:event_gotoPageKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        String code = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
//        crud.setId(code);
//        crud.setTitle("product");
//        detail detail = new detail();
//        detail.show();
        this.setFocusable(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            String code = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
            this.setFocusable(false);
            crud.setId(code);
            crud.setTitle("product");
            detail detail = new detail();
            detail.show();
        }
    }//GEN-LAST:event_jTable1MousePressed

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
            java.util.logging.Logger.getLogger(product_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JTextField gotoPage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel page;
    private javax.swing.JLabel totalPage;
    // End of variables declaration//GEN-END:variables
}
