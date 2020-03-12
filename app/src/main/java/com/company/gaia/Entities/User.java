package com.company.gaia.Entities;


import java.util.UUID;

public class User {

    private UUID mId;
    private String mName;
    private String mEmail;
    private String mPassword;
    private String mUserInfo;
    private double mOriginalIndex;
    private double mCurrIndex;
    private int mTransIndex;
    private int mFoodIndex;
    private int mHouseIndex;
    private int mConsIndex;


    public User() {
        this(UUID.randomUUID());
    }

    public User(UUID id) {
        mId = id;
    }


    public UUID getId() {
        return mId;
    }

    /*public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return userName;
    } */

    /* GETTERS & SETTERS for name */
    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        this.mName = Name;
    }


    /* GETTERS & SETTERS for email */
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    /* GETTERS & SETTERS for password */
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }


    /* GETTERS & SETTERS for userInfo */
    public String getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(String userInfo) {
        this.mUserInfo = userInfo;
    }


    /* GETTERS & SETTERS for originalIndex */
    public double getOriginalIndex() { return mOriginalIndex; }

    public void setOriginalIndex(double originalIndex) {
        this.mOriginalIndex = originalIndex;
    }

    /* GETTERS & SETTERS for currIndex */
    public double getCurrIndex() {
        return mCurrIndex;
    }

    public void setCurrIndex(double currIndex) {
        this.mCurrIndex = currIndex;
    }

    /* GETTERS & SETTERS for transIndex */
    public int getTransIndex() { return mTransIndex; }

    public void setTransIndex(int transIndex) { this.mTransIndex = transIndex; }

    /* GETTERS & SETTERS for foodIndex */
    public int getFoodIndex() { return mFoodIndex; }

    public void setFoodIndex(int foodIndex) { this.mFoodIndex = foodIndex; }

    /* GETTERS & SETTERS for houseIndex */
    public int getHouseIndex() { return mHouseIndex; }

    public void setHouseIndex(int houseIndex) { this.mHouseIndex = houseIndex; }

    /* GETTERS & SETTERS for consIndex */
    public int getConsIndex() { return mConsIndex; }

    public void setConsIndex(int consIndex) { this.mConsIndex = consIndex; }

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
