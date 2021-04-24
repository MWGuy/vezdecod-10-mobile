package com.mwguy.vezdecod10mobile.activities;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.mwguy.vezdecod10mobile.R;
import com.mwguy.vezdecod10mobile.services.CodeService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setText(CodeService.isSecretCodePresent(this) ? R.string.main_edit_code : R.string.main_set_code);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() != R.id.button) {
            return;
        }

        startActivity(new Intent(this, CodeEditActivity.class));
    }
}
