package com.example.appconcrud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorArticulos extends RecyclerView.Adapter<AdaptadorArticulos.ArticulosViewHolder> {
    private Context mCtx;
    private List<Dto> articulosList;
    private Object SQLiteDatabase;


    public AdaptadorArticulos(Context mCtx, List<Dto> articulosList) {
        this.mCtx = mCtx;
        this.articulosList = articulosList;
    }

    @NonNull
    @Override


    public AdaptadorArticulos.ArticulosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_recyclerview, null);
        return new ArticulosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorArticulos.ArticulosViewHolder holder, int position) {
        Dto dto = articulosList.get(position);
        holder.textViewCodigo1.setText(String.valueOf(dto.getCodigo()));
        holder.textViewDescripcion1.setText(dto.getDescripcion());
        holder.textViewPrecio1.setText(String.valueOf(dto.getPrecio()));
        holder.textViewOtro.setText(String.valueOf("Registro #:" + (position + 1)) + "/" +
                getItemCount());

    }

    @Override
    public int getItemCount() {
        return articulosList.size();
    }


    public class ArticulosViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCodigo1, textViewDescripcion1, textViewPrecio1, textViewOtro;


        public ArticulosViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCodigo1 = itemView.findViewById(R.id.textViewCodigo1);
            textViewDescripcion1 = itemView.findViewById(R.id.textViewDescripcion1);
            textViewPrecio1 = itemView.findViewById(R.id.textViewPrecio1);
            textViewOtro = itemView.findViewById(R.id.textViewOtro);


        }

    }



}

