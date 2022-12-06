/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class QuanLy extends javax.swing.JFrame {
//d

    /**
     * Creates new form QuanLy
     */
    Color DefaultColor, ClickeColor;
    Login lg = new Login();

    public QuanLy(String manv, String tennv, String chucvu) {
        initComponents();
        this.setLocationRelativeTo(null);

        DefaultColor = new Color(51, 51, 51);
        ClickeColor = new Color(102, 102, 102);
        lblmanv.setText(manv);
        txtName.setText(tennv);
        txtChucVu.setText(chucvu);
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(DefaultColor);

        Menu1 mn1 = new Menu1();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn1).setVisible(true);
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
        jLabel10 = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JLabel();
        jDesktopPanel = new javax.swing.JDesktopPane();
        jDesktopPanel1 = new javax.swing.JDesktopPane();
        lblmanv = new javax.swing.JLabel();
        jlabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        menu8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        menu7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        menu9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        menu6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        menu5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        menu4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        menu3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        menu2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        menu1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/close (2).png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 20, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setText("Tên : ");
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, 30));

        txtChucVu.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        txtChucVu.setForeground(new java.awt.Color(255, 255, 255));
        txtChucVu.setText("Chức Vụ: ");
        jPanel1.add(txtChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 190, 30));

        jDesktopPanel.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPanel.setPreferredSize(new java.awt.Dimension(1270, 570));

        jDesktopPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPanel1.setPreferredSize(new java.awt.Dimension(1270, 570));

        javax.swing.GroupLayout jDesktopPanel1Layout = new javax.swing.GroupLayout(jDesktopPanel1);
        jDesktopPanel1.setLayout(jDesktopPanel1Layout);
        jDesktopPanel1Layout.setHorizontalGroup(
            jDesktopPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
        );
        jDesktopPanel1Layout.setVerticalGroup(
            jDesktopPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jDesktopPanel.setLayer(jDesktopPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
            .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jDesktopPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jDesktopPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jDesktopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1270, 570));

        lblmanv.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        lblmanv.setForeground(new java.awt.Color(255, 255, 255));
        lblmanv.setText("Mã : ");
        jPanel1.add(lblmanv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 30));

        jlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/URBAN OUTFIT (1).png"))); // NOI18N
        jPanel1.add(jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        jPanel2.setBackground(new java.awt.Color(50, 43, 43));

        menu8.setBackground(new java.awt.Color(50, 43, 43));
        menu8.setForeground(new java.awt.Color(255, 255, 255));
        menu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu8MousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/customer.png"))); // NOI18N
        jLabel11.setText(" Khách hàng");

        javax.swing.GroupLayout menu8Layout = new javax.swing.GroupLayout(menu8);
        menu8.setLayout(menu8Layout);
        menu8Layout.setHorizontalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu8Layout.setVerticalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu7.setBackground(new java.awt.Color(50, 43, 43));
        menu7.setForeground(new java.awt.Color(255, 255, 255));
        menu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu7MousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/multiple-users-silhouette.png"))); // NOI18N
        jLabel9.setText(" Nhân Viên");

        javax.swing.GroupLayout menu7Layout = new javax.swing.GroupLayout(menu7);
        menu7.setLayout(menu7Layout);
        menu7Layout.setHorizontalGroup(
            menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        menu7Layout.setVerticalGroup(
            menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        menu9.setBackground(new java.awt.Color(50, 43, 43));
        menu9.setForeground(new java.awt.Color(255, 255, 255));
        menu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu9MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu9MousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        jLabel12.setText(" Đăng Xuất");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menu9Layout = new javax.swing.GroupLayout(menu9);
        menu9.setLayout(menu9Layout);
        menu9Layout.setHorizontalGroup(
            menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        menu9Layout.setVerticalGroup(
            menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        menu6.setBackground(new java.awt.Color(50, 43, 43));
        menu6.setPreferredSize(new java.awt.Dimension(190, 60));
        menu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu6MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/trend.png"))); // NOI18N
        jLabel8.setText(" Thống kê");

        javax.swing.GroupLayout menu6Layout = new javax.swing.GroupLayout(menu6);
        menu6.setLayout(menu6Layout);
        menu6Layout.setHorizontalGroup(
            menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(13, 13, 13))
        );
        menu6Layout.setVerticalGroup(
            menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        menu5.setBackground(new java.awt.Color(50, 43, 43));
        menu5.setPreferredSize(new java.awt.Dimension(190, 60));
        menu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu5MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/promotions.png"))); // NOI18N
        jLabel7.setText("Khuyến Mại");

        javax.swing.GroupLayout menu5Layout = new javax.swing.GroupLayout(menu5);
        menu5.setLayout(menu5Layout);
        menu5Layout.setHorizontalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(17, 17, 17))
        );
        menu5Layout.setVerticalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu4.setBackground(new java.awt.Color(50, 43, 43));
        menu4.setPreferredSize(new java.awt.Dimension(190, 60));
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu4MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gift.png"))); // NOI18N
        jLabel3.setText(" Sản Phẩm");

        javax.swing.GroupLayout menu4Layout = new javax.swing.GroupLayout(menu4);
        menu4.setLayout(menu4Layout);
        menu4Layout.setHorizontalGroup(
            menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        menu4Layout.setVerticalGroup(
            menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        menu3.setBackground(new java.awt.Color(50, 43, 43));
        menu3.setPreferredSize(new java.awt.Dimension(190, 60));
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu3MousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/bill (1).png"))); // NOI18N
        jLabel6.setText(" Hóa Đơn");

        javax.swing.GroupLayout menu3Layout = new javax.swing.GroupLayout(menu3);
        menu3.setLayout(menu3Layout);
        menu3Layout.setHorizontalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        menu3Layout.setVerticalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        menu2.setBackground(new java.awt.Color(50, 43, 43));
        menu2.setPreferredSize(new java.awt.Dimension(190, 60));
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu2MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/shopping-cart.png"))); // NOI18N
        jLabel5.setText(" Bán Hàng");

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        menu1.setBackground(new java.awt.Color(50, 43, 43));
        menu1.setPreferredSize(new java.awt.Dimension(140, 60));
        menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu1MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/home (1).png"))); // NOI18N
        jLabel4.setText("Trang Chủ");

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(menu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1270, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1265, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MousePressed
        // TODO add your handling code here:
        menu1.setBackground(ClickeColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(DefaultColor);

    }//GEN-LAST:event_menu1MousePressed

    private void menu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu2MousePressed
        // TODO add your handling code here:
        menu1.setBackground(DefaultColor);
        menu2.setBackground(ClickeColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(DefaultColor);

    }//GEN-LAST:event_menu2MousePressed

    private void menu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu3MousePressed
        // TODO add your handling code here:
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(ClickeColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(DefaultColor);

    }//GEN-LAST:event_menu3MousePressed

    private void menu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu4MousePressed
        // TODO add your handling code here:
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(ClickeColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(DefaultColor);

    }//GEN-LAST:event_menu4MousePressed

    private void menu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu5MousePressed
        // TODO add your handling code here:
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(ClickeColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(DefaultColor);

    }//GEN-LAST:event_menu5MousePressed

    private void menu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu6MousePressed
        // TODO add your handling code here:
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(ClickeColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(DefaultColor);

    }//GEN-LAST:event_menu6MousePressed

    private void menu7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu7MousePressed
        // TODO add your handling code here:
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(ClickeColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(DefaultColor);

    }//GEN-LAST:event_menu7MousePressed

    private void menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseClicked
        // TODO add your handling code here:
        Menu1 mn1 = new Menu1();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn1).setVisible(true);
    }//GEN-LAST:event_menu1MouseClicked

    private void menu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu2MouseClicked
        // TODO add your handling code here:
        Menu2 mn2 = new Menu2();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn2).setVisible(true);
    }//GEN-LAST:event_menu2MouseClicked

    private void menu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu3MouseClicked
        // TODO add your handling code here:
        Menu3 mn3 = new Menu3();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn3).setVisible(true);
    }//GEN-LAST:event_menu3MouseClicked

    private void menu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu4MouseClicked
        // TODO add your handling code here:
        Menu4 mn4 = new Menu4();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn4).setVisible(true);
    }//GEN-LAST:event_menu4MouseClicked

    private void menu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu5MouseClicked
        // TODO add your handling code here:
        Menu5 mn5 = new Menu5();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn5).setVisible(true);
    }//GEN-LAST:event_menu5MouseClicked

    private void menu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu6MouseClicked
        // TODO add your handling code here:
        Menu6 mn6 = new Menu6();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn6).setVisible(true);
    }//GEN-LAST:event_menu6MouseClicked

    private void menu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu7MouseClicked
        // TODO add your handling code here:
        Menu7 mn7 = new Menu7();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn7).setVisible(true);
    }//GEN-LAST:event_menu7MouseClicked

    private void menu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu8MouseClicked
        // TODO add your handling code here:
        Menu8 mn8 = new Menu8();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(mn8).setVisible(true);
    }//GEN-LAST:event_menu8MouseClicked

    private void menu8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu8MousePressed
        // TODO add your handling code here:
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(ClickeColor);
        menu9.setBackground(DefaultColor);

    }//GEN-LAST:event_menu8MousePressed

    private void menu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu9MouseClicked
        // TODO add your handling code here:
        jDesktopPanel.removeAll();
    }//GEN-LAST:event_menu9MouseClicked

    private void menu9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu9MousePressed
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu4.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
        menu6.setBackground(DefaultColor);
        menu7.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu9.setBackground(ClickeColor);

    }//GEN-LAST:event_menu9MousePressed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng suất không ?");
        if (hoi == 0) {
            lg.setVisible(true);
            this.dispose();
        } else {
            return;
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void menu9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menu9MouseEntered
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JDesktopPane jDesktopPanel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlabel;
    public static javax.swing.JLabel lblmanv;
    private javax.swing.JPanel menu1;
    private javax.swing.JPanel menu2;
    private javax.swing.JPanel menu3;
    private javax.swing.JPanel menu4;
    private javax.swing.JPanel menu5;
    private javax.swing.JPanel menu6;
    private javax.swing.JPanel menu7;
    private javax.swing.JPanel menu8;
    private javax.swing.JPanel menu9;
    public static javax.swing.JLabel txtChucVu;
    public static javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
}
