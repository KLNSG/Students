package mapper;

import domain.Something;
import domain.Students;
import org.apache.ibatis.annotations.Param;

import javax.print.DocFlavor;
import java.util.List;

public interface StudentMapper{
    List<Students> findAll();

    List<Students> findbysomething(Something something);

    List<Students> findbyids(List<Integer> ids);

    int save(Students students);

    void trun();
}
