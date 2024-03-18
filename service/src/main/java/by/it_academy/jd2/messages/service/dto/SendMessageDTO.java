package by.it_academy.jd2.messages.service.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class SendMessageDTO {

    private String addressee;
    private String text;
}
