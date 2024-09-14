public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(int size) {
        employees = new Employee[size];
    }



    /**
     * Базовая сложность
     */

    // Получить список всех сотрудников со всеми имеющимися по ним данными
    public void EmployeeList(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // Посчитать сумму затрат на зарплаты в месяц.
    public float TotalSalaryByMonth(Employee[] employees) {
        float totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    // Найти сотрудника с минимальной зарплатой.
    public Employee MinSalaryEmployee(Employee[] employees) {
        Employee minSalaryEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    // Найти сотрудника с максимальной зарплатой.
    public Employee MaxSalaryEmployee(Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    // Подсчитать среднее значение зарплат
    public float AverageSalary(Employee[] employees) {
        int employeeCount = 0;
        float totalSalary = TotalSalaryByMonth(employees);

        for (Employee employee : employees) {
            if (employee != null) {
                employeeCount++;
            }
        }

        return totalSalary / employeeCount;
    }

    // Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public void FullNameList(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    // Проиндексировать зарплату у всех сотрудников на величину аргумента в %.
    public void IndexSalary(Employee[] employees, float index) {
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
    public Employee MinSalaryEmployeeByDept(Employee[] employees, int dept) {
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
    public Employee MaxSalaryEmployeeByDept(Employee[] employees, int dept) {
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
    public float TotalSalaryByDept(Employee[] employees, int dept) {
        float totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    // Найти среднюю зарплату по отделу
    public float AverageSalaryByDept(Employee[] employees, int dept) {
        int employeeCount = 0;
        float totalSalary = TotalSalaryByDept(employees, dept);

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                employeeCount++;
            }
        }
        return totalSalary / employeeCount;
    }
    // Проиндексировать зарплату у сотрудников отдела на величину аргумента в %.
    public void IndexSalary(Employee[] employees, float index, int dept) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                employee.setSalary(employee.getSalary() * (1 + index / 100));
            }
        }
    }

    // Вывести в консоль список сотрудников отдела
    public void EmployeeListByDept(Employee[] employees, int dept) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    // Найти всех сотрудников с зарплатой меньше числа
    public void FindEmployeesWithSalaryLessThan(Employee[] employees, float salary) {
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
    public void FindEmployeesWithSalaryMoreOrEqualThan(Employee[] employees, float salary) {
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
