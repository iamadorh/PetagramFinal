package com.example.petagramfinal.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petagramfinal.POJO.Mascotas;
import com.example.petagramfinal.R;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, BDConstantes.DATABASE_NAME, null, BDConstantes.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTablaMascotas = "CREATE TABLE " + BDConstantes.TABLE_MASCOTAS + "(" +
                BDConstantes.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BDConstantes.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                BDConstantes.TABLE_MASCOTAS_FOTO + " INTEGER)";

        String crearTablaLikes = "CREATE TABLE " + BDConstantes.TABLE_MASCOTA_LIKE+ "(" +
                BDConstantes.TABLE_MASCOTA_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BDConstantes.TABLE_MASCOTA_LIKE_ID_MASCOTA + " INTEGER, " +
                BDConstantes.TABLE_MASCOTA_LIKE_LIKES + " INTEGER, " +
                " FOREIGN KEY (" + BDConstantes.TABLE_MASCOTA_LIKE_ID_MASCOTA + ")  " +
                "REFERENCES " + BDConstantes.TABLE_MASCOTAS + "("+BDConstantes.TABLE_MASCOTAS_ID+")"+
                ")";

        db.execSQL(crearTablaMascotas);
        db.execSQL(crearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BDConstantes.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + BDConstantes.TABLE_MASCOTA_LIKE);
        onCreate(db);
    }


    public ArrayList<Mascotas> obtenerMascotas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + BDConstantes.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resultado = db.rawQuery(query, null);

        while (resultado.moveToNext()){
            Mascotas mascotas2 = new Mascotas(resultado.getInt(0), resultado.getInt(2), resultado.getString(1));
            mascotas.add(mascotas2);
        }
        db.close();

        return(mascotas);
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(BDConstantes.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(BDConstantes.TABLE_MASCOTA_LIKE, null, contentValues);
        db.close();
    }

    public int dameLikes(Mascotas mascotas){
        int likes = 0;

        String query = "SELECT COUNT("+ BDConstantes.TABLE_MASCOTA_LIKE_LIKES +") FROM " +
                BDConstantes.TABLE_MASCOTA_LIKE + " WHERE " + BDConstantes.TABLE_MASCOTA_LIKE_ID_MASCOTA +
                " = " + mascotas.getId();
        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor resultado = bd.rawQuery(query, null);
        if (resultado.moveToNext()){
            likes = resultado.getInt(0);
        }
        bd.close();

        return likes;
    }

}
