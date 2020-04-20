package com.example.myschoolapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyTeacher extends RecyclerView.Adapter<MyTeacher.MYTeacher> {

    Context context;

   ArrayList<Member> members;

   public MyTeacher(Context c,ArrayList<Member> p){
       context=c;
       members=p;
   }



    @NonNull
    @Override
    public MYTeacher onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MYTeacher(LayoutInflater.from(context).inflate(R.layout.list_teacher,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MYTeacher holder, int position) {

       holder.name.setText(members.get(position).getName());
       holder.email.setText(members.get(position).getEmail());
   holder.id.setText(members.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    class MYTeacher extends RecyclerView.ViewHolder {
        TextView name,email,id;

        public MYTeacher(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.teacher_nametxt);
            email=itemView.findViewById(R.id.teacher_emailtxt);
            id=itemView.findViewById(R.id.id_txt);

        }
    }
}
