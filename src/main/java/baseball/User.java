package baseball;

public class User {

    private int[] userAnswer;

    public User() {
        userAnswer = new int[3];
    }

    public int[] createUserAnswer(String userNumber) {
        for (int i = 0; i < 3; i++) {
            userAnswer[i] = userNumber.charAt(i) - '0';
        }
        return userAnswer;
    }
}
