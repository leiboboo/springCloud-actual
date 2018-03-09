package org.service.register.autoconfig;

public class HelloService {
	private String msg = "service";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String say() {
		return "hello,"+this.msg;
	}
}
