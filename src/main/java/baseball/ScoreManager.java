package baseball;

public class ScoreManager {

    private int[] computerAnswer;
    private int[] userAnswer;
    private int strike;
    private int ball;

    public ScoreManager(int[] computerAnswer, int[] userAnswer) {
        this.computerAnswer = computerAnswer;
        this.userAnswer = userAnswer;
    }

    public void checkScore() {
        strike = 0;
        ball = 0;
        for (int answer : computerAnswer) {
            for (int userA : userAnswer) {
                gradeScore(answer, userA);
            }
        }
    }

    private void gradeScore(int i, int j) {
        if (computerAnswer[i] == userAnswer[j]) {
            if (i == j) {
                ++strike;
            } else {
                ++ball;
            }
        }
    }

    public boolean playAgain() {
        if (isOver()) {
            Output.requestRestart();
            if (endGame()) {
                return false;
            }
        }
        return true;
    }

    public int getStrike() {
        return strike;
    }

    private boolean endGame() {
        int gameAgain = Integer.parseInt(Input.restartGame());
        if (gameAgain == 1) {
            return false;
        }
        return true;
    }

    private boolean isOver() {
        Output.scoreResult(ball, strike);
        if (getStrike() == 3) {
            return true;
        }
        return false;
    }
}
