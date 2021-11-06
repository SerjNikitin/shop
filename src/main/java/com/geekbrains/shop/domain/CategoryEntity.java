package com.geekbrains.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
@EqualsAndHashCode(exclude = {"id","products","subCategories","parentCategory"})
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Имя категории обязательно")
    private String name;

//    @NotBlank(message = "Алиас категории обязателен")
    private String alias;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryEntity parentCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "parentCategory")
    private Set<CategoryEntity> subCategories;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> products = new HashSet<>();

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}