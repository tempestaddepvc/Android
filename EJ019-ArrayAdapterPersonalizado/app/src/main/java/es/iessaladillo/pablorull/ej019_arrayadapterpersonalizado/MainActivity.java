package es.iessaladillo.pablorull.ej019_arrayadapterpersonalizado;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Se crea el array de Strings con los datos.
    protected ArrayList<Alumno> listaAlumnos;
    protected AdaptadorAlumnos adaptadorAlumnos;
    protected ListView listMain;
    protected Alumno baldomero=new Alumno("Baldomero",25,"777777");
    protected Alumno esutaquio=new Alumno("eustaquio",25,"777777");
    protected Alumno germangines=new Alumno("Germán Ginés",17,"777777");
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        listMain=(ListView)findViewById(R.id.listMain);
        listaAlumnos=new ArrayList<Alumno>();
        listaAlumnos.add(baldomero);
        listaAlumnos.add(esutaquio);
        listaAlumnos.add(germangines);
        adaptadorAlumnos = new AdaptadorAlumnos(this,
                 listaAlumnos);
        listMain.setAdapter(adaptadorAlumnos);
        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


}
