package domain;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.io.Serializable;

public class Students implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String telephone;
    private String email;
    private Role role;
    private Classes classid;

    public Students() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", classid=" + classid +
                '}';
    }

    public Students(Integer id, String name, Integer age, String gender, String elephone, String email, Classes classid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephone = elephone;
        this.email = email;
        this.classid = classid;
    }

    public Students(String name, Integer age, String gender, String elephone, String email, Classes classid) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephone = elephone;
        this.email = email;
        this.classid = classid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classes getClassid() {
        return classid;
    }

    public void setClassid(Classes classid) {
        this.classid = classid;
    }
}
