package com.example.aplikacja;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

   import com.example.aplikacja.Dane;
import com.example.aplikacja.R;

import java.util.List;
import java.util.Locale;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private List<Dane> data;
    public MainAdapter(List<Dane> data) {
        this.data = data;
    }

    @Override
    public MainViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MainViewHolder holder, int position) {
        Dane daneDoWypisania = data.get(position);

        holder.wypiszKoszt.setText(String.format(Locale.getDefault(), "%.2f", daneDoWypisania.koszt));
        holder.wypiszDystans.setText(String.format(Locale.getDefault(), "%.2f", daneDoWypisania.dystans));
        holder.wypiszDate.setText(String.valueOf(daneDoWypisania.data));
        holder.wypiszIlosc.setText(String.valueOf(daneDoWypisania.ilosc));
        holder.wypiszCene.setText(String.valueOf(daneDoWypisania.cena));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView wypiszKoszt;
        TextView wypiszDystans;
        TextView wypiszDate;
        TextView wypiszIlosc;
        TextView wypiszCene;
        public MainViewHolder(View itemView) {
            super(itemView);
            wypiszDate = (TextView) itemView.findViewById(R.id.wypiszDate);
            wypiszKoszt = (TextView) itemView.findViewById(R.id.wypiszKoszt);
            wypiszDystans = (TextView) itemView.findViewById(R.id.wypiszDystans);
            wypiszIlosc = (TextView) itemView.findViewById(R.id.wypiszIlosc);
            wypiszCene = (TextView) itemView.findViewById(R.id.wypiszCene);
        }
    }
}
