package DAOsloi;

import entity.Zakaz;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImZakazDao implements ZakazDao {


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Zakaz> rowMapper = new RowMapper<Zakaz>() {
        @Override
        public Zakaz mapRow(ResultSet rs, int rowNum) throws SQLException {
            Zakaz zakaz = new Zakaz();
            zakaz.setZak_status(rs.getString("zak_status"));
            zakaz.setAv_zak_id(rs.getInt("av_zak_id"));
            return zakaz;
        }
    };

    @Override
    public void insert(Zakaz zakaz ) {
        String sql = "INSERT INTO zakaz(zak_status) VALUES(?)";
        jdbcTemplate.update(sql, getPreparedStatementSetter(zakaz));
    }

    @Override
    public void delete(Zakaz zakaz) {
        jdbcTemplate.update("DELETE FROM zakaz WHERE av_id=?", zakaz.getAv_zak_id());

    }

    @Override
    public void update(Zakaz zakaz) {
        String sql = "UPDATE zakaz SET zak_status=? WHERE av_zak_id=?";
        jdbcTemplate.update(sql, getPreparedStatementSetter(zakaz));

    }

    @Override
    public Zakaz getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM zakaz WHERE av_zak_id=?", rowMapper, id);
    }

    @Override
    public List<Zakaz> showAll() {
        return jdbcTemplate.query("SELECT * FROM zakaz", rowMapper);
    }

    private PreparedStatementSetter getPreparedStatementSetter(final Zakaz zakaz) {
        return ps -> {
            int i = 0;
            ps.setString(++i, zakaz.getZak_status());
            ps.setInt(++i, zakaz.getAv_zak_id());
    };
}
}