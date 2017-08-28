package edu.weber.stevenbrown.cs3270a3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class gameResults extends Fragment {

    TextView txtGames, txtPhoneWins, txtMyWins, txtTie;
    String result="";
    int winCount=0, loseCount=0, tieCount=0, gameCount=0;

    public gameResults() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_results, container, false);

        txtGames = (TextView)view.findViewById(R.id.txtGames);
        txtPhoneWins = (TextView)view.findViewById(R.id.txtPhoneWins);
        txtMyWins = (TextView)view.findViewById(R.id.txtMyWins);
        txtTie = (TextView)view.findViewById(R.id.txtTie);


        return view;
    }//end onCreateView

    public void updateInfo(String s){

        //result = s;
        gameCount++;

        switch(s){
            case "win":
                winCount++;
                break;
            case "lose":
                loseCount++;
                break;
            case "tie":
                tieCount++;
                break;
            default:
                break;

        }

        txtGames.setText(gameCount+"");
        txtPhoneWins.setText(loseCount+"");
        txtMyWins.setText(winCount+"");
        txtTie.setText(tieCount+"");

    }//end updateinfo


    public void reset(){
        gameCount =0;
        loseCount =0;
        winCount=0;
        tieCount=0;

        txtGames.setText(gameCount+"");
        txtPhoneWins.setText(loseCount+"");
        txtMyWins.setText(winCount+"");
        txtTie.setText(tieCount+"");

    }//end reset()

}
