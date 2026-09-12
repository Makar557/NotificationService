package dybr.dev.notificationservice.kafka;

import dybr.dev.notificationservice.model.NotificationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> sendNotification(
            @Valid @RequestBody NotificationRequest request
    ) {

        notificationService.sendMessage(
                request.email(),
                request.operation().getMessage()
        );

        return ResponseEntity.ok().build();
    }
}