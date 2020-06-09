package br.com.local.AppAluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criando o esquema de banco de dados. Criando o banco de dados
            SQLiteDatabase bd = openOrCreateDatabase("dbAlunoCriar ", MODE_PRIVATE, null);

            //Criar a tabela do banco de dados
            bd.execSQL("CREATE TABLE IF NOT EXISTS  tbAlunos (nome VARCHAR,email Varchar,telefone INT(3))");

            //Inserindo dados na tabela
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Carlos','carlos@gmail.com',98545-4697)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Augusto','augusto@gmail.com',95684-8745)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Rogério','rogerio@gmail.com',99865-4697)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Eduardo','eduardo@gmail.com',95684-5845)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('William','william@gmail.com',98785-4327)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Marcos','marcos@gmail.com',95984-8784)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Gabriel','gabriel@gmail.com',95945-4597)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Matheus','matheus@gmail.com',95724-7845)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Fábio','fabio@gmail.com',98685-9897)");
            bd.execSQL("INSERT INTO tbAlunos(nome,email,telefone)VALUES('Lucas','lucas@gmail.com',95489-5745)");


            //Buscando os dados na tabela
            Cursor cursor = bd.rawQuery("SELECT nome, email, telefone FROM tbAlunos", null);


            //Qual a coluna que estou pegando os valores
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            //Vai guiar o cursor para frente da tabela inteira
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));
                //Guiar o cursor para frente de cada registro
                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
