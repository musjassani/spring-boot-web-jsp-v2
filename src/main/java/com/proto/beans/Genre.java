package com.proto.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genre {

    @Id
    private String code;
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
