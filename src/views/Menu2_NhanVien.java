/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDonModel;
import DomainModel.NhanVien;
import DomainModel.HoaDon_BanHangModel;
import DomainModel.KhuyenMai_BanHangModel;
import DomainModel.SanPham_BanhangModel;
import ITFService.BanHangITF;
import ServiceIML.BanHangIML;
import ViewModel.KhachHangViewModel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author DELL
 */
public class Menu2_NhanVien extends javax.swing.JInternalFrame {

    public BanHangITF banHangITF = new BanHangIML();
    public DefaultTableModel bang;
    private NumberFormat formatter = new DecimalFormat("#,###");
    SimpleDateFormat ftnow = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form Menu1
     */
    private String tenNV;

    public Menu2_NhanVien() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        LoadTableSanPham();
        LoadTableHoaDon();
        btnthanhtoan.setEnabled(false);
        cbbKhuyenMai();
        txtmaHoaDon.setEnabled(false);
        txttongtien.setEnabled(false);
        txtthanhtien.setEnabled(false);
        txttienthua.setEnabled(false);
        txtsokhuyenmai.setEnabled(false);
        txttienkhuyenmai.setEnabled(false);
        btnthemsanpham.setEnabled(false);
        txtbarcoe.requestFocus();
        btnhuy.setEnabled(false);
        btnxoaSanPham.setEnabled(false);
    }

// Hiện thị sản phẩm lên bảng sản phẩm
    private void LoadTableSanPham() {
        DefaultTableModel bang = (DefaultTableModel) tableSanPham.getModel();
        bang.setRowCount(0);
        int stt = 1;
        for (SanPham_BanhangModel sp : banHangITF.getall()) {
            if (Integer.parseInt(sp.getSoLuong()) > 0) {
                bang.addRow(new Object[]{stt++,
                    sp.getTenSP(),
                    sp.getLoaiSP(),
                    sp.getHang(),
                    sp.getChatLieu(),
                    sp.getKichCo(),
                    sp.getMauSac(),
                    sp.getDe(),
                    sp.getSoLuong(),
                    sp.getGiaBan(),
                    sp.getBarcode()});
            }
        }
    }

    // Tìm kiếm theo tên sản phẩm
    private void Findten(String ten) {
        DefaultTableModel bang = (DefaultTableModel) tableSanPham.getModel();
        bang.setRowCount(0);
        int stt = 1;
        for (SanPham_BanhangModel sp : banHangITF.FindTen(ten)) {
            bang.addRow(new Object[]{stt++,
                sp.getTenSP(),
                sp.getLoaiSP(),
                sp.getHang(),
                sp.getChatLieu(),
                sp.getKichCo(),
                sp.getMauSac(),
                sp.getDe(),
                sp.getSoLuong(),
                sp.getGiaBan(),
                sp.getBarcode()});
        }
    }
// Thêm sản phẩm vào giỏ hàng

    private void LoadTableGioHang(int soLuong) {
        bang = (DefaultTableModel) tableGioHang.getModel();
        int row = tableSanPham.getSelectedRow();
        String barcode = tableSanPham.getValueAt(row, 10).toString();
        for (GioHang_BanHangModel gh : banHangITF.getAllGioHang(null, barcode)) {
            bang.addRow(new Object[]{tableGioHang.getRowCount() + 1, gh.getTenSP(), gh.getSize(), gh.getMauSac(), soLuong, gh.getDonGia(), Integer.parseInt(gh.getDonGia()) * soLuong, gh.getBarcode()});
        }
    }
// Hiển thị hóa đơn lên bảng hóa đơn

    private void LoadTableHoaDon() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getAllHoaDon()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }

    private void Timma(String ma) {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.TimMaHoaDon(ma)) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }
// Lọc hóa đơn đã thanh toán

    private void LoadTableHoaDonThanhToan() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getHoaDonThanhToan()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }
// Lọc hóa đơn đang chờ

    private void LoadTableHoaDonDangCho() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getHoaDonDangCho()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }
//lọc hóa đơn chờ thanh toán

    private void LoadTableHoaDonDaHuy() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getHoaDonDangChoThanhToan()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }
// Tính tổng tiền trong gio hàng

    private void TinhTongTien() {
        int tien, tongtien = 0;
        int row = tableGioHang.getRowCount();
        for (int i = 0; i < row; i++) {
            tien = Integer.parseInt(tableGioHang.getValueAt(i, 6).toString());
            tongtien += tien;
        }
        txttongtien.setText(formatter.format(tongtien));
    }
