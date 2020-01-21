package com.jxmall.activity.channel;

import org.apache.servicecomb.foundation.common.utils.Log4jUtils;
import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;

@SpringBootApplication(exclude = {DispatcherServletAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableServiceComb
public class ActivityChannelServerApplication {

	public static void main(String[] args) throws Exception {
		Log4jUtils.init();
		SpringApplication.run(ActivityChannelServerApplication.class, args);
	}

}
