package id.mzennis.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.mzennis.myapplication.note.AddNoteActivity;
import id.mzennis.myapplication.note.Note;
import id.mzennis.myapplication.note.NoteManager;

/**
 * Created by meta on 30/03/18.
 */

public class NotesFragment extends Fragment {

    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        manager = new NoteManager(getActivity());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                AddNoteActivity.startActivity(getActivity(), count);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private int count = 0;
    private ListView listView;
    private NoteManager manager;
    private CustomAdapter adapter;
    private List<Note> notes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        listView = view.findViewById(R.id.listview);

        notes = new ArrayList<>();
        notes.addAll(manager.getNotes());

        count = notes.size();

        adapter = new CustomAdapter(notes, getContext());
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null && manager != null) {
            adapter.clear();
            adapter.addAll(manager.getNotes());
            adapter.notifyDataSetChanged();
        }

        if (notes != null)
            count = notes.size();
    }

    public class CustomAdapter extends ArrayAdapter<Note> {

        private class ViewHolder {
            TextView tvTitle, tvDesc;
        }

        public CustomAdapter(List<Note> data, Context context) {
            super(context, R.layout.item_note, data);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            Note dataModel = getItem(position);
            ViewHolder viewHolder;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.item_note, parent, false);
                viewHolder.tvTitle = convertView.findViewById(R.id.tv_title);
                viewHolder.tvDesc = convertView.findViewById(R.id.tv_desc);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            if (dataModel != null) {
                viewHolder.tvTitle.setText(dataModel.getTitle());
                viewHolder.tvDesc.setText(dataModel.getNote());

                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Muncul pop up", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            return convertView;
        }
    }
}
