package beanzhuru;/**
 * Created by jimmie on 2018/4/17.
 */

/**
 * @author jimmie
 * @create 2018-04-17 上午11:35
 */

public class Employee {


    private int id;
    private String name;
    private String sex;
    private Car car;


    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Employee(int id, String name, String sex) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
}