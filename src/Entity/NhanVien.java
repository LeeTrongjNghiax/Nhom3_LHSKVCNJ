package Entity;

public class NhanVien extends Nguoi {
  private String ma;
  public NhanVien(String ma, String hoTen, String soDienThoai, String email, Boolean phai, 
      String matKhau) {
    super(hoTen, soDienThoai, email, phai, matKhau);
    this.ma = ma;
  }
  public String getMa() {
    return ma;
  }
  public void setMa(String ma) {
    this.ma = ma;
  }
}
