package sas.finalexampo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;
    private String code;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeEntity typeEntity;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "items_orders",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "orderli_id"))    @Builder.Default
    private List<OrderLineEntity> orders = new ArrayList<>();
}