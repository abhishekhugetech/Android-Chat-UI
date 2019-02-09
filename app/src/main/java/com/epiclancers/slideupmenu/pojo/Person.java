package com.epiclancers.slideupmenu.pojo;

public class Person {

    public String name;
    public String desc;
    public String image;
    public long isOnline;
    public int lastOnline;

    public Person(String name, String desc, String image, long isOnline, int lastOnline) {
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.isOnline = isOnline;
        this.lastOnline = lastOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public int getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(int lastOnline) {
        this.lastOnline = lastOnline;
    }

    public long getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", image='" + image + '\'' +
                ", isOnline=" + isOnline +
                ", lastOnline=" + lastOnline +
                '}';
    }
}
