package com.lecture.gl.week3calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    private String current_str="0.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.txt_result);
        result.setText(current_str);
        current_str = "";

    }

    public void perfomTask(View v){
        String s ="";
        Interpreter interpreter = new Interpreter();
        try {
            interpreter.eval("result = " + current_str);
            s= interpreter.get("result").toString();
            result.setText(s);
        } catch (EvalError evalError) {
            evalError.printStackTrace();
        }

        current_str = s;



    }

    public void calc(View view) {
        Button b = (Button)view;
        String pressed = b.getText().toString();
        current_str = current_str + pressed;
        result.setText(current_str);
    }
}
