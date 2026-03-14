package benyandadamson.interbank.data.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private Long NotificationId;
    private String message;
    private NotificationType type;
    private boolean isSent;
    private LocalDateTime sentDate;
}
