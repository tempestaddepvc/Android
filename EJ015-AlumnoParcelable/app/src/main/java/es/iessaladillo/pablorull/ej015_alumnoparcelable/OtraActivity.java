package es.iessaladillo.pablorull.ej015_alumnoparcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class OtraActivity extends AppCompatActivity {
    public static final String EXTRA_ALUMNO ="alumno" ;
    public static final String EXTRA_ALUMNO_OTRA = "nombre";
    public static final String EDAD ="edad" ;
    protected String[] mSexos;
    protected ArrayAdapter<String> adaptador;
    protected Alumno mAlumno;
    protected EditText txtDNI;
    protected EditText txtNombre;
    protected EditText txtEdad;
    protected Button btnEnviar;
    protected Spinner spinnerSexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        mSexos = getResources().getStringArray(R.array.sexo);
        adaptador= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mSexos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        initViews();

        getDatosIniciales();
        if(savedInstanceState!=null){
            mAlumno=savedInstanceState.getParcelable("alumno");
            escribirAlumno();
        }
        else{
            mAlumno=new Alumno();
        }
    }
    private void initViews() {
        spinnerSexo =(Spinner) findViewById(R.id.spinnerSexo);
        spinnerSexo.setAdapter(adaptador);
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
            if (intent.hasExtra(EXTRA_ALUMNO)) {
               mAlumno = intent.getParcelableExtra(EXTRA_ALUMNO);
                txtDNI.setText(mAlumno.getDni());
            }

        }
    }

    public static void start(Alumno alumno,Activity activity,int requestCode) {
        Intent intent = new Intent(activity, OtraActivity.class);
        intent.putExtra(EXTRA_ALUMNO, alumno);
        activity.startActivityForResult(intent, requestCode);
    }
    public void finish() {
        Intent resultado = new Intent();
        mAlumno.setNombre(txtNombre.getText().toString());
        mAlumno.setEdad(txtEdad.getText().toString());
        mAlumno.setSexo(mSexos[(int)spinnerSexo.getSelectedItemId()]);
        resultado.putExtra(EXTRA_ALUMNO_OTRA, mAlumno);
        setResult(RESULT_OK, resultado);

        super.finish();
    }
    protected void escribirAlumno(){
        txtDNI.setText(mAlumno.getDni());
        txtEdad.setText(mAlumno.getEdad());
        txtNombre.setText(mAlumno.getNombre());

    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelable("alumno", mAlumno);
    }

}
