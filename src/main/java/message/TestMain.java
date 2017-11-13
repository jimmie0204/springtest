package message;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class TestMain {

	private static MessageSource messageSource = new ReloadableResourceBundleMessageSource();
	
	public static void main(String[] args) {
		String msg = messageSource.getMessage("inter.10100002" , new Object[0], Locale.CHINA);
		System.out.println(msg);
	}
}
