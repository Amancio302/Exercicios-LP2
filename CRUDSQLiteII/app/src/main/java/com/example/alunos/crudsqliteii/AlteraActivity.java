package com.example.alunos.crudsqliteii;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlteraActivity extends AppCompatActivity {

    EditText livro;
    EditText autor;
    EditText editora;
    Button alterar;
    Cursor cursor;
    BancoController crud;
    String codigo;
    Button deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        livro = (EditText) findViewById(R.id.editaTitulo);
        autor = (EditText) findViewById(R.id.editaAutor);
        editora = (EditText) findViewById(R.id.editaEditora);
        alterar = (Button) findViewById(R.id.butEdita);
        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TITULO)));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AUTOR)));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.EDITORA)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), livro.getText().toString(), autor.getText().toString(), editora.getText().toString());
                Intent intent = new Intent(AlteraActivity.this, ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button) findViewById(R.id.butDeletar);
        deletar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlteraActivity.this);
                builder.setTitle("Tem certeza?");
                builder.setMessage("Tem certeza?");
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(AlteraActivity.this, "Registro não Excluido", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(AlteraActivity.this, "Registro Excluido", Toast.LENGTH_SHORT).show();
                        crud.apagaRegistro(Integer.parseInt(codigo));
                        Intent intent = new Intent(AlteraActivity.this, ConsultaActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                AlertDialog alerta = builder.create();
                alerta.show();
            }
        });
    }
}
