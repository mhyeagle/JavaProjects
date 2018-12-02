package mybatisTest.service;

import mybatisTest.mapper.UserMapper;
import mybatisTest.po.User;
import mybatisTest.tools.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public static void main(String[] args) {
        //insertUser();
        selectAllUser();
    }

    /**
     * 新增用户
     */
    private static boolean insertUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User("test02", "123456", 700.0);

        try {
            int index = mapper.insertUser(user);
            boolean bool = index > 0 ? true : false;
            logger.error("新增用户user对象:{},操作状态:{}",new Object[]{user,bool});
            session.commit();
            return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    private static void selectAllUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        try {
            List<User> user = mapper.selectAllUser();
            //logger.debug("获取所有的用户: {}", user);
            System.out.println("获取所有的用户: \n" + user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}
