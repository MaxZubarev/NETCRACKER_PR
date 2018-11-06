package Services;

import DAOsloi.ZakazDao;
import entity.Zakaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ZakazService implements IZakazService {

    @Autowired
    public ZakazDao ImZakazDao;


    @Override
    public void insert(Zakaz zakaz) {ImZakazDao.insert(zakaz);

    }

    @Override
    public void delete(Zakaz zakaz) {ImZakazDao.delete(zakaz);

    }

    @Override
    public void update(Zakaz zakaz) {ImZakazDao.update(zakaz);

    }

    @Override
    public Zakaz getById(int id) {
        return ImZakazDao.getById(id);
    }

    @Override
    public List<Zakaz> showAll() {
        return ImZakazDao.showAll();
    }
}
