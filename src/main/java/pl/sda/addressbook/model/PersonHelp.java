package pl.sda.addressbook.model;

import javafx.beans.property.StringProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonHelp{


    private String name;
    private String lastname;
    private String street;
    private String city;
    private String postalCode;
    private String telephone;

 // poszlo Lombokiem:
//    public PersonHelp(String name, String lastname, String street, String city, String postalCode, String telephone) {
//        this.name = name;
//        this.lastname = lastname;
//        this.street = street;
//        this.city = city;
//        this.postalCode = postalCode;
//        this.telephone = telephone;
//    }
//
//    public PersonHelp(){
//
//    }


    @Override
    public String toString() {
        return "PersonHelp{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getPostalCode() {
//        return postalCode;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
}
