package test.cyb.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cyb.A_Application;
import com.cyb.dyncDs.MyDatasource;

/**
 * 作者 : iechenyb<br>
 * 类描述: 说点啥<br>
 * 创建时间: 2018年1月11日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = A_Application.class)
@ActiveProfiles("dev")
public class MyTest {
	@Autowired
	private MyDatasource datasource;

	@Test
	public void test() {
		System.out.println(datasource);
	}
}