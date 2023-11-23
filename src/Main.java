import java.util.ArrayList;
import java.util.List;

public class Main {

    // Метод для вычисления полинома Ньютона
    public static double interpolate(double[] x, double[] y, double xValue) {
        double result = y[0];
        double[] f = new double[y.length];
        for (int i = 0; i < y.length; i++) {
            f[i] = y[i];
        }
        for (int i = 1; i < x.length; i++) {
            for (int j = 0; j < x.length - i; j++) {
                f[j] = (f[j + 1] - f[j]) / (x[j + i] - x[j]);
            }
            result += f[0] * calculateProduct(xValue, x, i);
        }
        return result;
    }

    // Метод для вычисления произведения (x - x[j]), j != k
    private static double calculateProduct(double xValue, double[] x, int k) {
        double result = 1;
        for (int i = 0; i < k; i++) {
            result *= (xValue - x[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        // Заданные точки
        double[] x = {0, 1, 3};
        double[] y = {1, 4, 2};

        // Значение, для которого нужно выполнить интерполяцию
        double xValue = ; // Измените эту переменную для получения значения в другой точке

        // Интерполяция методом Ньютона
        double newtonResult = interpolate(x, y, xValue);
        System.out.println("Интерполяция Ньютона в точке x = " + xValue + ": " + newtonResult);
    }
}
