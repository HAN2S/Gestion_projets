package com.example.mahdi.gestion_projets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Projets extends AppCompatActivity {
    Button ajouter;
    Button modifier;
    Button supprimer;
    ListView liste_projets;
    DBProjet  db=new DBProjet(this);
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projets);

        liste_projets=findViewById(R.id.list_projets);

        final ArrayList<Projet> list_proj = db.getAllProjet();

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list_proj);
        liste_projets.setAdapter(adapter);

        ajouter=findViewById(R.id.btn_ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent projIntent = new Intent(Projets.this,Ajout.class);
                startActivity(projIntent);
            }
        });


        liste_projets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                Projet projet = (Projet) parent.getItemAtPosition(position);
                id = projet.getId();

                Intent intent = new Intent(Projets.this,Modification.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


    }
}
