abstract class Employee {
    String name;
    int id;
    double baseSalary;

    public Employee (String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public abstract double calcSalary ();

    public void displayEmployeeInfo () {
        System.out.println(name + " " + id + " " + baseSalary);
    }
}

interface Payable {
    double getPaymentAmount() ;
}

class FullTimeEmployee extends Employee implements Payable {
    public FullTimeEmployee(String name, int id, double baseSalary) {
        super(name, id, baseSalary*1.2);
    }

    @Override
    public double calcSalary() {
        return getPaymentAmount();
    }

    @Override
    public double getPaymentAmount() {
        return baseSalary;
    }
}

class ContractEmployee extends Employee implements Payable {
    private int hourlyRate;
    private int hoursWorked;

    public ContractEmployee(String name, int id, double baseSalary, int hourlyRate, int hoursWorked) {
        super(name, id, baseSalary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calcSalary() {
        return getPaymentAmount();
    }

    @Override
    public double getPaymentAmount() {
        return hourlyRate * hoursWorked;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] emps = new Employee[2];
        emps[0] = new FullTimeEmployee("Baistan", 123, 500000);
        emps[1] = new ContractEmployee("Akbar", 456, 500, 2, 200);
        for(Employee e : emps) {
            e.displayEmployeeInfo();
            System.out.println(e.calcSalary());
        }
    }
}