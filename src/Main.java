import interfaces.Contactable;
import model.Client;
import model.Employee;
import model.Person;

public class Main {
    static void notifyAll(Contactable[] contacts, String message) {
        for (int i = 0; i<contacts.length; i++) {
            contacts[i].sendMessage(message);
        }
    }

    static void printAll(Person[] persons) {
        for (int i = 0; i<persons.length; i++) {
            System.out.println(persons[i]);
        }
    }

    public static void main(String[] args) {
        Client client1 = new Client();
        client1.setName("Алия Иванова");
        client1.setPhone("+77001234567");
        client1.setAddress("Астана, ул. Абая 10");

        Client client2 = new Client();
        client2.setName("Данияр Сейтов");
        client2.setPhone("+77009876543");
        client2.setAddress("Астана, ул. Сары-Арка 5");

        Employee employee1 = new Employee();
        employee1.setName("Алимжан");
        employee1.setPhone("+77005555555");
        employee1.setPosition("Онлайн мастер");

        Contactable[] contacts = {client1, client2, employee1};

        Person[] persons = {client1, client2, employee1};

        System.out.println(client1 + "\n" + client2 + "\n" + employee1);

        notifyAll(contacts, "Всем привет!");
        printAll(persons);
    }
}