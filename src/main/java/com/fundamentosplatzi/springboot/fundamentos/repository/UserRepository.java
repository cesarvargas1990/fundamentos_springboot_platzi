package com.fundamentosplatzi.springboot.fundamentos.repository;

import com.fundamentosplatzi.springboot.fundamentos.dto.UserDto;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail (String email);
    @Query ("Select u from User u WHERE u.name like ?1%")
    List<User> findAndSort (String name, Sort sort);
    List<User> findByName (String name);
    User findByNameAndEmail (String name, String email);
    List<User> findByNameLike(String name);
    List<User> findByNameOrEmail (String name, String email);
    List<User> findByBirthDateBetween (LocalDate begin, LocalDate end);
    List<User> findByNameLikeOrderByIdDesc(String name);
    List<User> findByNameContainingOrderByIdDesc (String name);
    List<User> findByEmailContainingOrderByNameAsc (String name);
    List<User> findAll();
    @Query("select new com.fundamentosplatzi.springboot.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)" +
            "from User u " +
            "where u.birthDate=:parametroFecha " +
            "and u.email=:parametroEmail")
    Optional<UserDto> getAllByBirthDateAndEmail (@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String Email);
}
