package es.iessaladillo.pablorull.pr012_ciclovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_CONTADOR ="Estado del contador";
    protected TextView lblContador;
    protected Button btnSumaContador;
    protected int mContador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            mContador=savedInstanceState.getInt(STATE_CONTADOR);
        }
        setContentView(R.layout.activity_main);
        initViews();
    }
    protected void initViews(){
        lblContador=(TextView) findViewById(R.id.lblContador);
        lblContador.setText(mContador+"");
        btnSumaContador=(Button) findViewById(R.id.btnSumaContador);
        btnSumaContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContador++;
                lblContador.setText(mContador + "");

            }
        } );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_CONTADOR,mContador);
    }

}