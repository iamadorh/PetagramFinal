package com.example.petagramfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.petagramfinal.Adaptadores.MascotaAdaptador;
import com.example.petagramfinal.Adaptadores.PageAdapter;
import com.example.petagramfinal.Fragmentos.PerfilFragment;
import com.example.petagramfinal.Fragmentos.RecyclerViewFragment;
import com.example.petagramfinal.POJO.Mascotas;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent2 = new Intent (this, contactoActivity.class);
                startActivity(intent2);
                break;
            case R.id.mAcercaDe:
                Intent intent3 = new Intent (this, acercaDeActivity.class);
                startActivity(intent3);
                break;
            case R.id.mFiveFav:
                Intent intent = new Intent (this, CincoFavoritas.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.huella);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconoperro);
    }
}