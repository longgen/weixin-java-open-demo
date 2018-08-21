package com.agg.wx.open;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.agg.wx.open.mapper"})
public class WxOpenApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxOpenApplication.class, args);
    }
}
