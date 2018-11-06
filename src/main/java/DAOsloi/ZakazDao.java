package DAOsloi;

import entity.Zakaz;

import java.util.List;

public interface ZakazDao {


    void insert(Zakaz zakaz);
    void  delete(Zakaz zakaz);
    void  update (Zakaz zakaz);

    Zakaz  getById (int id);
    List<Zakaz> showAll();
}


