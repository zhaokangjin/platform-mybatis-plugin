package com.platform.provider;

import java.util.List;

/**
 *  @author kangjin.zhao
 */
public class PersonProvider {
    private java.lang.Long id;
    private java.lang.String name;
    private java.lang.Integer age;
    private java.util.List<String> hobby;

    public void setId(java.lang.Long id){
        this.id = id;
    }
    public java.lang.Long getId(){
        return this.id;
    }
    public void setName(java.lang.String name){
        this.name = name;
    }
    public java.lang.String getName(){
        return this.name;
    }
    public void setAge(java.lang.Integer age){
        this.age = age;
    }
    public java.lang.Integer getAge(){
        return this.age;
    }
    public void setHobby(java.util.List<String> hobby){
        this.hobby = hobby;
    }
    public java.util.List<String> getHobby(){
        return this.hobby;
    }
}