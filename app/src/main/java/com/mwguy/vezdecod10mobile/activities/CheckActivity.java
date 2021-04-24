package com.mwguy.vezdecod10mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.mwguy.vezdecod10mobile.R;
import com.mwguy.vezdecod10mobile.services.CodeService;

public class CheckActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chek_activity);

        if (CodeService.isSecretCodePresent(this)) {
            startActivity(new Intent(this, CodeActivateActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
