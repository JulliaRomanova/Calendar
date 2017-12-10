package com.example.julia.z;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class MainActivity extends AppCompatActivity {
    private MaterialCalendarView calendarView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        setupToolbar();

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

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

}