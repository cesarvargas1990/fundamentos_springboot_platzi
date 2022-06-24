package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.FundamentosApplication;
import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.LoggerFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
    private MyOperation myOperation;
    private MyCustomRepository myCustomRepository;
    public MyBeanWithDependencyImplement(MyOperation myOperation, MyCustomRepository myCustomRepository) {
        this.myOperation = myOperation;
        this.myCustomRepository = myCustomRepository;
    }


    @Override
    public void printWithDependency() {
        LOGGER.info("ingreso metodo printWithDependency");
        int number = 1;
        System.out.println( myOperation.sum(number));
        LOGGER.debug("valor de la variable number"+number);
        System.out.println("este es un ejemplo de la data de un bean que tiene dependencia llamando a custom repository");
        System.out.println(myCustomRepository.getData());
        System.out.println("hola desde mi bean wih dependency");
    }
}
