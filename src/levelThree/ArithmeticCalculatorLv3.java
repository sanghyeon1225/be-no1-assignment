package levelThree;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class ArithmeticCalculatorLv3<T extends Number> {
    private final ArrayList<T> resultArray = new ArrayList<>();
    private final Class<T> type;

    public ArithmeticCalculatorLv3(Class<T> type) {
        this.type = type;
    }

    public T calculate(T firstNum, T secondNum, OperatorTypeLv3 op) {
        double result = 0;
        switch(op) {
            case PLUS:
                result = firstNum.doubleValue() + secondNum.doubleValue();
                break;
            case MINUS:
                result = firstNum.doubleValue() - secondNum.doubleValue();
                break;
            case MULTIPLY:
                result = firstNum.doubleValue() * secondNum.doubleValue();
                break;
            case DIVIDE:
                try {
                    result = firstNum.doubleValue() / secondNum.doubleValue();
                }
                catch(Exception e1) {
                    System.out.println("0으로 나눗셈 할 수 없습니다! 다시 입력하세요.");
                    return null;
                }
                break;
        }
        return typeConvert(result);
    }

    private T typeConvert(double result) {
        if (type == Integer.class) {
            return (T) Integer.valueOf((int) result);
        }
        else if (type == Double.class) {
            return (T) Double.valueOf(result);
        }
        else if (type == Float.class) {
            return (T) Float.valueOf((float) result);
        }
        else if (type == Long.class) {
            return (T) Long.valueOf((long) result);
        }
        else if (type == Short.class) {
            return (T) Short.valueOf((short) result);
        }
        else {
            return (T) Double.valueOf(result);
        }
    }
    public int getSize() {
        return this.resultArray.size();
    }
    public T getResult(int index) {
        return this.resultArray.get(index);
    }
    public void setResult(T result) {
        this.resultArray.add(result);
    }

    public void removeResult() {
        this.resultArray.remove(0);
    }

    public void printFilterList(T number) {
        List<T> newArray = resultArray.stream()
                .filter(r -> r.doubleValue() > number.doubleValue())
                .toList();

        if (!newArray.isEmpty()) {
            System.out.print(number + "보다 큰 결과값 출력: ");
            for (T num : newArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        else {
            System.out.println(number + "보다 큰 결과값이 없습니다.");
        }

    }
}