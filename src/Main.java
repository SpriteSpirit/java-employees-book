
public class Main {
    public static void main(String[] args) {
        EmployeeBook employees = new EmployeeBook(10);

        employees.AddEmployee(new Employee("Петров", "Петр", "Иванович", 5, 150_000f));
        employees.AddEmployee(new Employee("Романеско", "Артуар", 2, 130_000f));
        employees.AddEmployee(new Employee("Маркиз", "Леруа", 3, 160_000f));
        employees.AddEmployee(new Employee("Дебекью", "Франсуа", 3, 155_000f));
        employees.AddEmployee(new Employee("Иванов", "Максим", "Викторович", 1, 180_000f));
        employees.AddEmployee(new Employee("Смирнов", "Евгений", "Маркович", 1, 170_000f));


        employees.EmployeeList();
        System.out.println("Сумма затрат на зарплаты на месяц: " + employees.TotalSalaryByMonth() + " руб.");
        System.out.println("Сотрудник с минимальной зарплатой: " + employees.MinSalaryEmployee() + " руб.");
        System.out.println("Сотрудник с максимальной зарплатой: " + employees.MaxSalaryEmployee() + " руб.");
        System.out.println("Среднее значение зарплат: " + employees.AverageSalary() + " руб.");
        employees.FullNameList();
        employees.IndexSalary(1.2f);
        employees.EmployeeList();

        System.out.println("Сотрудник отдела с минимальной зарплатой: " + employees.MinSalaryEmployeeByDept(1));
        System.out.println("Сотрудник отдела с максимальной зарплатой: " + employees.MaxSalaryEmployeeByDept(1));
        System.out.println("Сумма затрат на зарплаты отдела: " + employees.TotalSalaryByDept(1));
        System.out.println("Средняя зарплата по отделу: " + employees.AverageSalaryByDept(1));
        employees.IndexSalary(1.2f, 1);
        employees.EmployeeListByDept(1);
        employees.FindEmployeesWithSalaryLessThan(160_000f);
        employees.FindEmployeesWithSalaryMoreOrEqualThan(150_000f);

        employees.DeleteEmployee("Дебекью", "Франсуа");
        employees.DeleteEmployee("Иванов", "Максим", "Викторович");
        employees.DeleteEmployee(2);

        employees.UpdateEmployee("Петров", "Петр", "Иванович", 3, 160000f);
        employees.UpdateEmployee("Петров", "Петр", "Иванович", 165000f);
        employees.UpdateEmployee("Петров", "Петр", "Иванович", 1);
        employees.EmployeeList();
        employees.FullNameListSortedByDept();
    }
}
