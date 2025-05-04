package levelOne;
import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String isExit = "";
        int result = 0;

        while(!isExit.equals("exit")) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int firstNum = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int secondNum = scanner.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = scanner.next().charAt(0);

                if (operator == '+') {
                    result = firstNum + secondNum;
                }
                else if (operator == '-') {
                    result = firstNum - secondNum;
                }
                else if (operator == '*') {
                    result = firstNum * secondNum;
                }
                else if (operator == '/') {
                    if (secondNum == 0) {
                        System.out.println("0으로 나눗셈 할 수 없습니다! 다시 입력하세요.");
                        continue;
                    }
                    result = firstNum / secondNum;
                }
                else {
                    System.out.println("잘못된 연산 기호 입력! 다시 입력하세요.");
                    continue;
                }
            }
            catch (Exception e1) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine();
                continue;
            }

            System.out.println("연산 결과: " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            isExit = scanner.next();
        }
    }
}