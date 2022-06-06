package DAO;

import java.sql.*;
import java.util.ArrayList;

import ConnectDB.connectDB;
import Entity.DiaDiemDuLich;
import Entity.Tuyen;

public class Tuyen_DAO {
  public Tuyen_DAO() {
    
	}
	public static ArrayList<Tuyen> getAll() {
		ArrayList<Tuyen> TuyenList = new ArrayList<Tuyen>();
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM Tuyen";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				TuyenList.add(
					new Tuyen(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDate(4), 
						rs.getDate(5), 
						Double.parseDouble(rs.getString(6)),
						Integer.parseInt(rs.getString(7)),
						rs.getString(8)
					)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TuyenList;
	}
	public String getMaTuyen(String maTuyen) {
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM Tuyen WHERE maTuyen='" + maTuyen + "'";
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
	public Tuyen getTuyen(String maTuyen) {
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM Tuyen WHERE maTuyen='" + maTuyen + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				return new Tuyen(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getDate(4),
					rs.getDate(5),
					rs.getInt(6),
					rs.getInt(7),
					rs.getString(8)
				);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getSoNguoiThamGiaToiDa(String maTuyen) {
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT soNguoiThamGiaToiDa FROM Tuyen WHERE maTuyen='" + maTuyen + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<DiaDiemDuLich> getCacDiaDiemDuLich(String maTuyen) {
		ArrayList<DiaDiemDuLich> DiaDiemDuLichList = new ArrayList<DiaDiemDuLich>();
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT D.maDiaDiem, D.tenDiaDiem, D.diaChi, D.dacTrung FROM Tuyen AS T JOIN DiaDiemDuLich AS D ON T.maTuyen=D.maTuyen  WHERE T.maTuyen='" + maTuyen + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				DiaDiemDuLichList.add(
					new DiaDiemDuLich(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
					)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DiaDiemDuLichList;
	}
	public boolean create(Tuyen Tuyen) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("INSERT INTO" + " Tuyen VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, Tuyen.getMa());
			ps.setString(2, Tuyen.getTen());
			ps.setString(3, Tuyen.getMoTa());
			ps.setDate(4, new Date(Tuyen.getNgayKhoiHanh().getTime()));
			ps.setDate(5, new Date(Tuyen.getNgayKetThuc().getTime()));
			ps.setDouble(6, Tuyen.getGia());
			ps.setInt(7, Tuyen.getSoNguoiThamGia());
			ps.setString(8, Tuyen.getMaNhanVien());
			n = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(Tuyen Tuyen) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("UPDATE Tuyen SET tenTuyen=?, moTa=?, ngayKhoiHanh=?, ngayKetThuc=?, gia=?, soNguoiThamGiaToiDa=? WHERE maTuyen=?");
			ps.setString(1, Tuyen.getTen());
			ps.setString(2, Tuyen.getMoTa());
			ps.setDate(3, new Date(Tuyen.getNgayKhoiHanh().getTime()));
			ps.setDate(4, new Date(Tuyen.getNgayKetThuc().getTime()));
			ps.setDouble(5, Tuyen.getGia());
			ps.setInt(6, Tuyen.getSoNguoiThamGia());
			ps.setString(7, Tuyen.getMa());
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
			ps = con.prepareStatement("DELETE FROM Tuyen WHERE maTuyen=?");
			ps.setString(1, ma);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}