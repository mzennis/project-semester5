package id.mzennis.myapplication.sqlite;

/**
 * Created by meta on 18/05/18.
 */
public class Contact {

    public static final String TABLE_NAME = "contact";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NIM = "nim";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_ALAMAT = "alamat";
    public static final String COLUMN_TELP = "telp";
    public static final String COLUMN_EMAL = "email";

    private int id;
    private String nim;
    private String nama;
    private String alamat;
    private String telp;
    private String email;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NIM + " TEXT,"
                    + COLUMN_NAMA + " TEXT,"
                    + COLUMN_ALAMAT + " TEXT,"
                    + COLUMN_TELP + " TEXT,"
                    + COLUMN_EMAL + " TEXT"
                    + ")";

    public Contact() {
    }

    public Contact(String nim, String nama, String alamat, String telp, String email) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
