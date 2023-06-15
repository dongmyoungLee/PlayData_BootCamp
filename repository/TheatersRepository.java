package repository;

import config.JdbcConnection;
import domain.dto.ActorDto;
import domain.dto.MovieDto;
import domain.dto.TheatersDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheatersRepository {
    private static TheatersRepository repository;
    public static TheatersRepository getRepository() {
        if(repository == null) repository = new TheatersRepository();
        return repository;
    }

    public List<TheatersDto> showTheaters (int movieNum){
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select name, location, capacity\n" +
                "from theaters\n" +
                "where movie_seq = ? ;";
        List<TheatersDto> theatersDtoList = new ArrayList<>();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, movieNum);
            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()) {

                String theartersName = resultSet.getString("name");
                String theartersLocation = resultSet.getString("location");
                int theartersCapacity = resultSet.getInt("capacity");

                TheatersDto theatersDto = new TheatersDto();

                theatersDto.setName(theartersName);
                theatersDto.setLocation(theartersLocation);
                theatersDto.setCapacity(theartersCapacity);

                theatersDtoList.add(theatersDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return theatersDtoList;
    }

}
