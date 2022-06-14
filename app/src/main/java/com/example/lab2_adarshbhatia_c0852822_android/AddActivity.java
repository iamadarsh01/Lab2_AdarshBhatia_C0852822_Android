package com.example.lab2_adarshbhatia_c0852822_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {


    EditText title, genre, price, author;
    Button addBookBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title = findViewById(R.id.titleEditText);
        genre = findViewById(R.id.GenreEditText);
        price = findViewById(R.id.PriceEditText);
        author  = findViewById(R.id.AuthorEditText);

        addBookBtn = findViewById(R.id.addBookBtn);

        addBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper mydb = new MyDatabaseHelper(AddActivity.this);
                mydb.addBook(title.getText().toString().trim(),
                        author.getText().toString().trim(),
                        Integer.valueOf(price.getText().toString().trim()),
                        genre.getText().toString().toString());
            }
        });





    }
}