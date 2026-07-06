package model;

import exceptions.InvalidPhoneException;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;
    private String phone;

    public abstract String getRole();

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

    public void setPhone(String phone) throws InvalidPhoneException {
        if(phone.isEmpty()) {
            System.out.println("Вы не передали никакого значения...");
            return;
        } else if (!phone.startsWith("+7") || phone.length() < 12) {
            throw new InvalidPhoneException("ВЫ НАХУЯ С ДРУГОЙ СТРАНЫ ПИШИТЕ НАМ");
        } else {
            this.phone = phone;
        }
    }
}
