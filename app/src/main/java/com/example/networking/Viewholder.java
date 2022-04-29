package com.example.networking;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Viewholder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView location;
    public TextView size;

    public Viewholder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        location = itemView.findViewById(R.id.location);
        size = itemView.findViewById(R.id.size);
    }
}
