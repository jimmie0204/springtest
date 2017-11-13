package test.zhuru;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Zeus {

	@Value("#{configProperties['liyp']}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {//没有set方法也能注入
		this.name = name;
	}
}
