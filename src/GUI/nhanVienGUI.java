package GUI;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.DiaDiemDuLich_DAO;
import DAO.KhachHang_DAO;
import DAO.ThongTinDatVe_DAO;
import DAO.Tuyen_DAO;

import Entity.DiaDiemDuLich;
import Entity.KhachHang;
import Entity.ThongTinDatVe;
import Entity.Tuyen;

public class nhanVienGUI extends JFrame implements ActionListener, MouseListener, KeyListener {
  JTabbedPane tpLeft;

  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

  JLabel lbQuanLyKhachHang, 
          lbQuanLyTuyen, 
          lbQuanLyDiaDiemDuLich, 
          lbQuanLyDatVe, 
          lbHoSoCuaBan, 
          lbCatDat;

  JLabel lbTenTaiKhoan_QuanLyKhachHang, 
          lbHoTen_QuanLyKhachHang, 
          lbSoDienThoai_QuanLyKhachHang, 
          lbEmail_QuanLyKhachHang,
          lbPhai_QuanLyKhachHang, 
          lbMatKhau_QuanLyKhachHang, 
          
          lbMaTuyen_QuanLyTuyen, 
          lbTenTuyen_QuanLyTuyen, 
          lbMoTa_QuanLyTuyen, 
          lbNgayKhoiHanh_QuanLyTuyen, 
          lbNgayKetThuc_QuanLyTuyen, 
          lbGia_QuanLyTuyen, 
          lbSoNguoiThamGiaToiDa_QuanLyTuyen, 

          lbMa_QuanLyDiaDiemDuLich, 
          lbTen_QuanLyDiaDiemDuLich, 
          lbDiaChi_QuanLyDiaDiemDuLich, 
          lbDacTrung_QuanLyDiaDiemDuLich, 
          lbMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich, 

          lbSoNguoiThamGia_QuanLyDatVe, 
          lbHinhThucThanhToan_QuanLyDatVe, 
          lbMaKhachHang_QuanLyDatVe, 
          lbMaTuyen_QuanLyDatVe;

  JTextField tfTenTaiKhoan_QuanLyKhachHang, 
              tfHoTen_QuanLyKhachHang, 
              tfSoDienThoai_QuanLyKhachHang, 
              tfEmail_QuanLyKhachHang, 
              tfMatKhau_QuanLyKhachHang,

              tfMaTuyen_QuanLyTuyen, 
              tfTenTuyen_QuanLyTuyen, 
              tfMoTa_QuanLyTuyen, 
              tfNgayKhoiHanh_QuanLyTuyen, 
              tfNgayKetThuc_QuanLyTuyen, 
              tfGia_QuanLyTuyen, 
              tfSoNguoiThamGiaToiDa_QuanLyTuyen, 

              tfMa_QuanLyDiaDiemDuLich, 
              tfTen_QuanLyDiaDiemDuLich, 
              tfDiaChi_QuanLyDiaDiemDuLich, 
              tfDacTrung_QuanLyDiaDiemDuLich, 
              tfMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich, 

              tfSoNguoiThamGia_QuanLyDatVe, 
              tfMaKhachHang_QuanLyDatVe, 
              tfMaTuyen_QuanLyDatVe;

  String[] sPhai = {"Nam", "Nữ"};
  String[] sHinhThucThanhToan = {"Thanh toán qua thẻ", "Thanh toán bằng tiền mặt"};

  JComboBox<String> cbPhai;
  JComboBox<String> cbHinhThucThanhToan;

  JPanel pQuanLyKhachHang, 
          pQuanLyTuyen, 
          pQuanLyDiaDiemDuLich, 
          pQuanLyDatVe, 
          pHoSoCuaBan, 
          pCaiDat;

  Box b1_QuanLyKhachHang, 
			b1_1_QuanLyKhachHang, 
			b1_2_QuanLyKhachHang, 
			b1_3_QuanLyKhachHang, 
			b1_4_QuanLyKhachHang, 
			b1_5_QuanLyKhachHang, 
			b1_6_QuanLyKhachHang, 
			b1_7_QuanLyKhachHang, 
			b1_8_QuanLyKhachHang, 
			b1_9_QuanLyKhachHang, 
			b1_10_QuanLyKhachHang, 
			b1_11_QuanLyKhachHang, 

      b2_QuanLyKhachHang, 
			b2_1_QuanLyKhachHang, 
			b2_2_QuanLyKhachHang;

  Box b1_QuanLyTuyen, 
      b1_1_QuanLyTuyen, 
      b1_2_QuanLyTuyen, 
      b1_3_QuanLyTuyen, 
      b1_4_QuanLyTuyen, 
      b1_5_QuanLyTuyen, 
      b1_6_QuanLyTuyen, 
      b1_7_QuanLyTuyen, 
      b1_8_QuanLyTuyen, 
      b1_9_QuanLyTuyen, 
      b1_10_QuanLyTuyen, 
      b1_11_QuanLyTuyen, 
      b1_12_QuanLyTuyen, 
      b1_13_QuanLyTuyen, 
      b1_14_QuanLyTuyen, 

      b2_QuanLyTuyen, 
      b2_1_QuanLyTuyen, 
      b2_2_QuanLyTuyen;

  Box b1_QuanLyDiaDiemDuLich, 
      b1_1_QuanLyDiaDiemDuLich, 
      b1_2_QuanLyDiaDiemDuLich, 
      b1_3_QuanLyDiaDiemDuLich, 
      b1_4_QuanLyDiaDiemDuLich, 
      b1_5_QuanLyDiaDiemDuLich, 
      b1_6_QuanLyDiaDiemDuLich, 
      b1_7_QuanLyDiaDiemDuLich, 
      b1_8_QuanLyDiaDiemDuLich, 
      b1_9_QuanLyDiaDiemDuLich, 
      b1_10_QuanLyDiaDiemDuLich, 

      b2_QuanLyDiaDiemDuLich, 
      b2_1_QuanLyDiaDiemDuLich, 
      b2_2_QuanLyDiaDiemDuLich;

  Box b1_QuanLyDatVe, 

      b1_1_QuanLyDatVe, 
      b1_2_QuanLyDatVe, 
      b1_3_QuanLyDatVe, 
      b1_4_QuanLyDatVe, 
      b1_5_QuanLyDatVe, 
      b1_6_QuanLyDatVe, 
      b1_7_QuanLyDatVe, 
      b1_8_QuanLyDatVe, 

      b2_QuanLyDatVe, 
      b2_1_QuanLyDatVe, 
      b2_2_QuanLyDatVe;

  JButton bThem_QuanLyKhachHang, 
          bXoa_QuanLyKhachHang, 
          bXoaRong_QuanLyKhachHang, 
          bCapNhat_QuanLyKhachHang, 
          bXuat_QuanLyKhachHang;

  JButton bThem_QuanLyTuyen, 
          bXoa_QuanLyTuyen, 
          bXoaRong_QuanLyTuyen, 
          bCapNhat_QuanLyTuyen, 
          bXuat_QuanLyTuyen;

  JButton bThem_QuanLyDiaDiemDuLich, 
          bXoa_QuanLyDiaDiemDuLich, 
          bXoaRong_QuanLyDiaDiemDuLich, 
          bCapNhat_QuanLyDiaDiemDuLich, 
          bXuat_QuanLyDiaDiemDuLich;

  JButton bThem_QuanLyDatVe, 
          bXoa_QuanLyDatVe, 
          bXoaRong_QuanLyDatVe, 
          bCapNhat_QuanLyDatVe, 
          bXuat_QuanLyDatVe;

  JButton bDangXuat;

  String[] colKhachHang = {"Tên tài khoản", "Họ tên", "Số điện thoại", "Email", "Phái", "Mật khẩu"};
  String[] colTuyen = {"Mã tuyến", "Tên tuyến", "Mô tả", "Ngày khởi hành", "Ngày kết thúc", "Giá", "Số người tham gia tối đa", "Mã nhân viên quản lý"};
  String[] colDiaDiemDuLich = {"Mã địa điểm", "Tên địa điểm", "Địa chỉ", "Đặc trưng"};
  String[] colDatVe = {"Số người tham gia", "Hình thức thanh toán", "Mã khách hàng", "Mã tuyến"};

  DefaultTableModel dtmKhachHang, 
                    dtmTuyen, 
                    dtmDiaDiemDuLich, 
                    dtmDatVe;

  JTable tKhachHang, 
          tTuyen, 
          tDiaDiemDuLich, 
          tDatVe;

  TableRowSorter<TableModel> trsKhachHang, 
                              trsTuyen, 
                              trsDiaDiemDuLich, 
                              trsDatVe;

  JScrollPane spKhachHang, 
              spTuyen, 
              spDiaDiemDuLich, 
              spDatVe;
  
  KhachHang_DAO khachHang_DAO;
  Tuyen_DAO tuyen_DAO;
  DiaDiemDuLich_DAO diaDiemDuLich_DAO;
  ThongTinDatVe_DAO thongTinDatVe_DAO;

  String maNhanVien;

