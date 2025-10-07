package com.mx.skyangel.repository;

import com.mx.skyangel.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, BigInteger> {

    Optional<Account> findByUsername(String username);

}
