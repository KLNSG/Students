package mapper;

import domain.Classes;

import java.util.List;

public interface ClassMapper {
    List<Classes> findAll();
    List<Classes> findClass();
}
