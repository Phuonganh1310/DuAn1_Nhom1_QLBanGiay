/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.Thongke_Model;
import ITFService.ThongKeITF;
import Repositories.ThongKeRepo;
import ServiceIML.ThongKeIML;
import java.text.SimpleDateFormat;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Menu6 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Menu1
     */
    public ThongKeITF tkITF = new ThongKeIML();
    private ThongKeRepo tkrp = new ThongKeRepo();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public Menu6() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        LoadTableTK();
        tongTatca();
        HoaDonTatca();
        SanPhamTatca();
        KhachHangTatca();
        RadioNhanVien();
    }

    private void LoadTableTK() {
        DefaultTableModel bang = (DefaultTableModel) tbl_ThongKe.getModel();
        this.tkrp.getall();
        bang.setRowCount(0);
        for (Thongke_Model sp : this.tkrp.getall()) {
            bang.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getSoLuong(), sp.getNgayTao(), sp.getTT()});
        }
    }

    //load label tat ca
    private void tongTatca() {
        for (Thongke_Model sp : this.tkrp.tongTatCa()) {
            lb_tong.setText(sp.getTong());
        }
    }

    private void HoaDonTatca() {
        for (Thongke_Model sp : this.tkrp.HoaDonTatCa()) {
            lb_HoaDon.setText(sp.getTong());
        }
    }

    private void SanPhamTatca() {
        for (Thongke_Model sp : this.tkrp.SanPhamTatCa()) {
            lb_SanPham.setText(sp.getTong());
        }
    }

    private void KhachHangTatca() {
        for (Thongke_Model sp : this.tkrp.KhachHangTatCa()) {
            lb_KhachHang.setText(sp.getTong());
        }
    }

    //load  label ngay
    private void tongNgay() {
        for (Thongke_Model sp : this.tkrp.tongNgay()) {
            lb_tong.setText(sp.getTong());
        }
    }

    private void HoaDonNgay() {
        for (Thongke_Model sp : this.tkrp.HoaDonNgay()) {
            lb_HoaDon.setText(sp.getTong());
        }
    }

    private void SanPhamNgay() {
        for (Thongke_Model sp : this.tkrp.SanPhamNgay()) {
            lb_SanPham.setText(sp.getTong());
        }
    }

    private void KhachHangNgay() {
        for (Thongke_Model sp : this.tkrp.KhachHangNgay()) {
            lb_KhachHang.setText(sp.getTong());
        }
    }

    //load label Thang
    private void tongThang() {
        for (Thongke_Model sp : this.tkrp.tongThang()) {
            lb_tong.setText(sp.getTong());
        }
    }

    private void HoaDonThang() {
        for (Thongke_Model sp : this.tkrp.HoaDonThang()) {
            lb_HoaDon.setText(sp.getTong());
        }
    }

    private void SanPhamThang() {
        for (Thongke_Model sp : this.tkrp.SanPhamThang()) {
            lb_SanPham.setText(sp.getTong());
        }
    }

    private void KhachHangThang() {
        for (Thongke_Model sp : this.tkrp.KhachHangThang()) {
            lb_KhachHang.setText(sp.getTong());
        }
    }

    //load label nam
    private void tongNam() {
        for (Thongke_Model sp : this.tkrp.tongNam()) {
            lb_tong.setText(sp.getTong());
        }
    }

    private void HoaDonNam() {
        for (Thongke_Model sp : this.tkrp.HoaDonNam()) {
            lb_HoaDon.setText(sp.getTong());
        }
    }

    private void SanPhamNam() {
        for (Thongke_Model sp : this.tkrp.SanPhamNam()) {
            lb_SanPham.setText(sp.getTong());
        }
    }

    private void KhachHangNam() {
        for (Thongke_Model sp : this.tkrp.KhachHangNam()) {
            lb_KhachHang.setText(sp.getTong());
        }
    }

    //load table nhan vien
    private void LoadTableNVtuan() {
        DefaultTableModel bang = (DefaultTableModel) tbl_NhanVien.getModel();
        this.tkrp.NhanVienXS();
        bang.setRowCount(0);
        for (Thongke_Model sp : this.tkrp.NhanVienXS()) {
            bang.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getSoLuong(), sp.getTong(), null});
        }
    }

    private void LoadTableNVThang() {
        DefaultTableModel bang = (DefaultTableModel) tbl_NhanVien.getModel();
        this.tkrp.NhanVienXSThang();
        bang.setRowCount(0);
        for (Thongke_Model sp : this.tkrp.NhanVienXSThang()) {
            bang.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getSoLuong(), sp.getTong(), null});
        }
    }

    private void LoadTableNVNam() {
        DefaultTableModel bang = (DefaultTableModel) tbl_NhanVien.getModel();
        this.tkrp.NhanVienXSNam();
        bang.setRowCount(0);
        for (Thongke_Model sp : this.tkrp.NhanVienXSNam()) {
            bang.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getSoLuong(), sp.getTong(), null});
        }
    }

    //radio buton nhan vieen
    private void RadioNhanVien() {
        if (rbt_nvTuan.isSelected()) {
            LoadTableNVtuan();
        } else if (rbt_nvThang.isSelected()) {
            LoadTableNVThang();
        } else if (rbt_nvNam.isSelected()) {
            LoadTableNVNam();
        }
    }

    //radio buton san pham
    private void Radio() {
        if (rbt_TatCa.isSelected()) {
            tongTatca();
            HoaDonTatca();
            SanPhamTatca();
            KhachHangTatca();
        } else if (rbt_HomNay.isSelected()) {
            tongNgay();
            HoaDonNgay();
            SanPhamNgay();
            KhachHangNgay();
        } else if (rbt_Thang.isSelected()) {
            tongThang();
            HoaDonThang();
            SanPhamThang();
            KhachHangThang();
        } else if (rbt_Nam.isSelected()) {
            tongNam();
            HoaDonNam();
            SanPhamNam();
            KhachHangNam();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lb_tong = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_HoaDon = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb_SanPham = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lb_KhachHang = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ThongKe = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        rbt_nvTuan = new javax.swing.JRadioButton();
        rbt_nvThang = new javax.swing.JRadioButton();
        rbt_nvNam = new javax.swing.JRadioButton();
        rbt_TatCa = new javax.swing.JRadioButton();
        rbt_HomNay = new javax.swing.JRadioButton();
        rbt_Thang = new javax.swing.JRadioButton();
        rbt_Nam = new javax.swing.JRadioButton();
        btnbieudo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 690));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 690));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Doanh Thu");

        lb_tong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setText("VNĐ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lb_tong, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_tong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Số Hóa Đơn");

        lb_HoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lb_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Số Sản Phẩm");

        lb_SanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_SanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lb_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Số Khách Hàng");

        lb_KhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lb_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tbl_ThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "Ngày Thanh Toán", "Trạng Thái"
            }
        ));
        jScrollPane2.setViewportView(tbl_ThongKe);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("Sản phẩm bán", jPanel14);

        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Số Lượng", "Doanh Thu"
            }
        ));
        jScrollPane1.setViewportView(tbl_NhanVien);

        buttonGroup2.add(rbt_nvTuan);
        rbt_nvTuan.setSelected(true);
        rbt_nvTuan.setText("Tuần");
        rbt_nvTuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_nvTuanActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbt_nvThang);
        rbt_nvThang.setText("Tháng");
        rbt_nvThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_nvThangActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbt_nvNam);
        rbt_nvNam.setText("Năm");
        rbt_nvNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_nvNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(rbt_nvTuan)
                .addGap(18, 18, 18)
                .addComponent(rbt_nvThang)
                .addGap(34, 34, 34)
                .addComponent(rbt_nvNam)
                .addContainerGap(813, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbt_nvTuan)
                    .addComponent(rbt_nvThang)
                    .addComponent(rbt_nvNam))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Doanh thu bán NV", jPanel13);

        buttonGroup1.add(rbt_TatCa);
        rbt_TatCa.setSelected(true);
        rbt_TatCa.setText("Tất Cả");
        rbt_TatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_TatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbt_HomNay);
        rbt_HomNay.setText("Hôm Nay");
        rbt_HomNay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });

        buttonGroup1.add(rbt_Thang);
        rbt_Thang.setText("Tháng");
        rbt_Thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_ThangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbt_Nam);
        rbt_Nam.setText("Năm");
        rbt_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_NamActionPerformed(evt);
            }
        });

        btnbieudo.setText("Biểu đồ thống kê");
        btnbieudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbieudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbt_TatCa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbt_HomNay)
                                .addGap(18, 18, 18)
                                .addComponent(rbt_Thang)
                                .addGap(18, 18, 18)
                                .addComponent(rbt_Nam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnbieudo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(94, 94, 94))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbt_TatCa)
                            .addComponent(rbt_HomNay)
                            .addComponent(rbt_Thang)
                            .addComponent(rbt_Nam)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbieudo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1082, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbt_TatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_TatCaActionPerformed
        // TODO add your handling code here:
        Radio();
    }//GEN-LAST:event_rbt_TatCaActionPerformed

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
        Radio();
    }//GEN-LAST:event_none

    private void rbt_ThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_ThangActionPerformed
        // TODO add your handling code here:
        Radio();
    }//GEN-LAST:event_rbt_ThangActionPerformed

    private void rbt_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_NamActionPerformed
        // TODO add your handling code here:
        Radio();
    }//GEN-LAST:event_rbt_NamActionPerformed

    private void rbt_nvNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_nvNamActionPerformed
        // TODO add your handling code here:
        RadioNhanVien();
    }//GEN-LAST:event_rbt_nvNamActionPerformed

    private void rbt_nvThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_nvThangActionPerformed
        // TODO add your handling code here:
        RadioNhanVien();
    }//GEN-LAST:event_rbt_nvThangActionPerformed

    private void rbt_nvTuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_nvTuanActionPerformed
        // TODO add your handling code here:
        RadioNhanVien();
    }//GEN-LAST:event_rbt_nvTuanActionPerformed

    private void btnbieudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbieudoActionPerformed
        // TODO add your handling code here:
        new BieuDoThongKe().setVisible(true);
    }//GEN-LAST:event_btnbieudoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbieudo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb_HoaDon;
    private javax.swing.JLabel lb_KhachHang;
    private javax.swing.JLabel lb_SanPham;
    private javax.swing.JLabel lb_tong;
    private javax.swing.JRadioButton rbt_HomNay;
    private javax.swing.JRadioButton rbt_Nam;
    private javax.swing.JRadioButton rbt_TatCa;
    private javax.swing.JRadioButton rbt_Thang;
    private javax.swing.JRadioButton rbt_nvNam;
    private javax.swing.JRadioButton rbt_nvThang;
    private javax.swing.JRadioButton rbt_nvTuan;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTable tbl_ThongKe;
    // End of variables declaration//GEN-END:variables
}
