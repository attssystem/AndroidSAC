package xyz.attssystem.attssac;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.*;
import android.view.*;
import java.util.Random;
import android.os.Bundle;
import android.text.SpannableStringBuilder;

public class MainActivity extends AppCompatActivity {

    int attsServers = 20;
    int verizonServers = 20;
    int rand;
    TextView term;
    TextView aServers;
    TextView vServers;
    Button button;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        term = (TextView)findViewById(R.id.term);
        aServers = (TextView)findViewById(R.id.aServers);
        vServers = (TextView)findViewById(R.id.vServers);
        button = (Button)findViewById(R.id.mitm);
        button2 = (Button)findViewById(R.id.overcpu);
        button3 = (Button)findViewById(R.id.fix);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verizonServers--;
                textUpdate(term, ">MITM-Verizon servers -1", Color.GREEN);
                vattack();
                checkwin();
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                rand = r.nextInt(5 - 1) + 1;

                if (rand == 1)
                {
                    verizonServers --;
                    textUpdate(term, ">OverCPU-Verizon servers -1", Color.GREEN);
                }
                else if (rand == 2)
                {
                    verizonServers -= 2;
                    textUpdate(term, ">OverCPU-Verizon servers -2", Color.GREEN);
                }
                else if (rand == 3)
                {
                    verizonServers -= 3;
                    textUpdate(term, ">OverCPU-Verizon servers -3", Color.GREEN);
                }
                else if (rand == 4)
                {
                    verizonServers -= 4;
                    textUpdate(term, ">OverCPU-Verizon servers -4", Color.GREEN);
                }

                Random r1 = new Random();
                rand = r1.nextInt(4 - 1) + 1;

                if (rand == 1)
                {
                    attsServers --;
                    textUpdate(term, ">OverCPU-ATTS servers -1", Color.RED);
                }
                else if (rand == 2)
                {
                    attsServers -=2;
                    textUpdate(term, ">OverCPU-ATTS servers -2", Color.RED);
                }
                vattack();
                checkwin();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attsServers++;
                vattack();
                checkwin();
            }
        });

    }

    public void vattack() {
        Random r = new Random();
        rand = r.nextInt(4 - 1) + 1;
        if (rand == 1) {
            attsServers--;
            textUpdate(term, ">MITM-ATTS servers -1", Color.RED);
        } else if (rand == 2) {
            Random r1 = new Random();
            rand = r1.nextInt(5 - 1) + 1;

            if (rand == 1) {
                attsServers--;
                textUpdate(term, ">OverCPU-ATTS servers -1", Color.RED);
            } else if (rand == 2) {
                attsServers -= 2;
                textUpdate(term, ">OverCPU-ATTS servers -2", Color.RED);
            } else if (rand == 3) {
                attsServers -= 3;
                textUpdate(term, ">OverCPU-ATTS servers -3", Color.RED);
            } else if (rand == 4) {
                attsServers -= 4;
                textUpdate(term, ">OverCPU-ATTS servers -4", Color.RED);
            }

            Random r2 = new Random();
            rand = r2.nextInt(4 - 1) + 1;

            if (rand == 1) {
                verizonServers--;
                textUpdate(term, ">OverCPU-Verizon servers -1", Color.GREEN);
            } else if (rand == 2) {
                verizonServers -= 2;
                textUpdate(term, ">OverCPU-Verizon servers -2", Color.GREEN);
            } else if (rand == 3) {
                verizonServers++;
                textUpdate(term, ">Verizon servers + 1", Color.RED);
            }
        }
    }

    public void checkwin()
    {
        if (attsServers <= 0)
        {
            textUpdate(term, ">You lose!", Color.RED);
            textUpdate(term, ">GAME RESTARTED", Color.BLUE);
            attsServers = 20;
            verizonServers = 20;
        }
        else if (verizonServers <= 0)
        {
            textUpdate(term, ">You win!", Color.GREEN);
            textUpdate(term, ">You were appointed chief of the security team!", Color.GREEN);
            textUpdate(term, ">GAME RESTARTED", Color.BLUE);
            attsServers = 20;
            verizonServers = 20;
            System.getProperty("line.separator")
        }
    }

    public void scoreUpdate()
    {
        aServers.setText(String.valueOf(attsServers));
        vServers.setText(String.valueOf(verizonServers));
    }

    public void textUpdate(TextView tv, String textToAdd, int color){
        SpannableStringBuilder builder = new SpannableStringBuilder();
        String textContentView = tv.getText().toString();
        SpannableString textSpannable = new SpannableString(textToAdd);
        textSpannable.setSpan(new ForegroundColorSpan(color), 0, textToAdd.length(), 0);
        builder.append(new SpannableString(textContentView));
        builder.append(textSpannable);
        tv.setText("\n" + builder, TextView.BufferType.SPANNABLE);
        scoreUpdate();
    }

    }

