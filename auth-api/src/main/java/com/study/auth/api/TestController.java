package com.study.auth.api;

import com.study.auth.data.response.TestResponse;
import com.study.common.wrapper.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public ResponseResult<TestResponse> test() {
        return ResponseResult.from(new TestResponse(1L));
    }
}
