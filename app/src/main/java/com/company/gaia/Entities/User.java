package com.company.gaia.Entities;

public class User {
    
    private long id;

    public String userName;


    public String email;

    public String password;

    public String userInfo;

    public double originalIndex;

    public double currIndex;

    public int transIndex;

    public int foodIndex;

    public int houseIndex;

    public int consIndex;


    public User() {
    }

    /* USER */
    public User(String userName, String email, String password, String userInfo, double originalIndex, double currIndex,
                int transIndex, int foodIndex, int houseIndex, int consIndex, int worstCase, int currCase) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
        this.originalIndex = originalIndex;
        this.currIndex = currIndex;
        this.transIndex = transIndex;
        this.foodIndex = foodIndex;
        this.houseIndex = houseIndex;
        this.consIndex = consIndex;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return userName;
    }

    /* GETTERS & SETTERS for name */
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


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
        this.password = userInfo;
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

    /* GETTERS & SETTERS for worstCase
    public int getWorstCase() { return worstCase; }

    public void setWorstCase(int worstCase) { this.worstCase = worstCase; }

    /* GETTERS & SETTERS for consIndex
    public int getCurrCase() { return currCase; }

    public void setCurrCase(int currCase) { this.currCase = currCase; } */

    /*
     * Test for signUp
     */

}
