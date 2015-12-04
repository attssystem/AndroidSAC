package xyz.attssystem.attssac;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.*;
import android.view.*;
import java.util.Random;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int attsServers = 20;
    int verizonServers = 20;
    int rand;
    TextView term;
    TextView aServers;
    TextView vServers;
    Button mitm;
    Button overCPU;
    Button fix;
    Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        term = (TextView) findViewById(R.id.term);
        aServers = (TextView) findViewById(R.id.aServers);
        vServers = (TextView) findViewById(R.id.vServers);
        mitm = (Button) findViewById(R.id.mitm);
        overCPU = (Button) findViewById(R.id.overcpu);
        fix = (Button) findViewById(R.id.fix);
        help = (Button) findViewById(R.id.button);

        // It updates the scores.
        aServers.setText(String.valueOf(attsServers));
        vServers.setText(String.valueOf(verizonServers));

        // It says "Welcome" to the user.
        Spannable welcome = new SpannableString(">Welcome Admin.");
        welcome.setSpan(new ForegroundColorSpan(Color.BLUE), 0, welcome.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        term.setText(welcome);

        // If "MITM" button is clicked.
        mitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // It makes Verizon losing a server,
                verizonServers--;
                // It writes it in the "Terminal",
                textUpdate(term, "\nA", Color.LTGRAY);
                textUpdate(term, ">", Color.GREEN);
                textUpdate(term, "MITM-Verizon servers -1", Color.WHITE);
                // It makes Verizon hitting back.
                vAttack();
                // It verifies if someone won.
                checkWin();
            }

        });
        // If "OverCPU" button is clicked.
        overCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // It calls the OverCPU function.
                overCPUAtts();
            }
        });
        // If "Fix" button is clicked.
        fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // It makes the user fixing a server.
                attsServers++;
                textUpdate(term, "\nA", Color.LTGRAY);
                textUpdate(term, ">", Color.GREEN);
                textUpdate(term, "FIX-ATTS severs + 1", Color.WHITE);
                // It makes Verizon hitting back.
                vAttack();
                // It verifies if someone won.
                checkWin();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // It shows the "help".
                startActivity(new Intent(MainActivity.this, Help.class));
            }
        });

    }

    public void overCPUAtts() {
        // It takes a random number (1 to 4 included),
        Random r = new Random();
        rand = r.nextInt(5 - 1) + 1;
        // Depending on the number value, Verizon will lose 1 to 4 server(s).
        if (rand == 1) {
            verizonServers--;
            textUpdate(term, "\nA", Color.LTGRAY);
            textUpdate(term, ">", Color.GREEN);
            textUpdate(term, "OverCPU-Verizon servers -1", Color.WHITE);
        } else if (rand == 2) {
            verizonServers -= 2;
            textUpdate(term, "\nA", Color.LTGRAY);
            textUpdate(term, ">", Color.GREEN);
            textUpdate(term, "OverCPU-Verizon servers -2", Color.WHITE);
        } else if (rand == 3) {
            verizonServers -= 3;
            textUpdate(term, "\nA", Color.LTGRAY);
            textUpdate(term, ">", Color.GREEN);
            textUpdate(term, "OverCPU-Verizon servers -3", Color.WHITE);
        } else if (rand == 4) {
            verizonServers -= 4;
            textUpdate(term, "\nA", Color.LTGRAY);
            textUpdate(term, ">", Color.GREEN);
            textUpdate(term, "OverCPU-Verizon servers -4", Color.WHITE);
        }
        // Then it takes another random value (1 to 2 included)
        Random r1 = new Random();
        rand = r1.nextInt(4 - 1) + 1;
        // If it is 0 nothing happens else the user will lose 1 to 2 server(s).
        if (rand == 1) {
            attsServers--;
            textUpdate(term, "\nA", Color.LTGRAY);
            textUpdate(term, ">", Color.RED);
            textUpdate(term, "OverCPU-ATTS servers -1", Color.WHITE);
        } else if (rand == 2) {
            attsServers -= 2;
            textUpdate(term, "\nA", Color.LTGRAY);
            textUpdate(term, ">", Color.RED);
            textUpdate(term, "OverCPU-ATTS servers -2", Color.WHITE);
        }
        // It makes Verizon hitting back.
        vAttack();
        // It verifies if someone won.
        checkWin();
    }

    // It is the "hitting back" function of Verizon.
    public void vAttack() {
        // It takes a random number (1 to 3 included),
        Random r = new Random();
        rand = r.nextInt(4 - 1) + 1;
        // Depending on the number value, Verizon will use a specific attack.
        if (rand == 1) {
            attsServers--;
            textUpdate(term, "\nV", Color.LTGRAY);
            textUpdate(term, ">", Color.RED);
            textUpdate(term, "MITM-ATTS servers -1", Color.WHITE);
        } else if (rand == 2) {
            // It takes a random number (1 to 4 included),
            Random r1 = new Random();
            rand = r1.nextInt(5 - 1) + 1;
            // Depending on the number value, the user will lose 1 to 4 server(s).
            if (rand == 1) {
                attsServers--;
                textUpdate(term, "\nV", Color.LTGRAY);
                textUpdate(term, ">", Color.RED);
                textUpdate(term, "OverCPU-ATTS servers -1", Color.WHITE);
            } else if (rand == 2) {
                attsServers -= 2;
                textUpdate(term, "\nV", Color.LTGRAY);
                textUpdate(term, ">", Color.RED);
                textUpdate(term, "OverCPU-ATTS servers -2", Color.WHITE);
            } else if (rand == 3) {
                attsServers -= 3;
                textUpdate(term, "\nV", Color.LTGRAY);
                textUpdate(term, ">", Color.RED);
                textUpdate(term, "OverCPU-ATTS servers -3", Color.WHITE);
            } else if (rand == 4) {
                attsServers -= 4;
                textUpdate(term, "\nV", Color.LTGRAY);
                textUpdate(term, ">", Color.RED);
                textUpdate(term, "OverCPU-ATTS servers -4", Color.WHITE);
            }
            // It takes another random number (1 to 2 included),
            Random r2 = new Random();
            rand = r2.nextInt(4 - 1) + 1;
            // If it is 0 nothing happens else Verizon will lose 1 to 2 server(s).
            if (rand == 1) {
                verizonServers--;
                textUpdate(term, "\nV", Color.LTGRAY);
                textUpdate(term, ">", Color.GREEN);
                textUpdate(term, "OverCPU-Verizon servers -1", Color.WHITE);
            } else if (rand == 2) {
                verizonServers -= 2;
                textUpdate(term, "\nV", Color.LTGRAY);
                textUpdate(term, ">", Color.GREEN);
                textUpdate(term, "OverCPU-Verizon servers -2", Color.WHITE);
            } else if (rand == 3) {
                verizonServers++;
                textUpdate(term, "\nV", Color.LTGRAY);
                textUpdate(term, ">", Color.GREEN);
                textUpdate(term, "Verizon servers + 1", Color.WHITE);
            }
        }
    }
    // This function verifies if someone won.
    public void checkWin() {
        if (attsServers <= 0) {
            textUpdate(term, "\n>_", Color.BLUE);
            textUpdate(term, "You lose!", Color.RED);
            textUpdate(term, "\n>_", Color.BLUE);
            textUpdate(term, "GAME RESTARTED", Color.BLUE);
            attsServers = 20;
            verizonServers = 20;
        } else if (verizonServers <= 0) {
            textUpdate(term, "\n>_", Color.BLUE);
            textUpdate(term, "You win!", Color.GREEN);
            textUpdate(term, "\n>_", Color.BLUE);
            textUpdate(term, "You were appointed chief of the security team!", Color.GREEN);
            textUpdate(term, "\n>_", Color.BLUE);
            textUpdate(term, "GAME RESTARTED", Color.BLUE);
            attsServers = 20;
            verizonServers = 20;
        }
    }

    // This function updates the "Terminal" by using the terminal, the text to add and the chosen color as arguments.
    public void textUpdate(TextView tv, String textToAdd, int color) {
        // It takes the text you want and make it spannable,
        SpannableString spannableText=new SpannableString(textToAdd);
        spannableText.setSpan(new ForegroundColorSpan(color), 0, spannableText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Then it adds the text to the TextView.
        tv.append(spannableText);
        // It scrolls the "Terminal" if necessary.
        tv.setMovementMethod(new ScrollingMovementMethod());
        scroll(tv);
        // Then, it updates the players scores.
        aServers.setText(String.valueOf(attsServers));
        vServers.setText(String.valueOf(verizonServers));
    }

    // It makes the "Terminal" scrolling when it is full.
    public void scroll(TextView tv) {
        final int scrollAmount = tv.getLayout().getLineTop(tv.getLineCount()) - tv.getHeight();
        if (scrollAmount > 0)
            tv.scrollTo(0, scrollAmount);
        else
            tv.scrollTo(0, 0);
    }
}

