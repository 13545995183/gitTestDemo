package com.example.springbootdemo.FeignService;

import com.example.springbootdemo.ResultData.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.Map;

@FeignClient(name = "mytest",url = "https://vivid-datacloud-szxcdata.anji.gov.cn/supersetApi")
@Component
public interface FeignService {
    /*
     * 注册token鉴权码
     * */
    @PostMapping( path = "/sign", consumes = "application/json;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    ResultData sign(@PathParam("map") Map<String, String> map);
    /*
     *乡及镇概况:人口数量 接口
     * vivid_total_population
     * */
    @GetMapping( path = "/query/data/vivid_total_population",
            consumes = "application/json;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    String getPeopleSum(@RequestParam("map") Map<String, String> map);
}
