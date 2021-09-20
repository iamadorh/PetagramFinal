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
import com.example.petagramfinal.presentador.RecyclerViewFragmentPresenter;
import com.example.petagramfinal.presentador.iRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements iReclyclerViewFragmentView{

    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaPets;
    private iRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaPets = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
          return v;
    }



   /* public void initPets(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.conejo, "Conejito", 0));
        mascotas.add(new Mascotas(R.drawable.leon, "León",0));
        mascotas.add(new Mascotas(R.drawable.hipo, "Hipopotamo",0));
        mascotas.add(new Mascotas(R.drawable.tortuga, "Tortuga",0));
        mascotas.add(new Mascotas(R.drawable.perrito, "Perrito",0));
        mascotas.add(new Mascotas(R.drawable.vaca,"Vaquita",0));
    }
*/

    @Override
    public void generaLinearLayoutVertical() {
        LinearLayoutManager pasa = new LinearLayoutManager(getActivity());
        pasa.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(pasa);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas);
        return adapter;
    }

    @Override
    public void initAdapterRV(MascotaAdaptador pets) {
        listaPets.setAdapter(pets);
    }
}
