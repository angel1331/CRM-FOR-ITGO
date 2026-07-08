package enums;

public enum ClientStatus {
    NEW("Новый клиент"), ACTIVE("Активный клиент"), BLOCKED("Заблокирован");

    private final String description;

    ClientStatus(String description) {
        this.description = description;
    }

    public void getDescription() {
        System.out.println(description);
    }
}
