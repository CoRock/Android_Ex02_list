package com.example.ex02_list;

/**
 *  Created by CoRock on 2018-06-26.
 */

public class PhonebookDTO {

    private String name;
    private String tel;

    // [Alt+Insert] --> [constructor, getter & setter]
    public PhonebookDTO() { }
    public PhonebookDTO(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}