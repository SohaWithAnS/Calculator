package io.sohaparasnis.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    String display = "";
    String currentOperator = "";
//    String result = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.textView); //allocating the TextView to an object 'screen'
        screen.setText(display); //to set the initial value on the screen as 0 (blank?) every time the app is launched.
    }

    public void UpdateScreen() {

        screen.setText(display);

    }

    //    for operands
    public void onClickNumber(View v) {

        Button b = (Button) v;
        display += b.getText();
        UpdateScreen();
    }
/*

public boolean isOperator(char op) {
switch (op) {
case '+':
case '-':
case 'X':
case '/':
return true;
default:
return false;
}
}
*/

    public void onClickOperator(View v) {

        Button b = (Button) v;

        if (display == "") {
            UpdateScreen();
            return;
        }

        display += b.getText();
        currentOperator = (String) b.getText();
        UpdateScreen();

    }


    public void onClickEqual(View v) {
        String equation = display;

        if(display == "") {
            UpdateScreen();
            return;
        }

        if (display.matches("\\d+?")){  //refer Android Dev documentation for 'regex/Pattern'
            UpdateScreen();
        }

        if (equation.contains("+")) {
            String t[] = equation.split("\\+");
            int num1 = Integer.parseInt(t[0]);
            int num2 = Integer.parseInt(t[1]);
            int r = num1 + num2;
            screen.setText("=".concat(Integer.toString(r)));
        } else if (equation.contains("-")) {
            String t[] = equation.split("\\-");
            int num1 = Integer.parseInt(t[0]);
            int num2 = Integer.parseInt(t[1]);
            int r = num1 - num2;
            screen.setText("=".concat(Integer.toString(r)));
        } else if (equation.contains("x")) {
            String t[] = equation.split("x");
            int num1 = Integer.parseInt(t[0]);
            int num2 = Integer.parseInt(t[1]);
            int r = num1 * num2;
            screen.setText("=".concat(Integer.toString(r)));
        } else {
            String t[] = equation.split("\\/");
            int num1 = Integer.parseInt(t[0]);
            int num2 = Integer.parseInt(t[1]);
            float r = num1 / num2;
            screen.setText("=".concat(Float.toString(r)));
        }

    }


    public void onClickClear(View v) {
        display = "";
        UpdateScreen();
    }


}
