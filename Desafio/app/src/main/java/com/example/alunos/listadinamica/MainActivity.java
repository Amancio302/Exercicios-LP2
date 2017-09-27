package com.example.alunos.listadinamica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.alunos.listadinamica.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Pessoa> dados = new ArrayList<Pessoa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showList(View v) {
        Intent it = new Intent(this, mostraListaDinamica.class);
        it.putParcelableArrayListExtra("dados",dados);
        startActivity(it);

    }

    public void cadastrar(View v){
        EditText v1 = (EditText) findViewById(R.id.editNome);
        String nome = v1.getText().toString();
        EditText v2 = (EditText) findViewById(R.id.editTelefone);
        String telefone = v2.getText().toString();
        EditText v3 = (EditText) findViewById(R.id.editIdade);
        int idade = Integer.parseInt(v3.getText().toString());
        dados.add(new Pessoa(nome, telefone, idade));
    }
}
