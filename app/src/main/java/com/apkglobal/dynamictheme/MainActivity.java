package com.apkglobal.dynamictheme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_theme;
    SharedPreferences sp;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getFlag() ? R.style.AppTheme : R.style.AppThemeDark);
        setContentView(R.layout.activity_main);
        btn_theme = findViewById(R.id.btn_theme);
        btn_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFlag(!getFlag());
                Intent i = new Intent(MainActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void saveFlag(boolean b) {
        sp = getSharedPreferences("spfile", 0);
        ed = sp.edit();
        ed.putBoolean("dark", b);
        ed.commit();
    }

    private boolean getFlag() {
        sp = getSharedPreferences("spfile", 0);
        return sp.getBoolean("dark", false);
    }

}
