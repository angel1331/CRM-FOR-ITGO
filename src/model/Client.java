package model;
import interfaces.Contactable;

public class Client extends Person implements Contactable {
    private String address;

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
