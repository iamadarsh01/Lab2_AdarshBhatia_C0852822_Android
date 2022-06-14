package com.example.lab2_adarshbhatia_c0852822_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText title_input, author_input, price_input, genre_input;
    Button update_button, delete_btn;

    String id, title, author, price, genre;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input = findViewById(R.id.titleEditText2);
        author_input = findViewById(R.id.AuthorEditText2);
        price_input = findViewById(R.id.PriceEditText2);
        genre_input = findViewById(R.id.GenreEditText2);
        update_button = findViewById(R.id.update_button);
        delete_btn = findViewById(R.id.delete_btn);



        getAndSetIntentData();
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.updateData(id, title, author, price, genre);

            }
        });
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
             myDB.deleteOneRow(id);
            }
        });









    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("title") &&
                getIntent().hasExtra("author") &&
                getIntent().hasExtra("price") &&
                getIntent().hasExtra("genre"))
        {

            //Getting Data from Intent
            id  = getIntent().getStringExtra("id");
            title  = getIntent().getStringExtra("title");
            author  = getIntent().getStringExtra("author");
            price  = getIntent().getStringExtra("price");
            genre  = getIntent().getStringExtra("genre");

            //Setting Intent Data
            title_input.setText(title);
            author_input.setText(author);
            price_input.setText(price);
            genre_input.setText(genre);






        }else {
            Toast.makeText(this,"No Data", Toast.LENGTH_SHORT).show();
        }

    }
}