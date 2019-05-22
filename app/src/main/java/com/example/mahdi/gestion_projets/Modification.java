package com.example.mahdi.gestion_projets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

public class Modification extends AppCompatActivity {
    DBProjet db=new DBProjet(this);
    TextView nom;
    Button modifier;
    Button supprimer;
    TextView id1;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        final Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        nom=findViewById(R.id.Titre);
       // String name=db.getProjetById(id).getNom();
        //nom.setText(name);
       // id1=findViewById(R.id.id);
       // id1.setText(id);

        modifier=findViewById(R.id.modifier_projet);
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Projet projet = new Projet(nom.getText().toString());
                db.UpdateProjet(projet);
                Intent intent1 = new Intent(Modification.this,Projets.class);
                startActivity(intent1);
            }
        });


        supprimer=findViewById(R.id.btn_supprimer);
        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.DeleteProjet(id);
                Toast.makeText(Modification.this,"deleted",Toast.LENGTH_SHORT);
                Intent intent = new Intent(Modification.this,Projets.class);
                startActivity(intent);
            }
        });

    }

}
