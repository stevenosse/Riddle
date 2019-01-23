/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remind;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Seven7
 */
public class GameEngine {

    public int numberToFind;
    private String gameMode;
    private Player player1;
    private Player player2;

    public static final int PLAYER1_TYPE = 1;
    public static final int PLAYER2_TYPE = 2;

    public static final String SUCCESS = "trouvé";
    public static final String FAIL = "raté";
    public static final String FINISH = "Not enough try";

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public GameEngine(String gameMode, Player player1, Player player2) {
        this.gameMode = gameMode;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void generateNumber(int min, int max) {
        Random r = new Random();
        int number = r.nextInt(max - min) + 1;
        this.numberToFind = number;
        System.out.println(this.numberToFind);
    }

    public String giveIndice() {
        StringBuilder s = new StringBuilder();
        s.append("Le nombre est compris entre ").append(this.numberToFind - 2).append(" et ").append(this.numberToFind + 2);
        return s.toString();
    }

    public String validate(int answer, int playerType) throws IOException {
        if ("Mode Solo".equals(this.gameMode)) {
            if (answer == numberToFind) {
                player1.setScore(player1.getScore() + 10);
                return GameEngine.SUCCESS;
            } else {
                if (this.player1.getEssais() > 0) {
                    this.player1.setEssais(this.player1.getEssais() - 1);
                    return GameEngine.FAIL;
                } else {
                    player1.saveScore();
                    return GameEngine.FINISH;
                }
            }
        } else {
            if (playerType == 1) {
                if (this.player1.getEssais() > 1) {
                    if (answer == numberToFind) {
                        player1.setScore(player1.getScore() + 10);
                        return GameEngine.SUCCESS;
                        }
                    this.player1.setEssais(this.player1.getEssais() - 1);
                    return GameEngine.FAIL;
                } else {
                    return GameEngine.FINISH;
                }
            } else {
                if (answer == numberToFind) {
                    player2.setScore(player2.getScore() + 10);
                    return GameEngine.SUCCESS;
                } else if (this.player2.getEssais() > 0) {
                    this.player2.setEssais(this.player2.getEssais() - 1);
                    return GameEngine.FAIL;
                } else {
                    return GameEngine.FINISH;
                }
            }
        }
    }
}
