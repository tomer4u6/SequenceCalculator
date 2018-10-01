package com.example.tomer.sequencecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText et_frst,et_dcr;
    RadioButton rb_a,rb_g;
    Button btn;
    double a1,d_q;
    Intent t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_frst = (EditText)findViewById(R.id.et_frst);
        et_dcr = (EditText)findViewById(R.id.et_dcr);
        rb_a = (RadioButton)findViewById(R.id.rb_a);
        rb_g = (RadioButton)findViewById(R.id.rb_g);
        btn = (Button)findViewById(R.id.btn);
    }

    public void nxt_act(View view) {
        t = new Intent(this, SecondActivity.class);
        if(!((et_frst.getText().toString().equals("."))||(et_frst.getText().toString().equals("-"))
        ||(et_frst.getText().toString().equals("-."))||(et_frst.getText().toString().equals(""))
        ||(et_dcr.getText().toString().equals("."))||(et_dcr.getText().toString().equals("-"))
        ||(et_dcr.getText().toString().equals("-."))||(et_dcr.getText().toString().equals(""))))
        {
            a1 = Double.parseDouble(et_frst.getText().toString());
            d_q = Double.parseDouble(et_dcr.getText().toString());
            t.putExtra("first",a1);
            t.putExtra("d/q",d_q);
            if(rb_a.isChecked()){
                t.putExtra("s",true);
                startActivity(t);
            }
            else if(rb_g.isChecked()){
                t.putExtra("s",false);
                startActivity(t);
            }
            else{
                Toast.makeText(this, "Please check an option", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Please enter valid input", Toast.LENGTH_SHORT).show();
        }
    }
}
