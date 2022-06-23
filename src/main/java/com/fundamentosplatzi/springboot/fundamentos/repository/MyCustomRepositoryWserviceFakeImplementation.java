package com.fundamentosplatzi.springboot.fundamentos.component;

import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepositoryWserviceFake;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public class MyCustomRepositoryWserviceFakeImplementation implements MyCustomRepositoryWserviceFake {

    @Override
    public List<String> getDataFromService() {
        return Arrays.asList("datafromservice1","datafromservice2");
    }
}
