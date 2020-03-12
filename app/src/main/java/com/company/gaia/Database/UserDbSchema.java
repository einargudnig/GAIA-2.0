package com.company.gaia.Database;

public class UserDbSchema {

    public static final class UsersTable {
        public static final String NAME="user";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
            public static final String USERINFO = "userInfo";

            private double originalIndex;
            public double ORIGINALINDEX = originalIndex;

            private double transIndex;
            public double TRANSINDEX = transIndex;

            private double foodIndex;
            public double FOODINDEX = foodIndex;

            private double houseIndex;
            public double HOUSEINDEX = houseIndex;

            private double consIndex;
            public double CONSINDEX = consIndex;


        }
    }
}
