package com.example.demo.entity;


import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(length = 50,nullable = false)
    private String username;
    @Column(length = 50,nullable = false)
    private String password;
    @Column(length=50,nullable = false)
    private String email;
    @Column(length = 500,nullable = false)
    private String address;
    @Column(length = 50,nullable = false)
    private String phone;
    @Column(length = 50,nullable = false)
    private String company;
    @Column(length = 50,nullable = false)
    private String useroleid;
    @Column(length = 50,nullable = false)
    private String softdelete;

    public User(){super();}

    public User( String username, String password, String email, String address, String phone, String company, String useroleid, String softdelete) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.company = company;
        this.useroleid = useroleid;
        this.softdelete = softdelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUseroleid() {
        return useroleid;
    }

    public void setUseroleid(String useroleid) {
        this.useroleid = useroleid;
    }

    public String getSoftdelete() {
        return softdelete;
    }

    public void setSoftdelete(String softdelete) {
        this.softdelete = softdelete;
    }
}
