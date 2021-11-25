package com.h2sm.springmvcrest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "client_id", unique = true, nullable = false) int id;
    private @Column(name = "full_name") String fullName;
    private @Column(name = "passport") String passport;
    private @Column(name = "tel_name") String phoneNumber;
    private @Column(name = "date_of_birth") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateOfBirth;

    public Client(String fullName, String passport, String phoneNumber, String dateOfBirth) {
        this.fullName=fullName;
        this.passport=passport;
        this.phoneNumber=phoneNumber;
        this.dateOfBirth=convert(dateOfBirth);
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
        this.dateOfBirth = convert(date);
    }
}
