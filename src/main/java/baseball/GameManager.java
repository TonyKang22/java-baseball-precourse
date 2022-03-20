package baseball;

import java.util.List;

public class GameManager {

    private Player player;

    public GameManager() {
        player = new Player();
    }

    public boolean playGame(BaseballGame baseballGame) {
        List<Integer> answer = baseballGame.makeRandomNumber();
        List<Integer> playerAnswer = player.submitAnswer();
        Grade grade = baseballGame.gradeAnswer(answer, playerAnswer);

        while (!baseballGame.threeStrike(grade)) {
            playerAnswer = player.submitAnswer();
            grade = baseballGame.gradeAnswer(answer, playerAnswer);
        }
        return player.askForAnotherRound();
    }
}
