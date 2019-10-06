package com.kyle.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Kyle
 * @date: 2019/9/17 -  17:42
 */

/**
 * 将配置文件中配置的每一个属性的值,映射到这个组件中
 *@ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix = "person":配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件,才能使用容器提供的@ConfigurationProperties功能
 * @ConfigurationProperties(prefix = "person")默认从全局配置文件中获取值
 * JSR303的一个校验 @Validated: 表示Person类里面的属性需要进行校验
 */

//这里@Component的作用是把Person加载到容器中
@Component
//第一种注入方式,可以注入批量配置文件
@ConfigurationProperties(prefix = "person")
//告诉SpringBoot去加载类路径下的person.properties文件,并且把该文件的配置绑定到本类中,好处是可以自定义需要的配置信息
//@PropertySource(value = {"classpath:person.properties"})
//JSR303注入的值进行校验
//@Validated
public class Person {
    /**
     * <bean class="Person">
     *       <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
     * </bean>
     *
     */
    //第二种注入方式,这种方式比较麻烦,需要一个一个注入
    //@Value("${person.last-name}")
    //lastName的注入值必须是邮箱格式,否则就会报错
    //@Email
    private String lastName;
    //@Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists= lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