// thêm vào hóa đơn chi tiết

    private void InsertHoaDonChiTiet() {
        int row = tableGioHang.getRowCount();
        for (int i = 0; i < row; i++) {
            String barcode = tableGioHang.getValueAt(i, 7).toString();
            String MaHD = txtmaHoaDon.getText();
            String idChiTietSP = "";
            String idHoaDon = "";
            String idKM = "";
            for (SanPham_BanhangModel sanPham_BanhangModel : banHangITF.TenSPToId(barcode)) {
                idChiTietSP += sanPham_BanhangModel.getIdChiTietSP();
            }
            for (HoaDonModel hoaDonModel : banHangITF.MaHDToIdHD(MaHD)) {
                idHoaDon += hoaDonModel;
            }
            for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.TenKMtoIdKM(cbbkhuyenmai.getSelectedItem().toString())) {
                idKM += khuyenMai_BanHangModel;
            }
            String soLuong = tableGioHang.getValueAt(i, 4).toString();
            String GiaBan = tableGioHang.getValueAt(i, 5).toString();
            int DonGia = Integer.parseInt(soLuong) * Integer.parseInt(GiaBan);
            if (cbbkhuyenmai.getSelectedIndex() != 0) {
                banHangITF.insertHoaDonChiTiet(idHoaDon, idChiTietSP, idKM, Integer.parseInt(soLuong), String.valueOf(DonGia));
            } else {
                banHangITF.insertHoaDonChiTiet(idHoaDon, idChiTietSP, null, Integer.parseInt(soLuong), String.valueOf(DonGia));
            }
            banHangITF.updateSoLuongSanPham(Integer.parseInt(soLuong), idChiTietSP);
        }
    }

    // Thêm item vào cbb khuyến mại
    private void cbbKhuyenMai() {
        Date now = new Date();
        if (cbbkhuyenmai.getSelectedIndex() == 0) {
            txtthanhtien.setText(txttongtien.getText());
        }
        for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.getCbbTenKM(ftnow.format(now), ftnow.format(now))) {
            cbbkhuyenmai.addItem(khuyenMai_BanHangModel.getTenKM());
        }

    }

    // cập nhật tiền đc khuyến mại
    private void updatetienKM() {
        int Dis;
        NumberFormat formatter = new DecimalFormat("#,###");
        //tính Discount
        String Order = txttongtien.getText().replaceAll(",", "");
        Dis = (Integer.parseInt(txtsokhuyenmai.getText()) * Integer.parseInt(Order)) / 100;
        txttienkhuyenmai.setText(formatter.format(Dis));
        int tienkhuyenmai = Integer.parseInt(Order) - Dis;
        txtthanhtien.setText(formatter.format(tienkhuyenmai));

    }
// Xóa dữ liệu trên bảng giỏ hàng.

    public void ClearAlltableGioHang() {
        bang = (DefaultTableModel) tableGioHang.getModel();
        bang.getDataVector().removeAllElements();
        revalidate();
    }

    // Chuyển mã hóa đơn sang tên km
    public String MaHDtoTenKM(String MaHD) {
        for (HoaDonModel hdm : banHangITF.MouseClickKM()) {
            if (MaHD.equals(hdm.getMaHD().toString())) {
                return hdm.getIdKM();
            }
        }
        return null;
    }
