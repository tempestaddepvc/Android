package es.iessaladillo.pablorull.pr013;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OtraActivity extends AppCompatActivity {
    public static final String STRING_EXTRA ="" ;
    protected TextView textView;
    protected String mTexto;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        Intent intencion=getIntent();
        mTexto=intencion.getStringExtra(STRING_EXTRA);
        initViews();
    }

    private void initViews() {
        textView=(TextView) findViewById(R.id.textView);
        textView.setText(mTexto);
    }


}
