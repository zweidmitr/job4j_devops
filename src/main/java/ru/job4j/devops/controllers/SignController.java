package ru.job4j.devops.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import ru.job4j.devops.models.Result;
import ru.job4j.devops.models.TwoArgs;
import ru.job4j.devops.models.User;

@RestController
@RequestMapping("sign")
@AllArgsConstructor
public class SignController {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("up")
    public void up() {
        var user = new User();
        user.setName("Test" + System.nanoTime());
        kafkaTemplate.send("signup", user);
    }

    @PostMapping("times")
    public ResponseEntity<Result> times(@RequestBody TwoArgs twoArgs) {
        var result = twoArgs.getFirst() * twoArgs.getSecond();
        return ResponseEntity.ok(new Result(result));
    }
}
