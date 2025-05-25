/**
 * Класс, представляющий сотрудника в организации.
 * Содержит информацию об имени, фамилии, отчестве, отделе и зарплате сотрудника.
 */

public class Employee {
    /**
     * Имя сотрудника
     */
    private String firstName;
    /**
     * Фамилия сотрудника
     */
    private String lastName;
    /**
     * Отчество сотрудника
     */
    private String middleName;
    /**
     * Номер отдела, в котором работает сотрудник
     */
    private int department;
    /**
     * Зарплата сотрудника
     */
    private float salary;
    /**
     * Уникальный идентификатор сотрудника
     */
    private int id = 1;
    /**
     * Счетчик идентификатора сотрудника
     */
    private static int next_id = 1;

    /**
     * Конструктор с отчеством.
     *
     * @param lastName   Фамилия сотрудника
     * @param firstName  Имя сотрудника
     * @param middleName Отчество сотрудника
     * @param department  Отдел сотрудника
     * @param salary      Зарплата сотрудника
     */

    public Employee(String lastName, String firstName, String middleName, int department, float salary) {
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleName(middleName);
        setDepartment(department);
        setSalary(salary);
        this.id = next_id++;
    }

    /**
     * Конструктор без отчества.
     *
     * @param lastName  Фамилия сотрудника
     * @param firstName Имя сотрудника
     * @param department Отдел сотрудника
     * @param salary     Зарплата сотрудника
     */

    public Employee(String lastName, String firstName, int department, float salary) {
        setLastName(lastName);
        setFirstName(firstName);
        setDepartment(department);
        setSalary(salary);
        this.id = next_id++;
    }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя сотрудника
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Устанавливает имя сотрудника.
     * Имя будет установлено только если переданная строка не null и не пустая.
     *
     * @param firstName имя сотрудника
     * @throws IllegalArgumentException если имя null или пустое
     */
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isBlank()) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Поле не может быть пустым");
        }
    }

    /**
     * Возвращает фамилию сотрудника.
     *
     * @return фамилия сотрудника
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Устанавливает фамилию сотрудника.
     * Фамилия будет установлена только если переданная строка не null и не пустая.
     *
     * @param lastName фамилия сотрудника
     * @throws IllegalArgumentException если поле null или пустое
     */
    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isBlank()) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Поле не может быть пустым");
        }
    }

    /**
     * Возвращает отчество сотрудника.
     *
     * @return отчество сотрудника
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Устанавливает отчество сотрудника.
     * Отчество будет установлено только если переданная строка не null и не пустая.
     *
     * @param middleName отчество сотрудника
     * @throws IllegalArgumentException если поле null или пустое
     */
    public void setMiddleName(String middleName) {
        if (middleName != null && !middleName.isBlank()) {
            this.middleName = middleName;
        } else {
            throw new IllegalArgumentException("Поле не может быть пустым");
        }
    }

    /**
     * Возвращает ФИО сотрудника.
     *
     * @return ФИО или ФИ сотрудника
     */
    public String getFullName() {
        if (middleName != null && !middleName.isBlank()) {
            return lastName + " " + firstName + " " + middleName;
        } else {
            return lastName + " " + firstName;
        }
    }

    /**
     * Возвращает отдел сотрудника.
     *
     * @return отдел сотрудника
     */
    public int getDepartment() {
        return department;
    }

    /**
     * Устанавливает номер отдела сотрудника.
     * Отдел будет установлен только если значение больше 0.
     *
     * @param department отдел сотрудника
     * @throws IllegalArgumentException если значение меньше или равно 0
     */
    public void setDepartment(int department) {
        if (department > 0 && department < 6) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Значение должно быть больше 0");
        }
    }

    /**
     * Возвращает зарплату сотрудника.
     *
     * @return зарплата сотрудника
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Устанавливает зарплату сотрудника.
     * Зарплата будет установлена только если значение больше 0.
     *
     * @param salary зарплата сотрудника
     * @throws IllegalArgumentException если значение меньше или равно 0
     */
    public void setSalary(float salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Значение должно быть больше 0");
        }
    }

    /**
     * Возвращает уникальный id сотрудника.
     *
     * @return id сотрудника
     */
    public int getId() {
        return id;
    }

    /**
     * Метод для строкового представления без отдела
     *
     * @return вся информация о сотруднике в строковом представлении
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Сотрудник: {");
        sb.append("ID=").append(getId());
        sb.append(", Фамилия='").append(getLastName()).append('\'');
        sb.append(", Имя='").append(getFirstName()).append('\'');

        if (getMiddleName() != null && !getMiddleName().isEmpty()) {
            sb.append(", Отчество='").append(getMiddleName()).append('\'');
        }

        sb.append(", Отдел=").append(getDepartment());
        sb.append(", Зарплата=").append(getSalary());
        sb.append('}');

        return sb.toString();
    }

    /**
     * Метод для строкового представления без отдела
     *
     * @return информация о сотруднике без указания отдела
     */
    public String toStringWithoutDepartment() {
        StringBuilder sb = new StringBuilder("Сотрудник: {");
        sb.append("ID=").append(getId());
        sb.append(", Фамилия='").append(getLastName()).append('\'');
        sb.append(", Имя='").append(getFirstName()).append('\'');

        if (getMiddleName() != null && !getMiddleName().isEmpty()) {
            sb.append(", Отчество='").append(getMiddleName()).append('\'');
        }

        sb.append(", Зарплата=").append(getSalary());
        sb.append('}');

        return sb.toString();
    }
}
