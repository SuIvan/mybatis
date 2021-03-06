import com.test.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : ivan
 * @version : v1.00
 * @CreationDate : 2018/11/9 14:01
 * @Description :
 * @update : 修改人，修改时间，修改内容
 * @see ：[相关类/方法]
 */
public class TestFunction {

    @Test
    public void SelectOne(){
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = TestFunction.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        try{
            String statement = "mapper.UserMapper.getUser";//映射sql的标识字符串
            //执行查询返回一个唯一user对象的sql
            User user = session.selectOne(statement, 1);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addOne(){
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = TestFunction.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        try{
            String statement = "mapper.UserMapper.addUser";//映射sql的标识字符串
            User user = new User();
            user.setName("name");
            user.setAge(11);
            //执行查询返回一个唯一user对象的sql
            int state = session.insert(statement, user);
            session.commit();
            session.close();
            System.out.println(user);
            System.out.println(state);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateOne(){
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = TestFunction.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        try{
            String statement = "mapper.UserMapper.updateUser";//映射sql的标识字符串
            User user = new User();
            user.setId(5);
            user.setName("name");
            user.setAge(11);
            //执行查询返回一个唯一user对象的sql
            int state = session.update(statement, user);
            session.commit();
            session.close();
            System.out.println(user);
            System.out.println(state);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
