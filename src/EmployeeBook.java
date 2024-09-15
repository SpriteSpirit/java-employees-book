import java.util.*;

/**
 * Класс для управления списком сотрудников.
 * Хранит массив объектов типа Employee и предоставляет методы для добавления и удаления сотрудников.
 */

public class EmployeeBook {
    /**
     * Массив для хранения сотрудников.
     */
    private final Employee[] employees;

    /**
     * Конструктор класса EmployeeBook.
     * Инициализирует массив сотрудников заданного размера.
     *
     * @param size размер массива для хранения сотрудников
     */
    public EmployeeBook(int size) {
        employees = new Employee[size];
    }

    /**
     * Добавить нового сотрудника в список.
     * Поиск первого свободного места в массиве и присваивание туда объекта сотрудника.
     *
     * @param employee объект сотрудника, который нужно добавить
     */
    public void AddEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    /**
     * Удаление сотрудника из списка по полному ФИО.
     * Поиск сотрудника по ФИО и установка его места в массиве на null.
     *
     * @param lastName  фамилия сотрудника
     * @param firstName имя сотрудника
     * @param middleName отчество сотрудника
     */
    public void DeleteEmployee(String lastName, String firstName, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.getLastName().equalsIgnoreCase(lastName)
                    && employee.getFirstName().equalsIgnoreCase(firstName)
                    && employee.getMiddleName().equalsIgnoreCase(middleName)) {
                employees[i] = null;
                break;
            }
        }
    }

    /**
     * Удаление сотрудника из списка по ФИ.
     * Поиск сотрудника по фамилии и имени и установка его места в массиве на null.
     *
     * @param lastName  фамилия сотрудника
     * @param firstName имя сотрудника
     */
    public void DeleteEmployee(String lastName, String firstName) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName) && employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employees[i] = null;
                    break;
                }
            }
        }
    }

    /**
     * Удаление сотрудника из списка по id.
     * Поиск сотрудника по id и установка его места в массиве на null.
     *
     * @param id идентификатор сотрудника
     */
    public void DeleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                if (employee.getId() == id) {
                    employees[i] = null;
                    break;
                }
            }
        }
    }

    /**
     * Изменить зарплату и отдел сотрудника по ФИО
     * Поиск сотрудника по ФИО и изменение отдела и зарплаты
     *
     * @param lastName  фамилия сотрудника
     * @param firstName имя сотрудника
     * @param middleName отчество сотрудника
     * @param dept отдел сотрудника
     * @param salary зарплата сотрудника
     */
    public void UpdateEmployee(String lastName, String firstName, String middleName, int dept,  float salary) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName) &&
                        employee.getFirstName().equalsIgnoreCase(firstName) &&
                        employee.getMiddleName().equalsIgnoreCase(middleName)) {
                    employee.setSalary(salary);
                    employee.setDepartment(dept);
                }
            }
        }
    }

    /**
     * Изменить зарплату сотрудника по ФИО
     * Поиск сотрудника по ФИО и изменение зарплаты
     *
     * @param lastName  фамилия сотрудника
     * @param firstName имя сотрудника
     * @param middleName отчество сотрудника
     * @param salary зарплата сотрудника
     */
    public void UpdateEmployee(String lastName, String firstName, String middleName,  float salary) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName) &&
                        employee.getFirstName().equalsIgnoreCase(firstName) &&
                        employee.getMiddleName().equalsIgnoreCase(middleName)) {
                    employee.setSalary(salary);
                }
            }
        }
    }

    /**
     * Изменить отдел сотрудника по ФИО
     * Поиск сотрудника по ФИО и изменение отдела
     *
     * @param lastName  фамилия сотрудника
     * @param firstName имя сотрудника
     * @param middleName отчество сотрудника
     * @param dept отдел сотрудника
     */
    public void UpdateEmployee(String lastName, String firstName, String middleName,  int dept) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName) &&
                        employee.getFirstName().equalsIgnoreCase(firstName) &&
                        employee.getMiddleName().equalsIgnoreCase(middleName)) {
                    employee.setDepartment(dept);
                }
            }
        }
    }

    /**
     * Вывод ФИО всех сотрудников по отделам
     */
    public void FullNameListSortedByDept() {
        Map<Integer, List<Employee>> employeesByDept = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                employeesByDept.computeIfAbsent(employee.getDepartment(), keyDept -> new ArrayList<>()).add(employee);
            }
        }

        for (Map.Entry<Integer, List<Employee>> entry : employeesByDept.entrySet()) {
            System.out.println("_______________________________");
            System.out.println("Отдел №" + entry.getKey() + ": ");
            System.out.println("-::-::-::-::-::-::-::-::-::-::-");

            for (Employee employee : entry.getValue()) {
                System.out.println(employee.getFullName());
            }

            System.out.println("_______________________________");
        }
    }


    // Базовая сложность

    /**
     * Получить список всех сотрудников со всеми имеющимися по ним данными
     */
    public void EmployeeList() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Посчитать сумму затрат на зарплаты в месяц.
     */
    public float TotalSalaryByMonth() {
        float totalSalary = 0;

        for (Employee employee : this.employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    /**
     * Найти сотрудника с минимальной зарплатой.
     */
    public Employee MinSalaryEmployee() {
        Employee minSalaryEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    /**
     * Найти сотрудника с максимальной зарплатой.
     */
    public Employee MaxSalaryEmployee() {
        Employee maxSalaryEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    /**
     * Подсчитать среднее значение зарплат
     */
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

    /**
     * Получить ФИО всех сотрудников и вывести в консоль
     */
    public void FullNameList() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    /**
     * Проиндексировать зарплату у всех сотрудников на величину аргумента в %.
     */
    public void IndexSalary(float index) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + index / 100));
            }
        }
    }

    // Повышенная сложность

    /**
     * Найти сотрудника с минимальной зарплатой в отделе.
     */
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

    /**
     * Найти сотрудника с максимальной зарплатой в отделе.
     */
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

    /**
     * Найти сумму затрат на зарплату по отделу.
     */
    public float TotalSalaryByDept(int dept) {
        float totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    /**
     * Найти среднюю зарплату по отделу
     */
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

    /**
     * Проиндексировать зарплату у сотрудников отдела на величину аргумента в %
     */
    public void IndexSalary(float index, int dept) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                employee.setSalary(employee.getSalary() * (1 + index / 100));
            }
        }
    }

    /**
     * Вывести в консоль список сотрудников отдела
     */
    public void EmployeeListByDept(int dept) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dept) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    /**
     * Найти всех сотрудников с зарплатой меньше числа
     */
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

    /**
     * ННайти всех сотрудников с зарплатой больше или равной числу
     */
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
