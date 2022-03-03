package baseball;

public class GameManager {

    private ScoreManager sm;
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
        sm = new ScoreManager(computerAnswer, userAnswer);
        Coin coin = new Coin(computerAnswer, userAnswer);

        while (coin.outOfCoin()) {
            sm.checkScore();
        }
    }
}