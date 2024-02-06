import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 컴퓨터 점수 지정
        int[] computerNumbers = getComputerNumbers();

        // 사용자 입력 부분
        playBaseball(computerNumbers);
    }

    private static void playBaseball(int[] computerNumbers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int tryCount = 1;
        while (true) {
            System.out.print(tryCount + "번째 시도 : ");
            int userNumber = sc.nextInt();
            int[] userNumbers = {userNumber / 100, userNumber % 100 / 10, userNumber % 10};

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < computerNumbers.length; i++) {
                for (int j = 0; j < userNumbers.length; j++) {
                    if (computerNumbers[i] == userNumbers[j]) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }

            showBaseballScore(strike, ball);

            if (strike == 3) {
                System.out.println(tryCount + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }

            tryCount++;
        }
    }

    private static void showBaseballScore(int strike, int ball) {
        if (ball == 3) {
            System.out.println(ball + "B");
        } else if (strike == 3) {
            System.out.println(strike + "S");
        } else {
            System.out.println(ball + "B" + strike + "S");
        }
    }

    private static int[] getComputerNumbers() {
        int[] computerNumbers = new int[3];
        Random random = new Random();

        for (int i = 0; i < computerNumbers.length; i++) {
            int randomNumber = random.nextInt(10); // 0 ~ 9
            computerNumbers[i] = randomNumber;

            // 중복 체크
            for (int j = 0; j < i; j++) {
                if (computerNumbers[j] == randomNumber) {
                    i--;
                    break;
                }
            }
        }
        return computerNumbers;
    }
}