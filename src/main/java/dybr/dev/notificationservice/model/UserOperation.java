package dybr.dev.notificationservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserOperation {

    USER_DELETION("Здравствуйте! Ваш аккаунт был удалён."),
    USER_CREATION("Здравствуйте! Ваш аккаунт на сайте был успешно создан.");
    @Getter
    private final String message;
}