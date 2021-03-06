package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean2Implement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependencyImplement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyOperation;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyOperationImpl;
import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation() {
        return new MyBean2Implement();
    }
    @Bean
    public MyOperation beanOperationOperation() {
        return new MyOperationImpl();
    }
    @Bean
    public MyBeanWithDependency myOperation(MyOperation myOperation, MyCustomRepository myCustomRepository) {
        return new MyBeanWithDependencyImplement(myOperation,myCustomRepository);
    }

}
