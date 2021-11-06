package com.geekbrains.shop.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id","category"})
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Имя продукта обязательно")
    private String title;

//    @NotNull(message = "Цена продукта обязательна")
    private Double price;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "productId")
    private Set<ProductReviewEntity> productReview;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }

}
