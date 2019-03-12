package homework.lessonEighth;

import java.io.Serializable;

public class Cat implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String color;

    public Cat() {
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        if (!name.equals(cat.name)) return false;
        return color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public Cat clone() throws CloneNotSupportedException {
        return (Cat) super.clone();
    }
}
