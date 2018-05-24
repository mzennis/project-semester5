package id.mzennis.myapplication.sqlite;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.mzennis.myapplication.R;

/**
 * Created by meta on 24/05/18.
 */
public class PlatCodeAdapter  extends RecyclerView.Adapter<PlatCodeAdapter.MyViewHolder> {

    private List<PlatCode> platCodes;

    public PlatCodeAdapter() {
    }

    public void setPlatCodes(List<PlatCode> platCodes) {
        this.platCodes = platCodes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_codeplat, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PlatCode item = platCodes.get(position);
        holder.kode.setText("Kode: "+item.getKode());
        holder.daerah.setText("Daerah: \n"+item.getDaerah());
        holder.provinsi.setText("Provinsi: "+item.getProvinsi());
    }

    @Override
    public int getItemCount() {
        return platCodes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView kode;
        TextView daerah;
        TextView provinsi;

        public MyViewHolder(View view) {
            super(view);
            kode = view.findViewById(R.id.tv_kode);
            daerah = view.findViewById(R.id.tv_daerah);
            provinsi = view.findViewById(R.id.tv_provinsi);
        }
    }
}
