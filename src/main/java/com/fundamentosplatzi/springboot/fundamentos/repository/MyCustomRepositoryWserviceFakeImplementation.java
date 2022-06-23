package com.fundamentosplatzi.springboot.fundamentos.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public class MyCustomRepositoryWserviceFakeImplementation implements MyCustomRepositoryWserviceFake{

    @Override
    public List<String> getDataFromService() {
        return Arrays.asList("datafromservice1","datafromservice2","datafromservice3","datafromservice4");
    }
    @Override
    public List<String> getDataFromService(int maxElements) {
        System.out.println("fake service return only=>"+maxElements);
        return Arrays.asList("datafromservice1");
    }
}
