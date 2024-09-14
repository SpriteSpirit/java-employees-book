/**
 * Класс, представляющий сотрудника в организации.
 * Содержит информацию об имени, фамилии, отчестве, отделе и зарплате сотрудника.
 */

public class Employee {
    /**
     * Имя сотрудника
     */
    private String first_name;
    /**
     * Фамилия сотрудника
     */
    private String last_name;
    /**
     * Отчество сотрудника
     */
    private String middle_name;
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
     * @param last_name   Фамилия сотрудника
     * @param first_name  Имя сотрудника
     * @param middle_name Отчество сотрудника
     * @param department  Отдел сотрудника
     * @param salary      Зарплата сотрудника
     */

    public Employee(String last_name, String first_name, String middle_name, int department, float salary) {
        setLast_name(last_name);
        setFirst_name(first_name);
        setMiddle_name(middle_name);
        setDepartment(department);
        setSalary(salary);
        this.id = next_id++;
    }

    /**
     * Конструктор без отчества.
     *
     * @param last_name  Фамилия сотрудника
     * @param first_name Имя сотрудника
     * @param department Отдел сотрудника
     * @param salary     Зарплата сотрудника
     */

    public Employee(String last_name, String first_name, int department, float salary) {
        setLast_name(last_name);
        setFirst_name(first_name);
        setDepartment(department);
        setSalary(salary);
        this.id = next_id++;
    }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя сотрудника
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Устанавливает имя сотрудника.
     * Имя будет установлено только если переданная строка не null и не пустая.
     *
     * @param first_name имя сотрудника
     * @throws IllegalArgumentException если имя null или пустое
     */
    public void setFirst_name(String first_name) {
        if (first_name != null && !first_name.isBlank()) {
            this.first_name = first_name;
        } else {
            throw new IllegalArgumentException("Поле не может быть пустым");
        }
    }

    /**
     * Возвращает фамилию сотрудника.
     *
     * @return фамилия сотрудника
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Устанавливает фамилию сотрудника.
     * Фамилия будет установлена только если переданная строка не null и не пустая.
     *
     * @param last_name фамилия сотрудника
     * @throws IllegalArgumentException если поле null или пустое
     */
    public void setLast_name(String last_name) {
        if (last_name != null && !last_name.isBlank()) {
            this.last_name = last_name;
        } else {
            throw new IllegalArgumentException("Поле не может быть пустым");
        }
    }

    /**
     * Возвращает отчество сотрудника.
     *
     * @return отчество сотрудника
     */
    public String getMiddle_name() {
        return middle_name;
    }

    /**
     * Устанавливает отчество сотрудника.
     * Отчество будет установлено только если переданная строка не null и не пустая.
     *
     * @param middle_name отчество сотрудника
     * @throws IllegalArgumentException если поле null или пустое
     */
    public void setMiddle_name(String middle_name) {
        if (last_name != null && !middle_name.isBlank()) {
            this.middle_name = middle_name;
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
        if (middle_name != null && !middle_name.isBlank()) {
            return last_name + " " + first_name + " " + middle_name;
        } else {
            return last_name + " " + first_name;
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
        if (department > 0) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Сотрудник: {");
        sb.append("ID=").append(getId());
        sb.append(", Фамилия='").append(getLast_name()).append('\'');
        sb.append(", Имя='").append(getFirst_name()).append('\'');

        if (getMiddle_name() != null && !getMiddle_name().isEmpty()) {
            sb.append(", Отчество='").append(getMiddle_name()).append('\'');
        }

        sb.append(", Отдел=").append(getDepartment());
        sb.append(", Зарплата=").append(getSalary());
        sb.append('}');

        return sb.toString();
    }
}
