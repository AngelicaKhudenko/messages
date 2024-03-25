package by.it_academy.jd2.messages.core.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDTO {

    private LocalDateTime post;
    private String sender;
    private String addressee;
    private String text;

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
