package com.malishalakshanrosa.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calculate(View v) {

        String bmi_categoy = "";

        // get BMI result TextView
        TextView tv_result = (TextView)findViewById(R.id.layer);

        // get BMI category TextView
        TextView tv_bmi_category = (TextView)findViewById(R.id.lbl_category);

        // get height - by feet
        EditText et_height = findViewById(R.id.txt_height);
        double height = Double.parseDouble(et_height.getText().toString());

        // get weight - by pound(lbs)
        EditText et_weight = findViewById(R.id.txt_weight);
        double weight = Double.parseDouble(et_weight.getText().toString());

        // BMI calculation
        // convert feets to inches
        double feet_to_inch = height * 12;

        double bmi_in_decimal = (703 * weight) / (feet_to_inch * feet_to_inch);
        double bmi = Math.round(bmi_in_decimal);

        if (bmi < 16){
            bmi_categoy = "Severe Thinness";
        }else if(bmi >= 16 && bmi <= 17){
            bmi_categoy = "Moderate Thinness";
        }else if(bmi > 17 && bmi <= 18.5){
            bmi_categoy = "Mild Thinness";
        }else if(bmi > 18.5 && bmi <= 25){
            bmi_categoy = "Normal";
        }else if(bmi > 25 && bmi <= 30){
            bmi_categoy = "Overweight";
        }else if (bmi > 30 && bmi <= 35){
            bmi_categoy = "Obese Class I";
        }else if (bmi > 35 && bmi <= 40){
            bmi_categoy = "Obese Class II";
        }else if (bmi > 40){
            bmi_categoy = "Obese Class III";

        }

        // Set BMI result to TextView
        String bmi_result = String.valueOf(bmi);
        tv_result.setText("BMI = " + bmi_result.concat(" kg/m2"));

        // Set BMI category to TextView
        tv_bmi_category.setText(bmi_categoy);




        // get age
        /*
        EditText et_age = findViewById(R.id.txt_age);
        String txt_age = et_age.getText().toString();
        int age = Integer.parseInt(txt_age);

        // get selected radio button id
        RadioGroup age_radio_group = findViewById(R.id.age_radio_group);
        int selected_radio_id = age_radio_group.getCheckedRadioButtonId();

        // get selected radio button name
        RadioButton radioButton = (RadioButton) findViewById(selected_radio_id);
        String selected_radio_btn_name = (String)radioButton.getText();
        */

        /*
        double bmi = 0;

        if (age >= 20){
            // convert feets to inches
            double feet_to_inch = height * 12;

            bmi = (703 * weight) / (feet_to_inch * feet_to_inch);

        }
        */


    }

    public void Reset(View v){

        EditText et_height = findViewById(R.id.txt_height);
        et_height.setText(null);
        et_height.requestFocus();

        EditText et_weight = findViewById(R.id.txt_weight);
        et_weight.setText(null);

        TextView tv_result = (TextView)findViewById(R.id.layer);
        tv_result.setText("Your Result");

        TextView tv_category = (TextView) findViewById(R.id.lbl_category);
        tv_category.setText("Category");

    }

}