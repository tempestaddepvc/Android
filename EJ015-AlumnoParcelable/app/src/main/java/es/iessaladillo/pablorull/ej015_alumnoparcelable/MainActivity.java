package es.iessaladillo.pablorull.ej015_alumnoparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
        protected EditText txtDNI;
        protected EditText txtNombre;
        protected EditText txtEdad;
        protected Button btnObtener;
        protected EditText txtSexo;

        protected final  int REQUEST_CODE = 0;
        protected Alumno mAlumno;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initViews();
            if(savedInstanceState!=null){
            mAlumno=savedInstanceState.getParcelable("alumno");
                escribirAlumno();
            }
            else{
                mAlumno=new Alumno();
            }
        }

        private void initViews() {
            txtSexo=(EditText)findViewById(R.id.txtSexo);
            txtDNI = (EditText)findViewById(R.id.txtDNI);
            txtDNI.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(!txtDNI.getText().toString().isEmpty()){
                        btnObtener.setEnabled(true);
                    }
                    if(txtDNI.getText().toString().isEmpty()){
                        btnObtener.setEnabled(false);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            txtNombre = (EditText)findViewById(R.id.txtNombre);
            txtEdad= (EditText)findViewById(R.id.txtEdad);
            btnObtener=(Button) findViewById(R.id.btnObtener);
            btnObtener.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAlumno.setDni(txtDNI.getText().toString());
                    OtraActivity.start(mAlumno, MainActivity.this, REQUEST_CODE);
                }
            });
            btnObtener.setEnabled(false);}
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            // Si el resultado es satisfactorio.
            if (resultCode == RESULT_OK) {
                // Depeniendo del código de petición (Request Code)
                if(requestCode==REQUEST_CODE){
                    getDatosResult(data);
                }
            }
        }

        private void getDatosResult(Intent data) {
            if(data!=null){
                if(data.hasExtra(OtraActivity.EXTRA_ALUMNO_OTRA)){
                    mAlumno= data.getParcelableExtra(OtraActivity.EXTRA_ALUMNO_OTRA);
                    escribirAlumno();
                }
            }

        }
    protected void escribirAlumno(){
        txtDNI.setText(mAlumno.getDni());
        txtEdad.setText(mAlumno.getEdad());
        txtNombre.setText(mAlumno.getNombre());
        txtSexo.setText(mAlumno.getSexo());

    }
     public void onSaveInstanceState(Bundle savedInstanceState){
            super.onSaveInstanceState(savedInstanceState);
         savedInstanceState.putParcelable("alumno",mAlumno);
        }

    }
