package com.agarwalnikhil307.attendancesystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

Context context;
ArrayList<User>list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
     return new MyViewHolder(v);
    }

    @Override

    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
            User user=list.get(position);
            holder.fulllname.setText(user.getFullname());
            holder.uid.setText(user.getUid());
            holder.classs.setText(user.getClasss());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fulllname,uid,classs;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fulllname=itemView.findViewById(R.id.tvfullName);
            fulllname=itemView.findViewById(R.id.tvuid);
            fulllname=itemView.findViewById(R.id.tvclass);
        }
    }
}
