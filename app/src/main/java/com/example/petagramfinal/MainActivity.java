package com.example.petagramfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPets = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager pasa = new LinearLayoutManager(this);
        pasa.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(pasa);
        initPets();
        initAdapter();

        ImageButton btnFavFive = (ImageButton) findViewById(R.id.ibFav5);
        btnFavFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (MainActivity.this, CincoFavoritas.class);
                startActivity(intent);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

 public void initAdapter(){
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas);
        listaPets.setAdapter(adapter);

 }


    public void initPets(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.conejo, "Conejito", "3"));
        mascotas.add(new Mascotas(R.drawable.leon, "León","5"));
        mascotas.add(new Mascotas(R.drawable.fav5, "Hipopotamo","1"));
        mascotas.add(new Mascotas(R.drawable.tortuga, "Tortuga","2"));
        mascotas.add(new Mascotas(R.drawable.perrito, "Perrito","10"));
        mascotas.add(new Mascotas(R.drawable.vaca,"Vaquita","1"));

    }

}