package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;

public class logIn extends JFrame implements ActionListener {
	JLabel lbMain, 
					lbTenDangNhap, 
					lbMatKhau, 
					lbChuaCoTaiKhoan;

	JTextField tfTenDangNhap;
	JPasswordField tfMatKhau;
						
	JButton bDangNhap, 
					bDangKy;

	JPanel pMain, 
					pNorth, 
					pCenter, 
					pSouth;

	Box bCenter1, 
			bCenter2, 
			bCenter3,
			bCenter4;

	KhachHang_DAO khachHang_DAO;
	NhanVien_DAO nhanVien_DAO;

	int gray = 50;
	int white = 255;

	public logIn() {
		super("Đăng nhập");

		khachHang_DAO = new KhachHang_DAO();
		nhanVien_DAO = new NhanVien_DAO();

		lbMain = new JLabel("Đăng nhập");
		lbMain.setFont(new Font("monospace", Font.BOLD, 20));
		lbMain.setForeground(new Color(white, white, white));

		lbTenDangNhap = new JLabel("Tên tài khoản: ");
		lbTenDangNhap.setForeground(new Color(white, white, white));

		lbMatKhau = new JLabel("Mật khẩu:");
		lbMatKhau.setForeground(new Color(white, white, white));
		lbMatKhau.setPreferredSize(lbTenDangNhap.getPreferredSize());

		lbChuaCoTaiKhoan = new JLabel("Bạn chưa có tài khoản? Đăng ký tại");
		lbChuaCoTaiKhoan.setForeground(new Color(white, white, white));

		tfTenDangNhap = new JTextField(20);
		tfTenDangNhap.setBackground(new Color(gray, gray, gray));
		tfTenDangNhap.setForeground(new Color(white, white, white));

		tfMatKhau = new JPasswordField(20);
		tfMatKhau.setBackground(new Color(gray, gray, gray));
		tfMatKhau.setForeground(new Color(white, white, white));

		bDangNhap = new JButton("Đăng nhập");
		bDangKy = new JButton("Đăng ký");

		pNorth = new JPanel();
		pCenter = new JPanel();
		pSouth = new JPanel();
		pMain = new JPanel();

		bCenter1 = Box.createHorizontalBox();
		bCenter2 = Box.createHorizontalBox();
		bCenter3 = Box.createHorizontalBox();
		bCenter4 = Box.createHorizontalBox();

		//----------------------------------------------------------------------------

		pNorth.add(lbMain);
		pNorth.setBackground(new Color(gray, gray, gray));

		//----------------------------------------------------------------------------

		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
		pCenter.setBackground(new Color(gray, gray, gray));

		bCenter1.add(Box.createHorizontalStrut(20));
		bCenter1.add(lbTenDangNhap);
		bCenter4.add(Box.createHorizontalStrut(10));
		bCenter1.add(tfTenDangNhap);
		bCenter1.add(Box.createHorizontalStrut(20));

		bCenter2.add(Box.createHorizontalStrut(20));
		bCenter2.add(lbMatKhau);
		bCenter2.add(Box.createHorizontalStrut(10));
		bCenter2.add(tfMatKhau);
		bCenter2.add(Box.createHorizontalStrut(20));

		bCenter3.add(Box.createHorizontalStrut(20));
		bCenter3.add(bDangNhap);
		bCenter3.add(Box.createHorizontalStrut(20));

		bCenter4.add(Box.createHorizontalStrut(20));
		bCenter4.add(lbChuaCoTaiKhoan);
		bCenter4.add(Box.createHorizontalStrut(5));
		bCenter4.add(bDangKy);
		bCenter4.add(Box.createHorizontalStrut(20));
		
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(bCenter1);
		pCenter.add(Box.createVerticalStrut(10));
		pCenter.add(bCenter2);
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(bCenter3);
		pCenter.add(Box.createVerticalStrut(10));
		pCenter.add(bCenter4);
		pCenter.add(Box.createVerticalStrut(20));
		
		//----------------------------------------------------------------------------

		pSouth.setLayout(new BoxLayout(pSouth, BoxLayout.X_AXIS));

		//----------------------------------------------------------------------------

		add(pNorth, BorderLayout.NORTH);
		add(pCenter, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);

		//----------------------------------------------------------------------------

		bDangNhap.addActionListener(this);
		bDangKy.addActionListener(this);

		//----------------------------------------------------------------------------

		setSize(400, 250);
		setVisible(true);
		setResizable(false);
		setBackground(new Color(40, 40, 40));
		setLocationRelativeTo(null);
		setBackground(new Color(gray, gray, gray));

		//-------------------------------------DEBUG---------------------------------------
		
		// addComponentListener(new ComponentAdapter() {
    //   public void componentResized(ComponentEvent e) {
    //     System.out.println("Resized to " + e.getComponent().getSize());
    //   }
    //   public void componentMoved(ComponentEvent e) {
    //     System.out.println("Moved to " + e.getComponent().getLocation());
    //   }
    // });

		tfTenDangNhap.setText("bonefries");
		tfMatKhau.setText("diem10LTHSK");

		tfTenDangNhap.setText("NV121");
		tfMatKhau.setText("zxcvbnm");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bDangKy) actionDangKy();
		if (e.getSource() == bDangNhap) actionDangNhap();
	}

	public void actionDangNhap() {
		if (
			!tfTenDangNhap.getText().equals("") &&
			!tfMatKhau.getText().equals("")
		) {
			if ( tfTenDangNhap.getText().matches("NV.+") ) {
				if ( nhanVien_DAO.getMa( tfTenDangNhap.getText(), tfMatKhau.getText() ) != null ) {
					JOptionPane.showMessageDialog(this, "Bạn đã đăng nhập dưới tư cách nhân viên thành công");
					dispose();
					new nhanVienGUI(nhanVien_DAO.getMa( tfTenDangNhap.getText(), tfMatKhau.getText() ));
				} else {
					JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu nhân viên không đúng");
				}
			} else {
				if ( khachHang_DAO.getTenTaiKhoan( tfTenDangNhap.getText(), tfMatKhau.getText() ) != null ) {
					JOptionPane.showMessageDialog(this, "Bạn đã đăng nhập thành công");
					dispose();
					new khachHangGUI(khachHang_DAO.getTenTaiKhoan( tfTenDangNhap.getText(), tfMatKhau.getText()));
				} else {
					JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ dữ liệu");
		}
	}

	public void actionDangKy() {
		new signUp();
	}
}