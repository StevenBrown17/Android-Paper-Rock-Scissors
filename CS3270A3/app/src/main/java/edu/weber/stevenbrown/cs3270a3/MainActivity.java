package edu.weber.stevenbrown.cs3270a3;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements gameCaption.OnFragmentSendText{

    //String outcome = gameCaption.outcome;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer1, new gameCaption(),"GC").addToBackStack(null).commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2, new gameResults(),"GR").addToBackStack(null).commit();

        btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gameResults gr = (gameResults)getSupportFragmentManager().findFragmentByTag("GR");
                gr.reset();

                Toast toast = Toast.makeText(getApplicationContext(), "Counts Reset", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public void onSendText(String text) {
        gameResults gr = (gameResults)getSupportFragmentManager().findFragmentByTag("GR");
        gr.updateInfo(text);

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test"," MainActivity onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test"," MainActivity onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test"," MainActivity onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test"," MainActivity onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test"," MainActivity onDestroy()");
    }



}//end class
