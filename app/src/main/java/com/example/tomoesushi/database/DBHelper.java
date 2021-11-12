package com.example.tomoesushi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tomoesushi.models.User;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TomoeSushi";
    public static final int DATABASE_VERSION = 1;

    //TABELA USUARIO
    public static final String USUARIO_TABLE_NAME = "TBUsuario";
    public static final String USUARIO_COLUMN_ID = "idUsuario";
    public static final String USUARIO_COLUMN_NAME = "nomeUsuario";
    public static final String USUARIO_COLUMN_EMAIL = "emailUsuario";
    public static final String USUARIO_COLUMN_TEL = "telUsuario";
    public static final String USUARIO_COLUMN_SENHA = "senhaUsuario";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_USUARIO = "CREATE TABLE TBUsuario ( idUsuario INTEGER PRIMARY KEY, nomeUsuario  TEXT, " +
                "emailUsuario  TEXT,  telUsuario TEXT, senhaUsuario TEXT); ";

        db.execSQL(QUERY_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USUARIO_TABLE_NAME + ";" );
        onCreate(db);
    }

    //-----------------INSERTS----------------------------------------------------------------------
   public void addUsuario (User usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USUARIO_COLUMN_NAME, usuario.getNomeUser());
        values.put(USUARIO_COLUMN_EMAIL, usuario.getEmailUser());
        values.put(USUARIO_COLUMN_TEL, usuario.getTelUser());
        values.put(USUARIO_COLUMN_SENHA, usuario.getSenhaUser());

        db.insert(USUARIO_TABLE_NAME, null, values);
        db.close();
    }

    //-----------------UPDATES----------------------------------------------------------------------

    //----------------SELECTS ALL-------------------------------------------------------------------

    //----------------SELECT WHERE------------------------------------------------------------------
    public boolean autenticaUsuario(User usuario){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql_busca_usuario =
                "SELECT * FROM " + USUARIO_TABLE_NAME + " WHERE " + USUARIO_COLUMN_EMAIL + " = " + "'" + usuario.getNomeUser() + "'";
        Cursor c = db.rawQuery(sql_busca_usuario, null);
        while(c.moveToNext()){
            if(usuario.getNomeUser().equals(c.getString(c.getColumnIndex(USUARIO_COLUMN_EMAIL)))){
                if(usuario.getSenhaUser().equals(c.getString(c.getColumnIndex(USUARIO_COLUMN_SENHA)))){
                    return true;
                }

            }
        }
        db.close();
        c.close();

        return false;
    }

    public  boolean ValidacaoEmail(String string){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT ? FROM TBUsuario WHERE emailUsuario =?", new String[]{string,string});
        if(c.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    //----------------DELETE ALL--------------------------------------------------------------------

    //----------------DELETE WHERE------------------------------------------------------------------

}
