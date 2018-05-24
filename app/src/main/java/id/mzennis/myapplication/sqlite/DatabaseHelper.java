package id.mzennis.myapplication.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Contact.CREATE_TABLE);
        db.execSQL(PlatCode.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Contact.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PlatCode.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertBulkPlatCode(List<PlatCode> platCodes) {
        SQLiteDatabase db = this.getWritableDatabase();

        for (PlatCode item : platCodes) {

            ContentValues values = new ContentValues();

            values.put(PlatCode.COLUMN_KODE, item.getKode());
            values.put(PlatCode.COLUMN_DAERAH, item.getDaerah());
            values.put(PlatCode.COLUMN_PROVINSI, item.getProvinsi());

            // insert row
            long id = db.insert(PlatCode.TABLE_NAME, null, values);
        }

        // close db connection
        db.close();

        // return newly inserted row id
        return 1;
    }

    public long insertBulkContac(List<Contact> contacts) {
        SQLiteDatabase db = this.getWritableDatabase();

        for (Contact contact : contacts) {

            ContentValues values = new ContentValues();

            values.put(Contact.COLUMN_NIM, contact.getNim());
            values.put(Contact.COLUMN_NAMA, contact.getNama());
            values.put(Contact.COLUMN_ALAMAT, contact.getAlamat());
            values.put(Contact.COLUMN_TELP, contact.getTelp());
            values.put(Contact.COLUMN_EMAL, contact.getEmail());

            // insert row
            long id = db.insert(Contact.TABLE_NAME, null, values);
        }

        // close db connection
        db.close();

        // return newly inserted row id
        return 1;
    }

    public long insertContact(String nim, String nama, String alamat, String telp, String email) {
       SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Contact.COLUMN_NIM, nim);
        values.put(Contact.COLUMN_NAMA, nama);
        values.put(Contact.COLUMN_ALAMAT, alamat);
        values.put(Contact.COLUMN_TELP, telp);
        values.put(Contact.COLUMN_EMAL, email);

        // insert row
        long id = db.insert(Contact.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Contact getContact(String nim) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Contact.TABLE_NAME,
                new String[]{Contact.COLUMN_ID, Contact.COLUMN_NIM, Contact.COLUMN_NAMA,
                        Contact.COLUMN_ALAMAT, Contact.COLUMN_TELP, Contact.COLUMN_EMAL},
                Contact.COLUMN_NIM + "=?",
                new String[]{String.valueOf(nim)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Contact note = new Contact(
                cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NIM)),
                cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NAMA)),
                cursor.getString(cursor.getColumnIndex(Contact.COLUMN_ALAMAT)),
                cursor.getString(cursor.getColumnIndex(Contact.COLUMN_TELP)),
                cursor.getString(cursor.getColumnIndex(Contact.COLUMN_EMAL)));

        // close the db connection
        cursor.close();

        return note;
    }

    public List<PlatCode> getAllPlatCodes() {
        List<PlatCode> platCodes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + PlatCode.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PlatCode item = new PlatCode();
                item.setKode(cursor.getString(cursor.getColumnIndex(PlatCode.COLUMN_KODE)));
                item.setDaerah(cursor.getString(cursor.getColumnIndex(PlatCode.COLUMN_DAERAH)));
                item.setProvinsi(cursor.getString(cursor.getColumnIndex(PlatCode.COLUMN_PROVINSI)));

                platCodes.add(item);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return platCodes;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Contact.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_ID)));
                contact.setNim(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NIM)));
                contact.setNama(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NAMA)));
                contact.setAlamat(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_ALAMAT)));
                contact.setTelp(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_TELP)));
                contact.setEmail(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_EMAL)));

                contacts.add(contact);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return contacts;
    }

    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + Contact.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

//    public int updateContact(Contact note) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(Contact.COLUMN_NOTE, note.getContact());
//
//        // updating row
//        return db.update(Contact.TABLE_NAME, values, Contact.COLUMN_ID + " = ?",
//                new String[]{String.valueOf(note.getId())});
//    }
//
//    public void deleteContact(Contact note) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Contact.TABLE_NAME, Contact.COLUMN_ID + " = ?",
//                new String[]{String.valueOf(note.getId())});
//        db.close();
//    }
}
