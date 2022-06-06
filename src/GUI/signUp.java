package GUI;

import javax.swing.*;

import DAO.KhachHang_DAO;
import Entity.KhachHang;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class signUp extends JFrame implements ActionListener {
  JLabel lbMain, 
          lbHoTen, 
          lbSoDienThoai, 
          lbEmail, 
          lbPhai, 
          lbTenTaiKhoan, 
          lbMatKhau, 
          lbXacNhanMatKhau;

  JTextField tfHoTen, 
              tfSoDienThoai, 
              tfEmail, 
              tfTenTaiKhoan;

  JPasswordField tfMatKhau, 
                  tfXacNhanMatKhau;

  JButton btnDangKy;

  String[] sPhai = {"Nam", "Nữ"};
  JComboBox<String> cbPhai;
  
  JPanel pNorth, 
          pCenter, 
          pSouth;

  Box boxCenter1, 
      boxCenter2, 
      boxCenter3, 
      boxCenter4, 
      boxCenter5, 
      boxCenter6, 
      boxCenter7;

  int horiStrut = 50, 
      verStrut = 10;

  KhachHang_DAO khachHang_DAO;

  public signUp() {
    super("Đăng ký tài khoản");

    khachHang_DAO = new KhachHang_DAO();

    lbMain = new JLabel("Đăng ký tài khoản");
    lbMain.setFont(new Font("monospace", Font.BOLD, 20));

    lbXacNhanMatKhau = new JLabel("Xác nhận mật khẩu: ");

    lbHoTen = new JLabel("Họ tên: ");
    lbHoTen.setPreferredSize(lbXacNhanMatKhau.getPreferredSize());

    lbSoDienThoai = new JLabel("Số điện thoại: ");
    lbSoDienThoai.setPreferredSize(lbXacNhanMatKhau.getPreferredSize());

    lbEmail = new JLabel("Email: ");
    lbEmail.setPreferredSize(lbXacNhanMatKhau.getPreferredSize());

    lbPhai = new JLabel("Phái: ");
    lbPhai.setPreferredSize(lbXacNhanMatKhau.getPreferredSize());

    lbTenTaiKhoan = new JLabel("Tên tài khoản: ");
    lbTenTaiKhoan.setPreferredSize(lbXacNhanMatKhau.getPreferredSize());

    lbMatKhau = new JLabel("Mật khẩu: ");
    lbMatKhau.setPreferredSize(lbXacNhanMatKhau.getPreferredSize());

    tfXacNhanMatKhau = new JPasswordField(10);
    tfHoTen = new JTextField(10);
    tfSoDienThoai = new JTextField(10);
    tfEmail = new JTextField(10);
    // tfPhai = new JTextField(10);
    tfTenTaiKhoan = new JTextField(10);
    tfMatKhau = new JPasswordField(10);

    btnDangKy = new JButton("Đăng ký");

    cbPhai = new JComboBox<String>(sPhai);

    boxCenter1 = Box.createHorizontalBox();
    boxCenter2 = Box.createHorizontalBox();
    boxCenter3 = Box.createHorizontalBox();
    boxCenter4 = Box.createHorizontalBox();
    boxCenter5 = Box.createHorizontalBox();
    boxCenter6 = Box.createHorizontalBox();
    boxCenter7 = Box.createHorizontalBox();

    pNorth = new JPanel();
    pCenter = new JPanel();
    pSouth = new JPanel();

    //----------------------------------------------------------------------------

    pNorth.add(lbMain);

    //----------------------------------------------------------------------------

    pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));

    boxCenter1.add(Box.createHorizontalStrut(horiStrut));
    boxCenter1.add(lbHoTen);
    boxCenter1.add(Box.createHorizontalStrut(horiStrut));
    boxCenter1.add(tfHoTen);
    boxCenter1.add(Box.createHorizontalStrut(horiStrut));

    boxCenter2.add(Box.createHorizontalStrut(horiStrut));
    boxCenter2.add(lbSoDienThoai);
    boxCenter2.add(Box.createHorizontalStrut(horiStrut));
    boxCenter2.add(tfSoDienThoai);
    boxCenter2.add(Box.createHorizontalStrut(horiStrut));

    boxCenter3.add(Box.createHorizontalStrut(horiStrut));
    boxCenter3.add(lbEmail);
    boxCenter3.add(Box.createHorizontalStrut(horiStrut));
    boxCenter3.add(tfEmail);
    boxCenter3.add(Box.createHorizontalStrut(horiStrut));

    boxCenter4.add(Box.createHorizontalStrut(horiStrut));
    boxCenter4.add(lbPhai);
    boxCenter4.add(Box.createHorizontalStrut(horiStrut));
    boxCenter4.add(cbPhai);
    boxCenter4.add(Box.createHorizontalStrut(horiStrut));

    boxCenter5.add(Box.createHorizontalStrut(horiStrut));
    boxCenter5.add(lbTenTaiKhoan);
    boxCenter5.add(Box.createHorizontalStrut(horiStrut));
    boxCenter5.add(tfTenTaiKhoan);
    boxCenter5.add(Box.createHorizontalStrut(horiStrut));

    boxCenter6.add(Box.createHorizontalStrut(horiStrut));
    boxCenter6.add(lbMatKhau);
    boxCenter6.add(Box.createHorizontalStrut(horiStrut));
    boxCenter6.add(tfMatKhau);
    boxCenter6.add(Box.createHorizontalStrut(horiStrut));

    boxCenter7.add(Box.createHorizontalStrut(horiStrut));
    boxCenter7.add(lbXacNhanMatKhau);
    boxCenter7.add(Box.createHorizontalStrut(horiStrut));
    boxCenter7.add(tfXacNhanMatKhau);
    boxCenter7.add(Box.createHorizontalStrut(horiStrut));

    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(boxCenter1);
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(boxCenter2);
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(boxCenter3);
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(boxCenter4);
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(boxCenter5);
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(boxCenter6);
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(boxCenter7);
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(Box.createVerticalStrut(verStrut));
    pCenter.add(Box.createVerticalStrut(verStrut));

    //----------------------------------------------------------------------------

    pSouth.add(btnDangKy);

    //----------------------------------------------------------------------------

    add(pNorth, BorderLayout.NORTH);
    add(pCenter, BorderLayout.CENTER);
    add(pSouth, BorderLayout.SOUTH);

    //----------------------------------------------------------------------------

    btnDangKy.addActionListener(this);

    //----------------------------------------------------------------------------


    setSize(500, 360);
    setVisible(true);
    setLocationRelativeTo(null);

    //----------------------------------------------------------------------------

    // addComponentListener(new ComponentAdapter() {
    //   public void componentResized(ComponentEvent e) {
    //     System.out.println("Resized to " + e.getComponent().getSize());
    //   }
    //   public void componentMoved(ComponentEvent e) {
    //     System.out.println("Moved to " + e.getComponent().getLocation());
    //   }
    // });
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnDangKy) actionDangKy();
  }

  public void actionDangKy() {
    if (
      !tfHoTen.getText().equals("") &&
      !tfSoDienThoai.getText().equals("") &&
      !tfEmail.getText().equals("") &&
      !tfTenTaiKhoan.getText().equals("") &&
      !tfMatKhau.getText().equals("") &&
      !tfXacNhanMatKhau.getText().equals("")
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
          if ( tfXacNhanMatKhau.getText().equals( tfMatKhau.getText() ) ) {
            khachHang_DAO.create(
              new KhachHang(
                tfTenTaiKhoan.getText(),
                tfHoTen.getText(), 
                tfSoDienThoai.getText(), 
                tfEmail.getText(), 
                cbPhai.getSelectedItem().toString() == "Nam" ? true : false,
                tfMatKhau.getText()
              )
            );
            JOptionPane.showMessageDialog(this, "Bạn đã đăng ký tài khoản thành công");
            dispose();
          } else {
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không đúng");
            tfXacNhanMatKhau.requestFocus();
          }
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
