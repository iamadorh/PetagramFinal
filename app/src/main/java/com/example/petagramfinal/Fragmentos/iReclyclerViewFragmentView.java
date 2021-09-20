package com.example.petagramfinal.Fragmentos;

import com.example.petagramfinal.Adaptadores.MascotaAdaptador;
import com.example.petagramfinal.POJO.Mascotas;

import java.util.ArrayList;

public interface iReclyclerViewFragmentView {

    public void generaLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador (ArrayList<Mascotas> mascotas);

    public void initAdapterRV(MascotaAdaptador pets);

}
