package com.linksinnovation.springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@Entity
public class Authority implements GrantedAuthority{
    
    @Id
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
}
