package com.example.alunos.listadinamica;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.alunos.listadinamica.model.Pessoa;
import com.example.alunos.listadinamica.model.adapter.PessoaAdapter;

import java.util.ArrayList;

public class mostraListaDinamica extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mostra_lista_dinamica);

//        ListView listview = (ListView) findViewById(R.id.listview);

        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        lista.add(new Pessoa("Peter", "3690-1234", 12));
        lista.add(new Pessoa("John", "3690-1233", 18));

        setListAdapter(new PessoaAdapter(this, lista));
    }
}
