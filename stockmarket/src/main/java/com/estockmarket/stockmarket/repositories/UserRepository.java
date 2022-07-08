package com.estockmarket.stockmarket.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.estockmarket.stockmarket.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID>{

    @AllowFiltering
    public User findByUsernameAndPassword(String UserName, String Password);

    @AllowFiltering
    public User findByUsername(String username);;

    public User findByName(String name);;
}
