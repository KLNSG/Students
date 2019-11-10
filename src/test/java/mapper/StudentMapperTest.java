package mapper;

import com.sun.jnlp.DownloadService2Impl;
import domain.Classes;
import domain.Role;
import domain.Something;
import domain.Students;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.Connection;
import java.util.*;

import static org.junit.Assert.*;

/**
 * @author
 *
 */
public class StudentMapperTest{

    private SqlSessionFactory s;


    @Before
    public void before() throws IOException{
        InputStream in = Resources.getResourceAsStream("Student_config.xml");
        s = new SqlSessionFactoryBuilder().build(in);
    }


    public boolean addstudnet(Students students){
        SqlSession n=s.openSession();
        try {
            StudentMapper students1 = n.getMapper(StudentMapper.class);
            int i = students1.save(students);
            n.commit();
            if (i != 0) {
                return true;
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            n.close();
        }
        return false;
    }

    public void Sel() throws IOException{
        SqlSession n=s.openSession();
        try {
            ClassMapper classMapper = n.getMapper(ClassMapper.class);
            classMapper.findAll().forEach(e -> {
                System.out.println("年级 " + e.getName());
                e.getStudentsSet().forEach(x -> System.out.println(x));
                System.out.println();
            });
            n.commit();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            n.close();
        }
    }

    public int getClass(String classname){
        switch (classname){
            case "大一":
                return 1;
            case "大二":
                return 2;
            case "大三":
                return 3;
            case "大四":
                return 4;
                default:return 0;
        }
    }

    public void Truncate(){
        SqlSession session=s.openSession();
        try{
            StudentMapper a=session.getMapper(StudentMapper.class);
            a.trun();
            session.commit();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            session.close();
        }
    }

    public void selbysomething(Something something){
        SqlSession a=s.openSession();
        StudentMapper student=a.getMapper(StudentMapper.class);
        student.findbysomething(something).forEach(System.out::println);
        a.commit();
    }

  /*  public Object getvalues(String values){
        Map<String,Object> a=new HashMap<>();
        Object s=a.get(values);
        if (s==null){
            a.put(values,Object);
            s=a.get(values);
        }
        return s;
    }*/



    @Test
    public void Test() throws IOException{

        /*
        JedisShardInfo shardInfo = new JedisShardInfo("localhost",6379);//这里是连接的本地地址和端口
        shardInfo.setPassword("123456");//这里是密码
        Jedis jedis = new Jedis(shardInfo);
        System.out.println(jedis.get("age"));
        jedis.connect();*/
        /*SqlSession aa=s.openSession();
        StudentMapper ss=aa.getMapper(StudentMapper.class);
        Students lv=new Students("卡列宁",16,"男","123","321",new Classes(1));
        lv.setRole(Role.USER);
        System.out.println(addstudnet(lv));*/
       Sel();
    }
}
