package DAOsloi;

import entity.Client;
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
public class ImClientDao implements ClientDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Client> rowMapper = new RowMapper<Client>() {
        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            Client client = new Client();
            client.setCl_id(rs.getInt("cl_id"));
            client.setCl_nick(rs.getString("cl_nick"));
            client.setCl_pass(rs.getString("cl_pass"));
            return client;
        }
    };

    @Override
    public void insert(Client client) {
        String sql = "INSERT INTO client(cl_nick, cl_pass) VALUES()";
        jdbcTemplate.update(sql, getPreparedStatementSetter(client));
    }

    @Override
    public void delete(Client client) {
        jdbcTemplate.update("DELETE FROM client WHERE cl_id=?", client.getCl_id());

    }

    @Override
    public void update(Client client) {
        String sql = "UPDATE client SET cl_nick=?, cl_pass=? WHERE cl_id=?";
        jdbcTemplate.update(sql, getPreparedStatementSetter(client));

    }

    @Override
    public Client getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM client WHERE cl_id=?", rowMapper, id);
    }

    @Override
    public List<Client> showAll() {
        return jdbcTemplate.query("SELECT * FROM client", rowMapper);
    }

    private PreparedStatementSetter getPreparedStatementSetter(final Client client) {
        return ps -> {
            int i = 0;
            ps.setInt(++i, client.getCl_id());
            ps.setString(++i, client.getCl_nick());
            ps.setString(++i, client.getCl_pass());
        };
    }
}
