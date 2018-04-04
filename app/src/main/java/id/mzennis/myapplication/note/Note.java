package id.mzennis.myapplication.note;

/**
 * Created by meta on 30/03/18.
 */

public class Note {
    private int id;
    private String title;
    private String note;

    public Note(int id, String title, String note) {
        this.id = id;
        this.title = title;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }
}
