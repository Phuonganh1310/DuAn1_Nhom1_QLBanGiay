/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.KhuyenMaiModel;
import ITFService.KhuyenMaiIF;
import ServiceIML.KhuyenMaiIML;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Menu5 extends javax.swing.JInternalFrame {
    
    private KhuyenMaiIF khuyenMaiIF = new KhuyenMaiIML();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form Menu1
     */
    public Menu5() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        this.LoatTable();
        
    }
    
    public void LoatTable() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        this.khuyenMaiIF.all();
        dtm.setRowCount(0);
        for (KhuyenMaiModel khuyenMaiModel : this.khuyenMaiIF.all()) {
            dtm.addRow(new Object[]{khuyenMaiModel.getMa(), khuyenMaiModel.getTen(), khuyenMaiModel.getKhuyenmai(), khuyenMaiModel.getNgaybd(), khuyenMaiModel.getNgaykt(), khuyenMaiModel.getMota()});
        }
    }
    
    public void Find(String ten) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        this.khuyenMaiIF.all();
        dtm.setRowCount(0);
        for (KhuyenMaiModel khuyenMaiModel : this.khuyenMaiIF.Find(ten)) {
            dtm.addRow(new Object[]{khuyenMaiModel.getMa(), khuyenMaiModel.getTen(), khuyenMaiModel.getKhuyenmai(), khuyenMaiModel.getNgaybd(), khuyenMaiModel.getNgaykt(), khuyenMaiModel.getMota()});
        }
    }
    
    public void Findtt(String ngaybd, String ngaykt) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        this.khuyenMaiIF.all();
        dtm.setRowCount(0);
        for (KhuyenMaiModel khuyenMaiModel : this.khuyenMaiIF.Findtt(ngaybd, ngaykt)) {
            dtm.addRow(new Object[]{khuyenMaiModel.getMa(), khuyenMaiModel.getTen(), khuyenMaiModel.getKhuyenmai(), khuyenMaiModel.getNgaybd(), khuyenMaiModel.getNgaykt(), khuyenMaiModel.getMota()});
        }
    }
    
    public void Findttkt(String ngaybd, String ngaykt) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        this.khuyenMaiIF.all();
        dtm.setRowCount(0);
        for (KhuyenMaiModel khuyenMaiModel : this.khuyenMaiIF.Findttkt(ngaybd, ngaykt)) {
            dtm.addRow(new Object[]{khuyenMaiModel.getMa(), khuyenMaiModel.getTen(), khuyenMaiModel.getKhuyenmai(), khuyenMaiModel.getNgaybd(), khuyenMaiModel.getNgaykt(), khuyenMaiModel.getMota()});
        }
    }
    
    public KhuyenMaiModel GetFromData() {
        String ma = txtma.getText();
        String ten = txtten.getText();
        String khuyenmai = txtkhuyenmai.getText();
        String ngaybd = sdf.format(dsngaybd.getDate());
        String ngaykt = sdf.format(dsngaykt.getDate());
        String mota = txtmota.getText();
        
        if (ma.trim().length() == 0
                || ten.trim().length() == 0
                || khuyenmai.trim().length() == 0
                || mota.trim().length() == 0) {
            
        }
        if(!txtkhuyenmai.getText().matches("^[1-9]?[0-9]{1}$|^100$")){
            JOptionPane.showMessageDialog(this, "Khuyến mại từ 1% đến 100% .");
            return null;
        }
        
        KhuyenMaiModel khuyenMaiModel = new KhuyenMaiModel(ma, ten, khuyenmai, ngaybd, ngaykt, mota);
        return khuyenMaiModel;
        
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
        dsngaykt = new com.toedter.calendar.JDateChooser();
        dsngaybd = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtkhuyenmai = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        btthem = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txttim = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbtrangthai = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btloc = new javax.swing.JButton();
        dstu = new com.toedter.calendar.JDateChooser();
        dsden = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1270, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1270, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dsngaykt.setDate(new java.util.Date(1669125429000L));
        dsngaykt.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(dsngaykt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 130, 30));

        dsngaybd.setDate(new java.util.Date(1669125429000L));
        dsngaybd.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(dsngaybd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 140, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tên khuyến mại:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Khuyến mại:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ngày bắt đầu:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 100, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Mô tả:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Ngày kết thúc: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 100, 20));

        txtma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtma.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtma, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 290, 40));

        txtkhuyenmai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtkhuyenmai.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtkhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 290, 40));

        txtten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtten.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 290, 40));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        txtmota.setColumns(20);
        txtmota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtmota.setRows(5);
        jScrollPane1.setViewportView(txtmota);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 290, 90));

        btthem.setBackground(new java.awt.Color(51, 51, 51));
        btthem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btthem.setForeground(new java.awt.Color(255, 255, 255));
        btthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add.png"))); // NOI18N
        btthem.setText("Thêm");
        btthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemActionPerformed(evt);
            }
        });
        jPanel1.add(btthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 110, 30));

        btsua.setBackground(new java.awt.Color(51, 51, 51));
        btsua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btsua.setForeground(new java.awt.Color(255, 255, 255));
        btsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sửa.png"))); // NOI18N
        btsua.setText("Cập nhật");
        btsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsuaActionPerformed(evt);
            }
        });
        jPanel1.add(btsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mã khuyến mại:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tìm khuyến mại");

        txttim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttim.setForeground(new java.awt.Color(0, 0, 0));
        txttim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttimCaretUpdate(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Trạng thái");

        cbtrangthai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbtrangthai.setForeground(new java.awt.Color(0, 0, 0));
        cbtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngưng hoạt động", "Vẫn hoạt động" }));
        cbtrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtrangthaiActionPerformed(evt);
            }
        });

        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mại", "Tên khuyến mại", "khuyến mại ", "Ngày bắt đầu ", "Ngày kết thúc ", "Mô tả"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(cbtrangthai, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttim, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 810, 530));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Phân loại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Từ:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Đến:");

        btloc.setBackground(new java.awt.Color(51, 51, 51));
        btloc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btloc.setForeground(new java.awt.Color(255, 255, 255));
        btloc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lọc.png"))); // NOI18N
        btloc.setText("Lọc");
        btloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlocActionPerformed(evt);
            }
        });

        dstu.setDate(new java.util.Date(1669125429000L));
        dstu.setDateFormatString("yyyy/MM/dd");

        dsden.setDate(new java.util.Date(1669125429000L));
        dsden.setDateFormatString("yyyy/MM/dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(dstu, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dsden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btloc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dstu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(dsden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btloc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 370, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemActionPerformed
        // TODO add your handling code here:
        KhuyenMaiModel khuyenMaiModel = this.GetFromData();
        if (khuyenMaiModel == null) {
            return;
        }
        String ma=txtma.getText();
        for(KhuyenMaiModel km: khuyenMaiIF.all()){
            if(km.getMa().equals(ma)){
                JOptionPane.showMessageDialog(this, "Mã khuyến mại đã tồn tại.");
                return;
            }
        }
        this.khuyenMaiIF.insert(khuyenMaiModel);
        this.LoatTable();
    }//GEN-LAST:event_btthemActionPerformed

    private void btsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsuaActionPerformed
        // TODO add your handling code here:
        KhuyenMaiModel khuyenMaiModel = this.GetFromData();
        if (khuyenMaiModel == null) {
            return;
        }
        this.khuyenMaiIF.update(khuyenMaiModel.getMa(), khuyenMaiModel);
        this.LoatTable();
    }//GEN-LAST:event_btsuaActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:

        try {
            int row = table.getSelectedRow();
            Date start = sdf.parse(table.getValueAt(row, 3).toString());
            Date end = sdf.parse(table.getValueAt(row, 4).toString());
            txtma.setText(table.getValueAt(row, 0).toString());
            txtten.setText(table.getValueAt(row, 1).toString());
            txtkhuyenmai.setText(table.getValueAt(row, 2).toString());
            txtmota.setText(table.getValueAt(row, 5).toString());
            dsngaybd.setDate(start);
            dsngaykt.setDate(end);
        } catch (ParseException ex) {
            Logger.getLogger(Menu5.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tableMouseClicked

    private void cbtrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtrangthaiActionPerformed
        // TODO add your handling code here:
        Date now = new Date();
        if (cbtrangthai.getSelectedIndex() == 0) {
            Findttkt(sdf.format(now), sdf.format(now));
        } else if (cbtrangthai.getSelectedIndex() == 1) {
            Findtt(sdf.format(now), sdf.format(now));
        }

    }//GEN-LAST:event_cbtrangthaiActionPerformed

    private void txttimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimCaretUpdate
        // TODO add your handling code here:
        Find(txttim.getText());
    }//GEN-LAST:event_txttimCaretUpdate

    private void btlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlocActionPerformed
        // TODO add your handling code here:
        String ngaybd = sdf.format(dstu.getDate());
        String ngaykt = sdf.format(dsden.getDate());
        Findtt(ngaybd, ngaykt);
    }//GEN-LAST:event_btlocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btloc;
    private javax.swing.JButton btsua;
    private javax.swing.JButton btthem;
    private javax.swing.JComboBox<String> cbtrangthai;
    private com.toedter.calendar.JDateChooser dsden;
    private com.toedter.calendar.JDateChooser dsngaybd;
    private com.toedter.calendar.JDateChooser dsngaykt;
    private com.toedter.calendar.JDateChooser dstu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtkhuyenmai;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txttim;
    // End of variables declaration//GEN-END:variables
}
