package com.example.alunos.crudsqliteii;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alunos.crudsqliteii.R;

public class ConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        BancoController crud  = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();
        String[] nomeCampos = new String[]{CriaBanco.ID, CriaBanco.TITULO};
        int[] idViews = new int[]{R.id.idLivro, R.id.nomeLivro};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.row_layout, cursor, nomeCampos, idViews, 0);
        ListView lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView . OnItemClickListener (){
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id){
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow (CriaBanco.ID));
                Intent intent = new Intent(ConsultaActivity. this, AlteraActivity. class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}
