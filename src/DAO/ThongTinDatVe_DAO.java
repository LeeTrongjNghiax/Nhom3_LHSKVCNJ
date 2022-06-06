package DAO;

import java.sql.*;
import java.util.ArrayList;

import ConnectDB.connectDB;
import Entity.ThongTinDatVe;

public class ThongTinDatVe_DAO {
  public ThongTinDatVe_DAO() {
    
	}
	public static ArrayList<ThongTinDatVe> getAll() {
		ArrayList<ThongTinDatVe> ThongTinDatVeList = new ArrayList<ThongTinDatVe>();
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM ThongTinDatVe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				ThongTinDatVeList.add(
					new ThongTinDatVe(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4)
					)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ThongTinDatVeList;
	}
	public int getSoNguoiThamGia(String maKhachHang, String maTuyen) {
		int tong = 0;
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT soNguoiThamGia FROM ThongTinDatVe WHERE maKhachHang='" + maKhachHang + "' AND maTuyen='" + maTuyen + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				tong += rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tong;
	}
	public ThongTinDatVe getThongTinDatVe(String maKhachHang, String maTuyen) {
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM ThongTinDatVe WHERE maKhachHang='" + maKhachHang + "' AND maTuyen='" + maTuyen + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			if (rs.next()) {
				return new ThongTinDatVe(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)
				);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean create(ThongTinDatVe thongTinDatVe) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("INSERT INTO ThongTinDatVe VALUES(?, ?, ?, ?)");
			ps.setInt(1, thongTinDatVe.getSoNguoiThamGia());
			ps.setString(2, thongTinDatVe.getHinhThucThanhToan());
			ps.setString(3, thongTinDatVe.getMaKhachHang());
			ps.setString(4, thongTinDatVe.getMaTuyen());
			n = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(ThongTinDatVe thongTinDatVe) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("UPDATE thongTinDatVe SET soNguoiThamGia=?, hinhThucThanhToan=? WHERE maKhachHang=? AND maTuyen=?");
			ps.setInt(1, thongTinDatVe.getSoNguoiThamGia());
			ps.setString(2, thongTinDatVe.getHinhThucThanhToan());
			ps.setString(3, thongTinDatVe.getMaKhachHang());
			ps.setString(4, thongTinDatVe.getMaTuyen());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String maKhachHang, String maTuyen) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("DELETE FROM ThongTinDatVe WHERE maKhachHang=? AND maTuyen=?");
			ps.setString(1, maKhachHang);
			ps.setString(2, maTuyen);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}