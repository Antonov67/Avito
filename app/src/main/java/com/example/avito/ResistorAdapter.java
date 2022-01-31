package com.example.avito;


import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResistorAdapter extends RecyclerView.Adapter<ResistorAdapter.ResistorViewHolder> {

    private final LayoutInflater inflater;
    private static List<Resistor> resistorList;

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
    public long getItemId(int position) {
        return super.getItemId(position);
    }



    @Override
    public void onBindViewHolder(@NonNull ResistorAdapter.ResistorViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Resistor resistor = resistorList.get(position);
        holder.resistorResistance.setText(resistor.resistance + "");
        holder.nameOfResistor.setText(resistor.name);
    }

    @Override
    public int getItemCount() {

        return resistorList.size();
    }

    public List<Resistor> getResistorList(){
        return resistorList;
    }


    public static class ResistorViewHolder extends RecyclerView.ViewHolder {



        final EditText resistorResistance;
        final TextView nameOfResistor;
        public ResistorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.resistorResistance = itemView.findViewById(R.id.item_resistor);
            this.nameOfResistor = itemView.findViewById(R.id.name_resistor);
            resistorResistance.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (charSequence.length() != 0){
                        resistorList.add(getAdapterPosition(),
                                new Resistor(Float.parseFloat(charSequence.toString()),
                                "резистор №" + (getAdapterPosition() + 1)));
                        resistorList.remove(getAdapterPosition() + 1);
                        Log.d("Di", charSequence + " " + getAdapterPosition());
                    }
                    else {
                        Log.d("Di","null " + getAdapterPosition());
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {


                }
            });
        }


    }
}