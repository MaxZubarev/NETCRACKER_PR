package Services;

import DAOsloi.PokypkaDao;
import entity.Pokypka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PokypkaService implements  IpokypkaService {
    @Autowired
    public PokypkaDao ImPokypkaDao;
    @Override
    public void insert(Pokypka pokypka) {ImPokypkaDao.insert(pokypka);

    }

    @Override
    public void delete(Pokypka pokypka) {ImPokypkaDao.delete(pokypka);

    }

    @Override
    public void update(Pokypka pokypka) {ImPokypkaDao.update(pokypka);

    }

    @Override
    public Pokypka getById(int id) {
        return ImPokypkaDao.getById(id);
    }

    @Override
    public List<Pokypka> showAll() {
        return ImPokypkaDao.showAll();
    }
}
