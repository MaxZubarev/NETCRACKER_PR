package DAOsloi;

import entity.Auto;

import java.util.List;

public interface AutoDao {

    void insert(Auto auto);
    void  delete(Auto auto);
    void  update (Auto auto);

    Auto getById (int id);
    List<Auto> showAll();

}
