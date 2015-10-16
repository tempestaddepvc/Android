package es.iessaladillo.pablorull.pr014_intentyresult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OtraActivity extends AppCompatActivity {

    public static final String EXTRA_DNI ="dni" ;
    public static final String NOMBRE = "nombre";
    public static final String EDAD ="edad" ;

    protected EditText txtDNI;
    protected EditText txtNombre;
    protected EditText txtEdad;
    protected Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        initViews();
        getDatosIniciales();
    }
    private void initViews() {

        txtDNI = (EditText)findViewById(R.id.txtDNI);
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtEdad= (EditText)findViewById(R.id.txtEdad);
        btnEnviar=(Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();

            }
        });
    }
    private void getDatosIniciales() {
        Intent intent = this.getIntent();
        if (intent != null) {
            if (intent.hasExtra(EXTRA_DNI)) {
                txtDNI.setText(intent.getStringExtra(EXTRA_DNI));
            }

        }
    }

    public static void start(String dni,Activity activity,int requestCode) {
        Intent intent = new Intent(activity, OtraActivity.class);
        intent.putExtra(EXTRA_DNI, dni);

        activity.startActivityForResult(intent, requestCode);
    }
    public void finish() {

        Intent resultado = new Intent();
        resultado.putExtra(NOMBRE, txtNombre.getText().toString());
        resultado.putExtra(EDAD, txtEdad.getText().toString());
        setResult(RESULT_OK, resultado);

        super.finish();
    }
}
