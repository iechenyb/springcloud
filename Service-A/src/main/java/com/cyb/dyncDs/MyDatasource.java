package com.cyb.dyncDs;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月11日
 */
/*@Setter
@Getter
@ToString*/
//@AllArgsConstructor
@Data 
public class MyDatasource {
	@Getter @Setter
	private String username;
	private String password;
	private String url;
	private String driverClass;
	/*public MyDatasource(){}
	public MyDatasource(String username){
		this.username = username;
	}
	public static void main(String[] args) {
		//new MyDatasource().;
	}*/
}
