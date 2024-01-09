package com.ing9990.accounts.repository;

import com.ing9990.accounts.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.mobileNumber = ?1")
    Optional<Customer> findByMobileNumber(String mobileNumber);
}