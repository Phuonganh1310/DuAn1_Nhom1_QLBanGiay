/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDonModel;
import DomainModel.HoaDonView;
import DomainModel.KhuyenMai_BanHangModel;
import ITFService.BanHangITF;
import ITFService.HoadonITF;
import ServiceIML.BanHangIML;
import ServiceIML.HoaDonIML;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Menu3 extends javax.swing.JInternalFrame {
    
    private HoadonITF hoadonITF = new HoaDonIML();
    DefaultTableModel bang;
    private BanHangITF banHangITF = new BanHangIML();
    private NumberFormat formatter = new DecimalFormat("#,###");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * Creates new form Menu1
     */
    public Menu3() {
        initComponents();
        lblmahd.setEnabled(false);
        lblchuongtrinhkm.setEnabled(false);
        lbltongcong.setEnabled(false);
        lblsokhuyenmai.setEnabled(false);
        lbltienkm.setEnabled(false);
        lblthanhtien.setEnabled(false);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        LoadTableHoaDon();
    }
    
    private void LoadTableHoaDon() {
        DefaultTableModel bang = (DefaultTableModel) tablehoadon.getModel();
        bang.setRowCount(0);
        for (HoaDonView hdv : hoadonITF.getall()) {
            bang.addRow(new Object[]{tablehoadon.getRowCount() + 1, hdv.getMaHD(), hdv.getTenNV(), hdv.getTenKH(), hdv.getNgayTao(), hdv.trangThai()});
        }
    }
    
    private void LocNgay(String ngayBD, String ngayKT) {
        DefaultTableModel bang = (DefaultTableModel) tablehoadon.getModel();
        bang.setRowCount(0);
        for (HoaDonView hdv : hoadonITF.LocNgay(ngayBD, ngayKT)) {
            bang.addRow(new Object[]{tablehoadon.getRowCount() + 1, hdv.getMaHD(), hdv.getTenNV(), hdv.getTenKH(), hdv.getNgayTao(), hdv.trangThai()});
        }
    }
    
    private void FinmaHD(String ten) {
        DefaultTableModel bang = (DefaultTableModel) tablehoadon.getModel();
        bang.setRowCount(0);
        for (HoaDonView hdv : hoadonITF.FindMaNV(ten)) {
            bang.addRow(new Object[]{tablehoadon.getRowCount() + 1, hdv.getMaHD(), hdv.getTenNV(), hdv.getTenKH(), hdv.getNgayTao(), hdv.trangThai()});
        }
    }
    
    private void ClearAlltableGioHang() {
        bang = (DefaultTableModel) tablegiohang.getModel();
        bang.getDataVector().removeAllElements();
        revalidate();
    }
    
    private void TinhTongTien() {
        int tien, tongtien = 0;
        int row = tablegiohang.getRowCount();
        for (int i = 0; i < row; i++) {
            tien = Integer.parseInt(tablegiohang.getValueAt(i, 7).toString());
            tongtien += tien;
        }
        lbltongcong.setText(formatter.format(tongtien));
    }
    
    private String MaHDtoTenKM(String MaHD) {
        for (HoaDonModel hdm : banHangITF.MouseClickKM()) {
            if (MaHD.equals(hdm.getMaHD().toString())) {
                return hdm.getIdKM();
            }
        }
        return null;
    }
    
    private void updatetienKM() {
        int Dis;
        NumberFormat formatter = new DecimalFormat("#,###");
        //tính Discount
        String Order = lbltongcong.getText().replaceAll(",", "");
        Dis = (Integer.parseInt(lblsokhuyenmai.getText()) * Integer.parseInt(Order)) / 100;
        lbltienkm.setText(formatter.format(Dis));
        int tienkhuyenmai = Integer.parseInt(Order) - Dis;
        lblthanhtien.setText(formatter.format(tienkhuyenmai));
        
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
        txttim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblmahd = new javax.swing.JTextField();
        lblchuongtrinhkm = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        ngaybd = new com.toedter.calendar.JDateChooser();
        ngaykt = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbltongcong = new javax.swing.JTextField();
        lblsokhuyenmai = new javax.swing.JTextField();
        lbltienkm = new javax.swing.JTextField();
        lblthanhtien = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablehoadon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablegiohang = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 690));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 690));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttim.setBackground(new java.awt.Color(255, 255, 255));
        txttim.setForeground(new java.awt.Color(0, 0, 0));
        txttim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttimCaretUpdate(evt);
            }
        });
        jPanel1.add(txttim, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 319, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tìm mã HD:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 16, 87, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mã HD :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 78, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tổng cộng: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 109, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Chiếu khấu:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Thành tiền:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 80, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Chương trình KM: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 167, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("%");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 20, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("VND");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 45, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("VND");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 45, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("VND");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 45, -1));

        lblmahd.setBackground(new java.awt.Color(255, 255, 255));
        lblmahd.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(lblmahd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 320, 30));

        lblchuongtrinhkm.setBackground(new java.awt.Color(255, 255, 255));
        lblchuongtrinhkm.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(lblchuongtrinhkm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 320, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Phân Loại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 30));

        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 150, 30));

        ngaybd.setDate(new java.util.Date(1669125429000L));
        ngaybd.setDateFormatString("dd/MM/yyyy");
        jPanel2.add(ngaybd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, 30));

        ngaykt.setDate(new java.util.Date(1669125429000L));
        ngaykt.setDateFormatString("dd/MM/yyyy");
        jPanel2.add(ngaykt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 150, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Trạng thái :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Từ ngày:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 66, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Đến ngày:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 75, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 380, 150));

        lbltongcong.setBackground(new java.awt.Color(255, 255, 255));
        lbltongcong.setForeground(new java.awt.Color(255, 0, 51));
        lbltongcong.setText("0");
        jPanel1.add(lbltongcong, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 222, 160, 30));

        lblsokhuyenmai.setBackground(new java.awt.Color(255, 255, 255));
        lblsokhuyenmai.setForeground(new java.awt.Color(0, 0, 0));
        lblsokhuyenmai.setText("0");
        jPanel1.add(lblsokhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 30, 30));

        lbltienkm.setBackground(new java.awt.Color(255, 255, 255));
        lbltienkm.setForeground(new java.awt.Color(255, 0, 51));
        lbltienkm.setText("0");
        jPanel1.add(lbltienkm, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 272, 130, 30));

        lblthanhtien.setBackground(new java.awt.Color(255, 255, 255));
        lblthanhtien.setForeground(new java.awt.Color(255, 0, 51));
        lblthanhtien.setText("0");
        jPanel1.add(lblthanhtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 322, 110, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Chi Tiết Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        tablehoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Tên NV", "Tên KH", "Ngày Tạo", "Trạng Thái"
            }
        ));
        tablehoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablehoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablehoadon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 680, 200));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Chi Tiết Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        tablegiohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Loại SP", "Size", "Màu sắc", "Số Lượng", "Giá Bán", "Thành Tiền"
            }
        ));
        jScrollPane2.setViewportView(tablegiohang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 1030, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimCaretUpdate
        // TODO add your handling code here:
        FinmaHD(txttim.getText());
    }//GEN-LAST:event_txttimCaretUpdate

    private void tablehoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehoadonMouseClicked
        // TODO add your handling code here:
        ClearAlltableGioHang();
        int row = tablehoadon.getSelectedRow();
        String maHD = tablehoadon.getValueAt(row, 1).toString();
        String idHd = "";
        for (HoaDonModel hdm : banHangITF.MaHDToIdHD(maHD)) {
            idHd += hdm;
        }
        bang = (DefaultTableModel) tablegiohang.getModel();
        for (GioHang_BanHangModel ghbhm : banHangITF.MouesClickTableHoaDon(idHd)) {
            bang.addRow(new Object[]{tablegiohang.getRowCount() + 1, ghbhm.getTenSP(), ghbhm.getLoaiSP(),ghbhm.getSize(),ghbhm.getMauSac(), ghbhm.getSoLuong(), ghbhm.getDonGia(), ghbhm.getSoLuong()*Integer.parseInt( ghbhm.getDonGia())});
        }
        String tenKM = MaHDtoTenKM(maHD);
        lblchuongtrinhkm.setText(tenKM);
        lblmahd.setText(maHD);
        TinhTongTien();
        for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.getKhuyenMai(lblchuongtrinhkm.getText())) {
            lblsokhuyenmai.setText(khuyenMai_BanHangModel.getGiamGia());
//            lblhankm.setText(khuyenMai_BanHangModel.getNgayBD() + " - " + khuyenMai_BanHangModel.getNgayKT());
        }
        if (lblchuongtrinhkm.getText() == null) {
            lblthanhtien.setText(lbltongcong.getText());
            lblsokhuyenmai.setText("0");
            lbltienkm.setText("0");
        } else {
            updatetienKM();
        }
    }//GEN-LAST:event_tablehoadonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ngaybd = sdf.format(this.ngaybd.getDate());
        String ngaykt = sdf.format(this.ngaybd.getDate());
        LocNgay(ngaybd, ngaykt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblchuongtrinhkm;
    private javax.swing.JTextField lblmahd;
    private javax.swing.JTextField lblsokhuyenmai;
    private javax.swing.JTextField lblthanhtien;
    private javax.swing.JTextField lbltienkm;
    private javax.swing.JTextField lbltongcong;
    private com.toedter.calendar.JDateChooser ngaybd;
    private com.toedter.calendar.JDateChooser ngaykt;
    private javax.swing.JTable tablegiohang;
    private javax.swing.JTable tablehoadon;
    private javax.swing.JTextField txttim;
    // End of variables declaration//GEN-END:variables
}
