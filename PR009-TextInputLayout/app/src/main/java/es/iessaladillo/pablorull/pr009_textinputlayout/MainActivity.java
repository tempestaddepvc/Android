package es.iessaladillo.pablorull.pr009_textinputlayout;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

   protected void initViews(){
       final TextInputLayout tilName =(TextInputLayout) findViewById(R.id.textInputLayoutNombre);
       final EditText editTextNombre =(EditText) findViewById(R.id.txtNombre);
       Button snackBtn =(Button) findViewById(R.id.snackBtn);
       final LinearLayout llRaiz =(LinearLayout) findViewById(R.id.llRaiz);

       editTextNombre.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(editTextNombre.getText().toString())){
                    if(editTextNombre.getText().toString().matches("[A-ZÑ]{1}.*")){
                       tilName.setErrorEnabled(false);
                    }else{
                        tilName.setError("El nombre debe empezar en mayúscula");
                    }
                }else{
                    tilName.setErrorEnabled(false);
                }
           }
       });

       snackBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Snackbar.make(llRaiz, "TÓCAME", Snackbar.LENGTH_LONG).setAction("Jeje", new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       editTextNombre.setText("HAHAHAAHAAAHA");
                   }
               }).show();
           }
       });
   }

}
