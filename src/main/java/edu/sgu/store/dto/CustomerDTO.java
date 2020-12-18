package edu.sgu.store.dto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class CustomerDTO {
    private Integer id;
    @NotBlank(message = "enter username" )
    private String username;
    @NotBlank(message = "enter passwork" )
    private String passwork;
    @NotBlank(message = "enter firstName" )
    private String firstName;
    @NotBlank(message = "enter lastName" )
    private String lastName;
    @NotBlank(message = "enter gender" )
    private String gender;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthDate;
    @NotBlank(message = "enter address" )

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
