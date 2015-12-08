package com.testcase.cdiviewscopetest;

import javax.annotation.PostConstruct;
import java.io.Serializable;

// ClassCastException
@javax.inject.Named
@javax.faces.view.ViewScoped
// Works
//@javax.faces.bean.ManagedBean
//@javax.faces.bean.ViewScoped
public class ViewScopedBean implements Serializable {

    @PostConstruct
    private void init() {
        System.out.println("Constructing ViewScopedBean");
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void increaseValue() {
        value++;
    }

}
