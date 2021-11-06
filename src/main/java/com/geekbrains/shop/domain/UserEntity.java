package com.geekbrains.shop.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
@ToString(exclude = "roles")
@EqualsAndHashCode(exclude = {"id", "roles"})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Имя обязательно")
//    @Size(min = 1,max = 30)
    private String username;

//    @Size(min = 6,max = 80)
//    @NotBlank(message = "Пароль обязательно")
    private String password;

//    @NotBlank(message = "email обязательно")
    private String email;

    private boolean enabled = true;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<RoleEntity> roles;
}