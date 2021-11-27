package com.example.auth.model;

import lombok.Value;

/**
 * @author Viacheslav Shago
 */
@Value
public class User {
    String clientId;
    String clientSecret;
}
