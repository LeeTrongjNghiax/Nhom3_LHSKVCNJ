package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import DAO.ThongTinDatVe_DAO;
import DAO.Tuyen_DAO;
import Entity.ThongTinDatVe;

public class formDatVeGui extends JFrame implements ActionListener {
  JLabel lbFormDatVe, 
          lbSoNguoiThamGia, 
          lbHinhThucThanhToan;

  JTextField tfSoNguoiThamGia;

  Box b1, 
      b2, 
      b2_1, 
      b2_2, 
      b3;

  JButton bDatVe;

  String[] sHinhThucThanhToan = {"Thanh toán qua thẻ", "Thanh toán bằng tiền mặt"};

  JComboBox<String> cbHinhThucThanhToan;

  JPanel pNouth, 
          pCenter, 
          pSouth;

  ThongTinDatVe_DAO thongTinDatVe_DAO;
  Tuyen_DAO tuyen_DAO;

  String maTuyen;
  String maKhachHang;

  public formDatVeGui(String maTuyen2, String maKhachHang2) {
    thongTinDatVe_DAO = new ThongTinDatVe_DAO();
    tuyen_DAO = new Tuyen_DAO();

    maTuyen = maTuyen2;
    maKhachHang = maKhachHang2;

    cbHinhThucThanhToan = new JComboBox<>(sHinhThucThanhToan);

    lbFormDatVe = new JLabel("Form đặt vé");
    lbFormDatVe.setFont(new Font("monospace", Font.BOLD, 40));
    lbFormDatVe.setForeground(Color.BLUE);

    lbSoNguoiThamGia = new JLabel("Chọn số người tham gia: ");
    lbSoNguoiThamGia.setFont(new Font("monospace", Font.BOLD, 20));

    lbHinhThucThanhToan = new JLabel("Chọn chọn hình thức thanh toán: ");
    lbHinhThucThanhToan.setFont(new Font("monospace", Font.BOLD, 20));

    tfSoNguoiThamGia = new JTextField(10);

    cbHinhThucThanhToan = new JComboBox<String>(sHinhThucThanhToan);

    b1 = Box.createHorizontalBox();
    b2 = Box.createVerticalBox();
    b2_1 = Box.createHorizontalBox();
    b2_2 = Box.createHorizontalBox();
    b3 = Box.createVerticalBox();

    bDatVe = new JButton("Đặt vé!");

    pNouth = new JPanel();
    pCenter = new JPanel();
    pSouth = new JPanel();

    //----------------------------------------------------------------------------

    b1.add(lbFormDatVe);
    pNouth.add(b1);

    //----------------------------------------------------------------------------

    b2_1.add(Box.createVerticalStrut(10));
    b2_1.add(lbSoNguoiThamGia);
    b2_1.add(Box.createVerticalStrut(10));
    b2_1.add(tfSoNguoiThamGia);
    b2_1.add(Box.createVerticalStrut(10));

    b2_2.add(Box.createVerticalStrut(10));
    b2_2.add(lbHinhThucThanhToan);
    b2_2.add(Box.createVerticalStrut(10));
    b2_2.add(cbHinhThucThanhToan);
    b2_2.add(Box.createVerticalStrut(10));

    b2.add(Box.createVerticalStrut(10));
    b2.add(b2_1);
    b2.add(Box.createVerticalStrut(10));
    b2.add(b2_2);
    b2.add(Box.createVerticalStrut(10));

    pCenter.add(b2);

    //----------------------------------------------------------------------------

    b3.add(bDatVe);

    pSouth.add(b3);

    //----------------------------------------------------------------------------

    add(pNouth, BorderLayout.NORTH);
    add(pCenter, BorderLayout.CENTER);
    add(pSouth, BorderLayout.SOUTH);

    //----------------------------------------------------------------------------

    bDatVe.addActionListener(this);

    //----------------------------------------------------------------------------

    setSize(600, 250);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bDatVe) actionDatVe();
  }

  public void actionDatVe() {
    if ( !tfSoNguoiThamGia.getText().equals("") ) {
      if ( isNumberic(tfSoNguoiThamGia.getText()) ) {
        if ( thongTinDatVe_DAO.getSoNguoiThamGia(maKhachHang, maTuyen) + Integer.parseInt(tfSoNguoiThamGia.getText()) <= tuyen_DAO.getSoNguoiThamGiaToiDa(maTuyen) ) {
          thongTinDatVe_DAO.create(
            new ThongTinDatVe(
              Integer.parseInt(tfSoNguoiThamGia.getText()), 
              cbHinhThucThanhToan.getSelectedItem().toString(),
              maKhachHang, 
              maTuyen
            )
          );
          JOptionPane.showMessageDialog(this, "Đặt vé thành công");
        } else {
          JOptionPane.showMessageDialog(this, "Số người tham gia quá lớn");
        }
      } else {
        JOptionPane.showMessageDialog(this, "Số người tham gia phải là số");
      }
    } else {
      JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ dữ liệu");
    }
  }

  public boolean isNumberic(String s) {
    if (s.equals("")) return false;
    try {
      Double.parseDouble(s);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
