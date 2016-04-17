package xyz.attssystem.attssac;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Game extends AppCompatActivity {

    int attsServers = 20;
    int verizonServers = 20;
    boolean start = false;
    int rand;
    TextView term;
    TextView aServers;
    TextView vServers;
    Button mitm;
    Button overCPU;
    Button fix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        term = (TextView) findViewById(R.id.term);
        aServers = (TextView) findViewById(R.id.aServers);
        vServers = (TextView) findViewById(R.id.vServers);
        mitm = (Button) findViewById(R.id.mitm);
        overCPU = (Button) findViewById(R.id.overcpu);
        fix = (Button) findViewById(R.id.fix);

        // It says "Welcome" to the user.
        Spannable welcome = new SpannableString(">Welcome Admin.");
        welcome.setSpan(new ForegroundColorSpan(Color.BLUE), 0, welcome.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        term.setText(welcome);

        // If "MITM" button is clicked.
        mitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
                // It makes Verizon losing a server,
                verizonServers--;
                // It writes it in the "Terminal",
                textUpdate(term, "\nA", Color.DKGRAY);
                textUpdate(term, ">_ ", Color.GREEN);
                textUpdate(term, "MITM-Verizon Servers -1", Color.GRAY);
                // It makes Verizon hitting back.
                scoreUpdate();
                vAttack();
            }

        });
        // If "OverCPU" button is clicked.
        overCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
                // It calls the OverCPU function.
                overCPUAtts();
                scoreUpdate();
                vAttack();
            }
        });
        // If "Fix" button is clicked.
        fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
                // It makes the user fixing a server.
                attsServers++;
                textUpdate(term, "\nA", Color.DKGRAY);
                textUpdate(term, ">_ ", Color.GREEN);
                textUpdate(term, "FIX-ATTS Servers + 1", Color.GRAY);
                // It makes Verizon hitting back.
                scoreUpdate();
                vAttack();
            }
        });

    }

    public void start() {
        if (start == true) {
            // It says "Welcome" to the user.
            Spannable welcome = new SpannableString(">Welcome Admin.");
            welcome.setSpan(new ForegroundColorSpan(Color.BLUE), 0, welcome.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            term.setText(welcome);
            start = false;
        }
    }

    public void overCPUAtts() {
        // It takes a random number (1 to 4 included),
        Random r = new Random();
        rand = r.nextInt(5 - 1) + 1;
        // Depending on the number value, Verizon will lose 1 to 4 server(s).
        if (rand == 1) {
            verizonServers--;
            textUpdate(term, "\nA", Color.DKGRAY);
            textUpdate(term, ">_ ", Color.GREEN);
            textUpdate(term, "OverCPU-Verizon Servers -1", Color.GRAY);
        } else if (rand == 2) {
            verizonServers = verizonServers - 2;
            textUpdate(term, "\nA", Color.DKGRAY);
            textUpdate(term, ">_ ", Color.GREEN);
            textUpdate(term, "OverCPU-Verizon Servers -2", Color.GRAY);
        } else if (rand == 3) {
            verizonServers = verizonServers - 3;
            textUpdate(term, "\nA", Color.DKGRAY);
            textUpdate(term, ">_ ", Color.GREEN);
            textUpdate(term, "OverCPU-Verizon Servers -3", Color.GRAY);
        } else if (rand == 4) {
            verizonServers = verizonServers - 4;
            textUpdate(term, "\nA", Color.DKGRAY);
            textUpdate(term, ">_ ", Color.GREEN);
            textUpdate(term, "OverCPU-Verizon Servers -4", Color.GRAY);
        }
        // Then it takes another random value (1 to 2 included)
        Random r1 = new Random();
        rand = r1.nextInt(4 - 1) + 1;
        // If it is 0 nothing happens else the user will lose 1 to 2 server(s).
        if (rand == 1) {
            attsServers--;
            textUpdate(term, "\nA", Color.DKGRAY);
            textUpdate(term, ">_ ", Color.RED);
            textUpdate(term, "OverCPU-ATTS Servers -1", Color.GRAY);
        } else if (rand == 2) {
            attsServers = attsServers - 2;
            textUpdate(term, "\nA", Color.DKGRAY);
            textUpdate(term, ">_ ", Color.RED);
            textUpdate(term, "OverCPU-ATTS Servers -2", Color.GRAY);
        }
    }

    // It is the "hitting back" function of Verizon.
    public void vAttack() {
        Thread sleep = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // It takes a random number (1 to 3 included),
                        Random r = new Random();
                        rand = r.nextInt(7 - 1) + 1;
                        // Depending on the number value, Verizon will use a specific attack.
                        if (rand == 1) {
                            attsServers--;
                            textUpdate(term, "\nV", Color.DKGRAY);
                            textUpdate(term, ">_ ", Color.RED);
                            textUpdate(term, "MITM-ATTS Servers -1", Color.GRAY);
                        } else if (rand == 2 || rand == 4 || rand == 5 || rand == 6) {
                            // It takes a random number (1 to 4 included),
                            Random r1 = new Random();
                            rand = r1.nextInt(11 - 1) + 1;
                            // Depending on the number value, the user will lose 1 to 4 server(s).
                            if (rand == 1) {
                                attsServers--;
                                textUpdate(term, "\nV", Color.DKGRAY);
                                textUpdate(term, ">_ ", Color.RED);
                                textUpdate(term, "OverCPU-ATTS Servers -1", Color.GRAY);
                            } else if (rand == 2 || rand == 5 || rand == 6 || rand == 7) {
                                attsServers = attsServers - 2;
                                textUpdate(term, "\nV", Color.DKGRAY);
                                textUpdate(term, ">_ ", Color.RED);
                                textUpdate(term, "OverCPU-ATTS Servers -2", Color.GRAY);
                            } else if (rand == 3 || rand == 8 || rand == 9) {
                                attsServers = attsServers -3;
                                textUpdate(term, "\nV", Color.DKGRAY);
                                textUpdate(term, ">_ ", Color.RED);
                                textUpdate(term, "OverCPU-ATTS Servers -3", Color.GRAY);
                            } else if (rand == 4 || rand == 10) {
                                attsServers = attsServers - 4;
                                textUpdate(term, "\nV", Color.DKGRAY);
                                textUpdate(term, ">_ ", Color.RED);
                                textUpdate(term, "OverCPU-ATTS Servers -4", Color.GRAY);
                            }
                            // It takes another random number (1 to 2 included),
                            Random r2 = new Random();
                            rand = r2.nextInt(5 - 1) + 1;
                            // If it is 4 nothing happens else Verizon will lose 1 to 2 server(s).
                            if (rand == 1) {
                                verizonServers--;
                                textUpdate(term, "\nV", Color.DKGRAY);
                                textUpdate(term, ">_ ", Color.GREEN);
                                textUpdate(term, "OverCPU-Verizon Servers -1", Color.GRAY);
                            } else if (rand == 2) {
                                verizonServers = verizonServers - 2;
                                textUpdate(term, "\nV", Color.DKGRAY);
                                textUpdate(term, ">_ ", Color.GREEN);
                                textUpdate(term, "OverCPU-Verizon Servers -2", Color.GRAY);
                            } else if (rand == 3) {
                                verizonServers++;
                                textUpdate(term, "\nV", Color.DKGRAY);
                                textUpdate(term, ">_ ", Color.GREEN);
                                textUpdate(term, "Verizon Servers + 1", Color.GRAY);
                            }
                        }
                        else if (rand == 3){
                            verizonServers++;
                            textUpdate(term, "\nV", Color.DKGRAY);
                            textUpdate(term, ">_ ", Color.RED);
                            textUpdate(term, "FIX-Verzion Servers +1", Color.GRAY);
                        }
                        scoreUpdate();
                    }
                });
            }
        };
        sleep.start();

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
    }

    public void scoreUpdate() {
        // Then, it updates the players' scores.
        if (attsServers <= 0) {
            Spannable dead = new SpannableString("DEAD");
            dead.setSpan(new ForegroundColorSpan(Color.RED), 0, dead.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            aServers.setText(dead);
            Spannable winner = new SpannableString("WINNER");
            winner.setSpan(new ForegroundColorSpan(Color.GREEN), 0, winner.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            vServers.setText(winner);
            term.setText("");
            textUpdate(term, ">_ ", Color.BLUE);
            textUpdate(term, "You lose!", Color.RED);
            Thread sleep1 = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {}
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            attsServers = 20;
                            verizonServers = 20;
                            term.setText("");
                            textUpdate(term, ">_GAME RESTARTED", Color.BLUE);
                            start = true;
                            aServers.setText(String.valueOf(attsServers));
                            vServers.setText(String.valueOf(verizonServers));
                        }
                    });
                }
            };
            sleep1.start();
        }
        else {
            aServers.setText(String.valueOf(attsServers));
            vServers.setText(String.valueOf(verizonServers));
        }
        if (verizonServers <= 0) {
            Spannable dead = new SpannableString("DEAD");
            dead.setSpan(new ForegroundColorSpan(Color.RED), 0, dead.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            vServers.setText(dead);
            Spannable winner = new SpannableString("WINNER");
            winner.setSpan(new ForegroundColorSpan(Color.GREEN), 0, winner.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            aServers.setText(winner);
            term.setText("");
            textUpdate(term, ">_ ", Color.BLUE);
            textUpdate(term, "You win!", Color.GREEN);
            textUpdate(term, "\n>_ ", Color.BLUE);
            textUpdate(term, "You were appointed chief of the security team!", Color.GREEN);
            Thread sleep2 = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {}
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            attsServers = 20;
                            verizonServers = 20;
                            term.setText("");
                            textUpdate(term, ">_GAME RESTARTED", Color.BLUE);
                            start = true;
                            vServers.setText(String.valueOf(verizonServers));
                            aServers.setText(String.valueOf(attsServers));
                        }
                    });
                }
            };
            sleep2.start();
        }
        else {
            vServers.setText(String.valueOf(verizonServers));
            aServers.setText(String.valueOf(attsServers));
        }
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