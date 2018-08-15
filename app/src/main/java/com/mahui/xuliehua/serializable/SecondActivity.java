package com.mahui.xuliehua.serializable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.mahui.xuliehua.R;

/**
 * @author 76047
 */
public class SecondActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text = findViewById(R.id.text);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        User user= (User) intent.getSerializableExtra("user");
        User user1 = (User) bundle.getSerializable("user1");
        text.setText("intent获取的user:"+user.getUsername()+"    bundle获取的user1:"+user1.getUsername());
    }
}
