package controller;

import config.JdbcConnection;
import domain.dto.MovieDto;
import domain.dto.UserDto;
import service.MovieService;
import view.MovieView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MovieController {
    // 객체 싱글톤
    private static MovieController controller;

    public static MovieController getController() {
        if (controller == null) controller = new MovieController();
        return controller;
    }

    public void mainMenu() {
        MovieView.getView().mainMenu();
    }

    public void login(String userId, String userPwd) {

        UserDto user = new MovieService().login(userId, userPwd);

        // 찾는 회원이 없다면 ..?
        if (user.getUserId() == null) {
            System.out.println("회원 정보가 올바르지 않아요.");
            return;
        }

        // 회원 id가 admin 이라면 admin 모드로..
        if (user.getUserId().equals("admin") && user.getUserPwd().equals("1234")) {
            MovieView.getView().adminMenu();
            return;
        }

        // 일반고객 모드..
        MovieView.getView().customerMenu();
    }

    public void signUp(String userId, String userPwd) {
        System.out.println("회원가입 기능");
    }

    public void insertMovieInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========== 영화 추가 모드 입니다. ==========");

        MovieDto movieDto = new MovieDto();

        // 정보를 전부 다 받자..
        System.out.println("영화의 제목을 입력 해주세요.");
        movieDto.setTitle(sc.nextLine());

        System.out.println("영화의 개봉일을 입력 해주세요. (yyyy-MM-dd)");
        // 입력된 문자열을 LocalDate로 변환
        LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        movieDto.setReleaseDate(date);

        System.out.println("영화의 상영시간을 숫자로 입력 해주세요.");
        movieDto.setDuration(Integer.parseInt(sc.nextLine()));

        System.out.println("영화의 설명을 입력 해주세요.");
        movieDto.setDescription(sc.nextLine());

        System.out.println("영화의 상영 등급을 입력 해주세요. (나이제한)");
        movieDto.setRating(sc.nextLine());

        System.out.println("영화의 장르를 입력 해주세요.");
        movieDto.setGenre(sc.nextLine());

        System.out.println("영화의 감독을 입력 해주세요.");
        movieDto.setDirector(sc.nextLine());

        MovieService.getService().insertMovieInfo(movieDto);


    }

    public void UserList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========== 회원 정보 조회 입니다. ==========");

        MovieDto movieDto = new MovieDto();

        // 정보를 전부 다 받자..
        System.out.println("영화의 제목을 입력 해주세요.");
        movieDto.setTitle(sc.nextLine());

        System.out.println("영화의 개봉일을 입력 해주세요. (yyyy-MM-dd)");
        // 입력된 문자열을 LocalDate로 변환
        LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        movieDto.setReleaseDate(date);

        System.out.println("영화의 상영시간을 숫자로 입력 해주세요.");
        movieDto.setDuration(Integer.parseInt(sc.nextLine()));

        System.out.println("영화의 설명을 입력 해주세요.");
        movieDto.setDescription(sc.nextLine());

        System.out.println("영화의 상영 등급을 입력 해주세요. (나이제한)");
        movieDto.setRating(sc.nextLine());

        System.out.println("영화의 장르를 입력 해주세요.");
        movieDto.setGenre(sc.nextLine());

        System.out.println("영화의 감독을 입력 해주세요.");
        movieDto.setDirector(sc.nextLine());

        MovieService.getService().insertMovieInfo(movieDto);


    }

    public UserDto getUserData(String userId) {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "SELECT * FROM user WHERE user_id = ?";

        UserDto user = new UserDto();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setString(1, userId);

            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("user_id"));
                System.out.println(resultSet.getString("user_email"));
                System.out.println(resultSet.getString("user_pwd"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;

    }
}