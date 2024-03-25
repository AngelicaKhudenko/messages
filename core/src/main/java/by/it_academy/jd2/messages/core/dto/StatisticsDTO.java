package by.it_academy.jd2.messages.core.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class StatisticsDTO {

    private long users;
    private long activeUsers;
    private long messages;
}
