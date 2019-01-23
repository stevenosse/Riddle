/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remind;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Seven7
 */
public class Player {

    private String name;
    private int Score;
    private String[] combos;
    private int essais;
    private boolean ended;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public void saveScore() throws IOException {
        String text = this.name+"&"+this.Score+"\n";
        try { 
  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter("scores.txt", true)); 
            out.write(text); 
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    }

    public String[] getCombos() {
        return combos;
    }

    public void setCombos(String[] combos) {
        this.combos = combos;
    }

    public int getEssais() {
        return essais;
    }

    public void setEssais(int essais) {
        this.essais = essais;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

}
