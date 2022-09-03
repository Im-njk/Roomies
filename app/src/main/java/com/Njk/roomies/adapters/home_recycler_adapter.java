package com.Njk.roomies.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Njk.roomies.R;
import com.Njk.roomies.model.roomateDetail;

import java.util.List;

public class home_recycler_adapter  extends RecyclerView.Adapter<home_recycler_adapter.ViewHolder> {

    List<roomateDetail> list;
    Context context;

    public home_recycler_adapter(List<roomateDetail> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.amt.setText(String.valueOf(list.get(position).getAmount()));
     holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,amt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.home_recycler_name);
            amt=itemView.findViewById(R.id.home_recycler_amt);
        }
    }
}
