public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(int size) {
        employees = new Employee[size];
    }

    // Добавить нового сотрудника
    public void AddEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    /**
     * Базовая сложность
     */

    // Получить список всех сотрудников со всеми имеющимися по ним данными
    public void EmployeeList() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // Посчитать сумму затрат на зарплаты в месяц.
    public float TotalSalaryByMonth() {
        float totalSalary = 0;

        for (Employee employee : this.employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    // Найти сотрудника с минимальной зарплатой.
    public Employee MinSalaryEmployee() {
        Employee minSalaryEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    // Найти сотрудника с максимальной зарплатой.
    public Employee MaxSalaryEmployee() {
        Employee maxSalaryEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    // Подсчитать среднее значение зарплат
    public float AverageSalary() {
        int employeeCount = 0;
        float totalSalary = TotalSalaryByMonth();

        for (Employee employee : employees) {
            if (employee != null) {
                employeeCount++;
            }
        }

        return totalSalary / employeeCount;
    }

    // Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public void FullNameList() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    // Проиндексировать зарплату у всех сотрудников на величину аргумента в %.
    public void IndexSalary(float index) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + index / 100));
            }
        }
    }

    /**
     * Повышенная сложность
     */

    // Найти сотрудника с минимальной зарплатой в отделе.
    public Employee MinSalaryEmployeeByDept(int dept) {
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
    public Employee MaxSalaryEmployeeByDept(int dept) {
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
    public float TotalSalaryByDept(int dept) {
        float totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    // Найти среднюю зарплату по отделу
    public float AverageSalaryByDept(int dept) {
        int employeeCount = 0;
        float totalSalary = TotalSalaryByDept(dept);

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                employeeCount++;
            }
        }
        return totalSalary / employeeCount;
    }
    // Проиндексировать зарплату у сотрудников отдела на величину аргумента в %.
    public void IndexSalary(float index, int dept) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                employee.setSalary(employee.getSalary() * (1 + index / 100));
            }
        }
    }

    // Вывести в консоль список сотрудников отдела
    public void EmployeeListByDept(int dept) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    // Найти всех сотрудников с зарплатой меньше числа
    public void FindEmployeesWithSalaryLessThan(float salary) {
        System.out.println("----------------------------------------");
        System.out.println("Сотрудники с зарплатой меньше " + salary + " руб.");
        System.out.println("----------------------------------------");

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.printf("ID: %d, %s, %.2f руб.\n",
                        employee.getId(),
                        employee.getFullName(),
                        employee.getSalary()
                );
            }
        }
    }

    // Найти всех сотрудников с зарплатой больше или равной числу
    public void FindEmployeesWithSalaryMoreOrEqualThan(float salary) {
        System.out.println("----------------------------------------");
        System.out.println("Сотрудники с зарплатой больше или равной " + salary + " руб.");
        System.out.println("----------------------------------------");

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.printf("ID: %d, %s, %.2f руб.\n",
                        employee.getId(),
                        employee.getFullName(),
                        employee.getSalary()
                );
            }
        }
    }
}