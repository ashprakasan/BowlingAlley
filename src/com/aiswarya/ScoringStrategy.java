package com.aiswarya;
import java.util.ArrayList;
/**
 * Created by ashprakasan on 14/12/17.
 */
public class ScoringStrategy implements IScoringStrategy {
    @Override
    public int calculateScore(Player p) {
        int totalScore = 0;
        ArrayList<Character> score = p.getScore();
        for(int i=0;i<score.size();i++){
            if(score.get(i) == 'X'){
                totalScore+=20;
            }
            else{
                if(score.get(i) == '/'){
                    totalScore+=15-Character.getNumericValue(score.get(i-1));
                }
                else{
                    totalScore+=Character.getNumericValue(score.get(i));
                }
            }
        }
        return totalScore;
    }
}
