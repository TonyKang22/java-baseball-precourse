package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

    public BaseballGame() {
    }

    public List<Integer> makeRandomNumber() {
        int answer = Randoms.pickNumberInRange(Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END);
        List<Integer> answerList = new ArrayList<>();
        Set<Integer> answerSet = new HashSet<>();

        while (answerSet.size() < Constants.DIGIT_NUMBER) {
            if (answerSet.contains(answer)) {
                answer = Randoms.pickNumberInRange(Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END);
            } else {
                answerSet.add(answer);
                answerList.add(answer);
            }
        }
        return answerList;
    }

    public Grade gradeAnswer(List<Integer> answerList, List<Integer> playerAnswer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < Constants.DIGIT_NUMBER; ++i) {
            if (answerList.get(i) == playerAnswer.get(i)) {
                ++strike;
                continue;
            }
            if (answerList.contains(playerAnswer.get(i))) {
                ++ball;
            }
        }

        Output playerOutput = new Output();
        playerOutput.printScore(strike, ball);

//        System.out.println("===Cheat Code : " + answerList.toString());

        return new Grade(strike, ball);
    }

    public boolean threeStrike(Grade grade) {
        return grade.getStrike() == Constants.WINNER;
    }
}
