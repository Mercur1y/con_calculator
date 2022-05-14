package com.simbirsoft.con_calc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class AbstractHuman {

    @NotBlank(message = "Поле имени не может быть пустым")
    protected String last_name;
    @NotBlank(message = "Поле фамилии не может быть пустым")
    protected String first_name;
    @NotBlank(message = "Поле отчества не может быть пустым")
    protected String second_name;
    @NotBlank(message = "Поле e-mail не может быть пустым")
    protected String email;
    @NotBlank(message = "Поле телефона не может быть пустым")
    protected Long phone;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}

