import com.test.model.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class TestOrder {

    public SqlSession getSession(){
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
        return  session;
    }


    @Test
    public void getOrderById(){
        String statement = "mapper.OrderMapper.getOrderById";
        SqlSession sqlSession = getSession();
        Order oder = sqlSession.selectOne(statement,1);
        sqlSession.close();
        System.out.println(oder);
    }

    @Test
    public void getselectOrder(){
        String statement = "mapper.OrderMapper.selectOrder";
        SqlSession sqlSession = getSession();
        Order oder = sqlSession.selectOne(statement,1);
        sqlSession.close();
        System.out.println(oder);
    }

    @Test
    public void selectOrderResultMap(){
        String statement = "mapper.OrderMapper.selectOrderResultMap";
        SqlSession sqlSession = getSession();
        Order oder = sqlSession.selectOne(statement,1);
        sqlSession.close();
        System.out.println(oder);
    }
}
