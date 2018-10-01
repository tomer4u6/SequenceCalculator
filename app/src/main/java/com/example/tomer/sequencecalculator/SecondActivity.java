package com.example.tomer.sequencecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Intent t;
    TextView tv1,tv2,tv3,tv4;
    double a1;
    double d_q;
    boolean s;
    String[] seq = new String[20];
    ListView lv;
    double sum,n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        lv = (ListView)findViewById(R.id.lv);
        if(getIntent()!=null){
            t = getIntent();
            s = t.getExtras().getBoolean("s");
            if(s)
                tv2.setText("d=");
            else
                tv2.setText("q=");
            a1=t.getExtras().getDouble("first",9.99997);
            d_q=t.getExtras().getDouble("d/q",9.99997);
            tv1.setText("a1= "+Double.toString(a1));
            tv2.setText(tv2.getText()+" "+Double.toString(d_q));
            seq[0]=Double.toString(a1);
            if (s){
                for(int i=1;i<20;i++){
                    seq[i] = Double.toString(Double.parseDouble(seq[i-1])+d_q);
                }
            }
            else{
                for(int i=1;i<20;i++){
                    seq[i] = Double.toString(Double.parseDouble(seq[i-1])*d_q);
                }
            }
        }
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, seq);
        lv.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        n = i+1;
        tv3.setText("n= "+Double.toString(n));
        if(s){
            sum = ((n*((2*a1)+d_q*(n-1)))/2);
        }
        else {
            if(d_q==1)
                sum = a1*n;
            else
                sum = ((a1 * ((Math.pow(d_q, n)) - 1)) / (d_q - 1));
        }
        tv4.setText(Double.toString(sum));
    }

    public void back(View view) {
        Intent b = new Intent(this, MainActivity.class);
        startActivity(b);
    }
}
