package com.cold.circlecornerprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CircleCornerProgressBar progress;
    private Button btnAdd;
    private Button btnDec;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (CircleCornerProgressBar) findViewById(R.id.progressbar);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnDec = (Button) findViewById(R.id.btn_dec);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress != null)
                    progress.setmProgress(++i);
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress != null)
                    progress.setmProgress(--i);
            }
        });
    }
}
