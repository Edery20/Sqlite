package facci.jordanpincha.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity {

    ListView listViewLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listViewLibros = findViewById(R.id.listViewLibros);
        // findViewById del boton

        //ListView o RecyclerView
        List<Book> books = Book.listAll(Book.class);
        List<String> listaTextoLibros = new ArrayList<>();

        for (Book libro : books)
        {
            Log.e("Libro",
                    libro.getTitle() + " " + libro.getEdition());
            listaTextoLibros.add(libro.getTitle() + " " + libro.getEdition());
        }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        listaTextoLibros);

        listViewLibros.setAdapter(itemsAdapter);

        //Book.deleteAll(Book.class);
    }
}
