package Entity;

import  java.util.Date;

public class Tuyen {
  private String ma;
  private String ten;
  private String moTa;
  private Date ngayKhoiHanh;
  private Date ngayKetThuc;
  private double gia;
  private int soNguoiThamGia;
  private String maNhanVien;
  public Tuyen(String ma, String ten, String moTa, Date ngayKhoiHanh, Date ngayKetThuc, double gia, int soNguoiThamGia,
      String maNhanVien) {
    this.ma = ma;
    this.ten = ten;
    this.moTa = moTa;
    this.ngayKhoiHanh = ngayKhoiHanh;
    this.ngayKetThuc = ngayKetThuc;
    this.gia = gia;
    this.soNguoiThamGia = soNguoiThamGia;
    this.maNhanVien = maNhanVien;
  }
  public String getMa() {
    return ma;
  }
  public void setMa(String ma) {
    this.ma = ma;
  }
  public String getTen() {
    return ten;
  }
  public void setTen(String ten) {
    this.ten = ten;
  }
  public String getMoTa() {
    return moTa;
  }
  public void setMoTa(String moTa) {
    this.moTa = moTa;
  }
  public Date getNgayKhoiHanh() {
    return ngayKhoiHanh;
  }
  public void setNgayKhoiHanh(Date ngayKhoiHanh) {
    this.ngayKhoiHanh = ngayKhoiHanh;
  }
  public Date getNgayKetThuc() {
    return ngayKetThuc;
  }
  public void setNgayKetThuc(Date ngayKetThuc) {
    this.ngayKetThuc = ngayKetThuc;
  }
  public double getGia() {
    return gia;
  }
  public void setGia(double gia) {
    this.gia = gia;
  }
  public int getSoNguoiThamGia() {
    return soNguoiThamGia;
  }
  public void setSoNguoiThamGia(int soNguoiThamGia) {
    this.soNguoiThamGia = soNguoiThamGia;
  }
  public String getMaNhanVien() {
    return maNhanVien;
  }
  public void setMaNhanVien(String maNhanVien) {
    this.maNhanVien = maNhanVien;
  }
}
