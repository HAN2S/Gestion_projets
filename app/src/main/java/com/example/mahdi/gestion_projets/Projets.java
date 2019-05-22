package com.example.mahdi.gestion_projets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Projets extends AppCompatActivity {
    Button ajouter;
    Button modifier;
    Button supprimer;
    ListView liste_projets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projets);

        liste_projets=findViewById(R.id.list_projets);
        ArrayList<String> list_proj = new ArrayList<String>();
        list_proj.add("JAVA");
        list_proj.add("WEB");
        list_proj.add("ANDROID");
        list_proj.add("C#");

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


    }
}
