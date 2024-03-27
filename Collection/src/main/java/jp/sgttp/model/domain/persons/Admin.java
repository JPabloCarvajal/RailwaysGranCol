/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.sgttp.model.domain.persons;

import jp.array.Array;

/**
 *
 * @author thewe
 */
public class Admin extends AbstractPerson {

    private String id;
    private final int type = 4;

    public Admin() {
        id = "N/A";
    }

    public Admin(String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Admin getNullAdmin() {
        return new Admin();
    }

    public int getType() {
        return type;
    }

}
