package benyandadamson.interbank.data.models;

import java.time.LocalDateTime;

public class Notification {
    private Long NotificationId;
    private String message;
    private NotificationType type;
    private boolean isSent;
    private LocalDateTime sentDate;
}