///test

    private void Clearform() {
        txtmaHoaDon.setText("");
        txtsokhuyenmai.setText("0");
        txttongtien.setText("0");
        txttienkhachdua.setText("0");
        txtthanhtien.setText("0");
        txttienthua.setText("0");
        txttienkhuyenmai.setText("0");
        lblthongbao.setText("");
        lblhankm.setText("");
        cbbkhuyenmai.setSelectedIndex(0);
        bang = (DefaultTableModel) tableGioHang.getModel();
        bang.setNumRows(0);
        btnhuy.setEnabled(false);
    }

    private void Barcode(int soluong) {
        bang = (DefaultTableModel) tableGioHang.getModel();
        banHangITF.getAllGioHang(null, txtbarcoe.getText()).forEach(gh -> {
            bang.addRow(new Object[]{tableGioHang.getRowCount() + 1, gh.getTenSP(), gh.getSize(), gh.getMauSac(), soluong, gh.getDonGia(), Integer.parseInt(gh.getDonGia()) * soluong, gh.getBarcode()});
        });
    }

    private String getTenKH(String sdt) {
        for (KhachHangViewModel khvm : banHangITF.getID_Ten_DiaChiKH(sdt)) {
            if (khvm.getSdt().toString().equals(sdt)) {
                return khvm.getTenKh();
            }
        }
        return null;
    }

    private String getDiaChiKH(String sdt) {
        for (KhachHangViewModel khvm : banHangITF.getID_Ten_DiaChiKH(sdt)) {
            if (khvm.getSdt().toString().equals(sdt)) {
                return khvm.getDiachi();
            }
        }
        return null;
    }

    private void CapNhapSoLuongHDHUY() {
        int row = tableGioHang.getRowCount();
        for (int i = 0; i < row; i++) {
            String soLuong = tableGioHang.getValueAt(i, 4).toString();
            String barcode = tableGioHang.getValueAt(i, 7).toString();
            banHangITF.updatesoLuongHuy(soLuong, barcode);
        }
    }

    private void XuatHoaDon() {
        Date now = new Date();
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream out = new FileOutputStream(new File("src/FileInHoaDon/" + txtmaHoaDon.getText() + ".docx"));

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run.setText("CỬA HÀNG BÁN GIÀY RUNNING");
            run.setFontSize(20);
            run.setBold(true);

            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            paragraph2.setAlignment(ParagraphAlignment.CENTER);
            run2.setText("ĐC: Phố Trịnh Văn Bô, Xuân Phương, Nam Từ Liêm, Hà Nội");

            XWPFParagraph paragraph3 = document.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);
            run3.setText("ĐT: 0862.008.304");
            run3.setTextPosition(50);

            XWPFParagraph paragraph4 = document.createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("HÓA ĐƠN BÁN HÀNG");
            run4.setFontSize(30);
            run4.setBold(true);

            XWPFParagraph paragraph55 = document.createParagraph();
            XWPFRun run55 = paragraph55.createRun();
            run55.setText("Mã hóa đơn:  " + txtmaHoaDon.getText());

            XWPFParagraph paragraph5 = document.createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            run5.setText("Khách hàng:  " + getTenKH(txtKhachMuaHang.getText()));

            XWPFParagraph paragraph6 = document.createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            run6.setText("Địa chỉ:          " + getDiaChiKH(txtKhachMuaHang.getText()));

            XWPFParagraph paragraph7 = document.createParagraph();
            XWPFRun run7 = paragraph7.createRun();
            run7.setText("SĐT:                " + txtKhachMuaHang.getText());

            XWPFParagraph paragraph8 = document.createParagraph();
            XWPFRun run8 = paragraph8.createRun();
            run8.setText("Ngày lập: " + ftnow.format(now));
            run8.setTextPosition(20);

            XWPFTable table = document.createTable(tableGioHang.getRowCount() + 2, 7);
            table.setWidth(50000);
            table.setCellMargins(ERROR, 300, ABORT, 300);

            XWPFTableRow row = table.getRow(0);
            XWPFParagraph paragraph9 = row.getCell(0).addParagraph();
            paragraph9.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run9 = paragraph9.createRun();
            run9.setText("STT");
            run9.setBold(true);
            run9.setTextPosition(20);

            XWPFTableRow row2 = table.getRow(0);
            XWPFParagraph paragraph10 = row.getCell(1).addParagraph();
            paragraph10.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run10 = paragraph10.createRun();
            run10.setText("Tên sản phẩm");
            run10.setBold(true);
            run10.setTextPosition(20);

            XWPFTableRow row89 = table.getRow(0);
            XWPFParagraph paragraph11 = row.getCell(2).addParagraph();
            paragraph11.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run11 = paragraph11.createRun();
            run11.setText("Kích cỡ");
            run11.setBold(true);
            run11.setTextPosition(20);

            XWPFTableRow row3 = table.getRow(0);
            XWPFParagraph paragraph12 = row.getCell(3).addParagraph();
            paragraph12.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run12 = paragraph12.createRun();
            run12.setText("Màu sắc");
            run12.setBold(true);
            run12.setTextPosition(20);

            XWPFTableRow row4 = table.getRow(0);
            XWPFParagraph paragraph13 = row.getCell(4).addParagraph();
            paragraph13.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run13 = paragraph13.createRun();
            run13.setText("Số lượng");
            run13.setBold(true);
            run13.setTextPosition(20);

            XWPFTableRow row5 = table.getRow(0);
            XWPFParagraph paragraph14 = row.getCell(5).addParagraph();
            paragraph14.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run14 = paragraph14.createRun();
            run14.setText("Đơn giá");
            run14.setBold(true);
            run14.setTextPosition(20);

            XWPFTableRow row6 = table.getRow(0);
            XWPFParagraph paragraph15 = row.getCell(6).addParagraph();
            paragraph14.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run15 = paragraph15.createRun();
            run15.setText("Thành tiền");
            run15.setBold(true);
            run15.setTextPosition(20);

            int tongsoluong = 0;
            for (int i = 0; i < tableGioHang.getRowCount(); i++) {
                String soluong = tableGioHang.getValueAt(i, 4).toString();
                table.getRow(i + 1).getCell(0).setText(tableGioHang.getValueAt(i, 0).toString());
                table.getRow(i + 1).getCell(1).setText(tableGioHang.getValueAt(i, 1).toString());
                table.getRow(i + 1).getCell(2).setText(tableGioHang.getValueAt(i, 2).toString());
                table.getRow(i + 1).getCell(3).setText(tableGioHang.getValueAt(i, 3).toString());
                table.getRow(i + 1).getCell(4).setText(soluong);
                table.getRow(i + 1).getCell(5).setText(tableGioHang.getValueAt(i, 5).toString() + " VNĐ");
                table.getRow(i + 1).getCell(6).setText(tableGioHang.getValueAt(i, 6).toString() + " VNĐ");
                tongsoluong += Integer.parseInt(soluong);
            }

            XWPFParagraph paragraph22 = document.createParagraph();
            paragraph22.setAlignment(ParagraphAlignment.LEFT);

            XWPFParagraph paragraph20 = document.createParagraph();
            paragraph20.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run211 = paragraph20.createRun();
            run211.setText("TỔNG CỘNG :                      " + tongsoluong + "                      " + txttongtien.getText() + " VNĐ");
            run211.setBold(true);

            XWPFParagraph paragraph21 = document.createParagraph();
            paragraph21.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run21 = paragraph21.createRun();
            run21.setText("CHIẾT KHẤU:                       " + txtsokhuyenmai.getText() + "%                  -" + txttienkhuyenmai.getText() + " VNĐ");
            run21.setBold(true);

            XWPFParagraph paragraph200 = document.createParagraph();
            paragraph200.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run20 = paragraph200.createRun();
            run20.setText("TỔNG TIỀN THANH TOÁN:                            " + txtthanhtien.getText() + " VNĐ");
            run20.setBold(true);

            XWPFParagraph paragraph23 = document.createParagraph();
            paragraph23.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run23 = paragraph23.createRun();
            run23.setText("Chương trình khuyến mại : " + cbbkhuyenmai.getSelectedItem().toString());

            XWPFParagraph paragraph24 = document.createParagraph();
            paragraph24.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run24 = paragraph24.createRun();
            run24.setText("Tiền khách đưa : " + txttienkhachdua.getText() + " VNĐ");

            XWPFParagraph paragraph25 = document.createParagraph();
            paragraph25.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run25 = paragraph25.createRun();
            run25.setText("Tiền trả lại: " + txttienthua.getText() + " VNĐ");

            XWPFParagraph paragraph26 = document.createParagraph();
            paragraph26.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run26 = paragraph26.createRun();
            run26.setText("------------------------------------------------------------------------------------------------------------------------------------------");

            XWPFParagraph paragraph18 = document.createParagraph();
            paragraph18.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run18 = paragraph18.createRun();
            run18.setText("Cảm ơn quý khách đã mua hàng!");

            XWPFParagraph paragraph19 = document.createParagraph();
            paragraph19.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run19 = paragraph19.createRun();
            run19.setText("Hẹn gặp lại!");

            document.write(out);
            out.close();
            document.close();

            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(System.err);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        CbbHoaDon = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableHoaDon = new javax.swing.JTable();
        txtmatimkiem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnxoaSanPham = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGioHang = new javax.swing.JTable();
        txtbarcoe = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnthemsanpham = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        txttimkiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmaHoaDon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbbkhuyenmai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtsokhuyenmai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttienkhuyenmai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttienkhachdua = new javax.swing.JTextField();
        txttienthua = new javax.swing.JTextField();
        btnthanhtoan = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        lblthongbao = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtKhachMuaHang = new javax.swing.JTextField();
        ThemKH = new javax.swing.JButton();
        lblhankm = new javax.swing.JLabel();
        btnhuy = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1270, 570));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1270, 570));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 3, true), "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        CbbHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Đang chờ", "Đã hủy" }));
        CbbHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbHoaDonActionPerformed(evt);
            }
        });

        tableHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Tên NV", "Trạng thái", "Ngày tạo"
            }
        ));
        tableHoaDon.setGridColor(new java.awt.Color(255, 255, 255));
        tableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableHoaDon);

        txtmatimkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtmatimkiemCaretUpdate(evt);
            }
        });

        jLabel11.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(CbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addComponent(txtmatimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmatimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 770, 170));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        btnxoaSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnxoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete-button.png"))); // NOI18N
        btnxoaSanPham.setText("  Xóa");
        btnxoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaSanPhamActionPerformed(evt);
            }
        });

        tableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Size", "Màu sắc", "Số  lượng", "Đơn giá", "Thành tiền", "Barcode"
            }
        ));
        tableGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGioHangMouseClicked(evt);
            }
        });
        tableGioHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableGioHangKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableGioHang);

        txtbarcoe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbarcoeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbarcoeKeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Bar code:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnxoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbarcoe, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbarcoe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addComponent(btnxoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 770, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        btnthemsanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Thêm sản phẩm.png"))); // NOI18N
        btnthemsanpham.setText("Thêm sản phẩm");
        btnthemsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemsanphamActionPerformed(evt);
            }
        });

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Loại SP", "Hãng", "Chất liệu", "Kích cỡ", "Màu sắc", "Đế", "Số lượng", "Giá bán", "Barcode"
            }
        ));
        jScrollPane2.setViewportView(tableSanPham);

        txttimkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttimkiemCaretUpdate(evt);
            }
        });
        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnthemsanpham)
                        .addGap(27, 27, 27)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 254, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthemsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 770, 200));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mã Hóa Đơn:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 110, 20));

        txtmaHoaDon.setBackground(new java.awt.Color(153, 153, 153));
        txtmaHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtmaHoaDon.setForeground(new java.awt.Color(255, 0, 51));
        txtmaHoaDon.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtmaHoaDon.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txtmaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 290, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Chương trình GG:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 110, -1));

        cbbkhuyenmai.setBackground(new java.awt.Color(153, 153, 153));
        cbbkhuyenmai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbbkhuyenmai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Khuyến mại" }));
        cbbkhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbkhuyenmaiActionPerformed(evt);
            }
        });
        jPanel2.add(cbbkhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 80, 170, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tổng cộng: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 130, 40));

        txttongtien.setBackground(new java.awt.Color(255, 255, 255));
        txttongtien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttongtien.setForeground(new java.awt.Color(255, 0, 51));
        txttongtien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttongtien.setText("0");
        txttongtien.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txttongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtienActionPerformed(evt);
            }
        });
        jPanel2.add(txttongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, 290, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Chiết khấu:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 130, 20));

        txtsokhuyenmai.setBackground(new java.awt.Color(153, 153, 153));
        txtsokhuyenmai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsokhuyenmai.setText("0");
        txtsokhuyenmai.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txtsokhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsokhuyenmaiActionPerformed(evt);
            }
        });
        jPanel2.add(txtsokhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, 40, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("%");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, 18, -1));

        txttienkhuyenmai.setBackground(new java.awt.Color(153, 153, 153));
        txttienkhuyenmai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttienkhuyenmai.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttienkhuyenmai.setText("0");
        txttienkhuyenmai.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txttienkhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 190, 220, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Thành tiền:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 220, 130, 20));

        txtthanhtien.setBackground(new java.awt.Color(153, 153, 153));
        txtthanhtien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtthanhtien.setForeground(new java.awt.Color(255, 0, 51));
        txtthanhtien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtthanhtien.setText("0");
        txtthanhtien.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txtthanhtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 290, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Tiền khách đưa:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 110, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tiền trả lại:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 130, 20));

        txttienkhachdua.setBackground(new java.awt.Color(153, 153, 153));
        txttienkhachdua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttienkhachdua.setForeground(new java.awt.Color(51, 51, 255));
        txttienkhachdua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttienkhachdua.setText("0");
        txttienkhachdua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttienkhachduaCaretUpdate(evt);
            }
        });
        jPanel2.add(txttienkhachdua, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 290, 250, 30));

        txttienthua.setBackground(new java.awt.Color(255, 255, 255));
        txttienthua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttienthua.setForeground(new java.awt.Color(255, 0, 51));
        txttienthua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttienthua.setText("0");
        txttienthua.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txttienthua, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 290, 30));

        btnthanhtoan.setBackground(new java.awt.Color(51, 51, 51));
        btnthanhtoan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnthanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        btnthanhtoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Thanh Toán.png"))); // NOI18N
        btnthanhtoan.setText(" Thanh Toán");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });
        jPanel2.add(btnthanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 490, 210, 60));

        btnTaoHoaDon.setBackground(new java.awt.Color(51, 51, 51));
        btnTaoHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tạo hóa đơn.png"))); // NOI18N
        btnTaoHoaDon.setText(" Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });
        jPanel2.add(btnTaoHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, 170, 40));

        lblthongbao.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblthongbao.setForeground(new java.awt.Color(255, 0, 51));
        jPanel2.add(lblthongbao, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, 240, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Khách hàng: ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, 140, -1));

        txtKhachMuaHang.setBackground(new java.awt.Color(153, 153, 153));
        txtKhachMuaHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(txtKhachMuaHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 420, 250, 30));

        ThemKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ThemKH.setText("+");
        ThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemKHActionPerformed(evt);
            }
        });
        jPanel2.add(ThemKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 420, 40, 30));

        lblhankm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhankm.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lblhankm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 110, 160, 20));

        btnhuy.setBackground(new java.awt.Color(51, 51, 51));
        btnhuy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnhuy.setForeground(new java.awt.Color(255, 255, 255));
        btnhuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Hủy hóa đơn.png"))); // NOI18N
        btnhuy.setText("  Hủy Hóa Đơn");
        btnhuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuyActionPerformed(evt);
            }
        });
        jPanel2.add(btnhuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 520, 170, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void btnthemsanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemsanphamActionPerformed
        // TODO add your handling code here:
        int Line = tableGioHang.getRowCount();
        int row = tableSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm ");
            return;
        }
        String barcode = tableSanPham.getValueAt(row, 10).toString();
        String soluong = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng sản phẩm");
        int sl = Integer.parseInt(soluong);
        for (int i = 0; i < Line; i++) {
            if (tableGioHang.getValueAt(i, 7).equals(barcode)) {
                int quanCu = (int) tableGioHang.getValueAt(i, 4);
                int quanMoi = sl;
                int quanCuVaMoi = quanCu + quanMoi;
                sl = quanCuVaMoi;
                bang.removeRow(i);
                break;
            }
        }
        String soLuongTon = tableSanPham.getValueAt(row, 8).toString();
        if (Integer.parseInt(soLuongTon) < sl) {
            JOptionPane.showMessageDialog(this, "Sản phẩm chỉ còn số lượng là " + soLuongTon + " .");
            return;
        }
        LoadTableGioHang(sl);
        TinhTongTien();
        txtthanhtien.setText(txttongtien.getText());
        btnxoaSanPham.setEnabled(true);
    }//GEN-LAST:event_btnthemsanphamActionPerformed

    private void txttimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimkiemCaretUpdate
        // TODO add your handling code here:
        Findten(txttimkiem.getText());
        updatetienKM();
    }//GEN-LAST:event_txttimkiemCaretUpdate
