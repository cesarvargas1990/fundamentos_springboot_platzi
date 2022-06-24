package com.fundamentosplatzi.springboot.fundamentos.configuration;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {
    private String nombre;
    private String apellido;

    public MyBeanWithPropertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function () {
        return nombre+" - "+apellido;
    }


}
