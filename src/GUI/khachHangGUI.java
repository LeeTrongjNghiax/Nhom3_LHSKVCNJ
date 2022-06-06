package GUI;

import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import DAO.Tuyen_DAO;
import Entity.KhachHang;
import Entity.Tuyen;

public class khachHangGUI extends JFrame implements ActionListener, MouseListener {
  JTabbedPane tpLeft;

  Tuyen_DAO tuyen_DAO;
  KhachHang_DAO khachHang_DAO;

  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

  JLabel lbThongTinCuaBan, 
          lbThongTinCuaBan2, 
          lbDatVe, 
          lbCaiDat,

          lbHoTen, 
          lbSoDienThoai, 
          lbEmail, 
          lbPhai, 
          lbTenTaiKhoan, 
          lbMatKhau, 
          
          lbChonTuyenMuonDat;

  JTextField tfHoTen, 
              tfSoDienThoai, 
              tfEmail, 
              tfTenTaiKhoan, 
              tfMatKhau, 
              
              tfTimKiem;

  Box b1_ThongTinCuaBan, 

      b2_ThongTinCuaBan, 

      b2_1_ThongTinCuaBan, 
      b2_2_ThongTinCuaBan, 
      b2_3_ThongTinCuaBan, 
      b2_4_ThongTinCuaBan, 
      b2_5_ThongTinCuaBan, 
      b2_6_ThongTinCuaBan, 
      b2_7_ThongTinCuaBan,
      b2_8_ThongTinCuaBan, 
      
      b1_DatVe, 

      b1_1_DatVe, 
      b1_2_DatVe, 

      b1_CaiDat;

  JButton bSua_ThongTinCuaBan, 
          bDangXuat_CaiDat;

  String[] sTuyen = {"Mã tuyến", "Tên tuyến", "Mô tả", "Ngày khởi hành", "Ngày kết thúc", "Giá", "Số người tham gia tối đa"};

  String[] sPhai = {"Nam", "Nữ"};
  JComboBox<String> cbPhai;

  DefaultTableModel dtmTuyen;

  JScrollPane spTuyen;

  JTable tTuyen;

  JPanel pThongTinCuaBan, 
          pDatVe, 
          pCaiDat;

  String tenTaiKhoanKhachHang;

