package com.mahui.xuliehua.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mahui.xuliehua.R;

/**
 *
 * @author 76047
 * @date 2018/8/14
 */

public class SecondParcelableActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_parcelable);
        text = findViewById(R.id.text);
        Intent intent = getIntent();
        Teacher mainBean = intent.getParcelableExtra("parcelable");
        Bundle bundle = getIntent().getExtras();
        Teacher mainBean1 = bundle.getParcelable("parcelable1");
        text.setText("intent获取的id:"+mainBean.getId()
                +"  normalStatus:"+mainBean.isNormalStatus()
                +"  gmtCreated:"+mainBean.getGmtCreated()
                +"  name:"+mainBean.getName()
                +"  price:"+mainBean.getPrice()
                +"  secondBean:"+mainBean.getSecondBean().getId()
                +"  secondBeanList:"+mainBean.getSecondBeanList().size()
                +"  numberArray:"+mainBean.getNumberArray().length
                +"  map:"+mainBean.getMap().get(1)
                +"  bundle获取的:"+mainBean1.getSecondBean().getId());
    }
}
