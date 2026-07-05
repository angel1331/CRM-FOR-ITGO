package model;
import interfaces.Contactable;

public class Employee extends Person implements Contactable {
    private String position;
    public Department department;

    public static class Department {
        public String name;
        public String code;

        @Override
        public String toString() {
            return name + " (" + code + ") ";
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getRole() {
        return "Сотрудник";
    }

    @Override
    public String toString() {
        return "Сотрудник: " + getName() + " | " + "Телефон: " + getPhone() + " | " + "Должность: " + getPosition() + " | " + "Департамент: " + getDepartment();
    }

    @Override
    public String getContactInfo() {
        return "Имя: " + getName() + " | Должность: " + getPosition() + " | " + "Телефон: " + getPhone();
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Отправка сообщения для сотрудника " + getName() + ": " + message);
    }

    public void setPosition(String position) {
        if(position.isEmpty()) {
            System.out.println("Вы не передали никакого значения...");
            return;
        } else {
            this.position = position;
        }
    }

    public String getPosition() {
        return position;
    }
}
