package com.ligq.utils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * @author young
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String userName;
    private int age;
    private String gender;
    @Property(nameInDb = "name")
    private String nickName;

    @Generated(hash = 2068680922)
    public User(Long id, String userName, int age, String gender, String nickName) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.nickName = nickName;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}