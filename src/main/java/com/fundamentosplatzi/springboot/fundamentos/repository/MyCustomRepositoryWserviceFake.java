package com.fundamentosplatzi.springboot.fundamentos.repository;

import java.util.List;

public interface MyCustomRepositoryWserviceFake {
    List<String> getDataFromService();
    List<String> getDataFromService(int maxElements);
}
