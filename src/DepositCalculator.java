import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexInterestDeposit(double amount, double yearRate, int d ) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * d);
        return round(pay, 2);
    }

    double calculateSimpleInterestDeposit(double amount, double yearRate, int depositPeriod) {
         return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int action;
        int amount;
        double result = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) result = calculateSimpleInterestDeposit(amount, 0.06, period);
        else if (action == 2) result = calculateComplexInterestDeposit(amount, 0.06, period);
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
