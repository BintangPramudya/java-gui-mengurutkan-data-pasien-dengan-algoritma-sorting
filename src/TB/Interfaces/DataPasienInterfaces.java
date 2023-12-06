package TB.Interfaces;

import TB.Entitty.Pasien;
import java.sql.SQLException;
import java.util.List;

public interface DataPasienInterfaces {

   Pasien insert(Pasien dm) throws SQLException;

    void update(Pasien dm) throws SQLException;

    void delete(int id) throws SQLException;

    List<Pasien> getAll() throws SQLException;
}
