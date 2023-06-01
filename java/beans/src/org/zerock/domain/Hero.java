package org.zerock.domain;

public class Hero {

    private String name;
    private boolean married;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isMarried() {
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
    }
    @Override
    public String toString() {
        return "Hero [name=" + name + ", married=" + married + "]";
    }



}