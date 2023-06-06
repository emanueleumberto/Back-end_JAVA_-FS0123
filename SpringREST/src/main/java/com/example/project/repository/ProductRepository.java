package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
