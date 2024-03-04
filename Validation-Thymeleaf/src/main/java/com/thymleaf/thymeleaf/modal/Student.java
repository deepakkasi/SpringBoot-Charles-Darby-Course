package com.thymleaf.thymeleaf.modal;


import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Student
{
    private String firstName;
   @NotNull(message = "is Required")
   @Size(min=1, message="is required")
    private String lastName="";

   @Min(value=0,message = "value should not be less than zero")
   @Max(value=10,message="Value must be less than 10")
   private int freetoken;
   @Email(message = "Enter valid email id")
   private  String email;
    @Pattern(regexp = "^[a-zA-z0-9]{6}",message="enter 6 six digit postal code")
    private String postalcode;

    @NotNull(message = "is Required")
    @Size(min = 10,max=10,message = "Mobile number should be 10 digits")

    private String phno;

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }


    public int getFreetoken() {
        return freetoken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFreetoken(int freetoken) {
        this.freetoken = freetoken;
    }


    public Student(){

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
}
