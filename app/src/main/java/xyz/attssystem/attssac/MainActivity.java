package xyz.attssystem.attssac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button play;
    Button help;
    Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.button4);
        quit = (Button) findViewById(R.id.button3);
        help = (Button) findViewById(R.id.button2);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Game.class));
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // It shows the "help".
                startActivity(new Intent(MainActivity.this, Help.class));
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

