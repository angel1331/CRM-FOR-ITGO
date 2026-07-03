import exceptions.EmptyFileException;
import exceptions.InvalidPhoneException;
import interfaces.Contactable;
import model.Client;
import model.Employee;
import model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    static ArrayList<Client> loadClientsFromFile(String fileName) throws InvalidPhoneException, EmptyFileException {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            if(!scanner.hasNextLine()) {
                throw new EmptyFileException("В файле нет данных.");
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                Client client = new Client();
                client.setName(parts[0] + " " + parts[1]);
                client.setPhone(parts[2]);
                client.setAddress(parts[3]);
                clients.add(client);
            }
            scanner.close();
            System.out.println(clients);
        } catch (FileNotFoundException | EmptyFileException e) {
            System.out.println("Не удалось загрузить клиентов из файла.");
        }
        return clients;
    }

    public static void main(String[] args) throws FileNotFoundException, InvalidPhoneException, EmptyFileException {
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

        System.out.println(client1.getRole());
        System.out.println(client2.getRole());
        System.out.println(employee1.getRole());
    }
}