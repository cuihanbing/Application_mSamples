package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.M_view.M_Top_Bar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//以下必须实现，否则报错
        M_Top_Bar m_top_bar=(M_Top_Bar) findViewById(R.id.mtopbar);

        m_top_bar.setOnmTopBarClickListener(new M_Top_Bar.MtopbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(getApplicationContext(),"左边",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void rightClick() {
                Toast.makeText(getApplicationContext(),"右边",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
