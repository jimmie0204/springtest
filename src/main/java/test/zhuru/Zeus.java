package test.zhuru;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Zeus {

	@Value("#{configProperties['liyp']}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {//û��set����Ҳ��ע��
		this.name = name;
	}

	@PostConstruct
	private void initZeus(){

		name = "jimmie";
		System.out.println("========PostConstruct执行初始化===========");
	}
}
