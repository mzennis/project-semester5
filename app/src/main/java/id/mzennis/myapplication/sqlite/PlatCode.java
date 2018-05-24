package id.mzennis.myapplication.sqlite;

/**
 * Created by meta on 24/05/18.
 */
public class PlatCode {

    private String kode;
    private String daerah;
    private String provinsi;

    public static final String TABLE_NAME = "platcode";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_KODE = "kode";
    public static final String COLUMN_DAERAH = "daerah";
    public static final String COLUMN_PROVINSI = "provinsi";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_KODE + " TEXT,"
                    + COLUMN_DAERAH + " TEXT,"
                    + COLUMN_PROVINSI + " TEXT"
                    + ")";

    public PlatCode() {
    }

    public PlatCode(String kode, String daerah, String provinsi) {
        this.kode = kode;
        this.daerah = daerah;
        this.provinsi = provinsi;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
}
