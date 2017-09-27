package com.example.alunos.crudsqlite;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        BancoController crud  = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();
        String[] nomeCampos = new String[]{CriaBanco.ID, CriaBanco.TITULO};
        int[] idViews = new int[]{R.id.idLivro, R.id.nomeLivro};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.row_layout, cursor, nomeCampos, idViews, 0);
        ListView lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);
    }
}