  public nhanVienGUI(String ma) {
    super("Xin chào " + ma);

    maNhanVien = ma;

    khachHang_DAO = new KhachHang_DAO();
    tuyen_DAO = new Tuyen_DAO();
    diaDiemDuLich_DAO = new DiaDiemDuLich_DAO();
    thongTinDatVe_DAO = new ThongTinDatVe_DAO();

    lbQuanLyTuyen = new JLabel("Quản lý chuyến đi");
    lbQuanLyTuyen.setPreferredSize(new Dimension(180, 50));

    lbQuanLyKhachHang = new JLabel("Quản lý khách hàng");
    lbQuanLyKhachHang.setPreferredSize(new Dimension(180, 50));

    lbQuanLyDiaDiemDuLich = new JLabel("Quản lý địa điểm du lịch");
    lbQuanLyDiaDiemDuLich.setPreferredSize(new Dimension(180, 50));

    lbQuanLyDatVe = new JLabel("Quản lý đặt vé");
    lbQuanLyDatVe.setPreferredSize(new Dimension(180, 50));

    lbHoSoCuaBan = new JLabel("Hồ sơ của bạn");
    lbHoSoCuaBan.setPreferredSize(new Dimension(180, 50));

    lbCatDat = new JLabel("Cài đặt");
    lbCatDat.setPreferredSize(new Dimension(180, 50));

    lbTenTaiKhoan_QuanLyKhachHang = new JLabel("Tên tài khoản:");
    lbHoTen_QuanLyKhachHang = new JLabel("Họ tên:");
    lbSoDienThoai_QuanLyKhachHang = new JLabel("Số điện thoại:"); 
    lbEmail_QuanLyKhachHang = new JLabel("Email:");
    lbPhai_QuanLyKhachHang = new JLabel("Phái:");
    lbMatKhau_QuanLyKhachHang = new JLabel("Mật khẩu:");

    tfTenTaiKhoan_QuanLyKhachHang = new JTextField(10);
    tfHoTen_QuanLyKhachHang = new JTextField(10);
    tfSoDienThoai_QuanLyKhachHang = new JTextField(10);
    tfEmail_QuanLyKhachHang = new JTextField(10);
    cbPhai = new JComboBox<String>(sPhai);
    tfMatKhau_QuanLyKhachHang = new JTextField(10);

    lbMaTuyen_QuanLyTuyen = new JLabel("Mã tuyến:");
    lbTenTuyen_QuanLyTuyen = new JLabel("Tên tuyến:");
    lbMoTa_QuanLyTuyen = new JLabel("Mô tả:");
    lbNgayKhoiHanh_QuanLyTuyen = new JLabel("Ngày khởi hành:");
    lbNgayKetThuc_QuanLyTuyen = new JLabel("Ngày kết thúc:");
    lbGia_QuanLyTuyen = new JLabel("Giá:");
    lbSoNguoiThamGiaToiDa_QuanLyTuyen = new JLabel("Số người tham gia tối đa:");

    tfMaTuyen_QuanLyTuyen = new JTextField(10);
    tfTenTuyen_QuanLyTuyen = new JTextField(10);
    tfMoTa_QuanLyTuyen = new JTextField(10);
    tfNgayKhoiHanh_QuanLyTuyen = new JTextField(10);
    tfNgayKetThuc_QuanLyTuyen = new JTextField(10);
    tfGia_QuanLyTuyen = new JTextField(10);
    tfSoNguoiThamGiaToiDa_QuanLyTuyen = new JTextField(10);

    lbMa_QuanLyDiaDiemDuLich = new JLabel("Mã địa điểm:");
    lbTen_QuanLyDiaDiemDuLich = new JLabel("Tên địa điểm:");
    lbDiaChi_QuanLyDiaDiemDuLich = new JLabel("Địa chỉ địa điểm:");
    lbDacTrung_QuanLyDiaDiemDuLich = new JLabel("Đặc trưng địa điểm:");
    lbMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich = new JLabel("Thuộc tuyến:");

    tfMa_QuanLyDiaDiemDuLich = new JTextField(10);
    tfTen_QuanLyDiaDiemDuLich = new JTextField(10);
    tfDiaChi_QuanLyDiaDiemDuLich = new JTextField(10);
    tfDacTrung_QuanLyDiaDiemDuLich = new JTextField(10);
    tfMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich = new JTextField(10);

    lbSoNguoiThamGia_QuanLyDatVe = new JLabel("Số người tham gia:");
    lbHinhThucThanhToan_QuanLyDatVe = new JLabel("Hình thức thanh toán:");
    lbMaKhachHang_QuanLyDatVe = new JLabel("Mã khách hàng:");
    lbMaTuyen_QuanLyDatVe = new JLabel("Mã tuyến:");

    tfSoNguoiThamGia_QuanLyDatVe = new JTextField(10);
    cbHinhThucThanhToan = new JComboBox<String>(sHinhThucThanhToan);
    tfMaKhachHang_QuanLyDatVe = new JTextField(10);
    tfMaTuyen_QuanLyDatVe = new JTextField(10);

    tpLeft = new JTabbedPane(JTabbedPane.LEFT);

    pQuanLyKhachHang = new JPanel();
    pQuanLyTuyen = new JPanel();
    pQuanLyDiaDiemDuLich = new JPanel();
    pQuanLyDatVe = new JPanel();
    pHoSoCuaBan = new JPanel();
    pCaiDat = new JPanel();

    b1_QuanLyKhachHang = Box.createVerticalBox();
		b1_QuanLyKhachHang.setPreferredSize(new Dimension(200, 500));

		b1_1_QuanLyKhachHang = Box.createHorizontalBox();
		b1_2_QuanLyKhachHang = Box.createHorizontalBox();
		b1_3_QuanLyKhachHang = Box.createHorizontalBox();
		b1_4_QuanLyKhachHang = Box.createHorizontalBox();
		b1_5_QuanLyKhachHang = Box.createHorizontalBox();
		b1_6_QuanLyKhachHang = Box.createHorizontalBox();
		b1_7_QuanLyKhachHang = Box.createHorizontalBox();
		b1_8_QuanLyKhachHang = Box.createHorizontalBox();
		b1_9_QuanLyKhachHang = Box.createHorizontalBox();
		b1_10_QuanLyKhachHang = Box.createHorizontalBox();
		b1_11_QuanLyKhachHang = Box.createHorizontalBox();

    b2_QuanLyKhachHang = Box.createVerticalBox();
		b2_1_QuanLyKhachHang = Box.createVerticalBox();
		b2_2_QuanLyKhachHang = Box.createHorizontalBox();

    b1_QuanLyTuyen = Box.createVerticalBox();
    b1_QuanLyTuyen.setPreferredSize(new Dimension(200, 500));

    b1_1_QuanLyTuyen = Box.createHorizontalBox();
		b1_2_QuanLyTuyen = Box.createHorizontalBox();
		b1_3_QuanLyTuyen = Box.createHorizontalBox();
		b1_4_QuanLyTuyen = Box.createHorizontalBox();
		b1_5_QuanLyTuyen = Box.createHorizontalBox();
		b1_6_QuanLyTuyen = Box.createHorizontalBox();
		b1_7_QuanLyTuyen = Box.createHorizontalBox();
		b1_8_QuanLyTuyen = Box.createHorizontalBox();
		b1_9_QuanLyTuyen = Box.createHorizontalBox();
		b1_10_QuanLyTuyen = Box.createHorizontalBox();
		b1_11_QuanLyTuyen = Box.createHorizontalBox();
    b1_12_QuanLyTuyen = Box.createHorizontalBox();
    b1_13_QuanLyTuyen = Box.createHorizontalBox();
    b1_14_QuanLyTuyen = Box.createHorizontalBox();

    b2_QuanLyTuyen = Box.createVerticalBox();
    b2_1_QuanLyTuyen = Box.createVerticalBox();
    b2_2_QuanLyTuyen = Box.createHorizontalBox();

    b1_QuanLyDiaDiemDuLich = Box.createVerticalBox();
    b1_QuanLyTuyen.setPreferredSize(new Dimension(200, 500));

    b1_1_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_2_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_3_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_4_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_5_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_6_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_7_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_8_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_9_QuanLyDiaDiemDuLich = Box.createHorizontalBox();
    b1_10_QuanLyDiaDiemDuLich = Box.createHorizontalBox();

    b2_QuanLyDiaDiemDuLich = Box.createVerticalBox();
    b2_1_QuanLyDiaDiemDuLich = Box.createVerticalBox();
    b2_2_QuanLyDiaDiemDuLich = Box.createHorizontalBox();

    b1_QuanLyDatVe = Box.createVerticalBox();
    b1_QuanLyDatVe.setPreferredSize(new Dimension(200, 1200));

    b1_1_QuanLyDatVe = Box.createHorizontalBox();
    b1_2_QuanLyDatVe = Box.createHorizontalBox();
    b1_3_QuanLyDatVe = Box.createHorizontalBox();
    b1_4_QuanLyDatVe = Box.createHorizontalBox();
    b1_5_QuanLyDatVe = Box.createHorizontalBox();
    b1_6_QuanLyDatVe = Box.createHorizontalBox();
    b1_7_QuanLyDatVe = Box.createHorizontalBox();
    b1_8_QuanLyDatVe = Box.createHorizontalBox();

    b2_QuanLyDatVe = Box.createVerticalBox();
    b2_1_QuanLyDatVe = Box.createVerticalBox();
    b2_2_QuanLyDatVe = Box.createHorizontalBox();

    bThem_QuanLyKhachHang = new JButton("Thêm");
    bXoa_QuanLyKhachHang = new JButton("Xoá");
    bXoaRong_QuanLyKhachHang = new JButton("Xoá rỗng");
    bCapNhat_QuanLyKhachHang = new JButton("Cập nhật");
    bXuat_QuanLyKhachHang = new JButton("Xuất");

    bThem_QuanLyTuyen = new JButton("Thêm");
    bXoa_QuanLyTuyen = new JButton("Xoá");
    bXoaRong_QuanLyTuyen = new JButton("Xoá rỗng");
    bCapNhat_QuanLyTuyen = new JButton("Cập nhật");
    bXuat_QuanLyTuyen = new JButton("Xuất");

    bThem_QuanLyDiaDiemDuLich = new JButton("Thêm");
    bXoa_QuanLyDiaDiemDuLich = new JButton("Xoá");
    bXoaRong_QuanLyDiaDiemDuLich = new JButton("Xoá rỗng");
    bCapNhat_QuanLyDiaDiemDuLich = new JButton("Cập nhật");
    bXuat_QuanLyDiaDiemDuLich = new JButton("Xuất");

    bThem_QuanLyDatVe = new JButton("Thêm");
    bXoa_QuanLyDatVe = new JButton("Xoá");
    bXoaRong_QuanLyDatVe = new JButton("Xoá rỗng");
    bCapNhat_QuanLyDatVe = new JButton("Cập nhật");
    bXuat_QuanLyDatVe = new JButton("Xuất");

    bDangXuat = new JButton("Đăng xuất");

    dtmKhachHang = new DefaultTableModel(colKhachHang, 0);
    dtmTuyen = new DefaultTableModel(colTuyen, 0);
    dtmDiaDiemDuLich = new DefaultTableModel(colDiaDiemDuLich, 0);
    dtmDatVe = new DefaultTableModel(colDatVe, 0);

    tKhachHang = new JTable(dtmKhachHang);
    tTuyen = new JTable(dtmTuyen);
    tDiaDiemDuLich = new JTable(dtmDiaDiemDuLich);
    tDatVe = new JTable(dtmDatVe);

    trsKhachHang = new TableRowSorter<TableModel>(tKhachHang.getModel());
    trsTuyen = new TableRowSorter<TableModel>(tTuyen.getModel());
    trsDiaDiemDuLich = new TableRowSorter<TableModel>(tDiaDiemDuLich.getModel());
    trsDatVe = new TableRowSorter<TableModel>(tDatVe.getModel());

    tKhachHang.setRowSorter(trsKhachHang);
    tTuyen.setRowSorter(trsTuyen);
    tDiaDiemDuLich.setRowSorter(trsDiaDiemDuLich);
    tDatVe.setRowSorter(trsDatVe);

    spKhachHang = new JScrollPane(tKhachHang);
    spTuyen = new JScrollPane(tTuyen);
    spDiaDiemDuLich = new JScrollPane(tDiaDiemDuLich);
    spDatVe = new JScrollPane(tDatVe);

    //---------------------------QuanLyKhachHang----------------------------------

		b1_1_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_1_QuanLyKhachHang.add(lbTenTaiKhoan_QuanLyKhachHang);
		b1_1_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_2_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_2_QuanLyKhachHang.add(tfTenTaiKhoan_QuanLyKhachHang);
		b1_2_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_3_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_3_QuanLyKhachHang.add(lbHoTen_QuanLyKhachHang);
		b1_3_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_4_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_4_QuanLyKhachHang.add(tfHoTen_QuanLyKhachHang);
		b1_4_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_5_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_5_QuanLyKhachHang.add(lbSoDienThoai_QuanLyKhachHang);
		b1_5_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_6_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_6_QuanLyKhachHang.add(tfSoDienThoai_QuanLyKhachHang);
		b1_6_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_7_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_7_QuanLyKhachHang.add(lbEmail_QuanLyKhachHang);
		b1_7_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_8_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_8_QuanLyKhachHang.add(tfEmail_QuanLyKhachHang);
		b1_8_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_9_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_9_QuanLyKhachHang.add(lbPhai_QuanLyKhachHang);
		b1_9_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_9_QuanLyKhachHang.add(cbPhai);
		b1_9_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_10_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_10_QuanLyKhachHang.add(lbMatKhau_QuanLyKhachHang);
		b1_10_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_11_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b1_11_QuanLyKhachHang.add(tfMatKhau_QuanLyKhachHang);
		b1_11_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_1_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_2_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_3_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_4_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_5_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_6_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_7_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_8_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_9_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_10_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b1_QuanLyKhachHang.add(b1_11_QuanLyKhachHang);
		b1_QuanLyKhachHang.add(Box.createVerticalStrut(10));

		b2_1_QuanLyKhachHang.add(spKhachHang);

		b2_2_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyKhachHang.add(bThem_QuanLyKhachHang);
		b2_2_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyKhachHang.add(bXoa_QuanLyKhachHang);
		b2_2_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyKhachHang.add(bXoaRong_QuanLyKhachHang);
		b2_2_QuanLyKhachHang.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyKhachHang.add(bCapNhat_QuanLyKhachHang);
		b2_2_QuanLyKhachHang.add(Box.createHorizontalStrut(10));

		b2_QuanLyKhachHang.add(b2_1_QuanLyKhachHang);
		b2_QuanLyKhachHang.add(Box.createVerticalStrut(10));
		b2_QuanLyKhachHang.add(b2_2_QuanLyKhachHang);
		b2_QuanLyKhachHang.add(Box.createVerticalStrut(10));

    pQuanLyKhachHang.setLayout(new BorderLayout());

    pQuanLyKhachHang.add(b1_QuanLyKhachHang, BorderLayout.WEST);
    pQuanLyKhachHang.add(b2_QuanLyKhachHang, BorderLayout.CENTER);

    //---------------------------------QuanLyTuyen------------------------------------

    b1_1_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_1_QuanLyTuyen.add(lbMaTuyen_QuanLyTuyen);
		b1_1_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_2_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_2_QuanLyTuyen.add(tfMaTuyen_QuanLyTuyen);
		b1_2_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_3_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_3_QuanLyTuyen.add(lbTenTuyen_QuanLyTuyen);
		b1_3_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_4_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_4_QuanLyTuyen.add(tfTenTuyen_QuanLyTuyen);
		b1_4_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_5_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_5_QuanLyTuyen.add(lbMoTa_QuanLyTuyen);
		b1_5_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_6_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_6_QuanLyTuyen.add(tfMoTa_QuanLyTuyen);
		b1_6_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_7_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_7_QuanLyTuyen.add(lbNgayKhoiHanh_QuanLyTuyen);
		b1_7_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_8_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_8_QuanLyTuyen.add(tfNgayKhoiHanh_QuanLyTuyen);
		b1_8_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_9_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_9_QuanLyTuyen.add(lbNgayKetThuc_QuanLyTuyen);
		b1_9_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_10_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_10_QuanLyTuyen.add(tfNgayKetThuc_QuanLyTuyen);
		b1_10_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_11_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_11_QuanLyTuyen.add(lbGia_QuanLyTuyen);
		b1_11_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_12_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_12_QuanLyTuyen.add(tfGia_QuanLyTuyen);
		b1_12_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_13_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_13_QuanLyTuyen.add(lbSoNguoiThamGiaToiDa_QuanLyTuyen); 
		b1_13_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_14_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b1_14_QuanLyTuyen.add(tfSoNguoiThamGiaToiDa_QuanLyTuyen); 
		b1_14_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_1_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_2_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_3_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_4_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_5_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_6_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_7_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_8_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_9_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_10_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_11_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_12_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_13_QuanLyTuyen);
    b1_QuanLyTuyen.add(Box.createVerticalStrut(10));
		b1_QuanLyTuyen.add(b1_14_QuanLyTuyen);

