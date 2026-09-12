package dybr.dev.notificationservice.model;

public record UserNotification(
        Long userId,
        String email,
        UserOperation operation
) {
}