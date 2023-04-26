package ru.perm.v.kotlin_in_action;

import java.util.Objects;

public class PersonJ {
    private String name ="";
    private Integer age =0;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonJ personJ = (PersonJ) o;
        return Objects.equals(name, personJ.name) && Objects.equals(age, personJ.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
