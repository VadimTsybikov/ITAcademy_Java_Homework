package calculatorWithOperator;

public class CalculatorWithOperator implements CalcInterface {
    //вещественное сложение
    public final double sum(double a, double b) {
        return a + b;
    }

    //вещественное вычитание
    public final double subtract(double a, double b) {
        return a - b;
    }

    //вещественное деление
    public final double divide(double a, double b) {
        return a / b;
    }

    //вещественное умножение
    public final double multiply(double a, double b) {
        return a * b;
    }

    //возведение вещественного числа в целочисленную степень
    public double power(double a, int b) {
        double result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        return result;
    }

    //модуль вещественного числа
    public double abs(double a) {
        return (a < 0) ? a * -1.0 : a;
    }

    //извлечение целочисленного корня из вещественного числа
    public double root(double a, int b) {
        double result = 0;

        //если требуется вычислить корень четной степени отрицательного числа - вернуть не-число
        if ((a < 0) && (b % 2 == 0))
            return Double.NaN;

        //подбор начального предположения
        int guess = 1;
        while (power(guess + 1, b) <= a)
            guess++;

        result += guess;

        if (a - guess > 0) {
            //итеративное уточнение предположения
            double lastRoot = guess;
            while (true) {
                double curRoot = (1 / (double)b) * ((b - 1) * lastRoot + a / (power(lastRoot, b - 1)));     //сложная формула, используемая в методе Ньютона
                curRoot = (int)(curRoot * 100) / 100.0;  //округление до сотых

                //если
                if (curRoot == lastRoot) {
                    result = curRoot;
                    break;
                }
                else
                    lastRoot = curRoot;
            }
        }

        return result;
    }
}