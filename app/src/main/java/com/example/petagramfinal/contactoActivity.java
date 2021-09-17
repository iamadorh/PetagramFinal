package com.example.petagramfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class contactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        ImageButton btnCorreo = (ImageButton) findViewById(R.id.btnCorreo);
        EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        EditText mlMensaje = (EditText) findViewById(R.id.mlMensaje);

        btnCorreo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{etCorreo.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT,"Contacto");
                it.putExtra(Intent.EXTRA_TEXT,mlMensaje.getText());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"gmail"));
            }
        });
    }
}