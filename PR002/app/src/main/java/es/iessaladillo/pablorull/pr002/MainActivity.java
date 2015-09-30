package es.iessaladillo.pablorull.pr002;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected EditText editText1;
    protected EditText editText2;
    protected TextView editText3;
    protected Button button1;
    protected Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }



    private void initViews() {
        editText1=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(TextView)findViewById(R.id.editText3);
        button1=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
    }

    public void mostrar1OnClick(View v){
        editText3.setText(getString(R.string.senior) + editText1.getText().toString() + ", " + editText2.getText().toString());
        button1.setEnabled(false);
        button2.setEnabled(true);
        Toast.makeText(this, "buhhh", Toast.LENGTH_SHORT).show();


    }
    public void mostrar2OnClick(View v){
        editText3.setText(getString(R.string.senior) + editText2.getText().toString() + ", " + editText1.getText().toString());
        button2.setEnabled(false);
        button1.setEnabled(true);
        Toast.makeText(this,"caca",Toast.LENGTH_SHORT).show();
    }
}
