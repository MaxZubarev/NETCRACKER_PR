package Services;

import entity.Pokypka;

import java.util.List;

public interface IpokypkaService {
    void insert(Pokypka pokypka);
    void  delete(Pokypka pokypka);
    void  update (Pokypka pokypka );

    Pokypka  getById (int id);
    List<Pokypka> showAll();
}