    b2_1_QuanLyTuyen.add(spTuyen);

    b2_2_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyTuyen.add(bThem_QuanLyTuyen);
		b2_2_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyTuyen.add(bXoa_QuanLyTuyen);
		b2_2_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyTuyen.add(bXoaRong_QuanLyTuyen);
		b2_2_QuanLyTuyen.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyTuyen.add(bCapNhat_QuanLyTuyen);
		b2_2_QuanLyTuyen.add(Box.createHorizontalStrut(10));

    b2_QuanLyTuyen.add(b2_1_QuanLyTuyen);
    b2_QuanLyTuyen.add(b2_2_QuanLyTuyen);

    pQuanLyTuyen.setLayout(new BorderLayout());
    pQuanLyTuyen.add(b1_QuanLyTuyen, BorderLayout.WEST);
    pQuanLyTuyen.add(b2_QuanLyTuyen, BorderLayout.CENTER);

    //-------------------------QuanLyDiaDiemDuLich-----------------------------------

    b1_1_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_1_QuanLyDiaDiemDuLich.add(lbMa_QuanLyDiaDiemDuLich);
		b1_1_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_2_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_2_QuanLyDiaDiemDuLich.add(tfMa_QuanLyDiaDiemDuLich);
		b1_2_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_3_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_3_QuanLyDiaDiemDuLich.add(lbTen_QuanLyDiaDiemDuLich);
		b1_3_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_4_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_4_QuanLyDiaDiemDuLich.add(tfTen_QuanLyDiaDiemDuLich);
		b1_4_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_5_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_5_QuanLyDiaDiemDuLich.add(lbDiaChi_QuanLyDiaDiemDuLich);
		b1_5_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_6_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_6_QuanLyDiaDiemDuLich.add(tfDiaChi_QuanLyDiaDiemDuLich);
		b1_6_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_7_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_7_QuanLyDiaDiemDuLich.add(lbDacTrung_QuanLyDiaDiemDuLich);
		b1_7_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_8_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_8_QuanLyDiaDiemDuLich.add(tfDacTrung_QuanLyDiaDiemDuLich);
		b1_8_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_9_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_9_QuanLyDiaDiemDuLich.add(lbMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich);
		b1_9_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_10_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b1_10_QuanLyDiaDiemDuLich.add(tfMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich);
		b1_10_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_1_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_2_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_3_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_4_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_5_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_6_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_7_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_8_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_9_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));
		b1_QuanLyDiaDiemDuLich.add(b1_10_QuanLyDiaDiemDuLich);
    b1_QuanLyDiaDiemDuLich.add(Box.createVerticalStrut(10));

    b2_1_QuanLyDiaDiemDuLich.add(spDiaDiemDuLich);

    b2_2_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyDiaDiemDuLich.add(bThem_QuanLyDiaDiemDuLich);
		b2_2_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyDiaDiemDuLich.add(bXoa_QuanLyDiaDiemDuLich);
		b2_2_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyDiaDiemDuLich.add(bXoaRong_QuanLyDiaDiemDuLich);
		b2_2_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyDiaDiemDuLich.add(bCapNhat_QuanLyDiaDiemDuLich);
		b2_2_QuanLyDiaDiemDuLich.add(Box.createHorizontalStrut(10));

    b2_QuanLyDiaDiemDuLich.add(b2_1_QuanLyDiaDiemDuLich);
    b2_QuanLyDiaDiemDuLich.add(b2_2_QuanLyDiaDiemDuLich);

    pQuanLyDiaDiemDuLich.setLayout(new BorderLayout());
    pQuanLyDiaDiemDuLich.add(b1_QuanLyDiaDiemDuLich, BorderLayout.WEST);
    pQuanLyDiaDiemDuLich.add(b2_QuanLyDiaDiemDuLich, BorderLayout.CENTER);

    //--------------------------------QuanLyDatVe---------------------------------

    b1_1_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b1_1_QuanLyDatVe.add(lbSoNguoiThamGia_QuanLyDatVe);
		b1_1_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b1_2_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b1_2_QuanLyDatVe.add(tfSoNguoiThamGia_QuanLyDatVe);
		b1_2_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b1_3_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b1_3_QuanLyDatVe.add(lbHinhThucThanhToan_QuanLyDatVe);
		b1_3_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b1_4_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b1_4_QuanLyDatVe.add(cbHinhThucThanhToan);
		b1_4_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b1_5_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b1_5_QuanLyDatVe.add(lbMaKhachHang_QuanLyDatVe);
		b1_5_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b1_6_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b1_6_QuanLyDatVe.add(tfMaKhachHang_QuanLyDatVe);
		b1_6_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b1_7_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b1_7_QuanLyDatVe.add(lbMaTuyen_QuanLyDatVe);
		b1_7_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b1_8_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b1_8_QuanLyDatVe.add(tfMaTuyen_QuanLyDatVe);
		b1_8_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));
		b1_QuanLyDatVe.add(b1_1_QuanLyDatVe);
    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));
		b1_QuanLyDatVe.add(b1_2_QuanLyDatVe);
    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));
		b1_QuanLyDatVe.add(b1_3_QuanLyDatVe);
    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));
		b1_QuanLyDatVe.add(b1_4_QuanLyDatVe);
    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));
		b1_QuanLyDatVe.add(b1_5_QuanLyDatVe);
    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));
		b1_QuanLyDatVe.add(b1_6_QuanLyDatVe);
    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));
		b1_QuanLyDatVe.add(b1_7_QuanLyDatVe);
    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));
		b1_QuanLyDatVe.add(b1_8_QuanLyDatVe);
    b1_QuanLyDatVe.add(Box.createVerticalStrut(10));

    b2_1_QuanLyDatVe.add(spDatVe);

    b2_2_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyDatVe.add(bThem_QuanLyDatVe);
		b2_2_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyDatVe.add(bXoa_QuanLyDatVe);
		b2_2_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyDatVe.add(bXoaRong_QuanLyDatVe);
		b2_2_QuanLyDatVe.add(Box.createHorizontalStrut(10));
		b2_2_QuanLyDatVe.add(bCapNhat_QuanLyDatVe);
		b2_2_QuanLyDatVe.add(Box.createHorizontalStrut(10));

    b2_QuanLyDatVe.add(b2_1_QuanLyDatVe);
    b2_QuanLyDatVe.add(b2_2_QuanLyDatVe);

    pQuanLyDatVe.setLayout(new BorderLayout());
    pQuanLyDatVe.add(b1_QuanLyDatVe, BorderLayout.WEST);
    pQuanLyDatVe.add(b2_QuanLyDatVe, BorderLayout.CENTER);

    //============================================================================

    tpLeft.addTab("Quản lý khách hàng", pQuanLyKhachHang);
    tpLeft.setTabComponentAt(0, lbQuanLyKhachHang);

    tpLeft.addTab("Quản lý chuyến đi", pQuanLyTuyen);
    tpLeft.setTabComponentAt(1, lbQuanLyTuyen);

    tpLeft.addTab("Quản lý địa điểm du lịch", pQuanLyDiaDiemDuLich);
    tpLeft.setTabComponentAt(2, lbQuanLyDiaDiemDuLich);

    tpLeft.addTab("Quản lý đặt vé", pQuanLyDatVe);
    tpLeft.setTabComponentAt(3, lbQuanLyDatVe);

    tpLeft.addTab("Hồ sơ của bạn", pHoSoCuaBan);
    tpLeft.setTabComponentAt(4, lbHoSoCuaBan);

    tpLeft.addTab("Đăng xuất", pCaiDat);
    tpLeft.setTabComponentAt(5, lbCatDat);

    add(tpLeft, BorderLayout.CENTER);

    addKhachHangToTable();
    addTuyenToTable();
    addDiaDiemDuLichToTable();
    addThongTinDatVeToTable();

    //----------------------------------------------------------------------------

		tKhachHang.addMouseListener(this);
		bThem_QuanLyKhachHang.addActionListener(this);
		bXoa_QuanLyKhachHang.addActionListener(this);
		bXoaRong_QuanLyKhachHang.addActionListener(this);
		bCapNhat_QuanLyKhachHang.addActionListener(this);

    tTuyen.addMouseListener(this);
		bThem_QuanLyTuyen.addActionListener(this);
		bXoa_QuanLyTuyen.addActionListener(this);
		bXoaRong_QuanLyTuyen.addActionListener(this);
		bCapNhat_QuanLyTuyen.addActionListener(this);

    tDiaDiemDuLich.addMouseListener(this);
		bThem_QuanLyDiaDiemDuLich.addActionListener(this);
		bXoa_QuanLyDiaDiemDuLich.addActionListener(this);
		bXoaRong_QuanLyDiaDiemDuLich.addActionListener(this);
		bCapNhat_QuanLyDiaDiemDuLich.addActionListener(this);

    tDatVe.addMouseListener(this);
		bThem_QuanLyDatVe.addActionListener(this);
		bXoa_QuanLyDatVe.addActionListener(this);
		bXoaRong_QuanLyDatVe.addActionListener(this);
		bCapNhat_QuanLyDatVe.addActionListener(this);



    tfTenTaiKhoan_QuanLyKhachHang.addKeyListener(this);
    // tfHoTen_QuanLyKhachHang.addKeyListener(this);
    // tfSoDienThoai_QuanLyKhachHang.addKeyListener(this);
    // tfEmail_QuanLyKhachHang.addKeyListener(this);
    // cbPhai.addKeyListener(this);
    // tfMatKhau_QuanLyKhachHang.addKeyListener(this);

    tfMaTuyen_QuanLyTuyen.addKeyListener(this);
    // tfTenTuyen_QuanLyTuyen.addKeyListener(this);
    // tfMoTa_QuanLyTuyen.addKeyListener(this);
    // tfGia_QuanLyTuyen.addKeyListener(this);
    // tfSoNguoiThamGiaToiDa_QuanLyTuyen.addKeyListener(this);

    tfMa_QuanLyDiaDiemDuLich.addKeyListener(this);
    // tfTen_QuanLyDiaDiemDuLich.addKeyListener(this);
    // tfDiaChi_QuanLyDiaDiemDuLich.addKeyListener(this);
    // tfDacTrung_QuanLyDiaDiemDuLich.addKeyListener(this);
    // tfMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich.addKeyListener(this);

    // tfSoNguoiThamGia_QuanLyDatVe.addKeyListener(this);
    // cbHinhThucThanhToan.addKeyListener(this);
    tfMaKhachHang_QuanLyDatVe.addKeyListener(this);
    tfMaTuyen_QuanLyDatVe.addKeyListener(this);

		//----------------------------------------------------------------------------

    setSize(1200, 500);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bThem_QuanLyKhachHang) actionThem_QuanLyKhachHang();
		if (e.getSource() == bXoa_QuanLyKhachHang) actionXoa_QuanLyKhachHang();
		if (e.getSource() == bXoaRong_QuanLyKhachHang) actionXoaRong_QuanLyKhachHang();
		if (e.getSource() == bCapNhat_QuanLyKhachHang) actionCapNhat_QuanLyKhachHang();

    if (e.getSource() == bThem_QuanLyTuyen) actionThem_QuanLyTuyen();
		if (e.getSource() == bXoa_QuanLyTuyen) actionXoa_QuanLyTuyen();
		if (e.getSource() == bXoaRong_QuanLyTuyen) actionXoaRong_QuanLyTuyen();
		if (e.getSource() == bCapNhat_QuanLyTuyen) actionCapNhat_QuanLyTuyen();

    if (e.getSource() == bThem_QuanLyDiaDiemDuLich) actionThem_QuanLyDiaDiemDuLich();
		if (e.getSource() == bXoa_QuanLyDiaDiemDuLich) actionXoa_QuanLyDiaDiemDuLich();
		if (e.getSource() == bXoaRong_QuanLyDiaDiemDuLich) actionXoaRong_QuanLyDiaDiemDuLich();
		if (e.getSource() == bCapNhat_QuanLyDiaDiemDuLich) actionCapNhat_QuanLyDiaDiemDuLich();

    if (e.getSource() == bThem_QuanLyDatVe) actionThem_QuanLyDatVe();
		if (e.getSource() == bXoa_QuanLyDatVe) actionXoa_QuanLyDatVe();
		if (e.getSource() == bXoaRong_QuanLyDatVe) actionXoaRong_QuanLyDatVe();
		if (e.getSource() == bCapNhat_QuanLyDatVe) actionCapNhat_QuanLyDatVe();
  }

  //---------------------------------------------------------------------------

	public void actionThem_QuanLyKhachHang() {
		if (
      !tfHoTen_QuanLyKhachHang.getText().equals("") &&
      !tfSoDienThoai_QuanLyKhachHang.getText().equals("") &&
      !tfEmail_QuanLyKhachHang.getText().equals("") &&
      !tfTenTaiKhoan_QuanLyKhachHang.getText().equals("") &&
      !tfMatKhau_QuanLyKhachHang.getText().equals("")
    ) {
      Pattern pattHoTen =  Pattern.compile(
        "^(\\p{Upper}{1}\\p{Lower}*)(\\s\\p{Upper}{1}\\p{Lower}*)+$", 
        Pattern.UNICODE_CHARACTER_CLASS
      );
      if (
        pattHoTen.matcher(tfHoTen_QuanLyKhachHang.getText()).matches() &&
        tfSoDienThoai_QuanLyKhachHang.getText().matches("^0{1}[1-9]{1}[0-9]{8}$") &&
        tfEmail_QuanLyKhachHang.getText().matches("^[A-Za-z_-]{1}[A-Za-z0-9_-]*@(gmail|yahoo|outlook){1}\\.com$") &&
        tfTenTaiKhoan_QuanLyKhachHang.getText().matches("^[A-Za-z_]{1}[A-Za-z0-9_-]*$") &&
        tfMatKhau_QuanLyKhachHang.getText().matches("^[A-Za-z_0-9]{1}[A-Za-z0-9_-]{4,}$")
      ) {
        if ( khachHang_DAO.getTenTaiKhoan(
          tfTenTaiKhoan_QuanLyKhachHang.getText(),
          tfMatKhau_QuanLyKhachHang.getText()
        ) == null ) {
          khachHang_DAO.create(
            new KhachHang(
              tfTenTaiKhoan_QuanLyKhachHang.getText(),
              tfHoTen_QuanLyKhachHang.getText(), 
              tfSoDienThoai_QuanLyKhachHang.getText(), 
              tfEmail_QuanLyKhachHang.getText(), 
              cbPhai.getSelectedItem().toString() == "Nam" ? true : false,
              tfMatKhau_QuanLyKhachHang.getText()
            )
          );
          JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
          dtmKhachHang.addRow(
            new String[] {
              tfTenTaiKhoan_QuanLyKhachHang.getText(),
              tfHoTen_QuanLyKhachHang.getText(), 
              tfSoDienThoai_QuanLyKhachHang.getText(), 
              tfEmail_QuanLyKhachHang.getText(), 
              cbPhai.getSelectedItem().toString(), 
              tfMatKhau_QuanLyKhachHang.getText()
            }
          );
        } else {
          JOptionPane.showMessageDialog(this, "Đã có khách hàng có tên tài khoản là " + tfTenTaiKhoan_QuanLyKhachHang.getText());
        }
      } else {
        if ( !pattHoTen.matcher(tfHoTen_QuanLyKhachHang.getText()).matches() ) {
          JOptionPane.showMessageDialog(this, "Họ tên không hợp lệ");
          tfHoTen_QuanLyKhachHang.requestFocus();
        }
        if ( !tfSoDienThoai_QuanLyKhachHang.getText().matches("0{1}[1-9]{1}[0-9]{8}") ) {
          JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
          tfSoDienThoai_QuanLyKhachHang.requestFocus();
        }
        if ( !tfEmail_QuanLyKhachHang.getText().matches("[A-Za-z_-]{1}[A-Za-z0-9_-]*@(gmail|yahoo|outlook){1}\\.com") ) {
          JOptionPane.showMessageDialog(this, "Email không hợp lệ");
          tfEmail_QuanLyKhachHang.requestFocus();
        }
        if ( !tfTenTaiKhoan_QuanLyKhachHang.getText().matches("^[A-Za-z_]{1}[A-Za-z0-9_-]*$") ) {
          JOptionPane.showMessageDialog(this, "Tên tài khoản không hợp lệ");
          tfTenTaiKhoan_QuanLyKhachHang.requestFocus();
        }
        if ( !tfMatKhau_QuanLyKhachHang.getText().matches("^[A-Za-z_0-9]{1}[A-Za-z0-9_-]{4,}$") ) {
          JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ");
          tfMatKhau_QuanLyKhachHang.requestFocus();
        }
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin");
    }
	}

	public void actionXoa_QuanLyKhachHang() {
		if (tKhachHang.getSelectedRow() != -1) {
      if ( JOptionPane.showConfirmDialog(
        this, 
        "Bạn có muốn xoá dòng này không?", 
        "Cảnh báo", 
        JOptionPane.YES_NO_OPTION
      ) == JOptionPane.YES_OPTION ) {
        khachHang_DAO.delete(
          tKhachHang.getValueAt(
            tKhachHang.getSelectedRow(), 
            0
          ).toString()
        );
        dtmKhachHang.removeRow(tKhachHang.getSelectedRow());
        JOptionPane.showMessageDialog(this, "Xoá khách hàng thành công");  
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xoá");
    }
	}

	public void actionXoaRong_QuanLyKhachHang() {
		tfTenTaiKhoan_QuanLyKhachHang.setText("");
		tfHoTen_QuanLyKhachHang.setText("");
		tfSoDienThoai_QuanLyKhachHang.setText("");
		tfEmail_QuanLyKhachHang.setText("");
		tfMatKhau_QuanLyKhachHang.setText("");
	}

	public void actionCapNhat_QuanLyKhachHang() {
		if (tKhachHang.getSelectedRow() != -1) {
      if ( JOptionPane.showConfirmDialog(
        this, 
        "Bạn có muốn sửa dòng này không?", 
        "Cảnh báo", 
        JOptionPane.YES_NO_OPTION
      ) == JOptionPane.YES_OPTION ) {
        khachHang_DAO.update(
          new KhachHang(
            tfTenTaiKhoan_QuanLyKhachHang.getText(), 
            tfHoTen_QuanLyKhachHang.getText(), 
            tfSoDienThoai_QuanLyKhachHang.getText(), 
            tfEmail_QuanLyKhachHang.getText(), 
            cbPhai.getSelectedItem() == "Nam" ? true : false, 
            tfMatKhau_QuanLyKhachHang.getText()
          )
        );

        Object[] obj = new Object[6];

        obj[0] = tfTenTaiKhoan_QuanLyKhachHang.getText();
        obj[1] = tfHoTen_QuanLyKhachHang.getText();
        obj[2] = tfSoDienThoai_QuanLyKhachHang.getText();
        obj[3] = tfEmail_QuanLyKhachHang.getText();
        obj[4] = cbPhai.getSelectedItem();
        obj[5] = tfMatKhau_QuanLyKhachHang.getText();

        for (int i = 0; i < tKhachHang.getColumnCount(); i++) {
          dtmKhachHang.setValueAt(obj[i], tKhachHang.getSelectedRow(), i);
        }
        JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công");  
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa");
    }
	}

  public void addKhachHangToTable() {
    ArrayList<KhachHang> KhachHangList = KhachHang_DAO.getAll();
    for (KhachHang khachHang : KhachHangList) {
      dtmKhachHang.addRow(
        new String[] {
          khachHang.getTenTaiKhoan(),
          khachHang.getHoTen(),
          khachHang.getSoDienThoai(), 
          khachHang.getEmail(),
          khachHang.getPhai() ? "Nam" : "Nữ",
          khachHang.getMatKhau()
        }
      );
    }
  }

  //---------------------------------------------------------------------------

	public void actionThem_QuanLyTuyen() {
		if (
      !tfMaTuyen_QuanLyTuyen.getText().equals("") &&
      !tfTenTuyen_QuanLyTuyen.getText().equals("") &&
      !tfMoTa_QuanLyTuyen.getText().equals("") &&
      !tfNgayKhoiHanh_QuanLyTuyen.getText().equals("") &&
      !tfNgayKetThuc_QuanLyTuyen.getText().equals("") &&
      !tfGia_QuanLyTuyen.getText().equals("") &&
      !tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText().equals("")
    ) {
      Pattern patt = Pattern.compile(
        "^(\\p{Upper}{1}[\\p{Lower}]*)([\\s-]\\p{Upper}*[\\p{Lower}-]*)+$", 
        Pattern.UNICODE_CHARACTER_CLASS
      );
      if (
        tfMaTuyen_QuanLyTuyen.getText().matches("^T\\d{3}$") &&
        patt.matcher(tfTenTuyen_QuanLyTuyen.getText()).matches() &&
        patt.matcher(tfMoTa_QuanLyTuyen.getText()).matches() &&
        tfNgayKhoiHanh_QuanLyTuyen.getText().matches("^\\d{4}-\\d{2}-\\d{2}$") &&
        tfNgayKetThuc_QuanLyTuyen.getText().matches("^\\d{4}-\\d{2}-\\d{2}$") &&
        isNumberic(tfGia_QuanLyTuyen.getText()) &&
        isNumberic(tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText())
      ) {
        if ( tuyen_DAO.getMaTuyen(tfMaTuyen_QuanLyTuyen.getText()) == null )  {
          try {
            tuyen_DAO.create(
              new Tuyen(
                tfMaTuyen_QuanLyTuyen.getText(), 
                tfTenTuyen_QuanLyTuyen.getText(), 
                tfMoTa_QuanLyTuyen.getText(), 
                new SimpleDateFormat("yyyy-MM-dd").parse(tfNgayKhoiHanh_QuanLyTuyen.getText()),
                new SimpleDateFormat("yyyy-MM-dd").parse(tfNgayKetThuc_QuanLyTuyen.getText()),
                Double.parseDouble(tfGia_QuanLyTuyen.getText()), 
                Integer.parseInt(tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText()),
                maNhanVien
              )
            );
            JOptionPane.showMessageDialog(this, "Thêm tuyến thành công");
            dtmTuyen.addRow(
              new String[] {
                tfMaTuyen_QuanLyTuyen.getText(), 
                tfTenTuyen_QuanLyTuyen.getText(), 
                tfMoTa_QuanLyTuyen.getText(), 
                tfNgayKhoiHanh_QuanLyTuyen.getText(),
                tfNgayKetThuc_QuanLyTuyen.getText(),
                tfGia_QuanLyTuyen.getText(), 
                tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText(),
                maNhanVien
              }
            );
          } catch (NumberFormatException e) {
            e.printStackTrace();
          } catch (ParseException e) {
            e.printStackTrace();
          }
        } else {
          JOptionPane.showMessageDialog(this, "Đã có mã tuyến " + tfMaTuyen_QuanLyTuyen.getText());
        }
      } else {
        if ( !tfMaTuyen_QuanLyTuyen.getText().matches("^T\\d{3}$") ) {
          JOptionPane.showMessageDialog(this, "Mã tuyến không hợp lệ");
          tfMaTuyen_QuanLyTuyen.requestFocus();
        }
        if ( !patt.matcher(tfTenTuyen_QuanLyTuyen.getText()).matches() ) {
          JOptionPane.showMessageDialog(this, "Tên tuyến không hợp lệ");
          tfTenTuyen_QuanLyTuyen.requestFocus();
        }
        if ( !patt.matcher(tfMoTa_QuanLyTuyen.getText()).matches() ) {
          JOptionPane.showMessageDialog(this, "Mô tả tuyến không hợp lệ");
          tfMoTa_QuanLyTuyen.requestFocus();
        }
        if ( !tfNgayKhoiHanh_QuanLyTuyen.getText().matches("^\\d{4}-\\d{2}-\\d{2}$") ) {
          JOptionPane.showMessageDialog(this, "Ngày khởi hành không hợp lệ");
          tfNgayKhoiHanh_QuanLyTuyen.requestFocus();
        }
        if ( !tfNgayKetThuc_QuanLyTuyen.getText().matches("^\\d{4}-\\d{2}-\\d{2}$") ) {
          JOptionPane.showMessageDialog(this, "Ngày kết thúc không hợp lệ");
          tfNgayKetThuc_QuanLyTuyen.requestFocus();
        }
        if ( !isNumberic(tfGia_QuanLyTuyen.getText()) ) {
          JOptionPane.showMessageDialog(this, "Giá không hợp lệ");
          tfGia_QuanLyTuyen.requestFocus();
        }
        if ( !isNumberic(tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText()) ) {
          JOptionPane.showMessageDialog(this, "Số người tham gia không hợp lệ");
          tfSoNguoiThamGiaToiDa_QuanLyTuyen.requestFocus();
        }
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin");
    }
	}

	public void actionXoa_QuanLyTuyen() {
		if (tTuyen.getSelectedRow() != -1) {
      if ( JOptionPane.showConfirmDialog(
        this, 
        "Bạn có muốn xoá dòng này không?", 
        "Cảnh báo", 
        JOptionPane.YES_NO_OPTION
      ) == JOptionPane.YES_OPTION ) {
        tuyen_DAO.delete(
          tTuyen.getValueAt(
            tTuyen.getSelectedRow(), 
            0
          ).toString()
        );
        dtmTuyen.removeRow(tTuyen.getSelectedRow());
        JOptionPane.showMessageDialog(this, "Xoá tuyến thành công");  
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xoá");
    }
	}

	public void actionXoaRong_QuanLyTuyen() {
		tfMaTuyen_QuanLyTuyen.setText("");
    tfTenTuyen_QuanLyTuyen.setText("");
    tfMoTa_QuanLyTuyen.setText("");
    tfNgayKhoiHanh_QuanLyTuyen.setText("");
    tfNgayKetThuc_QuanLyTuyen.setText("");
    tfGia_QuanLyTuyen.setText("");
    tfSoNguoiThamGiaToiDa_QuanLyTuyen.setText("");
	}

	public void actionCapNhat_QuanLyTuyen() {
		if (tTuyen.getSelectedRow() != -1) {
      if ( JOptionPane.showConfirmDialog(
        this, 
        "Bạn có muốn sửa dòng này không?", 
        "Cảnh báo", 
        JOptionPane.YES_NO_OPTION
      ) == JOptionPane.YES_OPTION ) {
        if (
          !tfMaTuyen_QuanLyTuyen.getText().equals("") &&
          !tfTenTuyen_QuanLyTuyen.getText().equals("") &&
          !tfMoTa_QuanLyTuyen.getText().equals("") &&
          !tfNgayKhoiHanh_QuanLyTuyen.getText().equals("") &&
          !tfNgayKetThuc_QuanLyTuyen.getText().equals("") &&
          !tfGia_QuanLyTuyen.getText().equals("") &&
          !tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText().equals("")
        ) {
          Pattern patt =  Pattern.compile(
            "^(\\p{Upper}{1}[\\p{Lower}]*)([\\s-]\\p{Upper}*[\\p{Lower}-]*)+$", 
            Pattern.UNICODE_CHARACTER_CLASS
          );
          if (
            tfMaTuyen_QuanLyTuyen.getText().matches("^T\\d{3}$") &&
            patt.matcher(tfTenTuyen_QuanLyTuyen.getText()).matches() &&
            patt.matcher(tfMoTa_QuanLyTuyen.getText()).matches() &&
            tfNgayKhoiHanh_QuanLyTuyen.getText().matches("^\\d{4}-\\d{2}-\\d{2}$") &&
            tfNgayKetThuc_QuanLyTuyen.getText().matches("^\\d{4}-\\d{2}-\\d{2}$") &&
            isNumberic(tfGia_QuanLyTuyen.getText()) &&
            isNumberic(tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText())
          ) {
              try {
                tuyen_DAO.update(
                  new Tuyen(
                    tfMaTuyen_QuanLyTuyen.getText(), 
                    tfTenTuyen_QuanLyTuyen.getText(), 
                    tfMoTa_QuanLyTuyen.getText(), 
                    new SimpleDateFormat("yyyy-MM-dd").parse(tfNgayKhoiHanh_QuanLyTuyen.getText()),
                    new SimpleDateFormat("yyyy-MM-dd").parse(tfNgayKetThuc_QuanLyTuyen.getText()),
                    Double.parseDouble(tfGia_QuanLyTuyen.getText()), 
                    Integer.parseInt(tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText()),
                    maNhanVien
                  )
                );
                Object[] obj = new Object[8];

                obj[0] = tfMaTuyen_QuanLyTuyen.getText();
                obj[1] = tfTenTuyen_QuanLyTuyen.getText();
                obj[2] = tfMoTa_QuanLyTuyen.getText();
                obj[3] = tfNgayKhoiHanh_QuanLyTuyen.getText();
                obj[4] = tfNgayKetThuc_QuanLyTuyen.getText();
                obj[5] = tfGia_QuanLyTuyen.getText();
                obj[6] = tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText();
                obj[7] = maNhanVien;

                for (int i = 0; i < tTuyen.getColumnCount(); i++) {
                  dtmTuyen.setValueAt(obj[i], tTuyen.getSelectedRow(), i);
                }
                JOptionPane.showMessageDialog(this, "Cập nhật tuyến thành công");
              } catch (NumberFormatException e) {
                e.printStackTrace();
              } catch (ParseException e) {
                e.printStackTrace();
              }
          } else {
            if ( !tfMaTuyen_QuanLyTuyen.getText().matches("^T\\d{3}$") ) {
              JOptionPane.showMessageDialog(this, "Mã tuyến không hợp lệ");
              tfMaTuyen_QuanLyTuyen.requestFocus();
            }
            if ( !patt.matcher(tfTenTuyen_QuanLyTuyen.getText()).matches() ) {
              JOptionPane.showMessageDialog(this, "Tên tuyến không hợp lệ");
              tfTenTuyen_QuanLyTuyen.requestFocus();
            }
            if ( !patt.matcher(tfMoTa_QuanLyTuyen.getText()).matches() ) {
              JOptionPane.showMessageDialog(this, "Mô tả tuyến không hợp lệ");
              tfMoTa_QuanLyTuyen.requestFocus();
            }
            if ( !tfNgayKhoiHanh_QuanLyTuyen.getText().matches("^\\d{4}-\\d{2}-\\d{2}$") ) {
              JOptionPane.showMessageDialog(this, "Ngày khởi hành không hợp lệ");
              tfNgayKhoiHanh_QuanLyTuyen.requestFocus();
            }
            if ( !tfNgayKetThuc_QuanLyTuyen.getText().matches("^\\d{4}-\\d{2}-\\d{2}$") ) {
              JOptionPane.showMessageDialog(this, "Ngày kết thúc không hợp lệ");
              tfNgayKetThuc_QuanLyTuyen.requestFocus();
            }
            if ( !isNumberic(tfGia_QuanLyTuyen.getText()) ) {
              JOptionPane.showMessageDialog(this, "Giá không hợp lệ");
              tfGia_QuanLyTuyen.requestFocus();
            }
            if ( !isNumberic(tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText()) ) {
              JOptionPane.showMessageDialog(this, "Số người tham gia không hợp lệ");
              tfSoNguoiThamGiaToiDa_QuanLyTuyen.requestFocus();
            }
          }
        } else {
          JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin");
        }
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa");
    }
	}

  public void addTuyenToTable() {
    ArrayList<Tuyen> TuyenList = Tuyen_DAO.getAll();
    for (Tuyen tuyen : TuyenList) {
      if (tuyen.getMaNhanVien().equals(maNhanVien)) {
        dtmTuyen.addRow(
          new String[] {
            tuyen.getMa(),
            tuyen.getTen(),
            tuyen.getMoTa(),
            tuyen.getNgayKhoiHanh() + "",
            tuyen.getNgayKetThuc() + "",
            tuyen.getGia() + "",
            tuyen.getSoNguoiThamGia() + "",
            tuyen.getMaNhanVien()
          }
        );
      }
    }
  }

  //---------------------------------------------------------------------------

	public void actionThem_QuanLyDiaDiemDuLich() {
		if (
      !tfMa_QuanLyDiaDiemDuLich.getText().equals("") &&
      !tfTen_QuanLyDiaDiemDuLich.getText().equals("") &&
      !tfDiaChi_QuanLyDiaDiemDuLich.getText().equals("") &&
      !tfDacTrung_QuanLyDiaDiemDuLich.getText().equals("") &&
      !tfMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich.getText().equals("")
    ) {
      Pattern patt =  Pattern.compile(
        "^(\\p{Upper}{1}\\p{Lower}*)(\\s\\p{Upper}{1}\\p{Lower}*)*$", 
        Pattern.UNICODE_CHARACTER_CLASS
      );
      Pattern patt2 =  Pattern.compile(
        "^(\\p{Upper}{1}\\p{Lower}*)(\\s\\p{Upper}*\\p{Lower}+)*$", 
        Pattern.UNICODE_CHARACTER_CLASS
      );
      if (
        tfMa_QuanLyDiaDiemDuLich.getText().matches("^DDDL\\d{3}$") &&
        patt.matcher( tfTen_QuanLyDiaDiemDuLich.getText() ).matches() &&
        patt2.matcher( tfDiaChi_QuanLyDiaDiemDuLich.getText() ).matches() &&
        patt2.matcher( tfDacTrung_QuanLyDiaDiemDuLich.getText() ).matches()
      ) {
        if ( diaDiemDuLich_DAO.getDiaDiemDuLich(tfMa_QuanLyDiaDiemDuLich.getText()) == null )  {
          if ( tuyen_DAO.getMaTuyen( tfMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich.getText() ) != null ) {
            try {
              diaDiemDuLich_DAO.create(
                new DiaDiemDuLich(
                  tfMa_QuanLyDiaDiemDuLich.getText(), 
                  tfTen_QuanLyDiaDiemDuLich.getText(), 
                  tfDiaChi_QuanLyDiaDiemDuLich.getText(), 
                  tfDacTrung_QuanLyDiaDiemDuLich.getText()
                ),
                tfMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich.getText()
              );
              JOptionPane.showMessageDialog(this, "Thêm địa điểm du lịch thành công");
              dtmDiaDiemDuLich.addRow(
                new String[] {
                  tfMa_QuanLyDiaDiemDuLich.getText(), 
                  tfTen_QuanLyDiaDiemDuLich.getText(), 
                  tfDiaChi_QuanLyDiaDiemDuLich.getText(), 
                  tfDacTrung_QuanLyDiaDiemDuLich.getText()
                }
              );
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          } else {
            JOptionPane.showMessageDialog(this, "Không có mã tuyến " + tfMaTuyenCuaDiaDiemDuLich_QuanLyDiaDiemDuLich.getText());
          }
        } else {
          JOptionPane.showMessageDialog(this, "Đã có mã địa điểm " + tfMa_QuanLyDiaDiemDuLich.getText());
        }
      } else {
        if ( !tfMa_QuanLyDiaDiemDuLich.getText().matches("^DDDL\\d{3}$") ) {
          JOptionPane.showMessageDialog(this, "Mã địa điểm không hợp lệ");
          tfMa_QuanLyDiaDiemDuLich.requestFocus();
        }
        if ( !patt.matcher( tfTen_QuanLyDiaDiemDuLich.getText() ).matches() ) {
          JOptionPane.showMessageDialog(this, "Tên địa điểm không hợp lệ");
          tfTen_QuanLyDiaDiemDuLich.requestFocus();
        }
        if ( !patt2.matcher( tfDiaChi_QuanLyDiaDiemDuLich.getText() ).matches() ) {
          JOptionPane.showMessageDialog(this, "Địa chỉ địa điểm không hợp lệ");
          tfDiaChi_QuanLyDiaDiemDuLich.requestFocus();
        }
        if ( !patt2.matcher( tfDacTrung_QuanLyDiaDiemDuLich.getText() ).matches() ) {
          JOptionPane.showMessageDialog(this, "Đặc trưng địa điểm không hợp lệ");
          tfDacTrung_QuanLyDiaDiemDuLich.requestFocus();
        }
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin");
    }
	}

	public void actionXoa_QuanLyDiaDiemDuLich() {
		if (tDiaDiemDuLich.getSelectedRow() != -1) {
      if ( JOptionPane.showConfirmDialog(
        this, 
        "Bạn có muốn xoá dòng này không?", 
        "Cảnh báo", 
        JOptionPane.YES_NO_OPTION
      ) == JOptionPane.YES_OPTION ) {
        diaDiemDuLich_DAO.delete(
          tDiaDiemDuLich.getValueAt(
            tDiaDiemDuLich.getSelectedRow(), 
            0
          ).toString()
        );
        dtmDiaDiemDuLich.removeRow(tDiaDiemDuLich.getSelectedRow());
        JOptionPane.showMessageDialog(this, "Xoá địa điểm thành công");  
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xoá");
    }
	}

	public void actionXoaRong_QuanLyDiaDiemDuLich() {
		tfMa_QuanLyDiaDiemDuLich.setText("");
    tfTen_QuanLyDiaDiemDuLich.setText("");
    tfDiaChi_QuanLyDiaDiemDuLich.setText("");
    tfDacTrung_QuanLyDiaDiemDuLich.setText("");
	}

	public void actionCapNhat_QuanLyDiaDiemDuLich() {
		if (tDiaDiemDuLich.getSelectedRow() != -1) {
      if ( JOptionPane.showConfirmDialog(
        this, 
        "Bạn có muốn sửa dòng này không?", 
        "Cảnh báo", 
        JOptionPane.YES_NO_OPTION
      ) == JOptionPane.YES_OPTION ) {
        try {
          diaDiemDuLich_DAO.update(
            new DiaDiemDuLich(
              tfMa_QuanLyDiaDiemDuLich.getText(), 
              tfTen_QuanLyDiaDiemDuLich.getText(), 
              tfDiaChi_QuanLyDiaDiemDuLich.getText(), 
              tfDacTrung_QuanLyDiaDiemDuLich.getText()
            )
          );

          Object[] obj = new Object[4];

          obj[0] = tfMaTuyen_QuanLyTuyen.getText();
          obj[1] = tfTenTuyen_QuanLyTuyen.getText();
          obj[2] = tfMoTa_QuanLyTuyen.getText();
          obj[3] = tfNgayKhoiHanh_QuanLyTuyen.getText();

          for (int i = 0; i < tDiaDiemDuLich.getColumnCount(); i++) {
            dtmDiaDiemDuLich.setValueAt(obj[i], tDiaDiemDuLich.getSelectedRow(), i);
          }
          JOptionPane.showMessageDialog(this, "Cập nhật tuyến thành công");
        } catch (NumberFormatException e) {
          e.printStackTrace();
        }  
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa");
    }
	}

  public void addDiaDiemDuLichToTable() {
    ArrayList<DiaDiemDuLich> DiaDiemDuLichList = DiaDiemDuLich_DAO.getAll();
    for (DiaDiemDuLich diaDiemDuLich : DiaDiemDuLichList) {
      dtmDiaDiemDuLich.addRow(
        new String[] {
          diaDiemDuLich.getMa(),
          diaDiemDuLich.getTen(),
          diaDiemDuLich.getDiaChi(),
          diaDiemDuLich.getDacTrung()
        }
      );
    }
  }

  //---------------------------------------------------------------------------

	public void actionThem_QuanLyDatVe() {
		if (
      !tfSoNguoiThamGia_QuanLyDatVe.getText().equals("") &&
      !tfMaKhachHang_QuanLyDatVe.getText().equals("") &&
      !tfMaTuyen_QuanLyDatVe.getText().equals("")
    ) {
      if ( isNumberic( tfSoNguoiThamGia_QuanLyDatVe.getText() ) ) {
        if ( tuyen_DAO.getTuyen(tfMaTuyen_QuanLyDatVe.getText()) != null )  {
          if ( khachHang_DAO.getKhachHang(tfMaKhachHang_QuanLyDatVe.getText()) != null ) {
            if ( 
              thongTinDatVe_DAO.getThongTinDatVe(
                tfMaKhachHang_QuanLyDatVe.getText(), 
                tfMaTuyen_QuanLyDatVe.getText()
              ) == null 
            ) {
              if ( 
                thongTinDatVe_DAO.getSoNguoiThamGia(
                  tfMaKhachHang_QuanLyDatVe.getText(), 
                  tfMaTuyen_QuanLyDatVe.getText()
                ) + Integer.parseInt(tfSoNguoiThamGia_QuanLyDatVe.getText())
                 <= tuyen_DAO.getSoNguoiThamGiaToiDa(tfMaTuyen_QuanLyDatVe.getText()) 
              ) {
                try {
                  thongTinDatVe_DAO.create(
                    new ThongTinDatVe(
                      Integer.parseInt(tfSoNguoiThamGia_QuanLyDatVe.getText()), 
                      cbHinhThucThanhToan.getSelectedItem().toString(), 
                      tfMaKhachHang_QuanLyDatVe.getText(), 
                      tfMaTuyen_QuanLyDatVe.getText()
                    )
                  );
                  dtmDatVe.addRow(
                    new String[] {
                      tfSoNguoiThamGia_QuanLyDatVe.getText(), 
                      cbHinhThucThanhToan.getSelectedItem().toString(), 
                      tfMaKhachHang_QuanLyDatVe.getText(), 
                      tfMaTuyen_QuanLyDatVe.getText()
                    }
                  );
                  JOptionPane.showMessageDialog(this, "Tạo thông tin đặt vé thành công");
                } catch (NumberFormatException e) {
                  e.printStackTrace();
                }
              } else {
                JOptionPane.showMessageDialog(this, "Số người tham gia vượt quá giới hạn tuyến cho phép (" + tuyen_DAO.getTuyen(tfMaTuyen_QuanLyDatVe.getText()).getSoNguoiThamGia() + ")");
              }
            } else {
              JOptionPane.showMessageDialog(this, "Đã có thông tin đặt vé cho mã khách hàng " + tfMaKhachHang_QuanLyDatVe.getText() + " và mã tuyến " + tfMaTuyen_QuanLyDatVe.getText());
            } 
          } else {
            JOptionPane.showMessageDialog(this, "Không có mã khách hàng " + tfMaKhachHang_QuanLyDatVe.getText());
          }
        } else {
          JOptionPane.showMessageDialog(this, "Không có mã tuyến " + tfMaTuyen_QuanLyDatVe.getText());
        }
      } else {
        JOptionPane.showMessageDialog(this, "Số người tham gia phải là số");
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin");
    }
	}

	public void actionXoa_QuanLyDatVe() {
		if (tDatVe.getSelectedRow() != -1) {
      if ( JOptionPane.showConfirmDialog(
        this, 
        "Bạn có muốn xoá dòng này không?", 
        "Cảnh báo", 
        JOptionPane.YES_NO_OPTION
      ) == JOptionPane.YES_OPTION ) {
        thongTinDatVe_DAO.delete(
          tDatVe.getValueAt(
            tDatVe.getSelectedRow(), 
            2
          ).toString(),
          tDatVe.getValueAt(
            tDatVe.getSelectedRow(), 
            3
          ).toString()
        );
        dtmDatVe.removeRow(tDatVe.getSelectedRow());
        JOptionPane.showMessageDialog(this, "Xoá thông tin đặt vé thành công");  
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xoá");
    }
	}

	public void actionXoaRong_QuanLyDatVe() {
		tfSoNguoiThamGia_QuanLyDatVe.setText("");
    tfMaKhachHang_QuanLyDatVe.setText("");
    tfMaTuyen_QuanLyDatVe.setText("");
	}

	public void actionCapNhat_QuanLyDatVe() {
		if (tDatVe.getSelectedRow() != -1) {
      if ( JOptionPane.showConfirmDialog(
        this, 
        "Bạn có muốn sửa dòng này không?", 
        "Cảnh báo", 
        JOptionPane.YES_NO_OPTION
      ) == JOptionPane.YES_OPTION ) {

        if (
          !tfSoNguoiThamGia_QuanLyDatVe.getText().equals("") &&
          !tfMaKhachHang_QuanLyDatVe.getText().equals("") &&
          !tfMaTuyen_QuanLyDatVe.getText().equals("")
        ) {
          if ( isNumberic( tfSoNguoiThamGia_QuanLyDatVe.getText() ) ) {
            if ( tuyen_DAO.getTuyen(tfMaTuyen_QuanLyDatVe.getText()) != null )  {
              if ( khachHang_DAO.getKhachHang(tfMaKhachHang_QuanLyDatVe.getText()) != null ) {
                if ( 
                  thongTinDatVe_DAO.getSoNguoiThamGia(
                    tfMaKhachHang_QuanLyDatVe.getText(), 
                    tfMaTuyen_QuanLyDatVe.getText()
                  ) + Integer.parseInt(tfSoNguoiThamGia_QuanLyDatVe.getText())
                  <= tuyen_DAO.getSoNguoiThamGiaToiDa(tfMaTuyen_QuanLyDatVe.getText()) 
                ) {
                  try {
                    thongTinDatVe_DAO.update(
                      new ThongTinDatVe(
                        Integer.parseInt(tfSoNguoiThamGia_QuanLyDatVe.getText()), 
                        cbHinhThucThanhToan.getSelectedItem().toString(), 
                        tfMaKhachHang_QuanLyDatVe.getText(), 
                        tfMaTuyen_QuanLyDatVe.getText()
                      )
                    );
          
                    Object[] obj = new Object[4];
          
                    obj[0] = tfSoNguoiThamGia_QuanLyDatVe.getText();
                    obj[1] = cbHinhThucThanhToan.getSelectedItem().toString();
                    obj[2] = tfMaKhachHang_QuanLyDatVe.getText();
                    obj[3] = tfMaTuyen_QuanLyDatVe.getText();
          
                    for (int i = 0; i < tDatVe.getColumnCount(); i++) {
                      dtmDatVe.setValueAt(obj[i], tDatVe.getSelectedRow(), i);
                    }
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin đặt vé thành công");
                  } catch (NumberFormatException e) {
                    e.printStackTrace();
                  }
                } else {
                  JOptionPane.showMessageDialog(this, "Số người tham gia vượt quá giới hạn tuyến cho phép (" + tuyen_DAO.getTuyen(tfMaTuyen_QuanLyDatVe.getText()).getSoNguoiThamGia() + ")");
                }
              } else {
                JOptionPane.showMessageDialog(this, "Không có mã khách hàng " + tfMaKhachHang_QuanLyDatVe.getText());
              }
            } else {
              JOptionPane.showMessageDialog(this, "Không có mã tuyến " + tfMaTuyen_QuanLyDatVe.getText());
            }
          } else {
            JOptionPane.showMessageDialog(this, "Số người tham gia phải là số");
          }
        } else {
          JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin");
        }
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa");
    }
	}

  public void addThongTinDatVeToTable() {
    ArrayList<ThongTinDatVe> ThongTinDatVeList = ThongTinDatVe_DAO.getAll();
    for (ThongTinDatVe thongTinDatVe : ThongTinDatVeList) {
      dtmDatVe.addRow(
        new String[] {
          thongTinDatVe.getSoNguoiThamGia() + "",
          thongTinDatVe.getHinhThucThanhToan(),
          thongTinDatVe.getMaKhachHang(), 
          thongTinDatVe.getMaTuyen(), 
        }
      );
    }
  }

  //---------------------------------------------------------------------------

  public boolean isNumberic(String s) {
    if (s.equals("")) return false;
    try {
      Double.parseDouble(s);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

	public void mouseClicked(java.awt.event.MouseEvent e) {
		if (e.getSource() == tKhachHang) {
			tfTenTaiKhoan_QuanLyKhachHang.setText(
        tKhachHang.getValueAt(
          tKhachHang.getSelectedRow(), 
          0
        ).toString()
      );
			tfHoTen_QuanLyKhachHang.setText(
        tKhachHang.getValueAt(
          tKhachHang.getSelectedRow(), 
          1
        ).toString()
      );
			tfSoDienThoai_QuanLyKhachHang.setText(
        tKhachHang.getValueAt(
          tKhachHang.getSelectedRow(), 
          2
        ).toString()
      );
			tfEmail_QuanLyKhachHang.setText(
        tKhachHang.getValueAt(
          tKhachHang.getSelectedRow(), 
          3
        ).toString()
      );
			cbPhai.getModel().setSelectedItem(
        tKhachHang.getValueAt(
          tKhachHang.getSelectedRow(), 
          4
        ).toString()
      );
			tfMatKhau_QuanLyKhachHang.setText(
        tKhachHang.getValueAt(
          tKhachHang.getSelectedRow(), 
          5
        ).toString()
      );
		}
    if (e.getSource() == tTuyen) {
			tfMaTuyen_QuanLyTuyen.setText(
        tTuyen.getValueAt(
          tTuyen.getSelectedRow(), 
          0
        ).toString()
      );
			tfTenTuyen_QuanLyTuyen.setText(
        tTuyen.getValueAt(
          tTuyen.getSelectedRow(), 
          1
        ).toString()
      );
      tfMoTa_QuanLyTuyen.setText(
        tTuyen.getValueAt(
          tTuyen.getSelectedRow(), 
          2
        ).toString()
      );
      tfNgayKhoiHanh_QuanLyTuyen.setText(
        tTuyen.getValueAt(
          tTuyen.getSelectedRow(), 
          3
        ).toString()
      );
      tfNgayKetThuc_QuanLyTuyen.setText(
        tTuyen.getValueAt(
          tTuyen.getSelectedRow(), 
          4
        ).toString()
      );
      tfGia_QuanLyTuyen.setText(
        tTuyen.getValueAt(
          tTuyen.getSelectedRow(), 
          5
        ).toString()
      );
      tfSoNguoiThamGiaToiDa_QuanLyTuyen.setText(
        tTuyen.getValueAt(
          tTuyen.getSelectedRow(), 
          6
        ).toString()
      );
		}
    if (e.getSource() == tDiaDiemDuLich) {
			tfMa_QuanLyDiaDiemDuLich.setText(
        tDiaDiemDuLich.getValueAt(
          tDiaDiemDuLich.getSelectedRow(), 
          0
        ).toString()
      );
      tfTen_QuanLyDiaDiemDuLich.setText(
        tDiaDiemDuLich.getValueAt(
          tDiaDiemDuLich.getSelectedRow(), 
          1
        ).toString()
      );
      tfDiaChi_QuanLyDiaDiemDuLich.setText(
        tDiaDiemDuLich.getValueAt(
          tDiaDiemDuLich.getSelectedRow(), 
          2
        ).toString()
      );
      tfDacTrung_QuanLyDiaDiemDuLich.setText(
        tDiaDiemDuLich.getValueAt(
          tDiaDiemDuLich.getSelectedRow(), 
          3
        ).toString()
      );
		}
    if (e.getSource() == tDatVe) {
			tfSoNguoiThamGia_QuanLyDatVe.setText(
        tDatVe.getValueAt(
          tDatVe.getSelectedRow(), 
          0
        ).toString()
      );
      cbHinhThucThanhToan.getModel().setSelectedItem(
        tDatVe.getValueAt(
          tDatVe.getSelectedRow(), 
          1
        ).toString()
      );
      tfMaKhachHang_QuanLyDatVe.setText(
        tDatVe.getValueAt(
          tDatVe.getSelectedRow(), 
          2
        ).toString()
      );
      tfMaTuyen_QuanLyDatVe.setText(
        tDatVe.getValueAt(
          tDatVe.getSelectedRow(), 
          3
        ).toString()
      );
		}
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }

  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }

  public void keyReleased(KeyEvent e) {
    if ( e.getSource().equals(tfTenTaiKhoan_QuanLyKhachHang) ) {
      trsKhachHang.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfTenTaiKhoan_QuanLyKhachHang.getText())
      );
    }
    if ( e.getSource().equals(tfHoTen_QuanLyKhachHang) ) {
      trsKhachHang.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfHoTen_QuanLyKhachHang.getText())
      );
    }
    if ( e.getSource().equals(tfSoDienThoai_QuanLyKhachHang) ) {
      trsKhachHang.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfSoDienThoai_QuanLyKhachHang.getText())
      );
    }
    if ( e.getSource().equals(tfEmail_QuanLyKhachHang) ) {
      trsKhachHang.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfEmail_QuanLyKhachHang.getText())
      );
    }
    if ( e.getSource().equals(cbPhai) ) {
      trsKhachHang.setRowFilter(
        RowFilter.regexFilter("(?i)" + cbPhai.getSelectedItem())
      );
    }
    if ( e.getSource().equals(tfMatKhau_QuanLyKhachHang) ) {
      trsKhachHang.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfMatKhau_QuanLyKhachHang.getText())
      );
    }



    if ( e.getSource().equals(tfMaTuyen_QuanLyTuyen) ) {
      trsTuyen.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfMaTuyen_QuanLyTuyen.getText())
      );
    }
    if ( e.getSource().equals(tfTenTuyen_QuanLyTuyen) ) {
      trsTuyen.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfTenTuyen_QuanLyTuyen.getText())
      );
    }
    if ( e.getSource().equals(tfMoTa_QuanLyTuyen) ) {
      trsTuyen.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfMoTa_QuanLyTuyen.getText())
      );
    }
    if ( e.getSource().equals(tfGia_QuanLyTuyen) ) {
      trsTuyen.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfGia_QuanLyTuyen.getText())
      );
    }
    if ( e.getSource().equals(tfSoNguoiThamGiaToiDa_QuanLyTuyen) ) {
      trsTuyen.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfSoNguoiThamGiaToiDa_QuanLyTuyen.getText())
      );
    }



    if ( e.getSource().equals(tfMa_QuanLyDiaDiemDuLich) ) {
      trsDiaDiemDuLich.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfMa_QuanLyDiaDiemDuLich.getText())
      );
    }
    if ( e.getSource().equals(tfTen_QuanLyDiaDiemDuLich) ) {
      trsDiaDiemDuLich.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfTen_QuanLyDiaDiemDuLich.getText())
      );
    }
    if ( e.getSource().equals(tfDiaChi_QuanLyDiaDiemDuLich) ) {
      trsDiaDiemDuLich.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfDiaChi_QuanLyDiaDiemDuLich.getText())
      );
    }
    if ( e.getSource().equals(tfDacTrung_QuanLyDiaDiemDuLich) ) {
      trsDiaDiemDuLich.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfDacTrung_QuanLyDiaDiemDuLich.getText())
      );
    }



    if ( e.getSource().equals(cbHinhThucThanhToan) ) {
      trsDatVe.setRowFilter(
        RowFilter.regexFilter("(?i)" + cbHinhThucThanhToan.getSelectedItem())
      );
    }
    if ( e.getSource().equals(tfSoNguoiThamGia_QuanLyDatVe) ) {
      trsDatVe.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfSoNguoiThamGia_QuanLyDatVe.getText())
      );
    }
    if ( e.getSource().equals(tfMaKhachHang_QuanLyDatVe) ) {
      trsDatVe.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfMaKhachHang_QuanLyDatVe.getText())
      );
    }
    if ( e.getSource().equals(tfMaTuyen_QuanLyDatVe) ) {
      trsDatVe.setRowFilter(
        RowFilter.regexFilter("(?i)" + tfMaTuyen_QuanLyDatVe.getText())
      );
    }
  }
}