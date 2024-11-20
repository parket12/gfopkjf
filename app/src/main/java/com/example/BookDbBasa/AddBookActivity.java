package com.example.BookDbBasa;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {

    private EditText editTextName,editTextAuthor;
    private Button add;
    private DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTextName = findViewById(R.id.editTextName);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        add=findViewById(R.id.add);

        db = new DataBaseHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBookToDatabase();
            }
        });
    }
    private void addBookToDatabase(){
        String bookName=editTextName.getText().toString().trim();
        String bookAuthor=editTextAuthor.getText().toString().trim();
        if(bookName.isEmpty() || bookAuthor.isEmpty()) {
            Toast.makeText(this, "Остались путсые поля", Toast.LENGTH_SHORT).show();
            return;
        }
        long result =db.addBook(bookName,bookAuthor);
        if(result>0){
            Toast.makeText(this,"Успешно",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AddBookActivity.this,MainActivity.class));
            finish();
        }else{
            Toast.makeText(this,"Анлак",Toast.LENGTH_SHORT).show();
        }

    }



}
