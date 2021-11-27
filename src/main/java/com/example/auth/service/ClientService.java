package com.example.auth.service;

/**
 * @author Viacheslav Shago
 */
public interface ClientService {
    void register(String clientId, String clientSecret);
    void checkCredentials(String clientId, String clientSecret);
}
