package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepository;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;
    private MyCustomRepository myCustomRepository;
    public MyBeanWithDependencyImplement(MyOperation myOperation, MyCustomRepository myCustomRepository) {
        this.myOperation = myOperation;
        this.myCustomRepository = myCustomRepository;
    }


    @Override
    public void printWithDependency() {
        int number = 1;
        System.out.println( myOperation.sum(number));
        System.out.println("este es un ejemplo de la data de un bean que tiene dependencia llamando a custom repository");
        System.out.println(myCustomRepository.getData());
        System.out.println("hola desde mi bean wih dependency");
    }
}
