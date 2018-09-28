package org.zerock.domain;

public class Member {

    private String name;
    private int age;
    private boolean married;

    public String getName() {
        System.out.println("getName...");
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        System.out.println("getAge...");
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isMarried() {
        System.out.println("isMarried");
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
    }
    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + ", married=" + married + "]";
    }




}