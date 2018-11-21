package com.test.model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sun.java2d.pipe.AAShapePipe;

import java.util.List;

/**
 * @author : ivan
 * @version : v1.00
 * @CreationDate : 2018/11/21 16:03
 * @Description :
 * @update : 修改人，修改时间，修改内容
 * @see ：[相关类/方法]
 */
public interface IUserMapper {

    /**
     * add user
     * @auther: ivan
     * @param user : user entity
     * @return : oooo
     */
    @Insert("insert into users(name,age) values(#{name},#{age})")
    public int add(User user);

    /**
     * aaa
     * @auther: ivan
     * @param id : 111
     * @return : null
     */
    @Delete("delete from users where id = #{id}")
    public int deleteById(int id);

    @Update("update users set name=#{name}, age=#{age} where id=#{id}")
    public int updatebyId(User user);

    @Select("select * from users where id=#{id}")
    public User getById(int id);

    @Select("select * from users ")
    public List<User> getAll();

}
