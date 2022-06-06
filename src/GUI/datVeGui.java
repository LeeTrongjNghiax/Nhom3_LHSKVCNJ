package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import DAO.Tuyen_DAO;
import Entity.DiaDiemDuLich;
import Entity.Tuyen;

public class datVeGui extends JFrame implements ActionListener {
  JPanel pMain;

  ArrayList<JPanel> pDiaDiemDuLichList;

  JLabel lbMaTuyen, 
          lbTenTuyen, 
          lbMoTa, 
          lbNgayKhoiHanh, 
          lbNgayKetThuc, 
          lbGia, 
          lbSoNguoiThamGiaToiDa, 
          
          lbCacDiaDiemDuLich;
    
  Box b1, 

      b1_1, 
      b1_2,
      b1_3,
      b1_4,
      b1_5,
      b1_6,
      b1_7, 
      b1_8, 
      
      b2, 
      
      b3, 
      b3_1, 
      b3_2;

  JButton bDatVe;

  Tuyen_DAO tuyen_DAO;

  String maTuyen;
  String maKhachHang;

  public datVeGui(String maTuyen2, String maKhachHang2) {
    super("Đặt tuyến");

    maTuyen = maTuyen2;
    maKhachHang = maKhachHang2;

    tuyen_DAO = new Tuyen_DAO();
    Tuyen tuyen = tuyen_DAO.getTuyen(maTuyen);

    pDiaDiemDuLichList = new ArrayList<JPanel>();

    pMain = new JPanel();

    lbMaTuyen = new JLabel("Mã tuyến: " + tuyen.getMa());
    lbMaTuyen.setFont(new Font("monospace", Font.BOLD, 20));

    lbTenTuyen = new JLabel("Tuyến: " + tuyen.getTen());
    lbTenTuyen.setFont(new Font("monospace", Font.BOLD, 20));

    lbMoTa = new JLabel("Mô tả: " + tuyen.getMoTa());
    lbMoTa.setFont(new Font("monospace", Font.BOLD, 20));

    lbNgayKhoiHanh = new JLabel("Ngày khởi hành: " + tuyen.getNgayKhoiHanh());
    lbNgayKhoiHanh.setFont(new Font("monospace", Font.BOLD, 20));

    lbNgayKetThuc = new JLabel("Ngày kết thúc: " + tuyen.getNgayKetThuc());
    lbNgayKetThuc.setFont(new Font("monospace", Font.BOLD, 20));

    lbGia = new JLabel("Giá: " + tuyen.getGia());
    lbGia.setFont(new Font("monospace", Font.BOLD, 20));

    lbSoNguoiThamGiaToiDa = new JLabel("Số người tham gia tối đa: " + tuyen.getSoNguoiThamGia());
    lbSoNguoiThamGiaToiDa.setFont(new Font("monospace", Font.BOLD, 20));

    String sDiaDiemDuLich = "Các địa điểm du lịch: ";
    ArrayList<DiaDiemDuLich> diaDiemDuLichList = tuyen_DAO.getCacDiaDiemDuLich(tuyen.getMa());

    for (DiaDiemDuLich dddl : diaDiemDuLichList) {
      sDiaDiemDuLich += dddl.getTen() + ", ";
    }

    lbCacDiaDiemDuLich = new JLabel(sDiaDiemDuLich);
    lbCacDiaDiemDuLich.setFont(new Font("monospace", Font.BOLD, 20));

    b1 = Box.createVerticalBox();

    b1_1 = Box.createVerticalBox();
    b1_2 = Box.createVerticalBox();
    b1_3 = Box.createVerticalBox();
    b1_4 = Box.createVerticalBox();
    b1_5 = Box.createVerticalBox();
    b1_6 = Box.createVerticalBox();
    b1_7 = Box.createVerticalBox();
    b1_8 = Box.createVerticalBox();

    b2 = Box.createHorizontalBox();

    b3 = Box.createVerticalBox();

    b3_1 = Box.createHorizontalBox();
    b3_2 = Box.createVerticalBox();

    bDatVe = new JButton("Đặt vé ngay");
 
    //-----------------------------------------------------------------------------

    b1_1.add(Box.createHorizontalStrut(30));
    b1_1.add(lbMaTuyen);
    b1_1.add(Box.createHorizontalStrut(10));

    b1_2.add(Box.createHorizontalStrut(30));
    b1_2.add(lbTenTuyen);
    b1_2.add(Box.createHorizontalStrut(10));

    b1_3.add(Box.createHorizontalStrut(30));
    b1_3.add(lbMoTa);
    b1_3.add(Box.createHorizontalStrut(10));

    b1_4.add(Box.createHorizontalStrut(30));
    b1_4.add(lbNgayKhoiHanh);
    b1_4.add(Box.createHorizontalStrut(10));

    b1_5.add(Box.createHorizontalStrut(30));
    b1_5.add(lbNgayKetThuc);
    b1_5.add(Box.createHorizontalStrut(10));

    b1_6.add(Box.createHorizontalStrut(30));
    b1_6.add(lbGia);
    b1_6.add(Box.createHorizontalStrut(10));

    b1_7.add(Box.createHorizontalStrut(30));
    b1_7.add(lbSoNguoiThamGiaToiDa);
    b1_7.add(Box.createHorizontalStrut(10));

    b1_8.add(Box.createHorizontalStrut(30));
    b1_8.add(lbCacDiaDiemDuLich);
    b1_8.add(Box.createHorizontalStrut(10));

    b1.add(Box.createVerticalStrut(10));
    b1.add(b1_1);
    b1.add(Box.createVerticalStrut(10));
    b1.add(b1_2);
    b1.add(Box.createVerticalStrut(10));
    b1.add(b1_3);
    b1.add(Box.createVerticalStrut(10));
    b1.add(b1_4);
    b1.add(Box.createVerticalStrut(10));
    b1.add(b1_5);
    b1.add(Box.createVerticalStrut(10));
    b1.add(b1_6);
    b1.add(Box.createVerticalStrut(10));
    b1.add(b1_7);
    b1.add(Box.createVerticalStrut(10));
    b1.add(b1_8);
    b1.add(Box.createVerticalStrut(10));

    b2.add(bDatVe);

    pMain.setLayout(new BorderLayout());
    pMain.add(b1, BorderLayout.CENTER);
    pMain.add(b2, BorderLayout.SOUTH);

    //-----------------------------------------------------------------------------

    add(pMain);

    //-----------------------------------------------------------------------------

    bDatVe.addActionListener(this);

    //-----------------------------------------------------------------------------

    setSize(700, 400);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bDatVe) {
      dispose();
      new formDatVeGui(maTuyen, maKhachHang);
    }
  }
}