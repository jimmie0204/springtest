package property;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Dchuancan {

	public static void main(String[] args) {
		Properties props = System.getProperties();
//		props.put("mail.smtp.host", "mail.369cloud.com");//设置SMTP发件服务器地址
		System.out.println(props.size());
		Iterator it=props.entrySet().iterator();
		while(it.hasNext()){
		    Map.Entry entry=(Map.Entry)it.next();
		    Object key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println(key +"========"+value);
		}
		System.out.println(System.getProperty("spring.profiles.active"));
	}
}
