package DAOsloi;

import entity.Auto;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImAutoDao implements AutoDao {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Auto> rowMapper = new RowMapper<Auto>() {
        @Override
        public Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Auto auto = new Auto();
            auto.setAv_id(rs.getInt("av_id"));
            auto.setAv_count(rs.getInt("av_count"));
            auto.setAv_price(rs.getInt("av_price"));
            auto.setAv_power(rs.getInt("av_power"));
            auto.setCat_id(rs.getInt("cat_id"));
            return auto;
        }
    };

    @Override
    public void insert(Auto auto) {
        String sql = "INSERT INTO auto(av_count, av_price, av_power, cat_id) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, getPreparedStatementSetter(auto));
    }

    @Override
    public void delete(Auto auto) {
        jdbcTemplate.update("DELETE FROM auto WHERE av_id=?", auto.getAv_id());

    }

    @Override
    public void update(Auto auto) {
        String sql = "UPDATE auto SET av_power=?, av_count=?, av_price=?, av_count=? WHERE av_id=?";
        jdbcTemplate.update(sql, getPreparedStatementSetter(auto));

    }

    @Override
    public Auto getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM auto WHERE av_id=?", rowMapper, id);
    }

    @Override
    public List<Auto> showAll() {
        return jdbcTemplate.query("SELECT * FROM auto", rowMapper);
    }

    private PreparedStatementSetter getPreparedStatementSetter(final Auto auto) {
        return ps -> {
            int i = 0;
            ps.setInt(++i, auto.getAv_id());
            ps.setInt(++i, auto.getAv_count());
            ps.setInt(++i, auto.getAv_price());
            ps.setInt(++i, auto.getAv_power());
            ps.setInt(++i, auto.getCat_id());
        };
    }


}

