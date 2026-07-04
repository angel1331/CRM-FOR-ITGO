package model;
import interfaces.Contactable;

public class Client extends Person implements Contactable {
    private String address;

    public String getRole() {
        return "Клиент";
    }

    @Override
    public boolean equals(Object obj) {
        Person obj1 = (Person) obj;
        return this.getName().equals(obj1.getName()) && this.getPhone().equals(obj1.getPhone());
    }

    @Override
    public String toString() {
        return "Клиент: " + getName() + " | " + "Телефон: " + getPhone() + " | " + "Адрес: " + getAddress();
    }


    @Override
    public String getContactInfo() {
        return "Имя: " + getName() + " | " + "Телефон: " + getPhone();
    }


    @Override
    public void sendMessage(String message) {
        System.out.println("Отправка сообщения для " + getName() + ": " + message);
    }

    public void setAddress(String address) {
        if(address.isEmpty()) {
            System.out.println("Вы не передали никакого значения...");
            return;
        } else {
            this.address = address;
        }
    }

    public String getAddress() {
        return address;
    }
}
