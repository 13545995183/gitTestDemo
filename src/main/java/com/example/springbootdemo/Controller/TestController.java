package com.example.springbootdemo.Controller;

import com.example.springbootdemo.FeignService.FeignService;
import com.example.springbootdemo.ResultData.ResultData;
import com.example.springbootdemo.config.Config;
import com.example.springbootdemo.config.SignScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    public FeignService feignService;
    /*@Autowired
    public SSDataInterfaceApiController ssDataInterfaceApiController;*/

    public static final String  townCode="330523205214";
    @GetMapping("querytest")
    public String querytest(){
        Map<String,String> map=new HashMap<>();
        map.put("appKey", Config.APP_KEY);
        map.put("appSecret", Config.APP_Secret);
        ResultData<Map<String, Object>> resultData=feignService.sign(map);
        Map<String,Object> dataList=  resultData.getData();
        System.out.println(dataList);
        return dataList.get("sign").toString();
    }
    /*
     *乡常驻总人口/乡流动人口 接口
     * vivid_total_population
     *钱圣
     * */
    @GetMapping("getPeopleSum")
    public String getPeopleSum(){
        Map<String,String> map=new HashMap<>();
        map.put("townCode", townCode);
        map.put("sign", SignScheduler.sign);
        return feignService.getPeopleSum(map);
    }
    @GetMapping("hello")
    public String getHello(){

        return "hello world";
    }

}
