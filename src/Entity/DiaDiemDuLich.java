package Entity;

public class DiaDiemDuLich {
  private String ma;
  private String ten;
  private String diaChi;
  private String dacTrung;

  public DiaDiemDuLich(String ma, String ten, String diaChi, String dacTrung) {
    this.ma = ma;
    this.ten = ten;
    this.diaChi = diaChi;
    this.dacTrung = dacTrung;
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
  public String getDiaChi() {
    return diaChi;
  }
  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }
  public String getDacTrung() {
    return dacTrung;
  }
  public void setDacTrung(String datTrung) {
    this.dacTrung = datTrung;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ma == null) ? 0 : ma.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DiaDiemDuLich other = (DiaDiemDuLich) obj;
    if (ma == null) {
      if (other.ma != null)
        return false;
    } else if (!ma.equals(other.ma))
      return false;
    return true;
  }
}
