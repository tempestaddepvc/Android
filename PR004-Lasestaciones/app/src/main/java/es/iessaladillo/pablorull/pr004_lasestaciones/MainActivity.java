package es.iessaladillo.pablorull.pr004_lasestaciones;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected ImageView imageView;
    protected Button button;
    protected RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    protected void initViews() {
        imageView = (ImageView) this.findViewById(R.id.imageView);
        button = (Button) this.findViewById(R.id.btnMeGusta);
        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroupEstaciones);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (radioGroup.getCheckedRadioButtonId()) {

                    case R.id.rdbtnPrimavera:
                        imageView.setImageResource(R.drawable.primavera);
                        break;
                    case R.id.rdbtnVerano:
                        imageView.setImageResource(R.drawable.verano);
                        break;
                    case R.id.rdbtnOtonio:
                        imageView.setImageResource(R.drawable.otonio);
                        break;
                    case R.id.rdbtnInvierno:
                        imageView.setImageResource(R.drawable.invierno);
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String auxiliar = "";
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rdbtnPrimavera:
                        auxiliar = getString(R.string.laPrimavera);
                        break;
                    case R.id.rdbtnVerano:
                        auxiliar = getString(R.string.elVerano);
                        break;
                    case R.id.rdbtnOtonio:
                        auxiliar = getString(R.string.elOtonio);
                        break;
                    case R.id.rdbtnInvierno:
                        auxiliar = getString(R.string.elInvierno);
                        break;
                }
                Toast.makeText(getApplicationContext(), getString(R.string.meGusta) +" "+ auxiliar, Toast.LENGTH_LONG).show();
            }


        });

    }
}