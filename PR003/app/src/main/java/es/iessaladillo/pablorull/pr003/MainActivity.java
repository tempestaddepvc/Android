package es.iessaladillo.pablorull.pr003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    protected EditText editText1;
    protected CheckBox checkBox1;
    protected void initViews(){
        editText1=(EditText)findViewById(R.id.editText);
        checkBox1=(CheckBox)findViewById(R.id.checkBox);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
