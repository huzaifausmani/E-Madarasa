package com.example.e_madarasa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewStudent extends RecyclerView.Adapter<ViewStudent.MyViewHolder> {
    List<Lessons> lessonsList;
    public ViewStudent(List<Lessons> lessonsList) {
        this.lessonsList = lessonsList;
    }

    @NonNull
    @Override
    public ViewStudent.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewStudent.MyViewHolder holder, int position) {
        holder.data = lessonsList.get(position);
        holder.manzil.setText(String.valueOf(holder.data.getManzil()));
        holder.sabak.setText(String.valueOf(holder.data.getSabak()));
        holder.sabki.setText(String.valueOf(holder.data.getSabki()));
        holder.date.setText(holder.data.getDate());
    }

    @Override
    public int getItemCount() {
        return lessonsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView sabak, sabki, manzil, date;
        Lessons data;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sabak = itemView.findViewById(R.id.sabakText);
            sabki = itemView.findViewById(R.id.sabkiText);
            manzil = itemView.findViewById(R.id.manzilText);
            date = itemView.findViewById(R.id.dateText);

        }
    }
}
