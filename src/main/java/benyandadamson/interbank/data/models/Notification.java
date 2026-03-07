package benyandadamson.interbank.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private Long NotificationId;
    private String message;
    private NotificationType type;
    private boolean isSent;
    private LocalDateTime sentDate;
}
