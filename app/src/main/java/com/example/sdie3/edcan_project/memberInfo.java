package com.example.sdie3.edcan_project;

import java.io.Serializable;

/**
 * Created by sdie3 on 2018-05-02.
 */

public class memberInfo implements Serializable {
    String name;
    String id;
    String password;
    String getId() {
        return id;
    }
    String getPassword() {
        return password;
    }

    memberInfo(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }
    memberInfo(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