  public khachHangGUI(String tenTaiKhoan) {
    super("Xin chào " + tenTaiKhoan);

    tenTaiKhoanKhachHang = tenTaiKhoan;

    tuyen_DAO = new Tuyen_DAO();
    khachHang_DAO = new KhachHang_DAO();
    KhachHang khachHang = khachHang_DAO.getKhachHang(tenTaiKhoan);

    tpLeft = new JTabbedPane(JTabbedPane.LEFT);

    lbThongTinCuaBan2 = new JLabel("Thông tin của bạn");
    lbThongTinCuaBan2.setFont(new Font("monospace", Font.BOLD, 30));

    lbThongTinCuaBan = new JLabel("Thông tin của bạn");
    lbThongTinCuaBan.setPreferredSize(new Dimension(120, 50));

    lbDatVe = new JLabel("Đặt vé");
    lbDatVe.setPreferredSize(new Dimension(120, 50));

    lbCaiDat = new JLabel("Cài đặt");
    lbCaiDat.setPreferredSize(new Dimension(120, 50));

    lbTenTaiKhoan = new JLabel("Tên tài khoản:");

    lbHoTen = new JLabel("Họ tên:");
    lbHoTen.setPreferredSize(lbTenTaiKhoan.getPreferredSize());

    lbSoDienThoai = new JLabel("Số điện thoại:");

    lbEmail = new JLabel("Email:");
    lbEmail.setPreferredSize(lbTenTaiKhoan.getPreferredSize());

    lbPhai = new JLabel("Phái:");
    lbPhai.setPreferredSize(lbTenTaiKhoan.getPreferredSize());

    lbMatKhau = new JLabel("Mật khẩu:");
    lbMatKhau.setPreferredSize(lbTenTaiKhoan.getPreferredSize());

    lbChonTuyenMuonDat = new JLabel("Chọn tuyến muốn đặt:");
    lbChonTuyenMuonDat.setFont(new Font("monospace", Font.BOLD, 30));

    tfHoTen = new JTextField(10);
    tfHoTen.setText(khachHang.getHoTen());

    tfSoDienThoai = new JTextField(10);
    tfSoDienThoai.setText(khachHang.getSoDienThoai());

    tfEmail = new JTextField(10);
    tfEmail.setText(khachHang.getEmail());

    cbPhai = new JComboBox<String>(sPhai);

    tfTenTaiKhoan = new JTextField(10);
    tfTenTaiKhoan.setText(khachHang.getTenTaiKhoan());

    tfMatKhau = new JTextField(10);
    tfMatKhau.setText(khachHang.getMatKhau());

    b1_ThongTinCuaBan = Box.createHorizontalBox();

    b2_ThongTinCuaBan = Box.createVerticalBox();

    b2_1_ThongTinCuaBan = Box.createHorizontalBox();
    b2_2_ThongTinCuaBan = Box.createHorizontalBox();
    b2_3_ThongTinCuaBan = Box.createHorizontalBox();
    b2_4_ThongTinCuaBan = Box.createHorizontalBox();
    b2_5_ThongTinCuaBan = Box.createHorizontalBox();
    b2_6_ThongTinCuaBan = Box.createHorizontalBox();
    b2_7_ThongTinCuaBan = Box.createHorizontalBox();
    b2_8_ThongTinCuaBan = Box.createHorizontalBox();

    b1_DatVe = Box.createVerticalBox();

    b1_1_DatVe = Box.createHorizontalBox();
    b1_2_DatVe = Box.createHorizontalBox();

    b1_CaiDat = Box.createVerticalBox();

    dtmTuyen = new DefaultTableModel(sTuyen, 0);
    tTuyen = new JTable(dtmTuyen);
    spTuyen = new JScrollPane(tTuyen);

    bSua_ThongTinCuaBan = new JButton("Sửa");
    bDangXuat_CaiDat = new JButton("Đăng xuất");

    pThongTinCuaBan = new JPanel();
    pDatVe = new JPanel();
    pCaiDat = new JPanel();

    //---------------------------------------------------------------------------

    b1_ThongTinCuaBan.add(lbThongTinCuaBan2);

    b2_1_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_1_ThongTinCuaBan.add(lbHoTen);
    b2_1_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_1_ThongTinCuaBan.add(tfHoTen);
    b2_1_ThongTinCuaBan.add(Box.createHorizontalStrut(50));

    b2_2_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_2_ThongTinCuaBan.add(lbSoDienThoai);
    b2_2_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_2_ThongTinCuaBan.add(tfSoDienThoai);
    b2_2_ThongTinCuaBan.add(Box.createHorizontalStrut(50));

    b2_3_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_3_ThongTinCuaBan.add(lbEmail);
    b2_3_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_3_ThongTinCuaBan.add(tfEmail);
    b2_3_ThongTinCuaBan.add(Box.createHorizontalStrut(50));

    b2_4_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_4_ThongTinCuaBan.add(lbPhai);
    b2_4_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_4_ThongTinCuaBan.add(cbPhai);
    b2_4_ThongTinCuaBan.add(Box.createHorizontalStrut(50));

    b2_5_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_5_ThongTinCuaBan.add(lbTenTaiKhoan);
    b2_5_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_5_ThongTinCuaBan.add(tfTenTaiKhoan);
    b2_5_ThongTinCuaBan.add(Box.createHorizontalStrut(50));

    b2_6_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_6_ThongTinCuaBan.add(lbMatKhau);
    b2_6_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_6_ThongTinCuaBan.add(tfMatKhau);
    b2_6_ThongTinCuaBan.add(Box.createHorizontalStrut(50));

    b2_7_ThongTinCuaBan.add(Box.createHorizontalStrut(50));
    b2_7_ThongTinCuaBan.add(bSua_ThongTinCuaBan);
    b2_7_ThongTinCuaBan.add(Box.createHorizontalStrut(50));

    b2_ThongTinCuaBan.add(Box.createVerticalStrut(50));
    b2_ThongTinCuaBan.add(b2_1_ThongTinCuaBan);
    b2_ThongTinCuaBan.add(Box.createVerticalStrut(10));
    b2_ThongTinCuaBan.add(b2_2_ThongTinCuaBan);
    b2_ThongTinCuaBan.add(Box.createVerticalStrut(10));
    b2_ThongTinCuaBan.add(b2_3_ThongTinCuaBan);
    b2_ThongTinCuaBan.add(Box.createVerticalStrut(10));
    b2_ThongTinCuaBan.add(b2_4_ThongTinCuaBan);
    b2_ThongTinCuaBan.add(Box.createVerticalStrut(10));
    b2_ThongTinCuaBan.add(b2_5_ThongTinCuaBan);
    b2_ThongTinCuaBan.add(Box.createVerticalStrut(10));
    b2_ThongTinCuaBan.add(b2_6_ThongTinCuaBan);
    b2_ThongTinCuaBan.add(Box.createVerticalStrut(10));
    b2_ThongTinCuaBan.add(b2_7_ThongTinCuaBan);
    b2_ThongTinCuaBan.add(Box.createVerticalStrut(10));

    pThongTinCuaBan.setLayout(new BorderLayout());

    pThongTinCuaBan.add(b1_ThongTinCuaBan, BorderLayout.NORTH);
    pThongTinCuaBan.add(b2_ThongTinCuaBan, BorderLayout.CENTER);

    //---------------------------------------------------------------------------

    b1_1_DatVe.add(Box.createVerticalStrut(10));
    b1_1_DatVe.add(lbChonTuyenMuonDat);
    b1_1_DatVe.add(Box.createVerticalStrut(10));

    b1_2_DatVe.add(spTuyen);

    b1_DatVe.add(b1_1_DatVe);
    b1_DatVe.add(b1_2_DatVe);

    pDatVe.setLayout(new BorderLayout());

    pDatVe.add(b1_DatVe, BorderLayout.CENTER);

    //---------------------------------------------------------------------------

    b1_CaiDat.add(bDangXuat_CaiDat);

    pCaiDat.setLayout(new BorderLayout());

    pCaiDat.add(b1_CaiDat, BorderLayout.CENTER);

    //---------------------------------------------------------------------------

    tpLeft.addTab("Quản lý khách hàng", pThongTinCuaBan);
    tpLeft.setTabComponentAt(0, lbThongTinCuaBan);

    tpLeft.addTab("Quản lý chuyến đi", pDatVe);
    tpLeft.setTabComponentAt(1, lbDatVe);

    tpLeft.addTab("Quản lý địa điểm du lịch", pCaiDat);
    tpLeft.setTabComponentAt(2, lbCaiDat);

    add(tpLeft, BorderLayout.CENTER);

    //---------------------------------------------------------------------------

    addTuyenToTable();

    //---------------------------------------------------------------------------

    tTuyen.addMouseListener(this);
    bSua_ThongTinCuaBan.addActionListener(this);
    bDangXuat_CaiDat.addActionListener(this);

    //---------------------------------------------------------------------------

    setSize(1400, 400);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bSua_ThongTinCuaBan) action_SuaThongTin();
    if (e.getSource() == bDangXuat_CaiDat) action_DangXuat();
  }

  public void action_SuaThongTin() {
    if ( JOptionPane.showConfirmDialog(
      this, 
      "Bạn có muốn thay đổi thông tin không?", 
      "Cảnh báo", 
      JOptionPane.YES_NO_OPTION
    ) == JOptionPane.YES_OPTION ) {
      if (
        !tfHoTen.getText().equals("") &&
        !tfSoDienThoai.getText().equals("") &&
        !tfEmail.getText().equals("") &&
        !tfTenTaiKhoan.getText().equals("") &&
        !tfMatKhau.getText().equals("")
      ) {
        Pattern pattHoTen =  Pattern.compile(
          "^(\\p{Upper}{1}\\p{Lower}*)(\\s\\p{Upper}{1}\\p{Lower}*)+$", 
          Pattern.UNICODE_CHARACTER_CLASS
        );
        if (
          pattHoTen.matcher(tfHoTen.getText()).matches() &&
          tfSoDienThoai.getText().matches("^0{1}[1-9]{1}[0-9]{8}$") &&
          tfEmail.getText().matches("^[A-Za-z_-]{1}[A-Za-z0-9_-]*@(gmail|yahoo|outlook){1}\\.com$") &&
          tfTenTaiKhoan.getText().matches("^[A-Za-z_]{1}[A-Za-z0-9_-]*$") &&
          tfMatKhau.getText().matches("^[A-Za-z_0-9]{1}[A-Za-z0-9_-]{4,}$")
        ) {
          if ( khachHang_DAO.getTenTaiKhoan(
            tfTenTaiKhoan.getText(), 
            tfMatKhau.getText()
          ) == null ) {
            khachHang_DAO.update(
              new KhachHang(
                tfTenTaiKhoan.getText(), 
                tfHoTen.getText(), 
                tfSoDienThoai.getText(), 
                tfEmail.getText(), 
                cbPhai.getSelectedItem() == "Nam" ? true : false, 
                tfMatKhau.getText()
              )
            );
            JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thành công");
          } else {
            JOptionPane.showMessageDialog(this, "Đã có tài khoản có tên là " + tfTenTaiKhoan.getText());
          }
        } else {
          if ( !pattHoTen.matcher(tfHoTen.getText()).matches() ) {
            JOptionPane.showMessageDialog(this, "Họ tên không hợp lệ");
            tfHoTen.requestFocus();
          }
          if ( !tfSoDienThoai.getText().matches("0{1}[1-9]{1}[0-9]{8}") ) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            tfSoDienThoai.requestFocus();
          }
          if ( !tfEmail.getText().matches("[A-Za-z_-]{1}[A-Za-z0-9_-]*@(gmail|yahoo|outlook){1}\\.com") ) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ");
            tfEmail.requestFocus();
          }
          if ( !tfTenTaiKhoan.getText().matches("^[A-Za-z_]{1}[A-Za-z0-9_-]*$") ) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản không hợp lệ");
            tfTenTaiKhoan.requestFocus();
          }
          if ( !tfMatKhau.getText().matches("^[A-Za-z_0-9]{1}[A-Za-z0-9_-]{4,}$") ) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ");
            tfMatKhau.requestFocus();
          }
        }
      } else {
        JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin");
      }
    }
  }

  public void action_DangXuat() {
    dispose();
    new logIn();
  }

  public void addTuyenToTable() {
    ArrayList<Tuyen> TuyenList = Tuyen_DAO.getAll();
    for (Tuyen tuyen : TuyenList) {
      dtmTuyen.addRow(
        new String[] {
          tuyen.getMa(),
          tuyen.getTen(),
          tuyen.getMoTa(),
          tuyen.getNgayKhoiHanh() + "",
          tuyen.getNgayKetThuc() + "",
          tuyen.getGia() + "",
          tuyen.getSoNguoiThamGia() + "",
        }
      );
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (e.getSource() == tTuyen) {
      new datVeGui(tuyen_DAO.getMaTuyen(
        tTuyen.getValueAt(tTuyen.getSelectedRow(), 0).toString()
      ), tenTaiKhoanKhachHang);
    }
    if (e.getSource() == bSua_ThongTinCuaBan) actionSuaThongTin();
  }

  public void actionSuaThongTin() {

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
}