package baseball;

public class Coin {

    private ScoreManager sm;

    public Coin(int[] computerAnswer, int[] userAnswer) {
        sm = new ScoreManager(computerAnswer, userAnswer);
    }

    public boolean outOfCoin() {
        if (sm.getStrike() == 3) {
            return true;
        }
        return false;
    }
}
