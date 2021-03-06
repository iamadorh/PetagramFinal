package com.example.petagramfinal.Adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagramfinal.Fragmentos.PerfilFragment;
import com.example.petagramfinal.IComunicaFragments;
import com.example.petagramfinal.MainActivity;
import com.example.petagramfinal.POJO.Mascotas;
import com.example.petagramfinal.R;
import com.example.petagramfinal.db.ConstructorMascotas;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.mascotaViewHolder> {
    ArrayList<Mascotas> mascotas;
    Activity activity;

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
        mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Like a " + mascota.getNombre()  , Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(view.getContext());
                constructorMascotas.darLike(mascota);
                mascotaViewHolder.tvLikesCV.setText(String.valueOf(constructorMascotas.obtenerLikes(mascota)));

            }
        });
        mascotaViewHolder.ivFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), mascota.getNombre()  , Toast.LENGTH_SHORT).show();

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
