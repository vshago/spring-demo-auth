package com.example.auth.dao;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Viacheslav Shago
 */
public interface ClientRepository
        extends CrudRepository<ClientEntity, String> {
}
