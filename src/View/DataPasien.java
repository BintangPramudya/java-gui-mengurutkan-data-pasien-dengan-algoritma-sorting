package View;

import TB.Entitty.Pasien;
import TB.Implement.DataPasienImplement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import TB.Interfaces.DataPasienInterfaces;

public class DataPasien extends javax.swing.JFrame {

    Pasien p = new Pasien();
    List<Pasien> record = new ArrayList<>();

    DataPasienInterfaces dbServices;
    int row;
    static int id;
    private Pasien[] ps;
    private int nElemen;

    // UrutBerdasarkanNim
    void bubbleSortByKodepasienAscending() {
        // Ambil data dari tabel dan simpan ke dalam array mhs[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan NIM
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                if (Integer.parseInt(ps[j].getKodepasien()) > Integer.parseInt(ps[j + 1].getKodepasien())) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void bubbleSortByKodepasienDescending() {
        // Ambil data dari tabel dan simpan ke dalam array mhs[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan NIM
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                if (Integer.parseInt(ps[j].getKodepasien()) < Integer.parseInt(ps[j + 1].getKodepasien())) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void bubbleSortByNameAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan nama secara ascending
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                if (ps[j].getNama().compareToIgnoreCase(ps[j + 1].getNama()) > 0) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void bubbleSortByNameDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan nama secara descending
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                if (ps[j].getNama().compareToIgnoreCase(ps[j + 1].getNama()) < 0) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    // Bubble Sort by Jenis Kelamin Ascending
    void bubbleSortByJenisKelaminAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan Jenis Kelamin secara ascending
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                // Bandingkan Jenis Kelamin pada posisi j dan j+1
                if (ps[j].getJenkel().compareTo(ps[j + 1].getJenkel()) > 0) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

// Bubble Sort by Jenis Kelamin Descending
    void bubbleSortByJenisKelaminDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan Jenis Kelamin secara descending
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                // Bandingkan Jenis Kelamin pada posisi j dan j+1
                if (ps[j].getJenkel().compareTo(ps[j + 1].getJenkel()) < 0) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void bubbleSortByAddressAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan alamat secara ascending
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                if (ps[j].getAlamat().compareToIgnoreCase(ps[j + 1].getAlamat()) > 0) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void bubbleSortByAddressDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan alamat secara descending
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                if (ps[j].getAlamat().compareToIgnoreCase(ps[j + 1].getAlamat()) < 0) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void bubbleSortByPenyakitAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan penyakit secara ascending
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                if (ps[j].getPenyakit().compareToIgnoreCase(ps[j + 1].getPenyakit()) > 0) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void bubbleSortByPenyakitDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Bubble Sort untuk mengurutkan data berdasarkan penyakit secara descending
        for (int i = 0; i < nElemen - 1; i++) {
            for (int j = 0; j < nElemen - i - 1; j++) {
                if (ps[j].getPenyakit().compareToIgnoreCase(ps[j + 1].getPenyakit()) < 0) {
                    swap(j, j + 1);
                }
            }
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }
//-------------------------------------------------------------------------------------------------------------

    void selectionSortByKodepasienAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan kode pasien secara ascending
        for (int i = 0; i < nElemen - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (Integer.parseInt(ps[j].getKodepasien()) < Integer.parseInt(ps[minIdx].getKodepasien())) {
                    minIdx = j;
                }
            }
            swap(i, minIdx);
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void selectionSortByKodepasienDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan kode pasien secara descending
        for (int i = 0; i < nElemen - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (Integer.parseInt(ps[j].getKodepasien()) > Integer.parseInt(ps[maxIdx].getKodepasien())) {
                    maxIdx = j;
                }
            }
            swap(i, maxIdx);
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    // Urut berdasrakan nama
    void selectionSortByNameAscending() {
        // Ambil data dari tabel dan simpan ke dalam array mhs[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan nama
        for (int i = 0; i < nElemen - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (ps[j].getNama().compareToIgnoreCase(ps[minIdx].getNama()) < 0) {
                    minIdx = j;
                }
            }
            // Swap elemen terkecil dengan elemen ke-i
            Pasien temp = ps[minIdx];
            ps[minIdx] = ps[i];
            ps[i] = temp;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void selectionSortByNameDescending() {
        // Ambil data dari tabel dan simpan ke dalam array mhs[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan nama
        for (int i = 0; i < nElemen - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (ps[j].getNama().compareToIgnoreCase(ps[minIdx].getNama()) > 0) {
                    minIdx = j;
                }
            }
            // Swap elemen terkecil dengan elemen ke-i
            Pasien temp = ps[minIdx];
            ps[minIdx] = ps[i];
            ps[i] = temp;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void selectionSortByGenderAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan jenis kelamin secara ascending
        for (int i = 0; i < nElemen - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (ps[j].getJenkel().compareToIgnoreCase(ps[minIdx].getJenkel()) < 0) {
                    minIdx = j;
                }
            }
            swap(i, minIdx);
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void selectionSortByGenderDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan jenis kelamin secara descending
        for (int i = 0; i < nElemen - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (ps[j].getJenkel().compareToIgnoreCase(ps[maxIdx].getJenkel()) > 0) {
                    maxIdx = j;
                }
            }
            swap(i, maxIdx);
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void selectionSortByAddressAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan alamat secara ascending
        for (int i = 0; i < nElemen - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (ps[j].getAlamat().compareToIgnoreCase(ps[minIdx].getAlamat()) < 0) {
                    minIdx = j;
                }
            }
            swap(i, minIdx);
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void selectionSortByAddressDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan alamat secara descending
        for (int i = 0; i < nElemen - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (ps[j].getAlamat().compareToIgnoreCase(ps[maxIdx].getAlamat()) > 0) {
                    maxIdx = j;
                }
            }
            swap(i, maxIdx);
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void selectionSortByPenyakitAscending() { 
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan penyakit secara ascending
        for (int i = 0; i < nElemen - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (ps[j].getPenyakit().compareToIgnoreCase(ps[minIdx].getPenyakit()) < 0) {
                    minIdx = j;
                }
            }
            swap(i, minIdx);
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void selectionSortByPenyakitDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Selection Sort untuk mengurutkan data berdasarkan penyakit secara descending
        for (int i = 0; i < nElemen - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < nElemen; j++) {
                if (ps[j].getPenyakit().compareToIgnoreCase(ps[maxIdx].getPenyakit()) > 0) {
                    maxIdx = j;
                }
            }
            swap(i, maxIdx);
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }
//---------------------------------------------------------------------------------------------------------------------------------//

    void insertionSortByKodepasienAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan kode pasien secara ascending
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            while (j >= 0 && Integer.parseInt(ps[j].getKodepasien()) > Integer.parseInt(key.getKodepasien())) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void insertionSortByKodepasienDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan kode pasien secara descending
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            while (j >= 0 && Integer.parseInt(ps[j].getKodepasien()) < Integer.parseInt(key.getKodepasien())) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void insertionSortByNameAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan nama secara ascending
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            while (j >= 0 && ps[j].getNama().compareToIgnoreCase(key.getNama()) > 0) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void insertionSortByNameDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan nama secara descending
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            while (j >= 0 && ps[j].getNama().compareToIgnoreCase(key.getNama()) < 0) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void insertionSortByGenderAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan jenis kelamin secara ascending
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            while (j >= 0 && ps[j].getJenkel().compareToIgnoreCase(key.getJenkel()) > 0) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void insertionSortByGenderDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan jenis kelamin secara descending
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            while (j >= 0 && ps[j].getJenkel().compareToIgnoreCase(key.getJenkel()) < 0) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    // Urutberdasarkanalamat
    void insertionSortByAlamatAscending() {
        // Ambil data dari tabel dan simpan ke dalam array mhs[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan alamat
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            // Pindahkan elemen dari mhs[0..i-1] yang lebih besar dari key ke posisi satu langkah di depan posisi mereka saat ini
            while (j >= 0 && ps[j].getAlamat().compareToIgnoreCase(key.getAlamat()) > 0) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void insertionSortByAlamatDescending() {
        // Ambil data dari tabel dan simpan ke dalam array mhs[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan alamat
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            // Pindahkan elemen dari mhs[0..i-1] yang lebih besar dari key ke posisi satu langkah di depan posisi mereka saat ini
            while (j >= 0 && ps[j].getAlamat().compareToIgnoreCase(key.getAlamat()) < 0) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void insertionSortByPenyakitAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan penyakit secara ascending
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            while (j >= 0 && ps[j].getPenyakit().compareToIgnoreCase(key.getPenyakit()) > 0) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void insertionSortByPenyakitDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Implementasi Insertion Sort untuk mengurutkan data berdasarkan penyakit secara descending
        for (int i = 1; i < nElemen; ++i) {
            Pasien key = ps[i];
            int j = i - 1;

            while (j >= 0 && ps[j].getPenyakit().compareToIgnoreCase(key.getPenyakit()) < 0) {
                ps[j + 1] = ps[j];
                j = j - 1;
            }
            ps[j + 1] = key;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }
//===========================================================================================================//

    void shellSortByKodepasienAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && Integer.parseInt(ps[inner - jarak].getKodepasien()) > Integer.parseInt(temp.getKodepasien())) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByKodepasienDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && Integer.parseInt(ps[inner - jarak].getKodepasien()) < Integer.parseInt(temp.getKodepasien())) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByNameAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && ps[inner - jarak].getNama().compareToIgnoreCase(temp.getNama()) > 0) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByNameDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && ps[inner - jarak].getNama().compareToIgnoreCase(temp.getNama()) < 0) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByJenkelAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && ps[inner - jarak].getJenkel().compareToIgnoreCase(temp.getJenkel()) > 0) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByJenkelDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && ps[inner - jarak].getJenkel().compareToIgnoreCase(temp.getJenkel()) < 0) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByAlamatAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && ps[inner - jarak].getAlamat().compareToIgnoreCase(temp.getAlamat()) > 0) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByAlamatDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && ps[inner - jarak].getAlamat().compareToIgnoreCase(temp.getAlamat()) < 0) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByPenyakitAscending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && ps[inner - jarak].getPenyakit().compareToIgnoreCase(temp.getPenyakit()) > 0) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }

    void shellSortByPenyakitDescending() {
        // Ambil data dari tabel dan simpan ke dalam array ps[] sebelum sorting
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ps = record.toArray(new Pasien[0]);
        nElemen = ps.length;

        // Hitung jarak awal
        int jarak = nElemen / 2;

        while (jarak > 0) {
            for (int outer = jarak; outer < nElemen; outer++) {
                Pasien temp = ps[outer];
                int inner = outer;

                // Lakukan insertion sort pada sub-array dengan jarak tertentu
                while (inner >= jarak && ps[inner - jarak].getPenyakit().compareToIgnoreCase(temp.getPenyakit()) < 0) {
                    ps[inner] = ps[inner - jarak];
                    inner -= jarak;
                }
                ps[inner] = temp;
            }
            // Kurangi jarak untuk iterasi selanjutnya
            jarak /= 2;
        }

        // Simpan kembali data yang sudah diurutkan ke dalam record
        record = Arrays.asList(ps);

        // Menampilkan data yang sudah diurutkan ke dalam tabel
        isiTabel();
    }
