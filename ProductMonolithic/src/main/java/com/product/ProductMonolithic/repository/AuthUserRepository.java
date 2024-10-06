package com.product.ProductMonolithic.repository;

import com.product.ProductMonolithic.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser,Long> {
    Optional<AuthUser> findByAuthName(String authName);
}
