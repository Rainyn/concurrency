package com.mmall.concurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project: concurrency
 * @description:
 * @author: Yuanjk
 * @create: 2018-04-12 01:18:39
 **/
@Controller
@Slf4j
public class TestController {
    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
