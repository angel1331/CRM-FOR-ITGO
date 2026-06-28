package model;

public class Person {
    private String name;
    private String phone;

    @Override
    public String toString() {
        return "Имя: " + name + "| Телефон: " + phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()) {
            System.out.println("Вы не передали никакого значения...");
            return;
        } else {
            this.name = name;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone.isEmpty()) {
            System.out.println("Вы не передали никакого значения...");
            return;
        } else {
            this.phone = phone;
        }
    }

}
