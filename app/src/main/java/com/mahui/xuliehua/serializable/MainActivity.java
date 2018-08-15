package com.mahui.xuliehua.serializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mahui.xuliehua.R;

/**
 * @author 76047
 */
public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        final User user = new User();
        user.setId(1);
        user.setUsername("小红");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("user",user);
                Bundle bundle = intent.getExtras();
                bundle.putSerializable("user1",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
