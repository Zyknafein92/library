package com.library.gateway.jwt;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String pseudo;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String accessToken, String pseudo, Collection<? extends GrantedAuthority> authorities) {

        this.token = accessToken;
        this.pseudo = pseudo;
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}