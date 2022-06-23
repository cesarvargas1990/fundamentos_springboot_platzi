package com.fundamentosplatzi.springboot.fundamentos.component;

import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public class MyCustomRepositoryImplement implements MyCustomRepository {

    @Override
    public List<String> getData() {
        return Arrays.asList("dato1","dato2","dato3","dato4");
    }
}