//--------------------------------------------------------------------------------------------------------------------------------------//

    void quickSortByKodePasienAscending(int low, int high) {
        if (low < high) {
            int pi = partitionAscending(low, high);

            quickSortByKodePasienAscending(low, pi - 1);
            quickSortByKodePasienAscending(pi + 1, high);
        }
    }

    void quickSortByKodePasienDescending(int low, int high) {
        if (low < high) {
            int pi = partitionDescending(low, high);

            quickSortByKodePasienDescending(low, pi - 1);
            quickSortByKodePasienDescending(pi + 1, high);
        }
    }

    int partitionAscending(int low, int high) {
        String pivot = ps[high].getKodepasien();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (Integer.parseInt(ps[j].getKodepasien()) < Integer.parseInt(pivot)) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    int partitionDescending(int low, int high) {
        String pivot = ps[high].getKodepasien();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (Integer.parseInt(ps[j].getKodepasien()) > Integer.parseInt(pivot)) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    void quickSortByNamaAscending(int low, int high) {
        if (low < high) {
            int pi = partitionNamaAscending(low, high);

            quickSortByNamaAscending(low, pi - 1);
            quickSortByNamaAscending(pi + 1, high);
        }
    }

    void quickSortByNamaDescending(int low, int high) {
        if (low < high) {
            int pi = partitionNamaDescending(low, high);

            quickSortByNamaDescending(low, pi - 1);
            quickSortByNamaDescending(pi + 1, high);
        }
    }

    int partitionNamaAscending(int low, int high) {
        String pivot = ps[high].getNama();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ps[j].getNama().compareToIgnoreCase(pivot) < 0) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    int partitionNamaDescending(int low, int high) {
        String pivot = ps[high].getNama();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ps[j].getNama().compareToIgnoreCase(pivot) > 0) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    void quickSortByJenisKelaminAscending(int low, int high) {
        if (low < high) {
            int pi = partitionJenisKelaminAscending(low, high);

            quickSortByJenisKelaminAscending(low, pi - 1);
            quickSortByJenisKelaminAscending(pi + 1, high);
        }
    }

    void quickSortByJenisKelaminDescending(int low, int high) {
        if (low < high) {
            int pi = partitionJenisKelaminDescending(low, high);

            quickSortByJenisKelaminDescending(low, pi - 1);
            quickSortByJenisKelaminDescending(pi + 1, high);
        }
    }

    int partitionJenisKelaminAscending(int low, int high) {
        String pivot = ps[high].getJenkel();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ps[j].getJenkel().compareToIgnoreCase(pivot) < 0) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    int partitionJenisKelaminDescending(int low, int high) {
        String pivot = ps[high].getJenkel();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ps[j].getJenkel().compareToIgnoreCase(pivot) > 0) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    void quickSortByAlamatAscending(int low, int high) {
        if (low < high) {
            int pi = partitionAlamatAscending(low, high);

            quickSortByAlamatAscending(low, pi - 1);
            quickSortByAlamatAscending(pi + 1, high);
        }
    }

    void quickSortByAlamatDescending(int low, int high) {
        if (low < high) {
            int pi = partitionAlamatDescending(low, high);

            quickSortByAlamatDescending(low, pi - 1);
            quickSortByAlamatDescending(pi + 1, high);
        }
    }

    int partitionAlamatAscending(int low, int high) {
        String pivot = ps[high].getAlamat();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ps[j].getAlamat().compareToIgnoreCase(pivot) < 0) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    int partitionAlamatDescending(int low, int high) {
        String pivot = ps[high].getAlamat();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ps[j].getAlamat().compareToIgnoreCase(pivot) > 0) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    void quickSortByPenyakitAscending(int low, int high) {
        if (low < high) {
            int pi = partitionPenyakitAscending(low, high);

            quickSortByPenyakitAscending(low, pi - 1);
            quickSortByPenyakitAscending(pi + 1, high);
        }
    }

    void quickSortByPenyakitDescending(int low, int high) {
        if (low < high) {
            int pi = partitionPenyakitDescending(low, high);

            quickSortByPenyakitDescending(low, pi - 1);
            quickSortByPenyakitDescending(pi + 1, high);
        }
    }

    int partitionPenyakitAscending(int low, int high) {
        String pivot = ps[high].getPenyakit();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ps[j].getPenyakit().compareToIgnoreCase(pivot) < 0) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

    int partitionPenyakitDescending(int low, int high) {
        String pivot = ps[high].getPenyakit();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ps[j].getPenyakit().compareToIgnoreCase(pivot) > 0) {
                i++;

                Pasien temp = ps[i];
                ps[i] = ps[j];
                ps[j] = temp;
            }
        }

        Pasien temp = ps[i + 1];
        ps[i + 1] = ps[high];
        ps[high] = temp;

        return i + 1;
    }

