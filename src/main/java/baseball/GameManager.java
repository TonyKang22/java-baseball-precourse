package baseball;

public class GameManager {

    private int[] userAnswer;
    private int[] computerAnswer;
    private int strike;
    private int ball;
    private final String RESTART_GAME = "1";
    private final String TERMINATE_GAME = "2";

    public GameManager() {
        User user = new User();
        startGame();
    }

    public void createUserAnswer(String userNumber) {
        for (int i = 0; i < 3; i++) {
            userAnswer[i] = userNumber.charAt(i) - '0';
        }
        Output.cheatVersion(computerAnswer);
        playBalls();
    }

    public void startGame() {
        Computer computer = new Computer();
        computerAnswer = computer.getAnswer();
        createUserAnswer(Input.userNumber());
    }

    public void playBalls() {
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

    private void gameStatus() {
        if (gameOver() == Output.GAME_FINISH) {
            Output.requestRestart();
            String gameAgain = Input.restartGame();

            if (gameAgain == RESTART_GAME) {
                startGame();
            } else if (gameAgain == TERMINATE_GAME) {
                return;
            }
        } else {
            createUserAnswer(Input.userNumber());
        }
    }

    private int gameOver() {
        if (result(ball, strike) == Output.GAME_FINISH) {
            return Output.GAME_FINISH;
        }
        return Output.GAME_CONTINUE;
    }

    private int result(int ball, int strike) {
        Output.scoreResult(ball, strike);
        return strike;
    }
}
