package es.iessaladillo.pablorull.ej020_menusimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected EditText txtNombre;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre=(EditText)findViewById(R.id.txtNombre);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador = getMenuInflater();
        // Se infla la especificacion xml del menú (mimenu.xml) y
        // se almacena en el menú.
        inflador.inflate(R.menu.main_menu, menu);
        // Por si el sistema quiere añadir algún ítem de menú.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuSuspender:
                Toast.makeText(getApplicationContext(), String.format("Se ha suspendido a %s", txtNombre.getText().toString()), Toast.LENGTH_LONG).show();
                return true;
            case R.id.mnuAprobar:
                Toast.makeText(getApplicationContext(), String.format("Se ha aprobado a %s", txtNombre.getText().toString()), Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem mnuAprobar=menu.findItem(R.id.mnuAprobar);
        MenuItem mnuSuspender=menu.findItem(R.id.mnuSuspender);
        mnuSuspender.setTitle(String.format("¿Suspender a %s ?", txtNombre.getText().toString()));
        mnuAprobar.setTitle(String.format("¿Suspender a %s ?", txtNombre.getText().toString()));
        return super.onPrepareOptionsMenu(menu);
    }
}
