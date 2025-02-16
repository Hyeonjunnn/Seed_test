package com.seed.test.domain.product.entity;

import com.seed.test.domain.cmms.entity.BaseEntity;
import com.seed.test.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no")
    private Long product_no;

    private String name;

    private Long price;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;
}
