package com.example.petagramfinal.Fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagramfinal.Adaptadores.MascotaAdaptador;
import com.example.petagramfinal.POJO.Mascotas;
import com.example.petagramfinal.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaPets;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaPets = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager pasa = new LinearLayoutManager(getActivity());
        pasa.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(pasa);
        initPets();
        initAdapter();

          return v;
    }

    public void initAdapter(){
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas);
        listaPets.setAdapter(adapter);

    }

    public void initPets(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.conejo, "Conejito", "3"));
        mascotas.add(new Mascotas(R.drawable.leon, "León","5"));
        mascotas.add(new Mascotas(R.drawable.hipo, "Hipopotamo","1"));
        mascotas.add(new Mascotas(R.drawable.tortuga, "Tortuga","2"));
        mascotas.add(new Mascotas(R.drawable.perrito, "Perrito","10"));
        mascotas.add(new Mascotas(R.drawable.vaca,"Vaquita","1"));
    }


}
