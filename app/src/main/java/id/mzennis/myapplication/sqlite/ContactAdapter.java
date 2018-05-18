package id.mzennis.myapplication.sqlite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.mzennis.myapplication.R;

/**
 * Created by meta on 18/05/18.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private List<Contact> contactList;

    public ContactAdapter() {
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sqlite, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.nim.setText(contact.getNim());
        holder.nama.setText(contact.getNama());
        holder.alamat.setText(contact.getAlamat());
        holder.telp.setText(contact.getTelp());
        holder.email.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nim;
        public TextView nama;
        public TextView alamat;
        public TextView telp;
        public TextView email;

        public MyViewHolder(View view) {
            super(view);
            nim = view.findViewById(R.id.tv_nim);
            nama = view.findViewById(R.id.tv_nama);
            alamat = view.findViewById(R.id.tv_alamat);
            telp = view.findViewById(R.id.tv_telp);
            email = view.findViewById(R.id.tv_email);
        }
    }
}
