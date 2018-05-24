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
import id.mzennis.myapplication.sqlite.PlatCode;
import id.mzennis.myapplication.sqlite.PlatCodeAdapter;

/**
 * Created by meta on 18/05/18.
 */
public class PlatNomorFragment extends Fragment {

    public static PlatNomorFragment newInstance() {
        return new PlatNomorFragment();
    }

    private PlatCodeAdapter adapter;
    private RecyclerView recyclerview;
    private DatabaseHelper db;
    private List<PlatCode> platCodes = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sqlite, container, false);

        recyclerview = view.findViewById(R.id.recycler_view);

        db = new DatabaseHelper(getActivity());

        adapter = new PlatCodeAdapter();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.addItemDecoration(new MyDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL, 16));
        recyclerview.setAdapter(adapter);


        platCodes = getPlatCodes();
        if (platCodes != null && !platCodes.isEmpty()) {
            adapter.setPlatCodes(platCodes);
            adapter.notifyDataSetChanged();
        } else {
            addPlatCodes();
        }

        return view;
    }

    private void addPlatCodes() {
        List<PlatCode> platCodes = new ArrayList<>();
        platCodes.add(new PlatCode("BL", "Seluruh Kabupaten/Kota di Provinsi Nanggroe Aceh Darussalam", "Provinsi Nanggroe Aceh Darussalam"));
        platCodes.add(new PlatCode("BB", "Kabupaten Tapanuli Utara\n" +
                "Kabupaten Tapanuli Tengah\n" +
                "Kabupaten Tapanuli Selatan\n" +
                "Kabupaten Sibolga\n" +
                "Kabupaten Dairi\n" +
                "Kabupaten Nias", "Provinsi Sumatera Utara"));
        platCodes.add(new PlatCode("BK", "Kota Medan\n" +
                "Kabupaten Deli Serdang\n" +
                "Kabupaten Tebing Tinggi\n" +
                "Kabupaten Langkat\n" +
                "Kabupaten Binjai\n" +
                "Kabupaten Simalungun\n" +
                "Kabupaten Pematang Siantar\n" +
                "Kabupaten Tanah Karo\n" +
                "Kabupaten Asahan\n" +
                "Kabupaten Labuhan Batu", "Provinsi Sumatera Utara"));
        platCodes.add(new PlatCode("BA", "Seluruh Kabupaten/Kota di Provinsi Sumatera Barat", "Provinsi Sumatera Barat"));
        platCodes.add(new PlatCode("BM", "Seluruh Kabupaten/Kota di Provinsi Riau", "Provinsi Riau"));
        platCodes.add(new PlatCode("BP", "Seluruh Kabupaten/Kota di Provinsi Kepulauan Riau", "Provinsi Kepulauan Riau"));
        platCodes.add(new PlatCode("BG", "Seluruh Kabupaten/Kota di Provinsi Sumatera Selatan", "Provinsi Sumatera Selatan"));
        platCodes.add(new PlatCode("BN", "Seluruh Kabupaten/Kota di Provinsi Bangka-Belitung", "Provinsi Bangka-Belitung"));
        platCodes.add(new PlatCode("BE", "Seluruh Kabupaten/Kota di Provinsi Lampung", "Provinsi Lampung"));
        platCodes.add(new PlatCode("BD", "Seluruh Kabupaten/Kota di Provinsi Bengkulu", "Provinsi Bengkulu"));
        platCodes.add(new PlatCode("BH", "Seluruh Kabupaten/Kota di Provinsi Jambi", "Provinsi Jambi"));
        platCodes.add(new PlatCode("B", "Seluruh Kabupaten/Kota di Provinsi DKI Jakarta", "Provinsi DKI Jakarta"));
        platCodes.add(new PlatCode("D", "Kota Bandung\n" +
                "Kabupaten Bandung", "Provinsi Jawa Barat"));
        platCodes.add(new PlatCode("F", "Kodya Bogor\n" +
                "Kabupaten Bogor\n" +
                "Kabupaten Cianjur\n" +
                "Kabupaten Sukabumi", "Provinsi Jawa Barat"));
        platCodes.add(new PlatCode("T", "Kabupaten Purwakarta\n" +
                "Kabupaten Karawang\n" +
                "Kabupaten Subang", "Provinsi Jawa Barat"));
        platCodes.add(new PlatCode("E", "Kota Cirebon\n" +
                "Kabupaten Cirebon\n" +
                "Kabupaten Indramay\n" +
                "Kabupaten Malajengka\n" +
                "Kabupaten Kuningan", "Provinsi Jawa Barat"));
        platCodes.add(new PlatCode("Z", "Kabupaten Garut\n" +
                "Kabupaten Sumedang\n" +
                "Kabupaten Tasikmalaya\n" +
                "Kabupaten Ciamis", "Provinsi Jawa Barat"));
        platCodes.add(new PlatCode("H", "Kota Semarang\n" +
                "Kabupaten Salatiga\n" +
                "Kabupaten Kendai\n" +
                "Kabupaten Demak\n" +
                "Kabupaten Grobogan", "Provinsi Jawa Tengah"));
        platCodes.add(new PlatCode("G", "Kota Pekalongan\n" +
                "Kabupaten Pekalogan\n" +
                "Kabupaten Brebes\n" +
                "Kabupaten Tegal\n" +
                "Kabupaten Siawi\n" +
                "Kabupaten Batang\n" +
                "Kabupaten Pemalang", "Provinsi Jawa Tengah"));
        platCodes.add(new PlatCode("K", "Kabupaten Pati\n" +
                "Kabupaten Kudus\n" +
                "Kabupaten Jepara\n" +
                "Kabupaten Rembang\n" +
                "Kabupaten Blora", "Provinsi Jawa Tengah"));
        platCodes.add(new PlatCode("R", "Kabupaten Banyumas\n" +
                "Kabupaten Cilacap\n" +
                "Kabupaten Purbalingga\n" +
                "Kabupaten Banjarnegara", "Provinsi Jawa Tengah"));
        platCodes.add(new PlatCode("AA", "Kota Magelang\n" +
                "Kabupaten Magelang\n" +
                "Kabupaten Purworejo\n" +
                "Kabupaten Kebumen\n" +
                "Kabupaten Temanggung\n" +
                "Kabupaten Wonosobo", "Provinsi Jawa Tengah"));
        platCodes.add(new PlatCode("AD", "Kota Surakarta\n" +
                "Kabupaten Sukoharjo\n" +
                "Kabupaten Boyolali\n" +
                "Kabupaten Sragen\n" +
                "Kabupaten Karanganyar\n" +
                "Kabupaten Wonogiri\n" +
                "Kabupaten Klaten", "Provinsi Jawa Tengah"));
        platCodes.add(new PlatCode("AB", "Seluruh Kabupaten/Kota di Provinsi D.I. Yogyakarta (DIY)", "Provinsi D.I. Yogyakarta (DIY)"));
        platCodes.add(new PlatCode("L", "Kota Surabaya", "Provinsi Jawa Timur"));
        platCodes.add(new PlatCode("W", "Kabupaten Gresik\n" +
                "Kabupaten Sidoarjo\n" +
                "Kabupaten Mojokerto\n" +
                "Kabupaten Jombang", "Provinsi Jawa Timur"));
        platCodes.add(new PlatCode("N", "Kota Malang\n" +
                "Kabupaten Malang\n" +
                "Kabupaten Probolinggo\n" +
                "Kabupaten Pasuruan\n" +
                "Kabupaten Lumajang", "Provinsi Jawa Timur"));
        platCodes.add(new PlatCode("P", "Kabupaten Besuki\n" +
                "Kabupaten Situbondo\n" +
                "Kabupaten Bondowoso\n" +
                "Kabupaten Jember\n" +
                "Kabupaten Banyuwangi", "Provinsi Jawa Timur"));
        platCodes.add(new PlatCode("AG", "Kota Kediri\n" +
                "Kabupaten Kediri/Pare\n" +
                "Kabupaten Blitar\n" +
                "Kabupaten Tulungagung\n" +
                "Kabupaten Nganjuk\n" +
                "Kabupaten Trenggalek", "Provinsi Jawa Timur"));
        platCodes.add(new PlatCode("AE", "Kota Madiun\n" +
                "Kabupaten Madiun\n" +
                "Kabupaten Ngawi\n" +
                "Kabupaten Magetan\n" +
                "Kabupaten Ponorogo\n" +
                "Kabupaten Pacitan", "Provinsi Jawa Timur"));
        platCodes.add(new PlatCode("S", "Kabupaten Bojonegoro\n" +
                "Kabupaten Tuban\n" +
                "Kabupaten Lamongan", "Provinsi Jawa Timur"));
        platCodes.add(new PlatCode("M", "Kabupaten Pamekasan\n" +
                "Kabupaten Bangkalan\n" +
                "Kabupaten Sampang\n" +
                "Kabupaten Sumenep", "Provinsi Jawa Timur"));
        platCodes.add(new PlatCode("DK", "Seluruh Kabupaten/Kota di Provinsi Bali", "Provinsi Bali"));
        platCodes.add(new PlatCode("DR", "Kota Mataram\n" +
                "Kabupaten Lombok Barat\n" +
                "Kabupaten Lombok Tengah\n" +
                "Kabupaten Lombok Timur", "Provinsi Nusa Tenggara Barat (NTB)"));
        platCodes.add(new PlatCode("EA", "Kabupaten Sumbawa\n" +
                "Kabupaten Dompu\n" +
                "Kabupaten Bima", "Provinsi Nusa Tenggara Barat (NTB)"));
        platCodes.add(new PlatCode("DH", "Kota Kupang\n" +
                "Kabupaten Timor Tengah Selatan\n" +
                "Kabupaten Timor Tengah Utara", "Provinsi Nusa Tenggara Timur (NTT)"));
        platCodes.add(new PlatCode("EB", "Kabupaten Ende\n" +
                "Kabupaten Sikka\n" +
                "Kabupaten Flores Timur\n" +
                "Kabupaten Ngada\n" +
                "Kabupaten Manggarai\n" +
                "Kabupaten Alor", "Provinsi Nusa Tenggara Timur (NTT)"));
        platCodes.add(new PlatCode("ED", "Kabupaten Sumba Timur\n" +
                "Kabupaten Sumba Barat", "Provinsi Nusa Tenggara Timur (NTT)"));
        platCodes.add(new PlatCode("KB", "Seluruh Kabupaten/Kota di Provinsi Kalimantan Barat", "Provinsi Kalimantan Barat"));
        platCodes.add(new PlatCode("DA", "Seluruh Kabupaten/Kota di Provinsi Kalimantan Selatan", "Provinsi Kalimantan Selatan"));
        platCodes.add(new PlatCode("KH", "Seluruh Kabupaten/Kota di Provinsi Kalimantan Tengah", "Provinsi Kalimantan Tengah"));
        platCodes.add(new PlatCode("KT", "Seluruh Kabupaten/Kota di Provinsi Kalimantan Timur", "Provinsi Kalimantan Timur"));
        platCodes.add(new PlatCode("KU", "Seluruh Kabupaten/Kota di Provinsi Kalimantan Utara", "Provinsi Kalimantan Utara"));
        platCodes.add(new PlatCode("DB", "Kota Manado-Kabupaten Minahasa-Kabupaten Bitung", "Provinsi Sulawesi Utara"));
        platCodes.add(new PlatCode("DL", "Kabupaten Sangir Talaud", "Provinsi Sulawesi Utara"));
        platCodes.add(new PlatCode("DM", "Seluruh Kabupaten/Kota di Provinsi Gorontalo", "Provinsi Gorontalo"));
        platCodes.add(new PlatCode("DN", "Seluruh Kabupaten/Kota di Provinsi Sulawesi Tengah", "Provinsi Sulawesi Tengah"));
        platCodes.add(new PlatCode("DD", "Seluruh Kabupaten/Kota di Provinsi Sulawesi Selatan", "Provinsi Sulawesi Selatan"));
        platCodes.add(new PlatCode("DC", "Seluruh Kabupaten/Kota di Provinsi Sulawesi Barat", "Provinsi Sulawesi Barat"));
        platCodes.add(new PlatCode("DT", "Seluruh Kabupaten/Kota di Provinsi Sulawesi Tenggara", "Provinsi Sulawesi Tenggara"));
        platCodes.add(new PlatCode("DE", "Seluruh Kabupaten/Kota di Provinsi Maluku", "Provinsi Maluku"));
        platCodes.add(new PlatCode("DG", "Seluruh Kabupaten/Kota di Provinsi Maluku Utara", "Provinsi Maluku Utara"));
        platCodes.add(new PlatCode("DS", "Seluruh Kabupaten/Kota di Provinsi Papua", "Provinsi Papua"));
        platCodes.add(new PlatCode("PB", "Seluruh Kabupaten/Kota di Provinsi Papua Barat", "Provinsi Papua Barat"));

        db.insertBulkPlatCode(platCodes);

        platCodes = getPlatCodes();
        adapter.setPlatCodes(platCodes);
        adapter.notifyDataSetChanged();
    }

    private List<PlatCode> getPlatCodes() {
        return db.getAllPlatCodes();
    }

}
