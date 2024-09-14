
public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Петров", "Петр", "Иванович", 5, 150_000f);
        employees[1] = new Employee("Романеско", "Артуар", 2, 130_000f);
        employees[2] = new Employee("Маркиз", "Леруа", 3, 160_000f);
        employees[3] = new Employee("Дебекью", "Франсуа", 3, 155_000f);
        employees[4] = new Employee("Иванов", "Максим", "Викторович", 1, 180_000f);
        employees[5] = new Employee("Смирнов", "Евгений", "Маркович", 1, 170_000f);

        EmployeeList(employees);
        System.out.println("Сумма затрат на зарплаты на месяц: " + TotalSalaryByMonth(employees) + " руб.");
        System.out.println("Сотрудник с минимальной зарплатой: " + MinSalaryEmployee(employees) + " руб.");
        System.out.println("Сотрудник с максимальной зарплатой: " + MaxSalaryEmployee(employees) + " руб.");
        System.out.println("Среднее значение зарплат: " + AverageSalary(employees) + " руб.");
        FullNameList(employees);
        IndexSalary(employees, 1.2f);
        EmployeeList(employees);

        System.out.println("Сотрудник отдела с минимальной зарплатой: " + MinSalaryEmployeeByDept(employees, 1));
        System.out.println("Сотрудник отдела с максимальной зарплатой: " + MaxSalaryEmployeeByDept(employees, 1));
        System.out.println("Сумма затрат на зарплаты отдела: " + TotalSalaryByDept(employees, 1));
        System.out.println("Средняя зарплата по отделу: " + AverageSalaryByDept(employees, 1));

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

    // Найти сотрудника с максимальной зарплатой.
    public static Employee MaxSalaryEmployee(Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    // Подсчитать среднее значение зарплат
    public static float AverageSalary(Employee[] employees) {
        int employeeCount = 0;
        float totalSalary = TotalSalaryByMonth(employees);

        for (Employee employee : employees) {
            if (employee!= null) {
                employeeCount++;
            }
        }

        return totalSalary/employeeCount;
    }

    // Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public static void FullNameList(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee!= null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    // Проиндексировать зарплату у всех сотрудников на величину аргумента в %.
    public static void IndexSalary(Employee[] employees, float index) {
        for (Employee employee : employees) {
            if (employee!= null) {
                employee.setSalary(employee.getSalary() * (1 + index/100));
            }
        }
    }

    // Найти сотрудника с минимальной зарплатой в отделе.
    public static Employee MinSalaryEmployeeByDept(Employee[] employees, int dept) {
        Employee minSalaryEmployee = null;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    // Найти сотрудника с максимальной зарплатой в отделе.
    public static Employee MaxSalaryEmployeeByDept(Employee[] employees, int dept) {
        Employee maxSalaryEmployee = null;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    // Найти сумму затрат на зарплату по отделу.
    public static float TotalSalaryByDept(Employee[] employees, int dept) {
        float totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    // Найти среднюю зарплату по отделу
    public static float AverageSalaryByDept(Employee[] employees, int dept){
        int employeeCount = 0;
        float totalSalary = TotalSalaryByDept(employees, dept);

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                employeeCount++;
            }
        }
        return totalSalary / employeeCount;
    }
}