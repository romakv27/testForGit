package ru.sfedu.library.entity;


import com.opencsv.bean.CsvBindByPosition;


public class User {

    @CsvBindByPosition(position = 0)
    private Long id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String surname;
    @CsvBindByPosition(position = 3)
    private Integer age;



    public User(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User () { };
    /**
     * Set the value of id
     * @param newVar the new value of id
     */

    public void setId (Long newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     * @return the value of id
     */

    public Long getId () {
        return id;
    }

    /**
     * Set the value of name
     * @param newVar the new value of name
     */

    public void setName (String newVar) {
        name = newVar;
    }

    /**
     * Get the value of name
     * @return the value of name
     */

    public String getName () {
        return name;
    }

    /**
     * Set the value of surname
     * @param newVar the new value of surname
     */

    public void setSurname (String newVar) {
        surname = newVar;
    }

    /**
     * Get the value of surname
     * @return the value of surname
     */

    public String getSurname () {
        return surname;
    }

    /**
     * Set the value of age
     * @param newVar the new value of age
     */

    public void setAge (Integer newVar) {
        age = newVar;
    }

    /**
     * Get the value of age
     * @return the value of age
     */

    public Integer getAge () {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
