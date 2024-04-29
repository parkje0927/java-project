package com.study.memberapi.api;

import com.study.common.holder.UserIdHolder;
import com.study.common.wrapper.ResponseResult;
import com.study.memberapi.data.response.TestResponse;
import com.study.memberapi.feign.AuthFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final AuthFeignClient authFeignClient;

    @GetMapping("/test")
    public ResponseResult<TestResponse> test() {
        Long userId = UserIdHolder.getUserId();
        System.out.println("userId = " + userId);
        return ResponseResult.from(authFeignClient.test().result());
    }
}
