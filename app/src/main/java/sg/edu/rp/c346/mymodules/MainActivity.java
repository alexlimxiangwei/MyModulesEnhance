package sg.edu.rp.c346.mymodules;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    TextView tv;
    int prev;
    String resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnMod1);
        btn2 = findViewById(R.id.btnMod2);
        tv = findViewById(R.id.tvTest);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ModuleDetailActivity.class);
                intent.putExtra("mod", 1);
                startActivityForResult(intent,1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ModuleDetailActivity.class);
                intent.putExtra("mod", 2);
                startActivityForResult(intent,2);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ModuleDetailActivity.class);
                intent.putExtra("mod", prev);
                startActivity(intent);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
        super.onActivityResult(requestCode, resultCode, resultIntent);
        if (resultCode == RESULT_OK){
            int mod = resultIntent.getIntExtra("mod",0);
            if(mod == 1) {
                resultText = getString(R.string.btnModule1);

            }
            else if (mod == 2){
                resultText = getString(R.string.btnModule2);
            }
            tv.setText("Back to previous module: " + resultText);
            prev = mod;
        }
    }
}
