package Services;

import DAOsloi.AutoDao;
import entity.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutoService implements IAutoService {


    @Autowired
    public AutoDao ImAutoDao;


    @Override
    public void insert(Auto auto) {ImAutoDao.insert(auto);

    }

    @Override
    public void delete(Auto auto) {ImAutoDao.delete(auto);

    }

    @Override
    public void update(Auto auto) {ImAutoDao.update(auto);

    }

    @Override
    public Auto getById(int id) {
        return ImAutoDao.getById(id);
    }

    @Override
    public List<Auto> showAll() {
        return ImAutoDao.showAll();
    }
}
