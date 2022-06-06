import ConnectDB.connectDB;
import GUI.logIn;

public class index {
  public static void main(String[] args) {
    connectDB.getInstance();
    connectDB.connect();
    new logIn();
  }
}