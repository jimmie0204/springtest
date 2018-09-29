package beanzhuru;

import org.springframework.beans.factory.FactoryBean;

public class EmployeeFactoryBean implements FactoryBean<Employee>{


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private Car car;



    @Override
    public Employee getObject() throws Exception {
        // TODO Auto-generated method stub

        //Here  is a complex  car  object  created
         // wouldn't be a very useful FactoryBean
        // if we could simply instantiate the object!
        Employee employee  = new Employee();

        if("奥迪".equalsIgnoreCase(car.getCarName())){
            employee.setName("wocao");
        }else{
            employee.setName("diaosi");
        }
        employee.setCar(car);
        return  employee;
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Employee.class;
    }  
  
    @Override  
    public boolean isSingleton() {  
        // TODO Auto-generated method stub  
        return true;  
    }  
  
}  