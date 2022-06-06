package Entity;

public class KhachHang extends Nguoi {
  private String tenTaiKhoan;
  public KhachHang(String tenTaiKhoan, String hoTen, String soDienThoai, String email, Boolean phai, 
      String matKhau) {
    super(hoTen, soDienThoai, email, phai, matKhau);
    this.tenTaiKhoan = tenTaiKhoan;
  }
  public String getTenTaiKhoan() {
    return tenTaiKhoan;
  }
  public void setTenTaiKhoan(String tenTaiKhoan) {
    this.tenTaiKhoan = tenTaiKhoan;
  }
}