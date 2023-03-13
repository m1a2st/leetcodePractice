package leecode;

import java.util.*;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.isDigit;
import static leecode.Utils.charArr2HashSet;
import static leecode.Utils.charArr2IntegerArr;

/**
 * @Author Ken
 * @Date
 * @Version
 * @Description
 */
public class ABGame {
    public static void main(String[] args) {
        AsBsGame game = new AsBsGame();
        game.start();
    }
}

class AsBsGame {

    private final Scanner sc;
    private final Integer[] ans;
    private Integer[] input;
    private boolean gameOver = false;
    private final int SIZE = 4;

    public AsBsGame() {
        Set<Integer> ans = new HashSet<>();
        Random random = new Random();
        while (ans.size() < SIZE) {
            int number = random.nextInt(10);
            ans.add(number);
        }
        this.ans = ans.toArray(new Integer[0]);
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Game Start!");
        while (!gameOver) {
            getInput();
            checkAnsAndPrint();
        }
    }

    private void getInput() {
        try {
            System.out.println("Please input your answer:");
            String customerAns = sc.next();
            char[] chars = customerAns.toCharArray();
            checkSize(chars);
            checkDigit(chars);
            checkDuplicate(chars);
            this.input = charArr2IntegerArr(chars);
        } catch (IllegalArgumentException e) {
            System.out.println("Input Illegal Argument!!!");
            getInput();
        }
    }

    private void checkAnsAndPrint() {
        int[] asAndBs = getAsAndBs(input, ans);
        printAsAndBs(asAndBs);
        checkEndGame(asAndBs);
    }

    private void checkSize(char[] chars) throws IllegalArgumentException {
        if (chars.length != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDigit(char[] chars) throws IllegalArgumentException {
        for (int i = 0; i < SIZE; i++) {
            if (!isDigit(chars[i])) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkDuplicate(char[] chars) throws IllegalArgumentException {
        if (charArr2HashSet(chars).size() != 4) {
            throw new IllegalArgumentException();
        }
    }

    private void checkEndGame(int[] asAndBs) {
        if (asAndBs[0] == SIZE) {
            gameOver = true;
            sc.close();
            System.out.println("game over");
        }
    }

    private void printAsAndBs(int[] asAndBs) {
        System.out.printf("%dA%dB%n", asAndBs[0], asAndBs[1]);
    }

    private int[] getAsAndBs(Integer[] inputs, Integer[] answers) {
        int a = 0, b = 0;
        for (int i = 0; i < SIZE; i++) {
            if (inputs[i].equals(answers[i])) {
                a++;
            } else {
                for (int j = 0; j < SIZE; j++) {
                    if (inputs[i].equals(answers[j])) {
                        b++;
                        break;
                    }
                }
            }
        }
        return new int[]{a, b};
    }
}

class Utils {

    public static Integer[] charArr2IntegerArr(char[] chars) {
        String string = new String(chars);
        Integer[] integerArray = new Integer[string.length()];
        for (int i = 0; i < string.length(); i++) {
            integerArray[i] = getNumericValue(string.charAt(i));
        }
        return integerArray;
    }

    public static HashSet<Integer> charArr2HashSet(char[] chars) {
        HashSet<Integer> set = new HashSet<>();
        for (char c : chars) {
            set.add((int) c);
        }
        return set;
    }
}