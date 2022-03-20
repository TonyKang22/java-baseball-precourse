package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private final int AGAIN = 1;
    private final int TERMINATE = 2;

    public Input() {
    }

    public List<Integer> inputPlayerAnswer() {
        String playerAnswer = Console.readLine();

        if (playerAnswer.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> playerAnswerList = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            int num = playerAnswer.charAt(i) - '0';
            playerAnswerList.add(num);
        }
        return playerAnswerList;
    }

    public boolean anotherRound() {
        int playerResponse = Console.readLine().charAt(0) - '0';
        if (playerResponse != AGAIN && playerResponse != TERMINATE) {
            throw new IllegalArgumentException();
        }
        return playerResponse == AGAIN;
    }
}
