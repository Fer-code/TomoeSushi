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
    //TABELA PRODUTO
    public static final String PRODUTO_TABLE_NAME = "TBProduto";
    public static final String PRODUTO_COLUMN_ID = "idProduto";
    public static final String PRODUTO_COLUMN_NAME = "nomeProduto";
    public static final String PRODUTO_COLUMN_PRECO = "precoProduto";
    public static final String PRODUTO_COLUMN_DESC = "descricaoProduto";
    public static final String PRODUTO_COLUMN_DF = "dataFabricacaoProduto";
    public static final String PRODUTO_COLUMN_DV = "dataValidadeProduto";
    public static final String PRODUTO_COLUMN_CAT = "categoriaProduto";
    public static final String PRODUTO_COLUMN_STATUS = "statusProduto";
    //TABELA PEDIDO
    public static final String PEDIDO_TABLE_NAME = "TBPedido";
    public static final String PEDIDO_COLUMN_ID = "idPedido";
    public static final String PEDIDO_COLUMN_QUANT = "quantidadePedido";
    public static final String PEDIDO_COLUMN_DATE = "dataPedido";
    public static final String PEDIDO_COLUMN_TIME = "horaPedido";
    public static final String PEDIDO_COLUMN_STATUS = "statusPedido";
    public static final String PEDIDO_COLUMN_SUBTOTAL = "subtotalPedido";
    //TABELA DELIVERY
    public static final String DELIVERY_TABLE_NAME = "TBDelivery";
    public static final String DELIVERY_COLUMN_ID = "idDelivery";
    public static final String DELIVERY_COLUMN_USER = "idUserDel";
    public static final String DELIVERY_COLUMN_PED = "idPedDel";
    public static final String DELIVERY_COLUMN_BAIRRO = "bairroDelivery";
    public static final String DELIVERY_COLUMN_LOG = "logradouroDelivery";
    public static final String DELIVERY_COLUMN_CEP = "CEPDelivery";
    public static final String DELIVERY_COLUMN_NUM = "numeroDelivery";
    //TABELA MESA
    public static final String MESA_TABLE_NAME = "TBMesa";
    public static final String MESA_TABLE_ID = "idMesa";
    public static final String MESA_TABLE_NUMCHAIR = "numAssentosMesa";
    public static final String MESA_TABLE_NUMMESA = "numMesa";
    public static final String MESA_TABLE_STATUS = "statusMesa";
    //TABELA RESERVA
    public static final String RESERVA_TABLE_NAME = "TMReserva";
    public static final String RESERVA_COLUMN_ID = "idReserva";
    public static final String RESERVA_COLUMN_USER = "idUserRes";
    public static final String RESERVA_COLUMN_MESA = "idMesaRes";
    public static final String RESERVA_COLUMN_NUMPEOPLE = "numPeopleRes";
    public static final String RESERVA_COLUMN_DATE = "dataReserva";
    public static final String RESERVA_COLUMN_TIME = "horaReserva";
    //TABELA PAGAMENTO
    public static final String PAGAMENTO_TABLE_NAME = "TBPagamento";
    public static final String PAGAMENTO_COLUMN_ID = "idPagamento";
    public static final String PAGAMENTO_COLUMN_PED = "idPedPag";
    public static final String PAGAMENTO_COLUMN_CPF = "cpfPagamento";
    public static final String PAGAMENTO_COLUMN_TOTAL = "totalPagamento";
    public static final String PAGAMENTO_COLUMN_TROCO = "trocoPagamento";
    public static final String PAGAMENTO_COLUMN_TYPE = "tipoPagamento";


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //-----------------INSERTS----------------------------------------------------------------------

    //-----------------UPDATES----------------------------------------------------------------------

    //----------------SELECTS ALL-------------------------------------------------------------------

    //----------------SELECT WHERE------------------------------------------------------------------

    //----------------DELETE ALL--------------------------------------------------------------------

    //----------------DELETE WHERE------------------------------------------------------------------

}