//    private String getSDTtoID(String sdt) {
//        for (KhachHangViewModel kh : banHangITF.getIDKH(sdt)) {
//            if (kh.getSdt().toString().equals(sdt)) {
//                return kh.getId();
//            }
//        }
//        return null;
//    }
    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        if (txtKhachMuaHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mời bạn nhập thông tin khách hàng!");
            return;
        }
        int count = 0;
        count = tableHoaDon.getRowCount();
        String chuoi1 = "";
        int chuoi2 = 0;
        chuoi1 = tableHoaDon.getValueAt(count - 1, 1).toString();
        chuoi2 = Integer.parseInt(chuoi1.substring(3).toString());
        this.Clearform();
        if (chuoi2 + 1 < 10) {
            txtmaHoaDon.setText("HD000" + (chuoi2 + 1));
        } else if (chuoi2 + 1 < 100) {
            txtmaHoaDon.setText("HD00" + (chuoi2 + 1));
        } else if (chuoi2 + 1 < 1000) {
            txtmaHoaDon.setText("HD0" + (chuoi2 + 1));
        }
        String MaHD = txtmaHoaDon.getText();
        for (HoaDon_BanHangModel hdbhm : banHangITF.getAllHoaDon()) {
            if (MaHD.equals(hdbhm.getMaHD().toString())) {
                JOptionPane.showMessageDialog(this, "Lỗi !mã hóa đơn trùng, vui lòng chọn dòng cuối cùng.");
                return;
            }
        }
        int TrangThai = 1;
        String idKH = "";
        String sdtKH = txtKhachMuaHang.getText();
        for (KhachHangViewModel kh : banHangITF.getID_Ten_DiaChiKH(sdtKH)) {
            idKH += kh.getId();
        }
        String manv =views. NhanVien.lblmanv.getText();
        String idNV = "";
        for (NhanVien nv : banHangITF.getMaNVtoID(manv)) {
            idNV += nv.getId();
        }
        banHangITF.insertHoaDon(idKH, idNV, null, MaHD, TrangThai);
        this.LoadTableHoaDon();
        JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công.");
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed


    private void CbbHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbHoaDonActionPerformed
        // TODO add your handling code here:
        if (CbbHoaDon.getSelectedIndex() == 0) {
            LoadTableHoaDon();
        } else if (CbbHoaDon.getSelectedIndex() == 1) {
            LoadTableHoaDonThanhToan();
        } else if (CbbHoaDon.getSelectedIndex() == 2) {
            LoadTableHoaDonDangCho();
        } else if (CbbHoaDon.getSelectedIndex() == 3) {
            LoadTableHoaDonDaHuy();
        }
    }//GEN-LAST:event_CbbHoaDonActionPerformed

    private void txttienkhachduaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttienkhachduaCaretUpdate
        // TODO add your handling code here:
        int tienthua;
        while (true) {
            if (txttienkhachdua.getText().trim().equals("")) {
                lblthongbao.setText("Khách hàng chưa trả tiền.");
                btnthanhtoan.setEnabled(false);
                return;
            } else if (!txttienkhachdua.getText().trim().matches("\\d+")) {
                lblthongbao.setText("Tiền phải là số.");
                btnthanhtoan.setEnabled(false);
                return;
            } else {
                lblthongbao.setText("");
                btnthanhtoan.setEnabled(false);
                break;
            }
        }
        String tongtien = txtthanhtien.getText().replaceAll(",", "");
        tienthua = Integer.parseInt(txttienkhachdua.getText()) - Integer.parseInt(tongtien);
        txttienthua.setText(formatter.format(tienthua));

        if (tienthua < 0) {
            lblthongbao.setText("Khách hàng chưa đưa đủ tiền.");
            btnthanhtoan.setEnabled(false);
            txttienthua.setText("0");
        } else if (Integer.parseInt(txttienkhachdua.getText()) == 0) {
            txttienthua.setText("0");
            btnthanhtoan.setEnabled(false);
        } else {
            txttienthua.setText(formatter.format(tienthua));
            btnthanhtoan.setEnabled(true);
        }
    }//GEN-LAST:event_txttienkhachduaCaretUpdate

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        // TODO add your handling code here:
        int row = tableHoaDon.getSelectedRow();
        String trangThai = tableHoaDon.getValueAt(row, 3).toString();
        if (trangThai == "Đang chờ") {
            String maHd = txtmaHoaDon.getText();
            int TrangThai = 0;
            banHangITF.updateTrangThaiHoaDon(TrangThai, maHd);
            InsertHoaDonChiTiet();
            String idKM = "";
            for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.TenKMtoIdKM(cbbkhuyenmai.getSelectedItem().toString())) {
                idKM += khuyenMai_BanHangModel;
            }
            if (cbbkhuyenmai.getSelectedIndex() != 0) {
                banHangITF.updateIdKm(idKM, maHd);
            }
            btnthemsanpham.setEnabled(false);
            LoadTableHoaDon();
            LoadTableSanPham();
            this.XuatHoaDon();
            Clearform();
            JOptionPane.showMessageDialog(this, "Thanh toán thành công.");
        }
        //
    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void tableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHoaDonMouseClicked
        // TODO add your handling code here:
        Clearform();
        ClearAlltableGioHang();
        int row = tableHoaDon.getSelectedRow();
        txtmaHoaDon.setText(tableHoaDon.getValueAt(row, 1).toString());
        String maHD = tableHoaDon.getValueAt(row, 1).toString();
        String TrangThaiGH = tableHoaDon.getValueAt(row, 3).toString();
        String idHd = "";
        for (HoaDonModel hdm : banHangITF.MaHDToIdHD(maHD)) {
            idHd += hdm;
        }
        bang = (DefaultTableModel) tableGioHang.getModel();
        for (GioHang_BanHangModel ghbhm : banHangITF.MouesClickTableHoaDon(idHd)) {
            bang.addRow(new Object[]{tableGioHang.getRowCount() + 1, ghbhm.getTenSP(), ghbhm.getSize(), ghbhm.getMauSac(), ghbhm.getSoLuong(), ghbhm.getDonGia(), ghbhm.getSoLuong() * Integer.parseInt(ghbhm.getDonGia()), ghbhm.getBarcode()});
        }
        String tenKM = MaHDtoTenKM(maHD);
        for (int i = 0; i < cbbkhuyenmai.getItemCount(); i++) {
            if (cbbkhuyenmai.getItemAt(i).toString().equals(tenKM)) {
                cbbkhuyenmai.setSelectedIndex(i);
            }
        }
        String sdtKH = "";
        for (KhachHangViewModel khvm : banHangITF.getSdtKH(maHD)) {
            sdtKH += khvm.getSdt();
        }
        txtKhachMuaHang.setText(sdtKH);
        TinhTongTien();
        updatetienKM();
        if (TrangThaiGH == "Đang chờ") {
            btnthemsanpham.setEnabled(true);
            btnhuy.setEnabled(true);
        } else if (TrangThaiGH == "Đã thanh toán") {
            btnthemsanpham.setEnabled(false);
            btnthanhtoan.setEnabled(false);
            btnhuy.setEnabled(true);
        }
        btnxoaSanPham.setEnabled(false);
    }//GEN-LAST:event_tableHoaDonMouseClicked

    private void cbbkhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbkhuyenmaiActionPerformed
        // TODO add your handling code here:
        if (cbbkhuyenmai.getSelectedIndex() == 0) {
            txtthanhtien.setText(txttongtien.getText());
            txtsokhuyenmai.setText("0");
            txttienkhuyenmai.setText("0");
        }
        for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.getKhuyenMai(cbbkhuyenmai.getSelectedItem().toString())) {
            txtsokhuyenmai.setText(khuyenMai_BanHangModel.getGiamGia());
            lblhankm.setText(khuyenMai_BanHangModel.getNgayBD() + " - " + khuyenMai_BanHangModel.getNgayKT());
            updatetienKM();
        }
    }//GEN-LAST:event_cbbkhuyenmaiActionPerformed

    private void btnxoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaSanPhamActionPerformed
        // TODO add your handling code here:
        int row = tableGioHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xóa");
            return;
        }
        bang.removeRow(row);
        TinhTongTien();
        txtthanhtien.setText(txttongtien.getText());
        JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
    }//GEN-LAST:event_btnxoaSanPhamActionPerformed

    private void txtbarcoeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarcoeKeyPressed
        // TODO add your handling code here:
        int Line = tableGioHang.getRowCount();
        String bacode = txtbarcoe.getText();
        int sl = 1;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            for (int i = 0; i < Line; i++) {
                if (tableGioHang.getValueAt(i, 7).equals(bacode)) {
                    int quanCu = (int) tableGioHang.getValueAt(i, 4);
                    int quanMoi = sl;
                    int quanCuVaMoi = quanCu + quanMoi;
                    sl = quanCuVaMoi;
                    bang.removeRow(i);
                    break;
                }
            }
            Barcode(sl);
            TinhTongTien();
            updatetienKM();
            txtbarcoe.setText("");
        }
    }//GEN-LAST:event_txtbarcoeKeyPressed

    private void txtbarcoeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarcoeKeyTyped
        // TODO add your handling code here:
        if ("".equals(txtbarcoe.getText())) {
            return;
        }
    }//GEN-LAST:event_txtbarcoeKeyTyped

    private void tableGioHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableGioHangKeyPressed
        // TODO add your handling code here:
        int row = tableGioHang.getSelectedRow();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String soluong = tableGioHang.getValueAt(row, 4).toString();
            String dongia = tableGioHang.getValueAt(row, 5).toString();
            int dg = Integer.parseInt(dongia);
            int sl = Integer.parseInt(soluong);
            tableGioHang.setValueAt(dg * sl, tableGioHang.getSelectedRow(), 6);
            TinhTongTien();
            txtthanhtien.setText(txttongtien.getText());
        }
    }//GEN-LAST:event_tableGioHangKeyPressed

    private void btnhuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuyActionPerformed
        // TODO add your handling code here:
        String maHd = txtmaHoaDon.getText();
        int TrangThai = 2;
        banHangITF.updateTrangThaiHoaDon(TrangThai, maHd);
        CapNhapSoLuongHDHUY();
        LoadTableHoaDon();
        LoadTableSanPham();
        Clearform();
        JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công.");
    }//GEN-LAST:event_btnhuyActionPerformed

    private void txtsokhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsokhuyenmaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsokhuyenmaiActionPerformed

    private void tableGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGioHangMouseClicked
        // TODO add your handling code here:
        btnxoaSanPham.setEnabled(true);
    }//GEN-LAST:event_tableGioHangMouseClicked

    private void ThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemKHActionPerformed
        // TODO add your handling code here:
        new KhachHangView1_NhanVien().setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_ThemKHActionPerformed

    private void txttongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtienActionPerformed

    private void txtmatimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtmatimkiemCaretUpdate
        // TODO add your handling code here:
        Timma(txtmatimkiem.getText());
    }//GEN-LAST:event_txtmatimkiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbHoaDon;
    private javax.swing.JButton ThemKH;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnhuy;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btnthemsanpham;
    private javax.swing.JButton btnxoaSanPham;
    private javax.swing.JComboBox<String> cbbkhuyenmai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblhankm;
    private javax.swing.JLabel lblthongbao;
    private javax.swing.JTable tableGioHang;
    private javax.swing.JTable tableHoaDon;
    private javax.swing.JTable tableSanPham;
    public static javax.swing.JTextField txtKhachMuaHang;
    private javax.swing.JTextField txtbarcoe;
    private javax.swing.JTextField txtmaHoaDon;
    private javax.swing.JTextField txtmatimkiem;
    private javax.swing.JTextField txtsokhuyenmai;
    private javax.swing.JTextField txtthanhtien;
    private javax.swing.JTextField txttienkhachdua;
    private javax.swing.JTextField txttienkhuyenmai;
    private javax.swing.JTextField txttienthua;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttongtien;
    // End of variables declaration//GEN-END:variables
}