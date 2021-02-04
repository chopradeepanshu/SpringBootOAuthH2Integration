package com.deepakmart.model;

import java.io.Serializable;

public class Welcome implements Serializable {

    private static final String GREETINGS = new String("Welcome %s!");

    public String greetings;

    public Welcome() {
    }

    public Welcome(String name) {
        this.greetings = String.format(GREETINGS, name);
    }
}
