package com.example.mahdi.gestion_projets;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DBProjet extends SQLiteOpenHelper{


    private static final String DB_NAME= "dbprojet";
    private static final String TB_NAME= "projet";

    private static final int VERSION= 1;


    public DBProjet(Context context) {

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create ="CREATE TABLE "+TB_NAME+" ( id integer PRIMARY KEY , name VARCHAR(30)  );";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String delete=" DROP TABLE IF EXISTS "+TB_NAME;
        db.execSQL(delete);
        onCreate(db);

    }

    public void AjoutContact(Projet projet)
    {
        SQLiteDatabase db =getWritableDatabase();

        ContentValues values = new ContentValues();//ContentValues est un enregistrement
        values.put("name",projet.getNom());
        db.insert(TB_NAME,null,values);
    }


    public ArrayList<Projet> getAllContact()
    {
        ArrayList<Projet> contacts = new ArrayList<>();

        String query=" SELECT * FROM "+TB_NAME+";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {

                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Projet projet = new Projet(id,name);

                contacts.add(projet);

            }while (cursor.moveToNext());
        }

        return contacts;
    }


    public Projet getProjetById(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query=" SELECT * FROM "+TB_NAME+" WHERE id = "+id;
        Cursor cursor = db.rawQuery(query,null);
        Projet projet =null ;
        if (cursor.moveToFirst())
        {
            String name_c=cursor.getString(cursor.getColumnIndex("name"));


            projet= new Projet(id,name_c);
        }

        return projet;
    }

    public Projet UpdateProjet(Projet projet)
    {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",projet.getNom());


        db.update(TB_NAME,values,"id=?",new String[]{String.valueOf(projet.getId())});

        return projet;
    }

    public void DeleteContact(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TB_NAME,"id=?",new String[]{String.valueOf(id)});

    }



}
