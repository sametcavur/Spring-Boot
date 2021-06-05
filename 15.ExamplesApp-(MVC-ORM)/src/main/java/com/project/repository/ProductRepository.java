package com.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
