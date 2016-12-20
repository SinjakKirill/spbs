package com.example.sinyakkirill.lab_12_13;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    int [][] arrInt;

    ImageButton b1, b2, b3, b4, b5, b6, b7, b8, b9;

    String[] arrItemMenu;
    int turn;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        arrItemMenu = getResources().getStringArray(R.array.itemMenu);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrItemMenu));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        restartGame();
                        break;
                    default:
                        break;
                }
            }
        });

        arrInt = new int[][]{{ 0, 0, 0},
                            { 0, 0, 0},
                            { 0, 0, 0}};

        b1 = (ImageButton) findViewById(R.id.b1);
        b2 = (ImageButton) findViewById(R.id.b2);
        b3 = (ImageButton) findViewById(R.id.b3);
        b4 = (ImageButton) findViewById(R.id.b4);
        b5 = (ImageButton) findViewById(R.id.b5);
        b6 = (ImageButton) findViewById(R.id.b6);
        b7 = (ImageButton) findViewById(R.id.b7);
        b8 = (ImageButton) findViewById(R.id.b8);
        b9 = (ImageButton) findViewById(R.id.b9);

        turn = 1;

        // X - 1
        // Y - 2

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[0][0] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b1.setImageResource(R.drawable.cross);
                        arrInt[0][0] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b1.setImageResource(R.drawable.ring);
                        arrInt[0][0] = 2;
                    }
                }
                endGame();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[0][1] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b2.setImageResource(R.drawable.cross);
                        arrInt[0][1] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b2.setImageResource(R.drawable.ring);
                        arrInt[0][1] = 2;
                    }
                }
                endGame();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[0][2] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b3.setImageResource(R.drawable.cross);
                        arrInt[0][2] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b3.setImageResource(R.drawable.ring);
                        arrInt[0][2] = 2;
                    }
                }
                endGame();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[1][0] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b4.setImageResource(R.drawable.cross);
                        arrInt[1][0] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b4.setImageResource(R.drawable.ring);
                        arrInt[1][0] = 2;
                    }
                }
                endGame();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[1][1] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b5.setImageResource(R.drawable.cross);
                        arrInt[1][1] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b5.setImageResource(R.drawable.ring);
                        arrInt[1][1] = 2;
                    }
                }
                endGame();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[1][2] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b6.setImageResource(R.drawable.cross);
                        arrInt[1][2] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b6.setImageResource(R.drawable.ring);
                        arrInt[1][2] = 2;
                    }
                }
                endGame();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[2][0] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b7.setImageResource(R.drawable.cross);
                        arrInt[2][0] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b7.setImageResource(R.drawable.ring);
                        arrInt[2][0] = 2;
                    }
                }
                endGame();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[2][1] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b8.setImageResource(R.drawable.cross);
                        arrInt[2][1] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b8.setImageResource(R.drawable.ring);
                        arrInt[2][1] = 2;
                    }
                }
                endGame();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrInt[2][2] == 0){
                    if (turn == 1) {
                        turn = 2;
                        b9.setImageResource(R.drawable.cross);
                        arrInt[2][2] = 1;
                    } else if (turn == 2) {
                        turn = 1;
                        b9.setImageResource(R.drawable.ring);
                        arrInt[2][2] = 2;
                    }
                }
                endGame();
            }
        });
    }

    public void endGame(){
        boolean end = false;
        String winner = new String();

        if(arrInt[0][0] == 2 && arrInt[0][1] == 2 && arrInt[0][2] == 2 ){
            Toast.makeText(this, "Winner player O!", Toast.LENGTH_LONG).show();
            finishAnimation(b1, b2, b3);
            winner = "O";
            end = true;
        }
        if(arrInt[0][0] == 2 && arrInt[1][1] == 2 && arrInt[2][2] == 2){
            Toast.makeText(this, "Winner player O!", Toast.LENGTH_LONG).show();
            finishAnimation(b1, b5, b9);
            end = true;
        }
        if(arrInt[0][0] == 2 && arrInt[1][0] == 2 && arrInt[2][0] == 2){
            Toast.makeText(this, "Winner player O!", Toast.LENGTH_LONG).show();
            finishAnimation(b1, b4, b7);
            end = true;
        }
        if(arrInt[0][1] == 2 && arrInt[1][1] == 2 && arrInt[2][1] == 2){
            Toast.makeText(this, "Winner player O!", Toast.LENGTH_LONG).show();
            finishAnimation(b2, b5, b8);
            end = true;
        }
        if(arrInt[0][2] == 2 && arrInt[1][2] == 2 && arrInt[2][2] == 2){
            Toast.makeText(this, "Winner player O!", Toast.LENGTH_LONG).show();
            finishAnimation(b3, b6, b9);
            end = true;
        }
        if(arrInt[1][0] == 2 && arrInt[1][1] == 2 && arrInt[1][2] == 2){
            Toast.makeText(this, "Winner player O!", Toast.LENGTH_LONG).show();
            finishAnimation(b4, b5, b6);
            end = true;
        }
        if(arrInt[2][0] == 2 && arrInt[2][1] == 2 && arrInt[2][2] == 2){
            Toast.makeText(this, "Winner player O!", Toast.LENGTH_LONG).show();
            finishAnimation(b7, b8, b9);
            end = true;
        }
        if(arrInt[2][0] == 2 && arrInt[1][1] == 2 && arrInt[0][2] == 2){
            Toast.makeText(MainActivity.this, "Winner Player O!", Toast.LENGTH_LONG).show();
            finishAnimation(b7, b5, b3);
            end = true;
        }


        ///////////////////////////////////////////////////////////////////////

        if(arrInt[0][0] == 1 && arrInt[0][1] == 1 && arrInt[0][2] == 1 ){
            Toast.makeText(this, "Winner player X!", Toast.LENGTH_LONG).show();
            finishAnimation(b1, b2, b3);
            end = true;
        }
        if(arrInt[0][0] == 1 && arrInt[1][1] == 1 && arrInt[2][2] == 1){
            Toast.makeText(this, "Winner player X!", Toast.LENGTH_LONG).show();
            finishAnimation(b1, b5, b9);
            end = true;
        }
        if(arrInt[0][0] == 1 && arrInt[1][0] == 1 && arrInt[2][0] == 1){
            Toast.makeText(this, "Winner player X!", Toast.LENGTH_LONG).show();
            finishAnimation(b1, b4, b7);
            end = true;
        }
        if(arrInt[0][1] == 1 && arrInt[1][1] == 1 && arrInt[2][1] == 1){
            Toast.makeText(this, "Winner player X!", Toast.LENGTH_LONG).show();
            finishAnimation(b2, b5, b8);
            end = true;
        }
        if(arrInt[0][2] == 1 && arrInt[1][2] == 1 && arrInt[2][2] == 1){
            Toast.makeText(this, "Winner player X!", Toast.LENGTH_LONG).show();
            finishAnimation(b3, b6, b9);
            end = true;
        }
        if(arrInt[1][0] == 1 && arrInt[1][1] == 1 && arrInt[1][2] == 1){
            Toast.makeText(this, "Winner player X!", Toast.LENGTH_LONG).show();
            finishAnimation(b4, b5, b6);
            end = true;
        }
        if(arrInt[2][0] == 1 && arrInt[2][1] == 1 && arrInt[2][2] == 1){
            Toast.makeText(this, "Winner player X!", Toast.LENGTH_LONG).show();
            finishAnimation(b7, b8, b9);
            end = true;
        }
        if(arrInt[2][0] == 1 && arrInt[1][1] == 1 && arrInt[0][2] == 1){
            Toast.makeText(MainActivity.this, "Winner Player X!", Toast.LENGTH_LONG).show();
            finishAnimation(b7, b5, b3);
            end = true;
        }

        if(end){
            b1.setClickable(false);
            b2.setClickable(false);
            b3.setClickable(false);
            b4.setClickable(false);
            b5.setClickable(false);
            b6.setClickable(false);
            b7.setClickable(false);
            b8.setClickable(false);
            b9.setClickable(false);
        }
        else{
            boolean point = false;
            for(int i = 0; i < arrInt.length; i++)
                for (int j = 0; j < arrInt.length; j++){
                    if(arrInt[i][j] == 0)
                        point = true;
                }
            if(!point){
                alertDialogRestart(this);
            }
        }
    }

    public void finishAnimation(ImageButton b_1, ImageButton b_2, ImageButton b_3){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        b_1.startAnimation(animation);
        b_2.startAnimation(animation);
        b_3.startAnimation(animation);
    }

    public void restartGame(){
        for(int i = 0; i < arrInt.length; i++)
            for (int j = 0; j < arrInt.length; j++)
                arrInt[i][j] = 0;
        b1.setImageResource(0);
        b2.setImageResource(0);
        b3.setImageResource(0);
        b4.setImageResource(0);
        b5.setImageResource(0);
        b6.setImageResource(0);
        b7.setImageResource(0);
        b8.setImageResource(0);
        b9.setImageResource(0);

        b1.setClickable(true);
        b2.setClickable(true);
        b3.setClickable(true);
        b4.setClickable(true);
        b5.setClickable(true);
        b6.setClickable(true);
        b7.setClickable(true);
        b8.setClickable(true);
        b9.setClickable(true);

        turn = 1;
    }

    public void alertDialogRestart(Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("End Game!")
                .setMessage("Restart?")
                .setCancelable(false)
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                restartGame();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
