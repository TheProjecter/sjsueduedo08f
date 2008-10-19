package edu.sjsu.edo08f.domain;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class Person {

    protected Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;

    // readonly variable. type="STUDENT" or "INSTRUCTOR"
    private String type;

    /*
    Zip code of the person.
    2 possible formats:
    [0-9][0-9][0-9][0-9][0-9]
    or
    [0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]
     */
    private String zipCode;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
