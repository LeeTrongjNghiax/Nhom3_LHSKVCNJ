package DAO;

import java.sql.*;
import java.util.ArrayList;

import ConnectDB.connectDB;
import Entity.KhachHang;

public class KhachHang_DAO {
  public KhachHang_DAO() {
    
	}
	public static ArrayList<KhachHang> getAll() {
		ArrayList<KhachHang> KhachHangList = new ArrayList<KhachHang>();
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				KhachHangList.add(
					new KhachHang(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getBoolean(5), 
						rs.getString(6)
					)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return KhachHangList;
	}
	public String getTenTaiKhoan(String tenTaiKhoan, String matKhau) {
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM KhachHang WHERE tenTaiKhoan='" + tenTaiKhoan + "' AND matKhau='" + matKhau + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getString(1);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public KhachHang getKhachHang(String tenTaiKhoan) {
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM KhachHang WHERE tenTaiKhoan='" + tenTaiKhoan + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				return new KhachHang(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getBoolean(5),
					rs.getString(6)
				);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean create(KhachHang khachHang) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("INSERT INTO" + " KhachHang VALUES(?, ?, ?, ?, ?, ?)");
			ps.setString(1, khachHang.getTenTaiKhoan());
			ps.setString(2, khachHang.getHoTen());
			ps.setString(3, khachHang.getSoDienThoai());
			ps.setString(4, khachHang.getEmail());
			ps.setBoolean(5, khachHang.getPhai());
			ps.setString(6, khachHang.getMatKhau());
			n = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(KhachHang khachHang) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("UPDATE KhachHang SET hoTen=?, soDienThoai=?, email=?, phai=?, matKhau=? WHERE tenTaiKhoan=?");
			ps.setString(1, khachHang.getHoTen());
			ps.setString(2, khachHang.getSoDienThoai());
			ps.setString(3, khachHang.getEmail());
			ps.setBoolean(4, khachHang.getPhai());
			ps.setString(5, khachHang.getMatKhau());
			ps.setString(6, khachHang.getTenTaiKhoan());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String tenTaiKhoan) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("DELETE FROM KhachHang WHERE tenTaiKhoan = ?");
			ps.setString(1, tenTaiKhoan);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}