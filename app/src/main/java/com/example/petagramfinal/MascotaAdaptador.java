package com.example.petagramfinal;

import static android.content.Context.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.mascotaViewHolder> {
    ArrayList<Mascotas> mascotas;


    public MascotaAdaptador( ArrayList<Mascotas> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public mascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new mascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull mascotaViewHolder mascotaViewHolder, int position) {
        Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.ivFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikesCV.setText(mascota.getLikes());
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Like a " + mascota.getNombre()  , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class mascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView ivFotoCV;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageButton btnLike;


        public mascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoCV = (ImageView) itemView.findViewById(R.id.ivFotoMascota);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvLikes);
            btnLike = (ImageButton) itemView.findViewById(R.id.ibLike);
        }
    }
}
