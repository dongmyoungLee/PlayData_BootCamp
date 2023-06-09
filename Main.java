import config.JdbcConnection;
import controller.MovieController;

public class Main {
    public static void main(String[] args) {
          JdbcConnection conn = new JdbcConnection();
          conn.getJdbc();
//        MovieController.getController().mainMenu();

    }
}
