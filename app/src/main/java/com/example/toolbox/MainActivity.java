package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView view = (ImageView) findViewById(R.id.imageView2);
        view.setImageResource(R.drawable.blank);
        mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setOnCheckedChangeListener(this);

        //SPINNER CODE: https://www.tutorialspoint.com/android/android_spinner_control.htm
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Red");
        categories.add("Orange");
        categories.add("Yellow");
        categories.add("Green");
        categories.add("Blue");
        categories.add("Purple");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void onCheckbox1Clicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        TextView textView = (TextView) findViewById(R.id.checkAnswer);
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox1:
                if (checked) {
                    textView.setText("That's right! Great job!");
                }
        }

    }

    public void onCheckbox2Clicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        TextView textView = (TextView) findViewById(R.id.checkAnswer);
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox2:
                if (checked) {
                    textView.setText("That's wrong! Try again!");
                }
        }

    }

    public void onCheckbox3Clicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        TextView textView = (TextView) findViewById(R.id.checkAnswer);
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox3:
                if (checked) {
                    textView.setText("That's right! Great job!");
                }
        }

    }

    public void radioButton1(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        // Check which RadioButton was clicked
        TextView text = (TextView) findViewById(R.id.checkAns);
        switch (v.getId()) {
            case R.id.radioButton:
                if (checked)
                    text.setText("That's wrong! Try again!");
        }

    }

    public void radioButton2(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        // Check which RadioButton was clicked
        TextView text = (TextView) findViewById(R.id.checkAns);
        switch (v.getId()) {
            case R.id.radioButton2:
                if (checked)
                    text.setText("That's right! Great job!");
        }
    }

    public void radioButton3(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        // Check which RadioButton was clicked
        TextView text = (TextView) findViewById(R.id.checkAns);
        switch (v.getId()) {
            case R.id.radioButton3:
                if (checked)
                    text.setText("That's wrong! Try again!");
        }
    }

//https://stackoverflow.com/questions/11278507/android-widget-switch-on-off-event-listener

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        boolean isChecked = ((Switch) compoundButton).isChecked();
        ImageView view = (ImageView) findViewById(R.id.imageView2);
        if (isChecked)
            view.setImageResource(R.drawable.gilbert_stuart_williamstown_portrait_of_george_washington_promo);
        else
            view.setImageResource(R.drawable.blank);

    }

    public void calculateScore(View v)
    {
        TextView text = (TextView) findViewById(R.id.checkAns);
        TextView textView = (TextView) findViewById(R.id.checkAnswer);
        TextView score = (TextView) findViewById(R.id.score);
        if (text.equals("That's right! Great job!") && textView.equals("That's right! Great job!"))
        {
            score.setText("You got 100%!!!");
        }
        else if (text.equals("That's wrong! Try again!") && textView.equals("That's right! Great job!"))
        {
            score.setText("You got 50%! Better luck next time!");
        }
        else if (text.equals("That's right! Great job!") && textView.equals("That's wrong! Try again!"))
        {
            score.setText("You got 50%! Better luck next time!");
        }
        else if (text.equals("That's wrong! Try again!") && textView.equals("That's wrong! Try again!"))
        {
            score.setText("You got 0%! Yikes!");
        }
        else
        {
            score.setText("You didn't answer one or more questions.");
        }

    }
}

