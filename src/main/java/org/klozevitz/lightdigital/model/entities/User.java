package org.klozevitz.lightdigital.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.klozevitz.lightdigital.model.BaseEntity;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user_t")
public class User extends BaseEntity {
    @Column
    private String username;
    @Column
    private String password;
    @CreatedDate
    @Column(name = "created")
    private Date created;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_t",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
    @OneToMany(mappedBy = "user")
    private List<Claim> claims;

    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", roles=" + roles +
                ", claims=" + claims +
                '}';
    }
}
