package com.mahui.xuliehua.serializable;

import java.io.Serializable;

/**
 *
 * @author 76047
 * @date 2018/8/14
 */

public class User implements Serializable{
    private int id;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
