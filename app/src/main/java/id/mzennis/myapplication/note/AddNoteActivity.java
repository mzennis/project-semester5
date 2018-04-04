package id.mzennis.myapplication.note;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.mzennis.myapplication.R;

/**
 * Created by meta on 30/03/18.
 */

public class AddNoteActivity extends AppCompatActivity {

    NoteManager manager;
    int count;

    public static void startActivity(Context context, int count) {
        Intent intent = new Intent(context, AddNoteActivity.class);
        intent.putExtra(AddNoteActivity.class.getSimpleName(), count);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        setTitle("Tambah Catatan");

        count = getIntent().getIntExtra(AddNoteActivity.class.getSimpleName(), 0);

        final EditText etTitle = findViewById(R.id.et_title);
        final EditText etDesc = findViewById(R.id.et_desc);
        Button btnAdd = findViewById(R.id.btn_add_note);

        manager = new NoteManager(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String desc = etDesc.getText().toString();

                if (title.isEmpty() || desc.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, "Isi dulu woy", Toast.LENGTH_SHORT).show();
                    return;
                }

                manager.saveNote(new Note(count, title, desc));
                Toast.makeText(AddNoteActivity.this, "Yey berhasil", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
