import controller.MovieController;
import repository.MovieRepository;

public class Main {
    public static void main(String[] args) {
//        MovieRepository.getRepository().getUserData("123");
        MovieController.getController().mainMenu();

    }
}
