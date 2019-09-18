package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
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
        ImageView view2 = (ImageView) findViewById(R.id.imageView);
        view2.setImageResource(R.drawable.blank);
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
        ConstraintLayout la = (ConstraintLayout) findViewById(R.id.layout);
        String item = parent.getItemAtPosition(position).toString();
        if (item.equals("Red"))
        {
            la.setBackgroundColor(Color.RED);
        }
        else if (item.equals("Orange"))
        {
            la.setBackgroundColor(Color.parseColor("#FFA500"));
        }
        else if (item.equals("Yellow"))
        {
            la.setBackgroundColor(Color.YELLOW);
        }
        else if (item.equals("Green"))
        {
            la.setBackgroundColor(Color.GREEN);
        }
        else if (item.equals("Blue"))
        {
            la.setBackgroundColor(Color.BLUE);
        }
        else if (item.equals("Purple"))
        {
            la.setBackgroundColor(Color.MAGENTA);
        }




        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
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
        ImageView view = (ImageView) findViewById(R.id.imageView);
        ImageView view2 = (ImageView) findViewById(R.id.imageView2);
        if (isChecked) {
            view.setImageResource(R.drawable.gilbert_stuart_williamstown_portrait_of_george_washington_promo);
            view2.setImageResource(R.drawable.download);
        }
            else {
            view.setImageResource(R.drawable.blank);
            view2.setImageResource(R.drawable.blank);
        }
    }

    public void checkAnswer(View v)
    {
        CheckBox cb1 = findViewById(R.id.checkBox1);
        CheckBox cb2 = findViewById(R.id.checkBox2);
        CheckBox cb3 = findViewById(R.id.checkBox3);
        boolean check1 = (cb1).isChecked();
        boolean check2 = (cb2).isChecked();
        boolean check3 = (cb3).isChecked();
        TextView text = (TextView) findViewById(R.id.checkAnswer);
        if (check2)
            text.setText("That's wrong! Try again!");
        else if (check1 && check3)
        {
            text.setText("That's right! Great job!");
        }
        else if (check1)
        {
            text.setText("You need to check one more box!");
        }
        else if (check3)
        {
            text.setText("You need to check one more box!");
        }
    }
}

