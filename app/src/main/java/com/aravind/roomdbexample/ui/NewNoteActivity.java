package com.aravind.roomdbexample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.aravind.roomdbexample.R;

public class NewNoteActivity extends AppCompatActivity {

    public static final String NOTE_ADDED = "new_note";
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        editText = findViewById(R.id.etNewNote);
        button = findViewById(R.id.bAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                if (TextUtils.isEmpty(editText.getText())) {
                    setResult(RESULT_CANCELED, intent);
                } else {
                    String note = editText.getText().toString();
                    intent.putExtra(NOTE_ADDED, note);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }
}
