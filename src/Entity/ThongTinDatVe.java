package Entity;

public class ThongTinDatVe {
  private int soNguoiThamGia;
  private String hinhThucThanhToan;
  private String maKhachHang;
  private String maTuyen;
  public ThongTinDatVe(int soNguoiThamGia, String hinhThucThanhToan, String maKhachHang, String maTuyen) {
    this.soNguoiThamGia = soNguoiThamGia;
    this.hinhThucThanhToan = hinhThucThanhToan;
    this.maKhachHang = maKhachHang;
    this.maTuyen = maTuyen;
  }
  public int getSoNguoiThamGia() {
    return soNguoiThamGia;
  }
  public void setSoNguoiThamGia(int soNguoiThamGia) {
    this.soNguoiThamGia = soNguoiThamGia;
  }
  public String getHinhThucThanhToan() {
    return hinhThucThanhToan;
  }
  public void setHinhThucThanhToan(String hinhThucThanhToan) {
    this.hinhThucThanhToan = hinhThucThanhToan;
  }
  public String getMaKhachHang() {
    return maKhachHang;
  }
  public void setMaKhachHang(String maKhachHang) {
    this.maKhachHang = maKhachHang;
  }
  public String getMaTuyen() {
    return maTuyen;
  }
  public void setMaTuyen(String maTuyen) {
    this.maTuyen = maTuyen;
  }
}