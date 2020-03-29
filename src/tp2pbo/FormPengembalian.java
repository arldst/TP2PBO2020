/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2pbo;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class FormPengembalian extends javax.swing.JFrame {
    
    
    /**
     * Creates new form FormPeminjaman
     */
    public FormPengembalian() {
        initComponents();
        show_db();
    }

    public static Connection getKoneksi(){     
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_perpus","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    public static ArrayList<Peminjaman> getPeminjaman(){   
        ArrayList<Peminjaman> peminjaman = new ArrayList<Peminjaman>();
        
        Connection con = getKoneksi();
        
        Statement st;
        
        ResultSet rs;
        
        Peminjaman p;
        
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM peminjaman");
            
            while(rs.next()){
                
                p = new Peminjaman(
                        rs.getString("kode_buku"),
                        rs.getString("nama_buku"),
                        rs.getString("nama_peminjam"),
                        rs.getString("tanggal_pinjam"),
                        rs.getString("tanggal_pengembalian")
                );
                
                peminjaman.add(p);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(Peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }

        return peminjaman;
    }
    
    public void show_db() {
        ArrayList<Peminjaman> p = getPeminjaman();
        DefaultTableModel tabel;
        tabel = (DefaultTableModel)tableDB.getModel();
        
        Object[] row = new Object[5];
        for(int i = 0; i < p.size(); i++) {
            row[0] = p.get(i).getKode_buku();
            row[1] = p.get(i).getNama_buku();
            row[2] = p.get(i).getNama_peminjam();
            row[3] = p.get(i).getTanggal_pinjam();
            row[4] = p.get(i).getTanggal_pengembalian();
            tabel.addRow(row);
        }
    }
    
    public void kosong() {
        inputKodeBuku.setText(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNIM = new java.awt.Label();
        inputKodeBuku = new javax.swing.JTextField();
        labelInKodeBuku = new java.awt.Label();
        pengembalianBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDB = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pengembalian");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        labelNIM.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        labelNIM.setForeground(new java.awt.Color(255, 255, 255));
        labelNIM.setText("1805152 - Ariel Jusuf Indrastata");

        inputKodeBuku.setPreferredSize(new java.awt.Dimension(200, 25));

        labelInKodeBuku.setForeground(new java.awt.Color(255, 255, 255));
        labelInKodeBuku.setText("Kode Buku");

        pengembalianBtn.setText("Pengembalian");
        pengembalianBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengembalianBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Kembali");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        tableDB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Buku", "Nama Buku", "Nama Peminjam", "Tanggal Pinjam", "Tanggal Pengembalian"
            }
        ));
        jScrollPane1.setViewportView(tableDB);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNIM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pengembalianBtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelInKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(inputKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(155, 155, 155)
                .addComponent(pengembalianBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pengembalianBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengembalianBtnActionPerformed
        // TODO add your handling code here:
        Connection con = getKoneksi();
        Statement st;       
        ResultSet rs;  
        
        try {   
            String query ="SELECT * FROM peminjaman WHERE kode_buku='"+inputKodeBuku.getText()+"'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Tidak ada buku dengan kode tersebut.");
            }
            else {
                query = "DELETE FROM peminjaman WHERE kode_buku='"+inputKodeBuku.getText()+"'";
                st.executeUpdate(query);
                
                DefaultTableModel table = (DefaultTableModel)tableDB.getModel();
                table.setRowCount(0);
                show_db();
                kosong();
                JOptionPane.showMessageDialog(null, "Pengembalian berhasil!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPengembalian.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Harap masukan kode buku!");
        }
    }//GEN-LAST:event_pengembalianBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        
        MainForm fp = new MainForm();
        fp.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FormPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField inputKodeBuku;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label labelInKodeBuku;
    private java.awt.Label labelNIM;
    private javax.swing.JButton pengembalianBtn;
    private javax.swing.JTable tableDB;
    // End of variables declaration//GEN-END:variables
}
