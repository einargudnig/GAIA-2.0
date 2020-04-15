package com.company.gaia.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private long id;
    private String email;
    private String userInfo;
    private double originalIndex;
    private double currIndex;
    private int transIndex;
    private int foodIndex;
    private int houseIndex;
    private int consIndex;
    private int worstCase;
    private int currCase;
    private String name;
    private String uname;
    private String password;

    public User() {

    }

    public void setId(long id) {
        this.id = id;
    }

    /* GETTERS & SETTERS for name */

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getuname() { return uname; }

    public void setuname(String uname) { this.uname = uname; }

    /* GETTERS & SETTERS for email */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* GETTERS & SETTERS for password */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /* GETTERS & SETTERS for userInfo */
    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }


    /* GETTERS & SETTERS for originalIndex */
    public double getOriginalIndex() { return originalIndex; }

    public void setOriginalIndex(double originalIndex) {
        this.originalIndex = originalIndex;
    }

    /* GETTERS & SETTERS for currIndex */
    public double getCurrIndex() {
        return currIndex;
    }

    public void setCurrIndex(double currIndex) {
        this.currIndex = currIndex;
    }

    /* GETTERS & SETTERS for transIndex */
    public int getTransIndex() { return transIndex; }

    public void setTransIndex(int transIndex) { this.transIndex = transIndex; }

    /* GETTERS & SETTERS for foodIndex */
    public int getFoodIndex() { return foodIndex; }

    public void setFoodIndex(int foodIndex) { this.foodIndex = foodIndex; }

    /* GETTERS & SETTERS for houseIndex */
    public int getHouseIndex() { return houseIndex; }

    public void setHouseIndex(int houseIndex) { this.houseIndex = houseIndex; }

    /* GETTERS & SETTERS for consIndex */
    public int getConsIndex() { return consIndex; }

    public void setConsIndex(int consIndex) { this.consIndex = consIndex; }

    /* GETTERS & SETTERS for worstCase */
    public int getWorstCase() { return worstCase; }

    public void setWorstCase(int worstCase) { this.worstCase = worstCase; }

    /* GETTERS & SETTERS for consIndex */
    public int getCurrCase() { return currCase; }

    public void setCurrCase(int currCase) { this.currCase = currCase; }

    /*
     * Test for signUp
     */

}
