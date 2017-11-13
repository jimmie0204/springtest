package processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory paramConfigurableListableBeanFactory)
			throws BeansException {
		AbstractBeanDefinition  bd = (AbstractBeanDefinition) paramConfigurableListableBeanFactory.getBeanDefinition("student");
		MutablePropertyValues pv = bd.getPropertyValues();
		if(pv.contains("username"))  
        {  
            pv.addPropertyValue("username", "tony");  
        } 
		
		pv.addPropertyValue("school",new School("sdust"));
		bd.setPropertyValues(pv);
	}

}
