package Services;

import DAOsloi.AutoDao;
import DAOsloi.CategoryDao;
import entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    public CategoryDao ImCategoryDao;

    @Override
    public void insert(Category category) {ImCategoryDao.insert(category);

    }

    @Override
    public void delete(Category category) {ImCategoryDao.delete(category);

    }

    @Override
    public void update(Category category) {ImCategoryDao.update(category);

    }

    @Override
    public Category getById(int id) {
        return ImCategoryDao.getById(id);
    }

    @Override
    public List<Category> showAll() {
        return ImCategoryDao.showAll();
    }
}
