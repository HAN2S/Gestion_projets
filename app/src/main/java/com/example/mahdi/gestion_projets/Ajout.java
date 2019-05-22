package com.example.mahdi.gestion_projets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ajout extends AppCompatActivity {
    TextView name;
    Button ajouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        ajouter=findViewById(R.id.ajouter_projet);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = name.getText().toString();
                Projet projet = new Projet(nom);
                DBProjet db = new DBProjet(Ajout.this);
                db.AjoutContact(projet);
                Toast.makeText(Ajout.this, "saved !", Toast.LENGTH_SHORT).show();
                Intent projIntent = new Intent(Ajout.this,Projets.class);
                startActivity(projIntent);
            }
        });

    }
}
