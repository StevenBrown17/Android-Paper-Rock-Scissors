package edu.weber.stevenbrown.cs3270a3;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.*;


public class gameCaption extends Fragment{

    Button btnRock, btnPaper, btnScissors;
    TextView txtPhone, txtOutcome;
    public static String outcome=""; //true player wins, false phone wins

    OnFragmentSendText sendText;
    public interface OnFragmentSendText{
        void onSendText(String text);
    }

    public void onAttach(Context context){
        super.onAttach(context);
        sendText = (OnFragmentSendText)context;
    }


    public gameCaption() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_caption, container, false);

        btnRock = (Button)view.findViewById(R.id.btnRock);
        btnPaper = (Button)view.findViewById(R.id.btnPaper);
        btnScissors = (Button)view.findViewById(R.id.btnScissors);
        txtPhone = (TextView)view.findViewById(R.id.txtPhone);
        txtOutcome = (TextView)view.findViewById(R.id.txtOutcome);


        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                btnRock.setBackgroundColor(Color.MAGENTA);
                btnPaper.setBackgroundResource(android.R.drawable.btn_default);
                btnScissors.setBackgroundResource(android.R.drawable.btn_default);


                int rand;
                Random r = new Random();
                rand = r.nextInt(3);
                //rand = 0, phone selects Rock
                //rand = 1, phone selects Paper
                //rand = 2, phone selects Scissors

                switch(rand){
                    case 0:
                        txtPhone.setText("Rock");
                        outcome = "tie";
                        txtOutcome.setText("It's a Tie!");
                        break;
                    case 1:
                        txtPhone.setText("Paper");
                        outcome = "lose";
                        txtOutcome.setText("Phone Wins!");
                        break;
                    case 2:
                        txtPhone.setText("Scissors");
                        outcome = "win";
                        txtOutcome.setText("You Win!");
                        break;
                    default:
                        break;
                }

                sendText.onSendText(outcome);


            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.refreshDrawableState();
                btnPaper.setBackgroundColor(Color.MAGENTA);
                btnRock.setBackgroundResource(android.R.drawable.btn_default);
                btnScissors.setBackgroundResource(android.R.drawable.btn_default);

                int rand;
                Random r = new Random();
                rand = r.nextInt(3);
                //rand = 0, phone selects Rock
                //rand = 1, phone selects Paper
                //rand = 2, phone selects Scissors

                switch(rand){
                    case 0:
                        txtPhone.setText("Rock");
                        outcome = "win";
                        txtOutcome.setText("You Win!");
                        break;
                    case 1:
                        txtPhone.setText("Paper");
                        outcome = "tie";
                        txtOutcome.setText("It's a Tie!");
                        break;
                    case 2:
                        txtPhone.setText("Scissors");
                        outcome = "lose";
                        txtOutcome.setText("Phone Wins!");
                        break;
                    default:
                        break;
                }

                sendText.onSendText(outcome);

            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnScissors.setBackgroundColor(Color.MAGENTA);
                btnRock.setBackgroundResource(android.R.drawable.btn_default);
                btnPaper.setBackgroundResource(android.R.drawable.btn_default);


                int rand;
                Random r = new Random();
                rand = r.nextInt(3);
                //rand = 0, phone selects Rock
                //rand = 1, phone selects Paper
                //rand = 2, phone selects Scissors

                switch(rand){
                    case 0:
                        txtPhone.setText("Rock");
                        outcome = "lose";
                        txtOutcome.setText("Phone Wins!");
                        break;
                    case 1:
                        txtPhone.setText("Paper");
                        outcome = "win";
                        txtOutcome.setText("You Win!");
                        break;
                    case 2:
                        txtPhone.setText("Scissors");
                        outcome = "tie";
                        txtOutcome.setText("It's a Tie!");
                        break;
                    default:
                        break;
                }

                sendText.onSendText(outcome);

            }
        });

        return view;

    }//end onCreateView



}//end class
