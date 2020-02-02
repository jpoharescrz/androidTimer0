package com.example.timer2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    TextView counter;
    Button btnStartStop;
    Integer count;
    long time;

    // Create the Handler object (on the main thread by default)
    Handler handler = new Handler();
    // Define the code block to be executed
    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {

            long new_time, delay_ms;

            // increment the counter
            count += 1;
            // Do something here on the main thread
            Log.d("Handlers", "Called on main thread:".concat(String.valueOf(count)));
            counter.setText(String.valueOf(count));
            // Repeat this the same runnable code block again another 1 seconds
            // 'this' is referencing the Runnable object
            new_time = System.currentTimeMillis(); // get the current milliseconds
            delay_ms = (time + 1000) - new_time;
            Log.d("Handlers", "Delay of:".concat(String.valueOf(delay_ms)));
            if (delay_ms < 0) {
                delay_ms = 0;
            }
            time += 1000;
            handler.postDelayed(this, delay_ms);
        }
    };

    // Button onClick code for Start/Stop button
    public void startStopCounter(View view){

        if (btnStartStop.getText().equals("Start")){
            // Start the initial runnable task by posting through the handler
            count = 0;
            time= System.currentTimeMillis(); // get the current milliseconds
            handler.post(runnableCode);
            btnStartStop.setText(R.string.stop);
        }
        else { // Stopping counter
            // Removes pending code execution
            handler.removeCallbacks(runnableCode);
            btnStartStop.setText(R.string.start);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        counter = findViewById(R.id.TviewCounter) ;
        btnStartStop = findViewById(R.id.btnStartStop);
        count = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
