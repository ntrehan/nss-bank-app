package com.nss.bank.cache;

import com.nss.bank.entity.Customer;
import com.nss.bank.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheStoreBeans {

    @Bean
    public CacheStore<Customer> userCache() {
        return new CacheStore<Customer>(120, TimeUnit.SECONDS);
    }

    @Bean
    public CacheStore<String> usernameCache() {
        return new CacheStore<String>(1, TimeUnit.HOURS);
    }
}
