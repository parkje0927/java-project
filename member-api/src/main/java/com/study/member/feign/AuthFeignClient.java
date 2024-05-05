package com.study.member.feign;

import com.study.common.config.FeignConfig;
import com.study.common.wrapper.ResponseResult;
import com.study.member.pojo.response.TestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "authFeignClient", url = "http://localhost:8085", configuration = FeignConfig.class)
public interface AuthFeignClient {

    @GetMapping("/test")
    ResponseResult<TestResponse> test();
}
