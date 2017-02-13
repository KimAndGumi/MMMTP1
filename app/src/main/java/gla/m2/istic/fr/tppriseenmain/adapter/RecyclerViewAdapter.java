package gla.m2.istic.fr.tppriseenmain.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gla.m2.istic.fr.tppriseenmain.R;
import gla.m2.istic.fr.tppriseenmain.parcelable.InfoParcelable;

/**
 * Created by nirina on 13/02/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<InfoParcelable> items;
    private int itemLayout;

    public RecyclerViewAdapter(List<InfoParcelable> items, int itemLayout){
        this.items = items;
        this.itemLayout = itemLayout;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        return new ViewHolder(v){

        };
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        InfoParcelable item = items.get(position);

        holder.prenomText.setText(item.getPrenom());
        holder.nomText.setText(item.getNom());
        holder.dateText.setText(item.getDate());
        holder.villeText.setText(item.getVille());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nomText;
        public TextView prenomText;
        public TextView villeText;
        public TextView dateText;

        public ViewHolder(View itemView){
            super(itemView);
            nomText = (TextView) itemView.findViewById(R.id.itemNom);
            prenomText = (TextView) itemView.findViewById(R.id.itemPrenom);
            villeText = (TextView) itemView.findViewById(R.id.itemVille);
            dateText = (TextView) itemView.findViewById(R.id.itemDate);
        }
    }
}

