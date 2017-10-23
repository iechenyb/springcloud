package com.cyb.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign类似dubbo的功能
 */
@RestController
public class FeignController {

	@Autowired
	private ServiceAFeignClient aFeignClient;

	@Autowired
	private ServiceBFeignClient bFeignClient;

	/**
	 * 
	 * 作者 : iechenyb<br>
	 * 方法描述: a服务有一个<br>
	 * 创建时间: 2017年7月15日hj12
	 * 
	 * @param a
	 * @param b
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dubbo_a", method = RequestMethod.GET)
	public String a(@RequestParam Integer a, @RequestParam Integer b, HttpServletRequest req) {
		String string = this.aFeignClient.add(a, b);
		return string + " feiginSessionId is " + req.getSession().getId();
	}

	/**
	 * 
	 * 作者 : iechenyb<br>
	 * 方法描述: b服务有两个，同名的serviceid<br>
	 * 创建时间: 2017年7月15日hj12
	 * 
	 * @param a
	 * @param b
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/dubbo_b", method = RequestMethod.GET)
	public String b(@RequestParam Integer a, @RequestParam Integer b, HttpServletRequest req) {
		String string =  this.bFeignClient.add(a, b);
		return string + " feiginSessionId is " + req.getSession().getId();
	}

	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public int sub(@RequestParam Integer a, @RequestParam Integer b) {
		int string = (a - b);
		return string;
	}
}