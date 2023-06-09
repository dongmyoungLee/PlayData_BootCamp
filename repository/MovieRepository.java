package repository;

import config.JdbcConnection;
import domain.dto.MovieDto;
import domain.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRepository {
    private static MovieRepository repository;
    public static MovieRepository getRepository() {
        if(repository == null) repository = new MovieRepository();
        return repository;
    }

    public UserDto login(String userId, String userPwd) {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "select * from user where user_id = ? and user_pwd = ?";

        UserDto user = new UserDto();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setString(1, userId);
            psmt.setString(2, userPwd);

            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()) {
                user.setUserId(resultSet.getString("user_id"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserPwd(resultSet.getString("user_pwd"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public int signUp(UserDto dto){
        Connection conn = new JdbcConnection().getJdbc();

        int result = 0;

        String sql = "insert into User (user_id, user_email, user_pwd)\n" +
                "value (?, ?, ?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getUserId());
            psmt.setString(2, dto.getUserEmail());
            psmt.setString(3, dto.getUserPwd());
            if(psmt.executeUpdate() == 0){
                result = 1;
            } else {
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    public int insertMovieInfo(MovieDto movieDto) {

        System.out.println(movieDto);


        return 0;
    }

}
