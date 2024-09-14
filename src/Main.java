
public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Петров", "Петр", "Иванович", 5, 150_000f);
        employees[1] = new Employee("Романеско", "Артуар",  2, 130_000f);

        System.out.println(employees[0]);
        System.out.println(employees[1]);

        System.out.println(employees[0].getFullName());
        System.out.println(employees[1].getFullName());
    }
}