package com.product.ProductMonolithic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user_details")
public class AuthUser {
    @Id
    @Column(name="auth_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authId;
    @Column(name="auth_name")
    private String authName;
    @Column(name="auth_password")
    private String authPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "credential_role",joinColumns = @JoinColumn(name="auth_id"),inverseJoinColumns = @JoinColumn(name="roles_id"))
    List<Roles> allRoles;

    public long getAuthId() {
        return authId;
    }

    public void setAuthId(long authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
    }

    public List<Roles> getAllRoles() {
        return allRoles;
    }

    public void setAllRoles(List<Roles> allRoles) {
        this.allRoles = allRoles;
    }
}
