import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class seriesCounter {
    public static void main(String args[]) {
        Scanner userInput = new Scanner(System.in);
        double seriesSum = 0;
        BigDecimal preciseSumOfSeries = new BigDecimal(0);
        int n = 0;
        double x = 0;
        System.out.print("Enter N: ");
        if (userInput.hasNextInt()) {
            n = userInput.nextInt();
        } else {
            System.out.println("Incorrect data, try again");
        }

        System.out.print("Enter X (-1,1): ");
        if (userInput.hasNextDouble()) {
            x = userInput.nextDouble();
        } else {
            System.out.println("Incorrect data, try again");
        }

        if (n < 15) {
            seriesSum = doubleSeriesSum(n, x);
            System.out.println(seriesSum);
        } else {
            preciseSumOfSeries = bigDecimalSeriesSum(n, x);
            System.out.println(preciseSumOfSeries);
        }
        userInput.close();

    }

    public static double doubleSeriesSum(int n, double x) {
        double seriesSum = 0;
        for (int i = 1; i <= n; i++) {
            seriesSum += Math.pow(-1, i) * (Math.pow(x, (2 * i - 1)) / (2 * i - 1));
        }
        return seriesSum;
    }

    public static BigDecimal bigDecimalSeriesSum(int n, double x) {
        BigDecimal seriesSum = new BigDecimal("0.0");
        for (int i = 1; i <= n; i++) {
            seriesSum = seriesSum.add((BigDecimal.valueOf(x).pow(2 * i - 1)
                    .divide(BigDecimal.valueOf((2 * i - 1)),n,RoundingMode.HALF_UP))
                    .multiply(BigDecimal.valueOf(Math.pow(-1, i))));
        }
        return seriesSum;
    }
}