package com.Njk.roomies.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Njk.roomies.DoubleClickListener;
import com.Njk.roomies.R;
import com.Njk.roomies.model.roomateDetail;

import java.util.List;

public class Add_amt_recycler extends RecyclerView.Adapter<Add_amt_recycler.ViewHolder> {
    Context context;
    List<roomateDetail> list;
    double tot_amt;
    Add_amt_recycler add_amt_recycler_class;
    RecyclerView ad_amt_recycler;


    public Add_amt_recycler(Context context, List<roomateDetail> list, double tot_amt, Add_amt_recycler add_amt_recycler_class, RecyclerView ad_amt_recycler) {
        this.context = context;
        this.list = list;
        this.tot_amt = tot_amt;
        this.add_amt_recycler_class = add_amt_recycler_class;
        this.ad_amt_recycler = ad_amt_recycler;
    }

    void recycler(){
        add_amt_recycler_class=new Add_amt_recycler(context,list,tot_amt,add_amt_recycler_class,ad_amt_recycler);
        ad_amt_recycler.setAdapter(add_amt_recycler_class);
    }
    double set_share_amt(TextView amt) {
        int cnt = 1;
        for (roomateDetail obj : list) {
            if (obj.isStatus()) cnt++;
        }
        for (roomateDetail obj : list) {
            if (obj.isStatus()){
                obj.setAmount(tot_amt / cnt);
            }
        }
        recycler();
        return tot_amt / cnt;
    }

    public void changeclr(roomateDetail obj, RelativeLayout r1, TextView name, TextView amt) {
        if (obj.isStatus() == false) {
            r1.setBackgroundColor(context.getResources().getColor(R.color.yellow));
            name.setTextColor(context.getResources().getColor(R.color.black));
            amt.setTextColor(context.getResources().getColor(R.color.black));
            amt.setText("Rs. " + set_share_amt(amt));
            obj.setStatus(true);
        } else {
            r1.setBackgroundResource(R.drawable.add_amt_unselected);
            name.setTextColor(context.getResources().getColor(R.color.white));
            amt.setTextColor(context.getResources().getColor(R.color.white));
            amt.setText("Rs. 0");
            obj.setStatus(false);
        }
    }

    @NonNull
    @Override
    public Add_amt_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_amt_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Add_amt_recycler.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        if(list.get(position).isStatus()) {
            holder.r1.setBackgroundColor(context.getResources().getColor(R.color.yellow));
            holder.name.setTextColor(context.getResources().getColor(R.color.black));
            holder.amt.setTextColor(context.getResources().getColor(R.color.black));
            holder.amt.setText("Rs. "+String.valueOf(list.get(position).getAmount()));
        }else{
            holder.r1.setBackgroundResource(R.drawable.add_amt_unselected);
            holder.name.setTextColor(context.getResources().getColor(R.color.white));
            holder.amt.setTextColor(context.getResources().getColor(R.color.white));
            holder.amt.setText("Rs. 0");
        }



        holder.r1.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onSingleClick(View v) {

                changeclr(list.get(position), holder.r1, holder.name, holder.amt);
                set_share_amt(holder.amt);
            }

            @Override
            public void onDoubleClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView amt;
        RelativeLayout r1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_add_amt);
            amt = itemView.findViewById(R.id.amount_add_amt);
            r1 = itemView.findViewById(R.id.add_amt_layout);
        }
    }
}
