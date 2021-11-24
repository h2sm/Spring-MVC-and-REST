package com.h2sm.springmvcrest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name="client", schema = "public")
@Getter
@Setter
@ToString()
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", unique = true, nullable = false)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "passport")
    private String passport;
    @Column(name = "tel_name")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date date_of_birth;

    public Client(String fullName, String passport, String phoneNumber, String dateOfBirth) {
        this.fullName=fullName;
        this.passport=passport;
        this.phoneNumber=phoneNumber;
        this.date_of_birth=convert(dateOfBirth);
    }

    public Client() {

    }
    @SneakyThrows
    private Date convert(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        var date = formatter.parse(s);
        return new Date(date.getTime());
    }

    public void setDate(String date){
        this.date_of_birth = convert(date);
    }
}
