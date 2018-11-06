package Services;

import DAOsloi.ClientDao;
import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService implements IClientService {
    @Autowired
    public ClientDao ImClientDao;
    @Override
    public void insert(Client client) {ImClientDao.insert(client);

    }

    @Override
    public void delete(Client client) {ImClientDao.delete(client);

    }

    @Override
    public void update(Client client) {ImClientDao.update(client);

    }

    @Override
    public Client getById(int id) {
        return ImClientDao.getById(id);
    }

    @Override
    public List<Client> showAll() {
        return ImClientDao.showAll();
    }
}
