package com.example.rig_covsign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class Form extends AppCompatActivity implements View.OnClickListener {
    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView imageToUpload;
    EditText title, datetime;
    TextView i, d;
    Button uploadimage, submit;

    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation for Incident Title
        awesomeValidation.addValidation(this, R.id.title, RegexTemplate.NOT_EMPTY, R.string.invalid_title);

        //Add Validation for Date & Time
        awesomeValidation.addValidation(this, R.id.datetime, RegexTemplate.NOT_EMPTY, R.string.invalid_datetime);

        imageToUpload = (ImageView) findViewById(R.id.imageToUpload);
        title = (EditText) findViewById(R.id.title);
        datetime= (EditText) findViewById(R.id.datetime);
        i = (TextView) findViewById(R.id.i);
        d = (TextView) findViewById(R.id.d);
        uploadimage = (Button) findViewById(R.id.uploadimage);
        submit = (Button) findViewById(R.id.submit);


        imageToUpload.setOnClickListener(this);
        uploadimage.setOnClickListener(this);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Check Validation
                if(awesomeValidation.validate()){
                    //On Success
                    Toast.makeText(getApplicationContext(),"Form Submitted Successfully...", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Form failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageToUpload:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;
            case R.id.uploadimage:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data !=null) {
            Uri selectedImage = data.getData();
            imageToUpload.setImageURI(selectedImage);

        }
    }
}
