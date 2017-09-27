package com.example.alunos.crudsqliteii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alunos.crudsqliteii.BancoController;
import com.example.alunos.crudsqliteii.R;

public class InsereActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere);
        Button botao = (Button)findViewById(R.id.butSalvar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                BancoController crud = new BancoController(getBaseContext());
                EditText titulo = (EditText)findViewById(R.id.editTitulo);
                EditText autor = (EditText)findViewById(R.id.editAutor);
                EditText editora = (EditText)findViewById(R.id.editEditora);
                String tituloString = titulo.getText().toString();
                String autorString = autor.getText().toString();
                String editoraString = editora.getText().toString();
                String resultado;
                resultado = crud.insereDados(tituloString, autorString, editoraString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
