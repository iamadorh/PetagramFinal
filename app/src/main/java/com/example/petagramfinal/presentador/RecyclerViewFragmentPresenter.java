package com.example.petagramfinal.presentador;

import android.content.Context;

import com.example.petagramfinal.Fragmentos.RecyclerViewFragment;
import com.example.petagramfinal.Fragmentos.iReclyclerViewFragmentView;
import com.example.petagramfinal.POJO.Mascotas;
import com.example.petagramfinal.db.ConstructorMascotas;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements iRecyclerViewFragmentPresenter{

    private iReclyclerViewFragmentView IRecyclerViewFragmentView;
    private ConstructorMascotas constructorMascotas;
    private Context context;
    private ArrayList<Mascotas> lasMascotas;

    public RecyclerViewFragmentPresenter(iReclyclerViewFragmentView IRecyclerViewFragmentView, Context context){
        this.IRecyclerViewFragmentView= IRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        lasMascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        IRecyclerViewFragmentView.initAdapterRV(IRecyclerViewFragmentView.crearAdaptador(lasMascotas));
        IRecyclerViewFragmentView.generaLinearLayoutVertical();
    }
}
