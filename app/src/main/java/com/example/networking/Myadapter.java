package com.example.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Viewholder>{
    private List<Mountain> mountains;
    public Myadapter(List<Mountain> mountains) {
        this.mountains = mountains;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.name.setText(mountains.get(position).getName());
        holder.location.setText(mountains.get(position).getLocation());
        holder.size.setText(String.valueOf(mountains.get(position).getSize()));
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }
}
