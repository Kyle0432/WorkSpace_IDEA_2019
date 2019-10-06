package com.kyle.cache.mapper;

import com.kyle.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author: Kyle
 * @date: 2019/9/27 -  18:27
 */

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},dId=#{dId} WHERE id =#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id= #{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,dId) VALUES(#{lastName},#{email},#{gender},#{Did})  ")
    public void insertEmployee(Employee employee);


    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
