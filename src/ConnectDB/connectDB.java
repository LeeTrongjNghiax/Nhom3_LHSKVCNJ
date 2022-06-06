package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
  public static Connection con = null;
  private static connectDB instance = new connectDB();  

  public static connectDB getInstance() {
    return instance;
  }
  public Connection getConnection() {
    return con;
  }
  public static void connect() {
    String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=QuanLyThongTinDuLich";
    String user = "sa";
    String password = "123";

    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("Connected");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Cannot connect");
    }
  }

  public static void disconnect() {
    try {
      con.close();
      System.out.println("Disconnected");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Cannot disconnect");
    }
  }

  // public static void main(String[] args) {
  //   connectDB.getInstance();
  //   connectDB.connect();
  // }
}
