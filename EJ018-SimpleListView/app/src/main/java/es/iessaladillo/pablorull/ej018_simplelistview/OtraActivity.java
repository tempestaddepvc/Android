package es.iessaladillo.pablorull.ej018_simplelistview;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OtraActivity extends AppCompatActivity {

    private static final String EXTRA_NOMBRE ="023" ;
    protected TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        initViews();
    }

    private void initViews() {
        textView=(TextView)findViewById(R.id.textView);
        getDatosIniciales();

    }

    public static void start(String nombre,Activity activity,int requestCode) {
        Intent intent = new Intent(activity, OtraActivity.class);
        intent.putExtra(EXTRA_NOMBRE, nombre);
        activity.startActivityForResult(intent, requestCode);
    }
    private void getDatosIniciales() {
        Intent intent = this.getIntent();
        if (intent != null) {
            if (intent.hasExtra(EXTRA_NOMBRE)) {
                textView.setText(intent.getStringExtra(EXTRA_NOMBRE));

            }

        }
    }
}
