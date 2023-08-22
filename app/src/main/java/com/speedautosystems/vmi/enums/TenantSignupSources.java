package com.speedautosystems.vmi.enums;

/**
 * Created by Rameel on 10/05/2021.
 */
public enum TenantSignupSources {

    Unknown(0),
    WebApp(1),
    MobileApp(2),
    Manual(3),
    Android(4),
    IOS(5);

    private final int id;

    TenantSignupSources(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}
