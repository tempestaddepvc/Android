package es.iessaladillo.pablorull.pr009_textinputlayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   protected void initViews(){
       final TextInputLayout tilName =(TextInputLayout) findViewById(R.id.textInputLayoutNombre);
       final EditText editTextNombre =(EditText) findViewById(R.id.txtNombre);
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
                    if(editTextNombre.getText().toString().matches("[A-ZÑ]")){
                       tilName.setErrorEnabled(false);
                    }else{
                        tilName.setError("El nombre debe empezar en mayúscula");
                    }
                }else{
                    tilName.setErrorEnabled(false);
                }
           }
       });
   }

}
