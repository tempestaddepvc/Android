package es.iessaladillo.pablorull.ej016_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Se crea el array de Strings con los datos.
    protected ArrayList<String> listaNombres;
    protected ArrayAdapter<String> adapter;
    protected ListView listMain;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        listMain=(ListView)findViewById(R.id.listMain);
        listaNombres=new ArrayList<String>();
        listaNombres.add("Baldomero");
        listaNombres.add("Germán Ginés");
        listaNombres.add("Rodolfo");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaNombres);
        listMain.setAdapter(adapter);
        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            OtraActivity.start((String)listaNombres.get((int)id),MainActivity.this,0);
            }
        });
    }


}
