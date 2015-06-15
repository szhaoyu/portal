package com.brick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brick.util.RegexValidator;

@Configuration
public class ValidatorConfiguration {

	@Bean(name="mobileValidator")
    RegexValidator getMobileNumberValidator() {
		/*
		 三大运营商的号段汇总：
			中国移动：134、135、136、137、138、139、150、151、152、157(TD)、158、159、182、183、184、187、178、188、147（数据卡号段） 、1705（虚拟运营商移动号段）
			中国联通：130、131、132、145(数据卡号段)155、156、176、185、186、1709（虚拟运营商联通号段）
			中国电信：133、153、177、180、181、189、（1349卫通）、1700（虚拟运营商电信号段）
		 */
    	return new RegexValidator("^(1[3,5,8][0-9]|14[5,7]|17[0,5,6,7,8])\\d{8}$");
    }

	@Bean(name="emailValidator")
    RegexValidator getEmailValidator() {
		/*
		 function validateEmail(email) {
    		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    		return re.test(email);
		 }
		 */
    	//return new RegexValidator("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		return new RegexValidator("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    }
	
}
