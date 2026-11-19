import java.util.Scanner;

public class PersonalIncomeTax {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String name;
        double salary, dailyRate, sidelineIncome;
        double monthlyIncome, annualIncome;
        double annualTax, monthlyTax, takeHome;

        System.out.println("==================================");
        System.out.println(" PERSONAL INCOME TAX CALCULATOR");
        System.out.println("==================================");

        System.out.print("Employee Name: ");
        name = input.nextLine();

        System.out.print("Monthly Basic Salary: ");
        salary = input.nextDouble();

        System.out.print("Daily Sideline Rate: ");
        dailyRate = input.nextDouble();

        System.out.print("Number of Sideline Workdays: ");
        int days = input.nextInt();

        if (salary < 0 || dailyRate < 0 || days < 0) {
            System.out.println("Invalid input. Please enter positive values.");
            input.close();
            return;
        }

        sidelineIncome = dailyRate * days;
        monthlyIncome = salary + sidelineIncome;
        annualIncome = monthlyIncome * 12;

        if (annualIncome <= 250000) {
            annualTax = 0;
        } else if (annualIncome <= 400000) {
            annualTax = (annualIncome - 250000) * 0.15;
        } else if (annualIncome <= 800000) {
            annualTax = 22500 +
                (annualIncome - 400000) * 0.20;
        } else if (annualIncome <= 2000000) {
            annualTax = 102500 +
                (annualIncome - 800000) * 0.25;
        } else if (annualIncome <= 8000000) {
            annualTax = 402500 +
                (annualIncome - 2000000) * 0.30;
        } else {
            annualTax = 2202500 +
                (annualIncome - 8000000) * 0.35;
        }

        monthlyTax = annualTax / 12;
        takeHome = monthlyIncome - monthlyTax;

        System.out.println("\n==================================");
        System.out.println("         INCOME TAX RESULT");
        System.out.println("==================================");

        System.out.println("Employee Name: " + name);
        System.out.printf("Monthly Salary: PHP %.2f%n", salary);
        System.out.printf("Sideline Income: PHP %.2f%n", sidelineIncome);
        System.out.printf("Monthly Income: PHP %.2f%n", monthlyIncome);
        System.out.printf("Annual Income: PHP %.2f%n", annualIncome);

        System.out.println("----------------------------------");

        System.out.printf("Annual Income Tax: PHP %.2f%n", annualTax);
        System.out.printf("Monthly Income Tax: PHP %.2f%n", monthlyTax);
        System.out.printf("Take-Home Income: PHP %.2f%n", takeHome);

        System.out.println("==================================");

        input.close();
    }
}
