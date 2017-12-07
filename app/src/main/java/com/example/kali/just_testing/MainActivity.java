package com.example.kali.just_testing;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    ArrayList<Word> words = new ArrayList<Word>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Hell = (TextView) findViewById(R.id.helloworld);
        final EditText taskn = (EditText) findViewById(R.id.taskname);
        final EditText time = (EditText) findViewById(R.id.time);
        Hell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(MainActivity.this, textview_2.class);
               /* i.putExtra("task", taskn.getText().toString());
                i.putExtra("time", time.getText().toString());


*/              l.putExtra("words",words);
               startActivity(l);
            }
        });
       /*Textview view2 = (TextView) findViewById(R.id.textview2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, textview_3.class);
                startActivity(i2);
            }
        });*/

    }


    public void OpenAlarms(View view) {

        //EditText time = (EditText) findViewById(R.id.time);
        ////EditText hour = (EditText) findViewById(R.id.hour);
        //EditText minutes = (EditText) findViewById(R.id.minutes);

        //int t = Integer.parseInt(time.getText().toString());
        //int h = Integer.parseInt(hour.getText().toString());
        //int m = Integer.parseInt(minutes.getText().toString());
        EditText taskn = (EditText) findViewById(R.id.taskname);
        /*long total_time = (t*1000) + (h*3600000) + (m*60000);

        long final_time = (System.currentTimeMillis()+ total_time) - System.currentTimeMillis();
        ;// if its string typey*/
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker1);
        startTask();

        /*String tt = hour.getText().toString() + " " + minutes.getText().toString() + " " + time.getText().toString();*/

        String tt = timePicker.getCurrentHour().toString() + " " + timePicker.getCurrentMinute();
        addTasks(taskn.getText().toString(),tt);








    }
    public void startTask(){

        Intent Nintent = new Intent(this, MyBrodcastRec.class);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker1);
         final DatePicker viewById = (DatePicker) findViewById(R.id.datePicker1);

        Calendar calendar =  Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MONTH, viewById.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, viewById.getDayOfMonth());




        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 4334, Nintent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(this, "Alarm set in " + calendar.getTime() + " seconds",Toast.LENGTH_LONG).show();
    }
    public void addTasks(String task, String time){

        words.add(new Word(task, time));
        Intent i = new Intent(MainActivity.this, textview_2.class);
        i.putExtra("words",words);
        startActivity(i);


    }


}
