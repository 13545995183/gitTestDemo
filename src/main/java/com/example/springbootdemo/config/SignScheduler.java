package com.example.springbootdemo.config;

import com.example.springbootdemo.FeignService.FeignService;
import com.example.springbootdemo.ResultData.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/*
 * 定时生成sign鉴权码
 * */
@Component
public class SignScheduler {
    @Autowired
    public FeignService feignService;

    public static String sign="";
    /*
     * sign鉴权码30分钟过期
     * @Scheduled(cron = "表达式")设置的28分钟远程调用sign()
     * @PostConstruct项目启动时，立即执行该方法
     * */
    @Scheduled(cron = "0 */28 * * * ?")
    @PostConstruct
    public void setSign() {
        Map<String,String> map=new HashMap<>();
        map.put("appKey", Config.APP_KEY);
        map.put("appSecret", Config.APP_Secret);
        ResultData<Map<String, Object>> resultData=feignService.sign(map);
        Map<String,Object> dataList=  resultData.getData();
        sign=dataList.get("sign").toString();
        System.out.println(sign);
    }
}
