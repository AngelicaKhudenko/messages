package by.it_academy.jd2.messages.core.dto;

import java.time.LocalDateTime;

public class MessageDTO {
    private LocalDateTime post;
    private String sender;
    private String addressee;
    private String text;

    public MessageDTO() {
    }

    public MessageDTO(String sender, String addressee, String text) {
        this.sender = sender;
        this.addressee = addressee;
        this.text = text;
    }

    /**
     * Метод, возвращающий дату отправки сообщения
     * @return - дата отправки сообщения
     */
    public LocalDateTime getPost() {
        return post;
    }

    /**
     * Метод, устанавливающий время отправки сообщения
     * @param post - время отправки сообщения
     */
    public void setPost(LocalDateTime post) {
        this.post = post;
    }

    /**
     * Метод, возвращающий отправителя сообщения
     * @return - отправитель сообщения
     */
    public String getSender() {
        return sender;
    }

    /**
     * Метод, устанавливающий отправителя сообщения
     * @param sender - отправитель сообщения
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Метод, возвращающий получателя сообщения
     * @return - адресат
     */
    public String getAddressee() {
        return addressee;
    }

    /**
     * Метод, устанавливающий адресата сообщения
     * @param addressee - адресат сообщения
     */
    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    /**
     * Метод, возвращающий текст сообщения
     * @return - текст сообщения
     */
    public String getText() {
        return text;
    }

    /**
     * Метод, устанавливающий текст сообщения
     * @param text - текст сообщения
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Отправитель: ");
        stringBuilder.append(sender);
        stringBuilder.append("\n");
        stringBuilder.append("Текст сообщения: "+"\n");
        stringBuilder.append(text);
        return stringBuilder.toString();
    }
}
