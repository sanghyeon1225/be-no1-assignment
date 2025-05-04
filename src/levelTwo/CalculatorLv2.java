package levelTwo;

import java.sql.SQLOutput;
import java.util.ArrayList;
public class CalculatorLv2 {
    private final ArrayList<Integer> resultArray = new ArrayList<Integer>();
    public int calculate(int firstNum, int secondNum, char operator) {
        int result = 0;
        switch(operator) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                try {
                    result = firstNum / secondNum;
                }
                catch(Exception e1) {
                    System.out.println("0으로 나눗셈 할 수 없습니다! 다시 입력하세요.");
                    return Integer.MIN_VALUE;
                }
                break;
            default:
                System.out.println("잘못된 연산자 입력입니다.");
                return Integer.MIN_VALUE;
        }
        return result;
    }
    public int getSize() {
        return this.resultArray.size();
    }
    public int getResult(int index) {
        return this.resultArray.get(index);
    }
    public void setResult(int result) {
        this.resultArray.add(result);
    }

    public void removeResult() {
        this.resultArray.remove(0);
    }
}