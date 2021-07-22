package br.com.cassio.ribeiro.teste.listarandomparimpar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.cassio.ribeiro.teste.listarandomparimpar.R;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.MyListViewHolder> {

    private ArrayList<ArrayList<Integer>> mMixedList;

    public ListaAdapter(ArrayList<ArrayList<Integer>> mMixedList) {
        this.mMixedList = mMixedList;
    }

    @Override
    public MyListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyListViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ListaAdapter.MyListViewHolder holder, int position) {
        Integer esq = mMixedList.get(position).get(0);
        Integer dir = mMixedList.get(position).get(1);

        if(esq != null && esq != -1){
            holder.tvEsq.setText(String.valueOf(esq));
        }else{
            holder.tvEsq.setText("-");
        }

        if(dir != null && dir != -1){
            holder.tvDir.setText(String.valueOf(dir));
        }else{
            holder.tvDir.setText("-");
        }
    }

    @Override
    public int getItemCount() {
        return mMixedList.size();
    }

    public static class MyListViewHolder extends RecyclerView.ViewHolder {
        private TextView tvEsq, tvDir;

        public MyListViewHolder(View itemView) {
            super(itemView);
            tvEsq = itemView.findViewById(R.id.tv_esq);
            tvDir = itemView.findViewById(R.id.tv_dir);
        }
    }
}
