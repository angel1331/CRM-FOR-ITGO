import interfaces.Contactable;
import model.Client;
import model.Employee;
import model.Person;

import java.util.ArrayList;

public class Main {
    static void notifyAll(ArrayList<Contactable> contacts, String message) {
        for (int i = 0; i<contacts.size(); i++) {
            contacts.get(i).sendMessage(message);
        }
    }

    static void printAll(ArrayList<Person> persons) {
        for (int i = 0; i<persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }

    static void printClients(ArrayList<Person> persons) {
        for(int i = 0; i<persons.size(); i ++) {
            if(persons.get(i) instanceof Client) {
                Client client = (Client) persons.get(i);
                System.out.println(client.getContactInfo());
            }
        }
    }

    public static void main(String[] args) {
        Contactable tempClient = new Contactable() {
            @Override
            public String getContactInfo() {
                return "Временный клиент";
            }

            @Override
            public void sendMessage(String message) {
                System.out.println("Сообщение временному клиенту: " + message);
            }
        };

        tempClient.sendMessage("Далбоеб иди нахуй отсюда");

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

        ArrayList<Contactable> contacts = new ArrayList<>();
        contacts.add(client1);
        contacts.add(client2);
        contacts.add(employee1);
        contacts.add(tempClient);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(client1);
        persons.add(client2);
        persons.add(employee1);

        printClients(persons);
        notifyAll(contacts, "Всем идите нахуй");
    }
}