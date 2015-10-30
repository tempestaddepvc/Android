package es.iessaladillo.pablorull.ej018_simplelistview;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String ESTADO_ADAPTADOR = "estadoAdaptador";
    private static final String ESTADO_LISTA= "estadoLista";
    protected ArrayList<String> listaNombres;
    protected ArrayAdapter<String> adapter;
    protected ListView listMain;
    protected EditText txtNombre;
    protected Button btnAniadir;
    protected Parcelable estadoAdaptador;
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

    private void initViews() {
        listMain=(ListView)findViewById(R.id.listMain);
        listMain.setEmptyView(findViewById(R.id.NoHayAlumnos));

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaNombres);
        listMain.setAdapter(adapter);
        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OtraActivity.start((String) listaNombres.get((int) id), MainActivity.this, 0);
            }
        });
        listMain.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.remove(adapter.getItem(position));
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        txtNombre=(EditText) findViewById(R.id.txtNombre);
        btnAniadir=(Button) findViewById(R.id.btnAniadir);
        btnAniadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add(txtNombre.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });}
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



