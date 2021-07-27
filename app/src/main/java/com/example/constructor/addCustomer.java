package com.example.constructor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import static com.example.constructor.R.string.invalidate_address;
import static com.example.constructor.R.string.invalidate_contactno;

public class addCustomer extends AppCompatActivity {
    ImageView imgClose;
    Button btnAdd ;
    EditText txt_Site, txt_Address, txt_ContactNo, txt_StartDate, txt_EndDate, txt_AssignedDate, txt_Amount;

    public addCustomer() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        Window window=this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.myStatusBar));
        imgClose=findViewById(R.id.btnClose);

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final AwesomeValidation awesomeValidation;

        btnAdd=findViewById(R.id.btnAdd);
        txt_Site = findViewById(R.id.txtSite);
        txt_Address = findViewById(R.id.txtAddress);
        txt_ContactNo = findViewById(R.id.txtContactNo);
        txt_StartDate = findViewById(R.id.txtStartDate);
        txt_EndDate = findViewById(R.id.txtEndDate);
        txt_AssignedDate = findViewById(R.id.txtAssignedDate);
        txt_Amount = findViewById(R.id.txtAmt);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.txtSite, RegexTemplate.NOT_EMPTY,R.string.invalidate_name);
        awesomeValidation.addValidation(this,R.id.txtStartDate, RegexTemplate.NOT_EMPTY,R.string.null_startate);
        awesomeValidation.addValidation(this,R.id.txtEndDate, RegexTemplate.NOT_EMPTY,R.string.null_endDate);
        awesomeValidation.addValidation(this,R.id.txtAddress, RegexTemplate.NOT_EMPTY, invalidate_address);
        awesomeValidation.addValidation(this,R.id.txtContactNo, "[5-9]{1}[0-9]{9}$", invalidate_contactno);
        awesomeValidation.addValidation(this,R.id.txtAmt, "^([0-9.]{1,50})$",R.string.invalidate_amt);
        Editable startDate = txt_StartDate.getText();
        Editable endDate = txt_EndDate.getText();



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate())
                {
                    Toast.makeText(getApplicationContext(), "Successfully added Customer", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