//akhir sorting
    void swap(int one, int two) {
        Pasien temp = ps[one];
        ps[one] = ps[two];
        ps[two] = temp;
    }

    void load() {
        try {
            record = dbServices.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void isiTabel() {
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Object data[][] = new Object[record.size()][5];
        int i = 0;
        for (Pasien dm : record) {

            data[i][0] = dm.getKodepasien();
            data[i][1] = dm.getNama();
            data[i][2] = dm.getJenkel();
            data[i][3] = dm.getAlamat();
            data[i][4] = dm.getPenyakit();
            i++;
        }
        String judul[] = {"Kode Pasien", "Nama Lengkap", "Jenis Kelamin", "Alamat", "Penyakit"};
        jTable1.setModel(new DefaultTableModel(data, judul));
    }

    void initAwal() {
        load();

        isiTabel();
    }

    void bersihkan() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    void setUtilityEdit() {
        p.setKodepasien(jTextField1.getText());
        p.setNama(jTextField2.getText());
        p.setAlamat(jTextField3.getText());
        p.setPenyakit(jTextField4.getText());
        p.setJenkel(jComboBox3.getSelectedItem().toString());

    }

    public DataPasien() {
        initComponents();
        setTitle("Data Pasien");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        dbServices = new DataPasienImplement();
        initAwal();

        jTable1.getSelectionModel().
                addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        row = jTable1.getSelectedRow();
                        if (row != -1) {
                            Pasien p = record.get(row);
                            id = p.getId();
                            jTextField1.setText(p.getKodepasien());
                            jTextField2.setText(p.getNama());
                            jTextField3.setText(p.getAlamat());
                            jTextField4.setText(p.getPenyakit());
                            if (p.getJenkel().equalsIgnoreCase("Laki-Laki")) {
                                jComboBox3.setSelectedIndex(0);
                            } else {
                                jComboBox3.setSelectedIndex(1);
                            }
                        }

                    }
                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Data Pasien");

        jLabel2.setText("Kode Pasien");

        jLabel3.setText("Nama");

        jLabel4.setText("Jenis Kelamin");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Keluar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("Sort by");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Pasien", "Nama", "Jenis kelamin", "Alamat", "Penyakit" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton5.setText("Urutkan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - laki", "Perempuan" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Alamat");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Penyakit");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BubbleSort", "SelectionSort", "InsertionSort", "ShellSort", "QuickSort" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(61, 61, 61)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jLabel8))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int hapus = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus data ini ?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (hapus == JOptionPane.YES_OPTION) {
            int no = id;
            try {
                dbServices.delete(no);
            } catch (SQLException ex) {
                Logger.getLogger(DataPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
            initAwal();
            bersihkan();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        p.setKodepasien(jTextField1.getText());
        p.setNama(jTextField2.getText());
        p.setAlamat(jTextField3.getText());
        p.setPenyakit(jTextField4.getText());
        p.setJenkel(jComboBox3.getSelectedItem().toString());
        try {
            dbServices.insert(p);
            JOptionPane.showMessageDialog(null, "Data Tersimpan.");
            bersihkan();
            initAwal();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Cek Inputan Anda");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        p.setId(id);
        try {
            setUtilityEdit();
            try {
                dbServices.update(p);
                initAwal();
                bersihkan();
                JOptionPane.showMessageDialog(null, "Data Tersimpan !");
            } catch (SQLException ex) {
                Logger.getLogger(DataPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error !");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        // Aksi yang diambil saat pengguna memilih opsi dari JComboBox
        String selectedSort = (String) jComboBox1.getSelectedItem();
        if (selectedSort.equals("Kode Pasien")) {
            // Lakukan sesuatu jika BubbleSort dipilih
            // Misalnya, tampilkan pesan atau atur sesuatu terkait BubbleSort berdasarkan NIM
        } else if (selectedSort.equals("Nama")) {
            // Lakukan sesuatu jika SelectionSort dipilih
            // Misalnya, tampilkan pesan atau atur sesuatu terkait SelectionSort berdasarkan nama
        } else if (selectedSort.equals("Jenis kelamin")) {
            // Lakukan sesuatu jika SelectionSort dipilih
            // Misalnya, tampilkan pesan atau atur sesuatu terkait SelectionSort berdasarkan nama
        } else if (selectedSort.equals("Alamat")) {
            // Lakukan sesuatu jika InsertionSort dipilih
            // Misalnya, tampilkan pesan atau atur sesuatu terkait InsertionSort berdasarkan alamat
        } else if (selectedSort.equals("Penyakit")) {
            // Lakukan sesuatu jika quicksort dipilih
            // Misalnya, tampilkan pesan atau atur sesuatu terkait InsertionSort berdasarkan penyakit
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        // Aksi yang diambil saat pengguna memilih opsi dari JComboBox untuk ascending/descending
        String selectedOrder = (String) jComboBox2.getSelectedItem();
        if (selectedOrder.equals("Ascending")) {
            // Lakukan sesuatu jika pengguna memilih ascending
            // Misalnya, atur variabel atau tanda untuk menunjukkan ascending order dipilih
        } else if (selectedOrder.equals("Descending")) {
            // Lakukan sesuatu jika pengguna memilih descending
            // Misalnya, atur variabel atau tanda untuk menunjukkan descending order dipilih
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String selectedSort = (String) jComboBox1.getSelectedItem();
        String selectedOrder = (String) jComboBox2.getSelectedItem();

        if (selectedSort.equals("Kode Pasien")) {
            if (selectedOrder.equals("Ascending")) {
                bubbleSortByKodepasienAscending();
            } else if (selectedOrder.equals("Descending")) {
                bubbleSortByKodepasienDescending();
            }
        } else if (selectedSort.equals("Nama")) {
            if (selectedOrder.equals("Ascending")) {
                bubbleSortByNameAscending();
            } else if (selectedOrder.equals("Descending")) {
                bubbleSortByNameDescending();
            }
        } else if (selectedSort.equals("Jenis kelamin")) {
            if (selectedOrder.equals("Ascending")) {
                bubbleSortByJenisKelaminAscending();
            } else if (selectedOrder.equals("Descending")) {
                bubbleSortByJenisKelaminDescending();
            }
        } else if (selectedSort.equals("Alamat")) {
            if (selectedOrder.equals("Ascending")) {
                bubbleSortByAddressAscending();
            } else if (selectedOrder.equals("Descending")) {
                bubbleSortByAddressDescending();
            }
        } else if (selectedSort.equals("Penyakit")) {
            if (selectedOrder.equals("Ascending")) {
                bubbleSortByPenyakitAscending();
            } else if (selectedOrder.equals("Descending")) {
                bubbleSortByPenyakitDescending();
            }
        }
//------------------------------------------------------------------------------//        
        if (selectedSort.equals("Kode Pasien")) {
            if (selectedOrder.equals("Ascending")) {
                selectionSortByKodepasienAscending();
            } else if (selectedOrder.equals("Descending")) {
                selectionSortByKodepasienDescending();
            }
        } else if (selectedSort.equals("Nama")) {
            if (selectedOrder.equals("Ascending")) {
                selectionSortByNameAscending();
            } else if (selectedOrder.equals("Descending")) {
                selectionSortByNameDescending();
            }
        } else if (selectedSort.equals("Jenis kelamin")) {
            if (selectedOrder.equals("Ascending")) {
                selectionSortByGenderAscending();
            } else if (selectedOrder.equals("Descending")) {
                selectionSortByGenderDescending();
            }
        } else if (selectedSort.equals("Alamat")) {
            if (selectedOrder.equals("Ascending")) {
                selectionSortByAddressAscending();
            } else if (selectedOrder.equals("Descending")) {
                selectionSortByAddressDescending();
            }
        } else if (selectedSort.equals("Penyakit")) {
            if (selectedOrder.equals("Ascending")) {
                selectionSortByPenyakitAscending();
            } else if (selectedOrder.equals("Descending")) {
                selectionSortByPenyakitDescending();
            }
        }
//------------------------------------------------------------------------------// 
        if (selectedSort.equals("Kode Pasien")) {
            if (selectedOrder.equals("Ascending")) {
                insertionSortByKodepasienAscending();
            } else if (selectedOrder.equals("Descending")) {
                insertionSortByKodepasienDescending();
            }
        } else if (selectedSort.equals("Nama")) {
            if (selectedOrder.equals("Ascending")) {
                insertionSortByNameAscending();
            } else if (selectedOrder.equals("Descending")) {
                insertionSortByNameDescending();
            }
        } else if (selectedSort.equals("Jenis kelamin")) {
            if (selectedOrder.equals("Ascending")) {
                insertionSortByGenderAscending();
            } else if (selectedOrder.equals("Descending")) {
                insertionSortByGenderDescending();
            }
        } else if (selectedSort.equals("Alamat")) {
            if (selectedOrder.equals("Ascending")) {
                insertionSortByAlamatAscending();
            } else if (selectedOrder.equals("Descending")) {
                insertionSortByAlamatDescending();
            }
        } else if (selectedSort.equals("Penyakit")) {
            if (selectedOrder.equals("Ascending")) {
                insertionSortByPenyakitAscending();
            } else if (selectedOrder.equals("Descending")) {
                insertionSortByPenyakitDescending();
            }
        }
//-----------------------------------------------------------------------------//
        if (selectedSort.equals("Kode Pasien")) {
            if (selectedOrder.equals("Ascending")) {
                shellSortByKodepasienAscending();
            } else if (selectedOrder.equals("Descending")) {
                shellSortByKodepasienDescending();
            }
        } else if (selectedSort.equals("Nama")) {
            if (selectedOrder.equals("Ascending")) {
                shellSortByNameAscending();
            } else if (selectedOrder.equals("Descending")) {
                shellSortByNameDescending();
            }
        } else if (selectedSort.equals("Jenis kelamin")) {
            if (selectedOrder.equals("Ascending")) {
                shellSortByJenkelAscending();
            } else if (selectedOrder.equals("Descending")) {
                shellSortByJenkelDescending();
            }
        } else if (selectedSort.equals("Alamat")) {
            if (selectedOrder.equals("Ascending")) {
                shellSortByAlamatAscending();
            } else if (selectedOrder.equals("Descending")) {
                shellSortByAlamatDescending();
            }
        } else if (selectedSort.equals("Penyakit")) {
            if (selectedOrder.equals("Ascending")) {
                shellSortByPenyakitAscending();
            } else if (selectedOrder.equals("Descending")) {
                shellSortByPenyakitDescending();
            }
        }
//-----------------------------------------------------------------------------//
        if (selectedSort.equals("Kode Pasien")) {
            if (selectedOrder.equals("Ascending")) {
                quickSortByKodePasienAscending(0, record.size() - 1);
            } else if (selectedOrder.equals("Descending")) {
                quickSortByKodePasienDescending(0, record.size() - 1);
            }
        } else if (selectedSort.equals("Nama")) {
            if (selectedOrder.equals("Ascending")) {
                quickSortByNamaAscending(0, record.size() - 1);
            } else if (selectedOrder.equals("Descending")) {
                quickSortByNamaDescending(0, record.size() - 1);
            }
        } else if (selectedSort.equals("Jenis kelamin")) {
            if (selectedOrder.equals("Ascending")) {
                quickSortByJenisKelaminAscending(0, record.size() - 1);
            } else if (selectedOrder.equals("Descending")) {
                quickSortByJenisKelaminDescending(0, record.size() - 1);
            }
        } else if (selectedSort.equals("Alamat")) {
            if (selectedOrder.equals("Ascending")) {
                quickSortByAlamatAscending(0, record.size() - 1);
            } else if (selectedOrder.equals("Descending")) {
                quickSortByAlamatDescending(0, record.size() - 1);
            }
        } else if (selectedSort.equals("Penyakit")) {
            if (selectedOrder.equals("Ascending")) {
                quickSortByPenyakitAscending(0, record.size() - 1);
            } else if (selectedOrder.equals("Descending")) {
                quickSortByPenyakitDescending(0, record.size() - 1);
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        // Aksi yang diambil saat pengguna memilih opsi dari JComboBox
        // Mendapatkan pilihan dari JComboBox4 (method)
        String selectedMethod = (String) jComboBox4.getSelectedItem();

        // Implementasi untuk setiap pilihan metode di sini
        // Misalnya, panggil metode sesuai pilihan di sini
        if (selectedMethod.equals("BubbleSort")) {
            
        } else if (selectedMethod.equals("SelectionSort")) {
            // Panggil metode pengurutan berdasarkan pilihan lainnya
        } else if (selectedMethod.equals("InsertionSort")) {
            // Panggil metode pengurutan berdasarkan pilihan lainnya
        } else if (selectedMethod.equals("ShellSort")) {
            // Panggil metode pengurutan berdasarkan pilihan lainnya
        } else if (selectedMethod.equals("QuickSort")) {
            // Panggil metode pengurutan berdasarkan pilihan lainnya
        }

    }//GEN-LAST:event_jComboBox4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
