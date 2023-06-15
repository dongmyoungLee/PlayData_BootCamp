package service;

import domain.dto.ActorDto;
import domain.dto.MovieDto;
import domain.dto.TheatersDto;
import repository.MovieRepository;
import repository.TheatersRepository;

import java.util.List;
import java.util.Scanner;

public class TheatersService {
    private static TheatersService service;
//    private static Scanner sc;
    public static TheatersService getService() {
        if(service == null) service = new TheatersService();
        return service;
    }
//          해당 영화의 상영관 찾기
    public void searchTheaters(){
        Scanner sc = new Scanner(System.in);
//        현재 상영중인 영화보여주기
        List<MovieDto> movieSelctlist = MovieRepository.getRepository().shownMovies();

        for (MovieDto movie : movieSelctlist) {
            System.out.print(movie.getMovie_seq() + ". ");
            System.out.print(movie.getTitle());
            System.out.println();
        }

        System.out.println("영화의 seq를 입력해주세요");

        int movieNum = Integer.parseInt(sc.nextLine());

        List<TheatersDto> theatersDtoList = TheatersRepository.getRepository().showTheaters(movieNum);

        for (TheatersDto theaters : theatersDtoList) {
            System.out.print(theaters.getName() + " ");
            System.out.print(theaters.getLocation() + " ");
            System.out.print(theaters.getCapacity());
            System.out.println();
        }




    }


}
