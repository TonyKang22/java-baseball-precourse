package baseball;

public class GameManager {

    private int[] userAnswer;
    private int[] computerAnswer;
    private int strike;
    private int ball;
    private final String RESTART_GAME = "1";

    public GameManager() {
        startComputer();
        setUser();
    }

    private void startComputer() {
        Computer computer = new Computer();
        computerAnswer = computer.getAnswer();
    }

    private void setUser() {
        User user = new User();
        userAnswer = user.createUserAnswer(Input.userNumber());
    }

    public void playGame() {
        while (gameStatus() == RESTART_GAME) {
            playBalls();

        }
    }

    private void playBalls() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                getScore(i, j);
            }
        }
        gameStatus();
    }

    private void getScore(int i, int j) {
        if (computerAnswer[i] == userAnswer[j]) {
            if (i == j) {
                ++strike;
            } else {
                ++ball;
            }
        }
    }

    private String gameStatus() {
        if (gameOver() == Output.GAME_FINISH) {
            Output.requestRestart();
            String gameAgain = Input.restartGame();
            return gameAgain;
        }
        return null;
    }

    private int gameOver() {
        if (result() == Output.GAME_FINISH) {
            return Output.GAME_FINISH;
        }
        return Output.GAME_CONTINUE;
    }

    private int result() {
        Output.scoreResult(ball, strike);
        return strike;
    }
}
