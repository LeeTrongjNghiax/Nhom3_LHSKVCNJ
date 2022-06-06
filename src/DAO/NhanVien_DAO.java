package DAO;

import java.sql.*;
import java.util.ArrayList;

import ConnectDB.connectDB;
import Entity.NhanVien;

public class NhanVien_DAO {
  public NhanVien_DAO() {
    
	}
	public ArrayList<NhanVien> getAll() {
		ArrayList<NhanVien> NhanVienList = new ArrayList<NhanVien>();
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getBoolean(5));

				NhanVienList.add(
					new NhanVien(
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
		return NhanVienList;
	}
	public String getMa(String ma, String matKhau) {
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM NhanVien WHERE ma='" + ma + "' AND matKhau='" + matKhau + "'";
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
	public boolean create(NhanVien nhanVien) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("INSERT INTO" + " NhanVien VALUES(?, ?, ?, ?, ?, ?)");
			ps.setString(1, nhanVien.getMa());
			ps.setString(2, nhanVien.getHoTen());
			ps.setString(3, nhanVien.getSoDienThoai());
			ps.setString(4, nhanVien.getEmail());
			ps.setBoolean(5, nhanVien.getPhai());
			ps.setString(6, nhanVien.getMatKhau());
			n = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(NhanVien nhanVien) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("UPDATE NhanVien SET hoTen=?, soDienThoai=?, email=?, phai=?, tenTaiKhoan=?, matKhau=? WHERE ma=?");
			ps.setString(1, nhanVien.getHoTen());
			ps.setString(2, nhanVien.getSoDienThoai());
			ps.setString(3, nhanVien.getEmail());
			ps.setBoolean(4, nhanVien.getPhai());
			ps.setString(5, nhanVien.getMatKhau());
			ps.setString(6, nhanVien.getMa());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String ma) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("DELETE FROM NhanVien WHERE ma=?");
			ps.setString(1, ma);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}