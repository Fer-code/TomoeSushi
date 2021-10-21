package com.example.tomoesushi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
