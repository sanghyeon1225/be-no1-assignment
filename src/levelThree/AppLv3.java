package levelThree;
import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {
        ArithmeticCalculatorLv3<Double> calculator = new ArithmeticCalculatorLv3<>(Double.class);
        Scanner scanner = new Scanner(System.in);
        String isExit = "";

        while(!isExit.equals("exit")) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double firstNum = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double secondNum = scanner.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = scanner.next().charAt(0);

                OperatorTypeLv3 op = OperatorTypeLv3.getType(operator);

                Double cal = calculator.calculate(firstNum, secondNum, op);
                if (cal == null) {
                    continue;
                }
                else {
                    calculator.setResult(cal);
                }
            }
            catch (IllegalArgumentException e1) {
                System.out.println("잘못된 연산자 입력입니다.");
                continue;
            }
            catch (Exception e2) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine();
                continue;
            }

            System.out.print("결과를 출력하시겠습니까? (Y 입력 시 출력): ");
            char printFlag = scanner.next().charAt(0);
            if (printFlag == 'Y') {
                try {
                    System.out.print("몇 번째 결과를 출력하시겠습니까?: ");
                    int index = scanner.nextInt();
                    System.out.println("결과: " + calculator.getResult(index));
                }
                catch (Exception e1) {
                    System.out.println(calculator.getSize()+ "보다 작은 범위만 출력 가능합니다.");
                }
            }

            System.out.print("연산 결과를 삭제하시겠습니까? (Y 입력 시 삭제): ");
            char removeFlag = scanner.next().charAt(0);
            if (removeFlag == 'Y') {
                calculator.removeResult();
            }

            System.out.print("입력값보다 큰 결과값들을 출력하시겠습니까? (Y 입력시 실행): ");
            char filterFlag = scanner.next().charAt(0);
            if (filterFlag == 'Y') {
                try {
                    System.out.print("입력값을 입력하세요: ");
                    double number = scanner.nextInt();
                    calculator.printFilterList(number);
                }
                catch (Exception e1) {
                    System.out.println("올바른 숫자를 입력하세요.");
                }
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            isExit = scanner.next();
        }
    }
}