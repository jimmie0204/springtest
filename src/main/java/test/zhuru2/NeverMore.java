package test.zhuru2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NeverMore {
	
	@Value("${lvalue}")
	private double price;  
	  
    public double getPrice() {  
        return price;  
    }  

    public void setPrice(double price) {  //û��set����Ҳ��ע��
        this.price = price;  
        System.out.println("**************** price: " + price);  
    }  
}
