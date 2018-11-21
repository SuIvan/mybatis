import com.test.model.IUserMapper;
import com.test.model.MyBatisUtil;
import com.test.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author : ivan
 * @version : v1.00
 * @CreationDate : 2018/11/21 16:16
 * @Description :
 * @update : 修改人，修改时间，修改内容
 * @see ：[相关类/方法]
 */
public class TestAnnotationFunction {

    @Test
    public void testAdd(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        User user = new User();
        user.setName("gogo");
        user.setAge(11);
        int result = userMapper.add(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.print(result);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        User user = new User();
        user.setName("gogogoogogoog");
        user.setAge(121);
        user.setId(9);
        int result = userMapper.updatebyId(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.print(result);
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        int result = userMapper.deleteById(9);
        sqlSession.commit();
        sqlSession.close();
        System.out.print(result);
    }

    @Test
    public void testGetByid(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        User result = userMapper.getById(71);

        sqlSession.commit();
        sqlSession.close();
        System.out.print(result);
    }

    @Test
    public void testAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        List<User> result = userMapper.getAll();
        sqlSession.commit();
        sqlSession.close();
        System.out.print(result);
    }
}
