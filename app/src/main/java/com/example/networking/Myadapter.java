package com.example.networking;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Viewholder>{

    public Myadapter(List<Mountain> mountains) {
        this.mountains = mountains;
    }

    private List<Mountain> mountains;
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.name.setText(mountains.get(position));
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }
}
