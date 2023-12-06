package TB.Implement;

import KoneksiDB.KoneksiDB;
import TB.Entitty.Pasien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import TB.Interfaces.DataPasienInterfaces;

public class DataPasienImplement implements DataPasienInterfaces {

    @Override
    public Pasien insert(Pasien dm) throws SQLException {
        try {
            PreparedStatement st = KoneksiDB.getConnection().prepareStatement("insert into tb_inf values(?, ?, ?, ?, ?, ?)");
            st.setInt(1, 0);
            st.setString(2, dm.getKodepasien());
            st.setString(3, dm.getNama());
            st.setString(4, dm.getJenkel());
            st.setString(5, dm.getAlamat());
            st.setString(6, dm.getPenyakit());
            st.executeUpdate();
            KoneksiDB.conn.close();

            System.out.println("insert data mahasiswa");

        } catch (SQLException ex) {
            Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }

    @Override
    public void update(Pasien p) throws SQLException {
        PreparedStatement st = KoneksiDB.getConnection().prepareStatement("update tb_inf set kode_pasien=?, nama=?, jen_kel=?, alamat=?, penyakit=? where id=?");
        st.setString(1, p.getKodepasien());
        st.setString(2, p.getNama());
        st.setString(3, p.getJenkel());
        st.setString(4, p.getAlamat());
        st.setString(5, p.getPenyakit());
        st.setInt(6, p.getId());
        st.executeUpdate();
        KoneksiDB.conn.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            PreparedStatement st = KoneksiDB.getConnection().prepareStatement("delete from tb_inf where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            KoneksiDB.conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Pasien> getAll() throws SQLException {
        List<Pasien> list = new ArrayList<>();
        try {
            Statement ss = KoneksiDB.getConnection().createStatement();
            ResultSet st = ss.executeQuery("select * from tb_inf order by id");

            while (st.next()) {
                Pasien p = new Pasien();
                p.setId(st.getInt("id"));
                p.setKodepasien(st.getString("kode_pasien"));
                p.setNama(st.getString("nama"));
                p.setJenkel(st.getString("jen_kel"));
                p.setAlamat(st.getString("alamat"));
                p.setPenyakit(st.getString("penyakit"));

                list.add(p);
            }
            KoneksiDB.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataPasienImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
