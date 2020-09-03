package cn.tsh.study.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter

public class User {
    private int id;
    private String username;
    private String password;
    public  User(int id,String username,String password){

        this.id=id;
        this.username=username;
        this.password=password;


    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    public static void main(String[] args) {
        User a=new User(1,"a","qqw");
        System.out.println(a.toString());

    }
}
