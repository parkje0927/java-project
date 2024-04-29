package com.study.memberapi.api;

import com.study.common.holder.UserIdHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public void test() {
        Long userId = UserIdHolder.getUserId();
        System.out.println("userId = " + userId);
    }
}
