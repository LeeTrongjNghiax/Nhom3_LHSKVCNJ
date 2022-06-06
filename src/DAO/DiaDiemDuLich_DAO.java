package DAO;

import java.sql.*;
import java.util.ArrayList;

import ConnectDB.connectDB;
import Entity.DiaDiemDuLich;

public class DiaDiemDuLich_DAO {
  public DiaDiemDuLich_DAO() {
    
	}
	public static ArrayList<DiaDiemDuLich> getAll() {
		ArrayList<DiaDiemDuLich> DiaDiemDuLichList = new ArrayList<DiaDiemDuLich>();
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM DiaDiemDuLich";
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
	public String getDiaDiemDuLich(String ma) {
		try {
			Connection con = connectDB.getInstance().getConnection();
			String sql = "SELECT * FROM DiaDiemDuLich WHERE maDiaDiem='" + ma + "'";
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
	public boolean create(DiaDiemDuLich diaDiemDuLich, String maTuyen) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("INSERT INTO DiaDiemDuLich VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, diaDiemDuLich.getMa());
			ps.setString(2, diaDiemDuLich.getTen());
			ps.setString(3, diaDiemDuLich.getDiaChi());
			ps.setString(4, diaDiemDuLich.getDacTrung());
			ps.setString(5, maTuyen);
			n = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(DiaDiemDuLich diaDiemDuLich) {
		Connection con = connectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("UPDATE DiaDiemDuLich SET tenDiaDiem=?, diaChi=?, dacTrung=? WHERE maDiaDiem=?");
			ps.setString(1, diaDiemDuLich.getTen());
			ps.setString(2, diaDiemDuLich.getDiaChi());
			ps.setString(3, diaDiemDuLich.getDacTrung());
			ps.setString(4, diaDiemDuLich.getMa());
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
			ps = con.prepareStatement("DELETE FROM DiaDiemDuLich WHERE maDiaDiem=?");
			ps.setString(1, ma);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}