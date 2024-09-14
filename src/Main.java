
public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Петров", "Петр", "Иванович", 5, 150_000f);
        employees[1] = new Employee("Романеско", "Артуар", 2, 130_000f);
        employees[2] = new Employee("Маркиз", "Леруа", 3, 160_000f);
        employees[3] = new Employee("Иванов", "Максим", "Викторович", 1, 180_000f);

        EmployeeList(employees);

    }

    // Получить список всех сотрудников со всеми имеющимися по ним данными
    public static void EmployeeList(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

}