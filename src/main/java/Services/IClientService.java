package Services;

import entity.Client;

import java.util.List;

public interface IClientService {
    void insert(Client client);
    void  delete(Client client);
    void  update (Client client);

    Client  getById (int id);
    List<Client> showAll();
}
