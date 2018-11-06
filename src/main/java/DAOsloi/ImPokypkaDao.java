package DAOsloi;

import entity.Auto;
import entity.Pokypka;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImPokypkaDao implements PokypkaDao{


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Pokypka> rowMapper = new RowMapper<Pokypka>() {
        @Override
        public Pokypka mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pokypka pokypka = new Pokypka();
            pokypka.setAv_id(rs.getInt("av_id"));
            pokypka.setPok_id(rs.getInt("pok_id"));
            pokypka.setAv_zak_id(rs.getInt("av_zak_id"));
            pokypka.setCl_id(rs.getInt("cl_id"));
            return pokypka;
        }
    };

    @Override
    public void insert(Pokypka pokypka) {
        String sql = "INSERT INTO pokypka(av_id, av_zak_id, cl_id) VALUES(?,?,?)";
        jdbcTemplate.update(sql, getPreparedStatementSetter(pokypka));
    }

    @Override
    public void delete(Pokypka pokypka) {
        jdbcTemplate.update("DELETE FROM pokypka WHERE pok_id=?", pokypka.getPok_id());

    }

    @Override
    public void update(Pokypka pokypka) {
        String sql = "UPDATE pokypka SET av_id=?, av_zak_id=?, cl_id=? WHERE pok_id=?";
        jdbcTemplate.update(sql, getPreparedStatementSetter(pokypka));

    }

    @Override
    public Pokypka getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM pokypka WHERE pok_id=?", rowMapper, id);
    }

    @Override
    public List<Pokypka> showAll() {
        return jdbcTemplate.query("SELECT * FROM pokypka", rowMapper);
    }

    private PreparedStatementSetter getPreparedStatementSetter(final Pokypka auto) {
        return ps -> {
            int i = 0;
            ps.setInt(++i, auto.getAv_id());
            ps.setInt(++i, auto.getPok_id());
            ps.setInt(++i, auto.getAv_zak_id());
            ps.setInt(++i, auto.getCl_id());
        };
    }
}
