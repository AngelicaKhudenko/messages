package by.it_academy.jd2.messages.dao.dto;

public enum Roles {
    USER("Пользователь"), ADMIN("Администратор");
    private final String description;
    Roles(String description){
        this.description=description;
    }
    public String getDescription() {
        return description;
    }
}
