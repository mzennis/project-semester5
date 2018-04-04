package id.mzennis.myapplication.note;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meta on 30/03/18.
 */

public class NoteManager {

    private SharedPreferences mPref;
    private SharedPreferences.Editor editor;

    public NoteManager(Context mContext) {
        mPref = mContext.getSharedPreferences(this.getClass().getPackage().getName(), Context.MODE_PRIVATE);
    }

    public void saveNote(Note note){
        editor = mPref.edit();
        Gson gson = new Gson();

        List<Note> notes = new ArrayList<>();
        if (getNotes() != null)
            notes = getNotes();
        notes.add(note);

        String json = gson.toJson(notes, new TypeToken<List<Note>>(){}.getType());
        editor.putString("note", json);
        editor.apply();
    }

    public List<Note> getNotes(){
        Gson gson = new Gson();
        String json = mPref.getString("note", "");
        if (json.isEmpty()) {
            return new ArrayList<>();
        }
        return gson.fromJson(json, new TypeToken<List<Note>>(){}.getType());
    }

}
