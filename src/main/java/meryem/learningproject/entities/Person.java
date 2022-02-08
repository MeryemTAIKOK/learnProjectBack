package meryem.learningproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private  String firstName;
   // private String FamilyName;
    private  String phoneNumber;
    private int age;
    private String country;
    private String jobTitle;
    private double monthlyIncome;
    private double log;
    private double len;


    public Person(String firstName,  String phoneNumber, int age,
                  String country, String jobTitle, double monthlyIncome, double log, double len) {
        this.firstName=firstName;
        this.phoneNumber=phoneNumber;
        this.age=age;
        this.country=country;
        this.jobTitle=jobTitle;
        this.monthlyIncome=monthlyIncome;
        this.log=log;
        this.len=len;
    }

    public Person(String firstName,  String phoneNumber, int age,
                  String country, String jobTitle, double monthlyIncome) {
        this.firstName=firstName;
        this.phoneNumber=phoneNumber;
        this.age=age;
        this.country=country;
        this.jobTitle=jobTitle;
        this.monthlyIncome=monthlyIncome;

    }



}
