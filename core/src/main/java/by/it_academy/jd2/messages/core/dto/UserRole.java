package by.it_academy.jd2.messages.core.dto;

public enum UserRole {
    USER("Пользователь"),
    ADMIN("Администратор");

    private final String description;

    UserRole(String description){
            this.description=description;
    }

    /**
     * Метод, возвращающий описание роли
     * @return - описание роли
     */
    public String getDescription() {
            return description;
    }
}
