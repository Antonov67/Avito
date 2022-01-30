package com.example.avito;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResistorAdapter extends RecyclerView.Adapter<ResistorAdapter.ResistorViewHolder> {

    private final LayoutInflater inflater;
    private final List<Resistor> resistorList;

    public ResistorAdapter(Context context, List<Resistor> resistorList) {
        this.inflater = LayoutInflater.from(context);
        this.resistorList = resistorList;
    }

    @NonNull
    @Override
    public ResistorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new ResistorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResistorAdapter.ResistorViewHolder holder, int position) {
        Resistor resistor = resistorList.get(position);
        holder.resistorResistance.setText(resistor.resistance + "");
    }

    @Override
    public int getItemCount() {

        return resistorList.size();
    }

    public static class ResistorViewHolder extends RecyclerView.ViewHolder {
        final EditText resistorResistance;
        public ResistorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.resistorResistance = itemView.findViewById(R.id.item_resistor);
        }
    }
}