package sg.edu.rp.c346.mymodules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModuleDetailActivity extends AppCompatActivity {

    TextView tv;
    String text;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_detail);

        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);

        Intent receivedIntent = getIntent();
        final int mod = receivedIntent.getIntExtra("mod",0);
        if (mod == 1){
            text = "Module Code : C346\n" +
                    "Module Name : Android Programming\n" +
                    "Academic Year : 2019\n" +
                    "Semester : 1\n" +
                    "Module Credit : 4\n" +
                    "Venue : W66H";

        }
        else if (mod == 2){
            text ="Module Code : C382\n" +
                    "Module Name : IT Service Delivery\n" +
                    "Academic Year : 2019\n" +
                    "Semester : 1\n" +
                    "Module Credit : 4\n" +
                    "Venue : W66H";
        }
        else{
            text = "ERROR MODULE NOT FOUND";
        }
        tv.setText(text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("result",mod);
                setResult(RESULT_OK,intent);
                finish();
            }

        });

    }

}
