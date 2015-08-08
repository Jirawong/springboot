/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linksinnovation.springboot.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
public class Authority implements GrantedAuthority{

    @Override
    public String getAuthority() {
        return null;
    }
    
}
