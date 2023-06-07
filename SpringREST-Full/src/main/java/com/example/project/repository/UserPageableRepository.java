package com.example.project.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.User;

@Repository
public interface UserPageableRepository extends PagingAndSortingRepository<User, Long> {

}
