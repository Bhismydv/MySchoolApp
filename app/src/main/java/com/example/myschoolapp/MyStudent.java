package com.example.myschoolapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyStudent extends RecyclerView.Adapter<MyStudent.MYViewHolder> {

    private Context context;

    private ArrayList<User> user;

    public MyStudent(Context c, ArrayList<User> p){
        context=c;
        user=p;
    }


    @NonNull
    @Override
    public MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MYViewHolder(LayoutInflater.from(context).inflate(R.layout.list_student,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MYViewHolder holder, int position) {

        holder.name.setText(user.get(position).getName());
        holder.email.setText(user.get(position).getEmail());
        holder.rollNo.setText(user.get(position).getRollno());

    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    class MYViewHolder extends RecyclerView.ViewHolder {

        TextView name,email,rollNo;
        public MYViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.nametxt);
            email=itemView.findViewById(R.id.emailtxt);
            rollNo=itemView.findViewById(R.id.rollnotxt);
        }
    }
}
