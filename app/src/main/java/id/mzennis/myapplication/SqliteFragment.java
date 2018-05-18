package id.mzennis.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.mzennis.myapplication.sqlite.Contact;
import id.mzennis.myapplication.sqlite.ContactAdapter;
import id.mzennis.myapplication.sqlite.DatabaseHelper;
import id.mzennis.myapplication.sqlite.MyDividerItemDecoration;

/**
 * Created by meta on 18/05/18.
 */
public class SqliteFragment extends Fragment {

    public static SqliteFragment newInstance() {
        return new SqliteFragment();
    }


    private ContactAdapter adapter;
    private RecyclerView recyclerview;
    private DatabaseHelper db;
    private List<Contact> contacts = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sqlite, container, false);

        recyclerview = view.findViewById(R.id.recycler_view);

        db = new DatabaseHelper(getActivity());

        adapter = new ContactAdapter();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.addItemDecoration(new MyDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL, 16));
        recyclerview.setAdapter(adapter);


        contacts = getContactList();
        if (contacts != null && !contacts.isEmpty()) {
            adapter.setContactList(contacts);
            adapter.notifyDataSetChanged();
        } else {
            addContacts();
        }

        return view;
    }

    private void addContacts() {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("41514120103", "Rizki Ade P", "Jl. Keadilan Raya No 65, Depok", "081316108193", "rizki_els13@live.com"));
        contactList.add(new Contact("41515110041", "Karmadenur", "Graha Raya Bintaro Blok HE 3 No 6  Tangerang", "0811133032", "karma.denur@gmail.com"));
        contactList.add(new Contact("41515110118", "Raihan M Akbar", "Cikeusal Lor RT/RW 002/001 Kec. Ketanggungan Kab, Brebes, Jawa Tengah", "081317905433", "raihanmakbar2@gmail.com"));
        contactList.add(new Contact("41515110119", "Arif Maulana", "Laladon Gede, Desa Laladon Kec. Ciomas Kabupaten Bogor", "085779985620", "bron.maulana@gmail.com"));
        contactList.add(new Contact("41515120050", "Ria Puspita Sari", "sentiaki baru 2 no18", "087886052270", "riaaa35@gmail.com"));
        contactList.add(new Contact("41515120052", "Okky Oktavianus", "Jln Raya Cikampak Perum Puri Arraya Blok BA no 27 kel Cicadas Kec. Ciampea Kab. Bogor", "081319363297", "okkyoktavianus2@gmail.com"));
        contactList.add(new Contact("41515120054", "Tatan Rustandi", "Lemahsugih, Majalengka, Jawa Barat", "085894890602", "tatanr45@gmail.com"));
        contactList.add(new Contact("41515120057", "Ihsan Nur Amin", "Villa Bintaro Indah, Blok A7 Jombang, Ciputat, Tangerang Selatan", "081213677804", "ihsannuramin03@gmail.com"));
        contactList.add(new Contact("41515120061", "Bayu Adi Wibowo", "DK.KARANGGANDUL PAKUJATI, PAGUYANGAN, BREBES, JAWA TENGAH", "085747818187", "bayuad65@gmail.com"));
        contactList.add(new Contact("41515120068", "Fikri Amrullah S.", "Jl. H. Nurleman No.77 RT.01/03, Benda Baru, Pamulang, Tangerang Selatan", "085210312350", "fikriamru@gmail.com"));
        contactList.add(new Contact("41515120101", "Irvan Juliansyah", "jalan ciindah ii nusa jaya karawaci tangerang", "081906444472", "julyirvan@gmail.com"));
        contactList.add(new Contact("41515120102", "Ashari Fauzi", "Jalan Raya Puncak, Pasar Cisarua, Kabupaten Bogor", "085772670301", "ashari.mahapatih@gmail.com"));
        contactList.add(new Contact("41515120106", "Meyta Jennis Taliti", "Bulak Rata, Pondok Rajeg Cibinong Kabupaten Bogor", "085773589030", "meytajennist@gmail.com"));
        contactList.add(new Contact("41515120142", "Rizqi Ahmad Fauzan", "Genito, Kec. WIndusari, Kab. Magelang, Jawa Tengah", "087878069499", "fauzangenito@gmail.com"));
        contactList.add(new Contact("41515120144", "Hendra Rudianto", "Cemeng, Sambung Macan, Sragen, Jawa Tengah ", "087800090097", "hendraruddianto@gmail.com"));
        contactList.add(new Contact("41516110058", "Agustinus Palbeno", "Jl.Kenari 1 No.G-31 Jakarta Pusat", "082277733360", "apstudio05@gmail.com"));
        contactList.add(new Contact("41516110078", "Achmad Helmy S", "Komp. Perum. Dasana Indah, Kab. Tangerang", "08111758565", "ach.helmy16@gmail.com"));
        contactList.add(new Contact("41516110090", "Novia Nurrohmah", "Padas, Kranggan, Polanharjo, Klaten, Jawa Tengah", "08742272022", "noviayaa@gmail.com"));
        contactList.add(new Contact("41516120070", "Rizal", "Jalan Gn. Guntur, Cirebon, Jawa Barat", "08561516470", "rizalbamumin@gmail.com"));
        contactList.add(new Contact("41516120104", "Topaz Malik Aziz", "Jalan Palam Puri 2 No 107, Sawah Baru, Ciputat, Tangerang Selatan", "081285306129", "topazmalikaziz@gmail.com"));
        contactList.add(new Contact("41517110106", "Iwan Gunawan", "Perum Panorama Sepatan, Tangerang ", "081280659841", "iwanguunawan@gmail.com"));
        contactList.add(new Contact("41517110159", "Ibnul Aziz", "Jl. Pedurenan Masjid 4, Karet Kuningan, Jakarta Selatan", "085355423134", "ibnulaziz10@gmail.com"));
        contactList.add(new Contact("41517110163", "Ichsan", "Jalan Poltek Aceh, Banda Aceh, Aceh", "08116888081", "ichsan.it@gmail.com"));
        contactList.add(new Contact("41517110164", "Jamaluddin", "Jl. Palupuh VI No. 2 Kota Bogor", "08176352664", "jamzjumz21@gmail.com"));
        contactList.add(new Contact("41516110054", "Justin Darius", "Griya Dadap Estate Blok H2 no 11/2 , Tangerang", "081806700500", "justin.darius2710@gmail.com"));

        db.insertBulkContac(contactList);

        contacts = getContactList();
        adapter.setContactList(contacts);
        adapter.notifyDataSetChanged();
    }

    private List<Contact> getContactList() {
        return db.getAllContacts();
    }

}
