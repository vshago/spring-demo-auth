package com.example.auth.service;

/**
 * @author Viacheslav Shago
 */
public interface TokenService {
    String generateToken(String clientId);
}
