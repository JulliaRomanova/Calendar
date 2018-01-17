package com.example.julia.z;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class MainActivity extends AppCompatActivity {
    private MaterialCalendarView calendarView;
    private Toolbar toolbar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setupToolbar();
        editText = findViewById(R.id.edit_text);

        calendarView = findViewById(R.id.calendar_view);
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Toast.makeText(getApplicationContext(),
                        "Год " + date.getYear() + "\n" +
                                "Месяц: " + date.getMonth() + "\n" +
                                "День: " + date.getDay(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        calendarView.setTopbarVisible(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

    }

}