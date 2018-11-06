package DAOsloi;

import entity.Category;

import java.util.List;

public interface CategoryDao {
    void insert(Category category);
    void  delete(Category category);
    void  update (Category category);

    Category getById (int id);
    List<Category> showAll();
}
