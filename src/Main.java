
public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Петров", "Петр", "Иванович", 5, 150_000f);
        employees[1] = new Employee("Романеско", "Артуар", 2, 130_000f);
        employees[2] = new Employee("Маркиз", "Леруа", 3, 160_000f);
        employees[3] = new Employee("Иванов", "Максим", "Викторович", 1, 180_000f);

        EmployeeList(employees);
        System.out.println("Сумма затрат на зарплаты на месяц: " + TotalSalaryByMonth(employees) + " руб.");
        System.out.println("Сотрудник с минимальной зарплатой: " + MinSalaryEmployee(employees) + " руб.");

    }

    // Получить список всех сотрудников со всеми имеющимися по ним данными
    public static void EmployeeList(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // Посчитать сумму затрат на зарплаты в месяц.
    public static float TotalSalaryByMonth(Employee[] employees) {
        float totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    // Найти сотрудника с минимальной зарплатой.
    public static Employee MinSalaryEmployee(Employee[] employees) {
        Employee minSalaryEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }
}