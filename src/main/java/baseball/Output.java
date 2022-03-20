package baseball;

public class Output {

    private final String TYPE_IN_NUMBERS = "숫자를 입력해주세요 : ";
    private final String CONGRATES = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String TYPE_IN_FOR_MORE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String STRIKE = "스크라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final String SPACE = " ";

    public Output() {
    }

    public void printAnswerRequest() {
        System.out.print(TYPE_IN_NUMBERS);
    }

    public void printAskMore() {
        System.out.println(CONGRATES + TYPE_IN_FOR_MORE);
    }

    public void printScore(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + BALL + SPACE + strike + STRIKE);
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        } else if (ball != 0 && strike == 0) {
            System.out.println(ball + BALL);
        } else {
            System.out.println(NOTHING);
        }
    }

}
