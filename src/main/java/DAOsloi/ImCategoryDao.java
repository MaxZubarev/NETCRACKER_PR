package DAOsloi;

import entity.Category;
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

public class ImCategoryDao implements CategoryDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Category> rowMapper = new RowMapper<Category>() {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setCat_id(rs.getInt("cat_id"));
            category.setCategory(rs.getString("category"));
            return category;
        }
    };

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO category(category) VALUES(?)";
        jdbcTemplate.update(sql, getPreparedStatementSetter(category));
    }

    @Override
    public void delete(Category category ) {
        jdbcTemplate.update("DELETE FROM category WHERE cat_id=?", category.getCat_id());

    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE category SET category=? WHERE cat_id=?";
        jdbcTemplate.update(sql, getPreparedStatementSetter(category));

    }

    @Override
    public Category getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM category WHERE cat_id=?", rowMapper, id);
    }

    @Override
    public List<Category> showAll() {
        return jdbcTemplate.query("SELECT * FROM category", rowMapper);
    }

    private PreparedStatementSetter getPreparedStatementSetter(final Category category ) {
        return ps -> {
            int i = 0;
            ps.setInt(++i, category.getCat_id());
            ps.setString(++i, category.getCategory());
        };
    }

}
