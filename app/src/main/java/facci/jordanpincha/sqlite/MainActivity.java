package facci.jordanpincha.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etTitulo, etEdicion, etID;
    Button btnGuadar, btnEliminar, btnModificar, btnMostrarLista, btnConsultaIndividual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = (EditText) findViewById(R.id.etID);
        etTitulo = (EditText) findViewById(R.id.etTitulo);
        etEdicion = (EditText) findViewById(R.id.etEdicion);

        //Create
        btnGuadar = (Button) findViewById(R.id.btnGuardar);
        //DELETE
        btnEliminar = ( Button) findViewById(R.id.btnEliminar);
        //UPDATE
        btnModificar = (Button) findViewById(R.id.btnModificar);
        //READ
        btnMostrarLista = (Button) findViewById(R.id.btnMostrarLista);
        btnConsultaIndividual = (Button) findViewById(R.id.btnConsultaIndividual);

        btnGuadar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book registro1 = new Book( etTitulo.getText().toString(),
                        etEdicion.getText().toString());
                registro1.save();
            }
        });
        btnConsultaIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(Book.class,
                        Long.parseLong(etID.getText().toString()));
                etTitulo.setText(book.getTitle());
                etEdicion.setText(book.getEdition());

            }
        });

        btnMostrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Listado.class);
                startActivity(intent);
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(Book.class, Long.parseLong(etID.getText().toString()));
                book.title = "updated title here"; // modify the values
                book.edition = "3rd edition";
                book.save();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = Book.listAll(Book.class);
                Book.deleteAll(Book.class);
            }
        });

        //Formulario
        /*Book registro1 = new Book("Java for Ddumies",  "First Edition ");
        registro1.save();
        Book registro2 = new Book("Mongo DB ", "Thir Edition");
        registro2.save();
        Book registro3 = new Book("PostgreSQL ", "Second Edition");
        registro3.save();*/





        /*Book book = new Book("Titulo", "Edition");
        book.save();

        Log.e("GUARDADO", "DATOS GUARDADOS");

        Book libro = Book.findById(
             Book.class, Long.parseLong("1"));*/



    }
}
