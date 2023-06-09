package service;

import controller.MovieController;
import domain.dto.MovieDto;
import domain.dto.UserDto;
import repository.MovieRepository;

import java.util.Scanner;

public class MovieService {
    private static MovieService service;

    public static MovieService getService() {
        if(service == null) service = new MovieService();
        return service;
    }

    public UserDto login(String userId, String userPwd) {
        return MovieRepository.getRepository().login(userId, userPwd);
    }

    public int insertMovieInfo(MovieDto movieDto) {
        return MovieRepository.getRepository().insertMovieInfo(movieDto);
    }


    public void getUserData(){
        Scanner sc =new Scanner(System.in);
        System.out.println("회원 아이디를 입력하세요");
        String user_id=sc.nextLine();
        MovieController.getController().getUserData(user_id);
    }

}
