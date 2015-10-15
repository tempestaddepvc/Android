package es.iessaladillo.pablorull.pr013;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String STRING_EXTRA ="" ;
    protected Button btn;
    protected EditText txt;
    protected Button btnMostrarEnOtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        txt=(EditText) findViewById(R.id.txt);
        btn=(Button) findViewById(R.id.btn);
        btnMostrarEnOtra = (Button) findViewById(R.id.btnMostrarEnOtra);
        btnMostrarEnOtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirOtra(txt.getText().toString());

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar(txt.getText().toString());

            }
        });
    }
    public void abrirOtra(String mensaje){
        Intent intencion = new Intent(this, OtraActivity.class);
        intencion.putExtra(STRING_EXTRA, mensaje);
        startActivity(intencion);
    }
    public void enviar(String mensaje){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, mensaje);
        startActivity(intent);


    }

}
