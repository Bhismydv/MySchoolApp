package com.example.myschoolapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;

    private ArrayList<Study> study;


    public MyAdapter(Context c,ArrayList<Study> p){

        context=c;
        study=p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_adapter,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



holder.subjname.setText(study.get(position).getSubject());
holder.desc.setText(study.get(position).getDesc());
holder.teacherid.setText(study.get(position).getTeacherid());




    }

    @Override
    public int getItemCount() {


        return study.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView subjname,teacherid,desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            subjname=itemView.findViewById(R.id.subjtxt);
            teacherid=itemView.findViewById(R.id.idtxt);
            desc=itemView.findViewById(R.id.desctxt);


        }
    }
}
