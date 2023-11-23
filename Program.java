package AtividadesEnum.teste;

import AtividadesEnum.domain.Department;
import AtividadesEnum.domain.HourContract;
import AtividadesEnum.domain.Worker;
import AtividadesEnum.domain.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String nameWorker = sc.nextLine();
        System.out.print("Level: ");
        String levelWorker = sc.nextLine();
        System.out.print("Base Salary: ");
        Double baseSalary = sc.nextDouble();
        Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(levelWorker), baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractsDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractsDate, valuePerHour, hours);
            worker.addContract(contract);
        }
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartment().getName());
        System.out.println("Level: " + worker.getLevel());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.inCome(year, month)));

    }
}
