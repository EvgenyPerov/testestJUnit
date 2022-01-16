package Entities;

import org.junit.Test;

import java.util.Objects;

public class Man implements Person {
    private int id;
    private String name;
    private int old;
    private EnumSex sex;

    public Man(int id, String name, int old, EnumSex sex){
        this.id = id;
        this.name = name;
        this.old = old;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOld() {
        return old;
    }

    @Override
    public EnumSex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", old=" + old +
                ", sex=" + sex +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return old == man.old && Objects.equals(name, man.name) && sex == man.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, old, sex);
    }
}
