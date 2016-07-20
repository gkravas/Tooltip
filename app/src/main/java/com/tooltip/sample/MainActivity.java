package com.tooltip.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.tooltip.Tooltip;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tooltip.Builder builder = new Tooltip.Builder(MainActivity.this, button, R.style.Tooltip2)
                        .setCancelable(true)
                        .setDismissOnClick(false)
                        .setCornerRadius(20f)
                        .setGravity(Gravity.BOTTOM)
                        .setText(R.string.tooltip_hello_world);
                builder.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (getSupportActionBar() != null) {
            MenuItem menuItem = menu.findItem(R.id.action_test2);
            Tooltip.Builder builder = new Tooltip.Builder(getSupportActionBar().getThemedContext(), menuItem)
                    .setCornerRadius(10f)
                    .setGravity(Gravity.BOTTOM)
                    .setText("I`m on the bottom of menu item");
            builder.show();
        }

        return super.onCreateOptionsMenu(menu);
    }
}
