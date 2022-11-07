package com.noirix.security.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;

import java.security.Principal;

public class PrincipalUtil {

    public static String getUsername(Principal principal) {
        Object castedPrincipal = ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return ((User) castedPrincipal).getUsername();
    }

}
