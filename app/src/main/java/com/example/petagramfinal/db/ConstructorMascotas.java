package com.example.petagramfinal.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagramfinal.POJO.Mascotas;
import com.example.petagramfinal.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas (Context context){
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerDatos(){
        /*ArrayList<Mascotas> mascotitas = new ArrayList<>();

        mascotitas.add(new Mascotas(R.drawable.conejo, "Conejito", 0));
        mascotitas.add(new Mascotas(R.drawable.leon, "León",0));
        mascotitas.add(new Mascotas(R.drawable.hipo, "Hipopotamo",0));
        mascotitas.add(new Mascotas(R.drawable.tortuga, "Tortuga",0));
        mascotitas.add(new Mascotas(R.drawable.perrito, "Perrito",0));
        mascotitas.add(new Mascotas(R.drawable.vaca,"Vaquita",0));
        return mascotitas;*/

        BaseDatos bd = new BaseDatos(context);
        insertarMascotas(bd);
        return(bd.obtenerMascotas());
    }

    public void insertarMascotas(BaseDatos bd){
        ContentValues contentValues = new ContentValues();
        contentValues.put(BDConstantes.TABLE_MASCOTAS_ID, 1);
        contentValues.put(BDConstantes.TABLE_MASCOTAS_NOMBRE, "Conejito");
        contentValues.put(BDConstantes.TABLE_MASCOTAS_FOTO, R.drawable.conejo);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(BDConstantes.TABLE_MASCOTAS_ID, 2);
        contentValues.put(BDConstantes.TABLE_MASCOTAS_NOMBRE, "León");
        contentValues.put(BDConstantes.TABLE_MASCOTAS_FOTO, R.drawable.leon);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(BDConstantes.TABLE_MASCOTAS_ID, 3);
        contentValues.put(BDConstantes.TABLE_MASCOTAS_NOMBRE, "Hipopotamo");
        contentValues.put(BDConstantes.TABLE_MASCOTAS_FOTO, R.drawable.hipo);
         bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(BDConstantes.TABLE_MASCOTAS_ID, 4);
        contentValues.put(BDConstantes.TABLE_MASCOTAS_NOMBRE, "Tortuga");
        contentValues.put(BDConstantes.TABLE_MASCOTAS_FOTO, R.drawable.tortuga);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(BDConstantes.TABLE_MASCOTAS_ID, 5);
        contentValues.put(BDConstantes.TABLE_MASCOTAS_NOMBRE, "Perrito");
        contentValues.put(BDConstantes.TABLE_MASCOTAS_FOTO, R.drawable.perrito);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(BDConstantes.TABLE_MASCOTAS_ID, 6);
        contentValues.put(BDConstantes.TABLE_MASCOTAS_NOMBRE, "Vaquita");
        contentValues.put(BDConstantes.TABLE_MASCOTAS_FOTO, R.drawable.vaca);
       bd.insertarMascota(contentValues);

    }

    public void darLike(Mascotas mascotas){
        BaseDatos bd = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(BDConstantes.TABLE_MASCOTA_LIKE_ID_MASCOTA, mascotas.getId());
        contentValues.put(BDConstantes.TABLE_MASCOTA_LIKE_LIKES, 1);
        bd.insertarLike(contentValues);
    }

    public int obtenerLikes(Mascotas mascotas){
        BaseDatos bd = new BaseDatos(context);
        return bd.dameLikes(mascotas);
    }
}
