package dybr.dev.notificationservice.kafka;

import dybr.dev.notificationservice.model.UserNotification;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserEventConsumer {

    private static final Logger logger = LoggerFactory.getLogger(UserEventConsumer.class);
    private final NotificationService sender;

    @KafkaListener(
            topics = "users"
    )
    public void listener(UserNotification notification) {

        sender.sendMessage(notification.email(), notification.operation().getMessage());

        logger.info(
                "Получено событие {} для пользователя {}",
                notification.operation(),
                notification.email()
        );
    }
}