package com.study.member.api;

import com.study.common.holder.UserIdHolder;
import com.study.common.wrapper.ResponseResult;
import com.study.member.pojo.response.TestResponse;
import com.study.member.feign.AuthFeignClient;
import com.study.member.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final AuthFeignClient authFeignClient;
    private final RedisService redisService;

    @GetMapping("/test")
    public ResponseResult<TestResponse> test() {
        Long userId = UserIdHolder.getUserId();
        System.out.println("userId = " + userId);
        return ResponseResult.from(authFeignClient.test().result());
    }

    /**
     * graphql docs example
     */

}
