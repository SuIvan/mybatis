package com.test.model;

/**
 * @author : ivan
 * @version : v1.00
 * @CreationDate : 2018/11/22 16:52
 * @Description :
 * @update : 修改人，修改时间，修改内容
 * @see ：[相关类/方法]
 */
public class Student {
    //定义属性，和student表中的字段对应
    private int id;            //id===>s_id
    private String name;    //name===>s_name

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

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
}
