package com.RKShopping.ShoppingDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RKShopping.ShoppingDetails.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{	
}
