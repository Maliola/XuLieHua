package com.mahui.xuliehua.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mahui.xuliehua.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 76047
 * @date 2018/8/14
 */

public class FirstParcelableActivity extends AppCompatActivity {
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_parcelable);
        text = findViewById(R.id.text);
        final Teacher mainBean = new Teacher();
        mainBean.setId(0);
        mainBean.setNormalStatus(false);
        mainBean.setGmtCreated(100L);
        mainBean.setName("小敏");
        mainBean.setPrice(new BigDecimal("1.34"));
        Student secondBean = new Student();
        secondBean.setId(26);
        mainBean.setSecondBean(secondBean);
        List<Student> list = new ArrayList<>();
        list.add(secondBean);
        list.add(secondBean);
        list.add(secondBean);
        list.add(secondBean);
        mainBean.setSecondBeanList(list);
        mainBean.setNumberArray(new int[]{1,2,3,4,5});
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","小红");
        map.put("2","小白");
        map.put("3","小黄");
        mainBean.setMap(map);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstParcelableActivity.this,SecondParcelableActivity.class);
                intent.putExtra("parcelable",mainBean);
                Bundle bundle = intent.getExtras();
                bundle.putParcelable("parcelable1",mainBean);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
