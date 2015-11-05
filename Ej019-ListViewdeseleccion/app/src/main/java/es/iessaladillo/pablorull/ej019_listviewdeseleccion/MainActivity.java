package es.iessaladillo.pablorull.ej019_listviewdeseleccion;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String ESTADO_ADAPTADOR = "estadoAdaptador";
    private static final String ESTADO_LISTA= "estadoLista";
    protected ArrayList<String> listaNombres;
    protected ArrayAdapter<String> adapter;
    protected ListView listMain;
    protected EditText txtNombre;
    protected Button btnContestar;

    protected Parcelable estadoAdaptador;
    protected ImageView imagen;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            listaNombres=new ArrayList<String>();
        }
        else{
            listaNombres=savedInstanceState.getStringArrayList(ESTADO_LISTA);
        }
        initViews();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Se obtiene un objeto inflador de menús.
        MenuInflater inflador = getMenuInflater();
        // Se infla la especificacion xml del menú (mimenu.xml) y
        // se almacena en el menú.
        inflador.inflate(R.menu.menu_main, menu);
        // Por si el sistema quiere añadir algún ítem de menú.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    private void initViews() {
        listMain=(ListView)findViewById(R.id.listMain);
        listMain.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listaNombres.add("Blanco");
        listaNombres.add("Azul");
        listaNombres.add("Multicolor");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, listaNombres);

        listMain.setAdapter(adapter);
        imagen=(ImageView)findViewById(R.id.imageView);
        Picasso.with(this).load("http://lorempixel.com/50/50/").into(imagen);
        btnContestar=(Button)findViewById(R.id.btnContestar);
        btnContestar.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if(listMain.getSelectedItem().toString().equals("Blanco")){
                                                    Toast.makeText(getApplicationContext(),"¡Has ganado!",Toast.LENGTH_LONG).show();
                                                }

                                            }
                                        }
        );
}
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        estadoAdaptador = listMain.onSaveInstanceState();
        outState.putParcelable(ESTADO_ADAPTADOR, estadoAdaptador);
        outState.putStringArrayList(ESTADO_LISTA,listaNombres);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Se obtiene el estado anterior de la lista.
        estadoAdaptador = savedInstanceState.getParcelable(ESTADO_ADAPTADOR);
    }
    protected void onResume() {
        super.onResume();

        if (estadoAdaptador != null) {
            listMain.onRestoreInstanceState(estadoAdaptador);
        }
    }

}


