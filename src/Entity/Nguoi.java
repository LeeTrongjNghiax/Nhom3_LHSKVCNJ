package Entity;

public abstract class Nguoi {
  protected String hoTen;
  protected String soDienThoai;
  protected String email;
  protected boolean phai;
  protected String matKhau;
  
  public Nguoi(String hoTen, String soDienThoai, String email, Boolean phai,
      String matKhau) {
    this.hoTen = hoTen;
    this.soDienThoai = soDienThoai;
    this.email = email;
    this.phai = phai;
    this.matKhau = matKhau;
  }

  public String getHoTen() {
    return hoTen;
  }

  public void setHoTen(String hoTen) {
    this.hoTen = hoTen;
  }

  public String getSoDienThoai() {
    return soDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    this.soDienThoai = soDienThoai;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getPhai() {
    return phai;
  }

  public void setPhai(Boolean phai) {
    this.phai = phai;
  }

  public String getMatKhau() {
    return matKhau;
  }

  public void setMatKhau(String matKhau) {
    this.matKhau = matKhau;
  }
}
