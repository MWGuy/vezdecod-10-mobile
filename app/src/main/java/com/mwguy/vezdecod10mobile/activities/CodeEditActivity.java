package com.mwguy.vezdecod10mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.mwguy.vezdecod10mobile.R;
import com.mwguy.vezdecod10mobile.services.CodeService;

public class CodeEditActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_input_activity);

        Button button = findViewById(R.id.button);
        button.setText(R.string.edit_button_text);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() != R.id.button) {
            return;
        }

        EditText editText = findViewById(R.id.editText);
        if (editText.getText().length() < 6) {
            editText.setError("Секретный ключ должен быть больше 6 символов");
            return;
        }

        CodeService.setSecretCode(this, editText.getText().toString());
        startActivity(new Intent(this, CheckActivity.class));
    }
}
