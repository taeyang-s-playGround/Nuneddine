package project.software.domain.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.software.domain.shop.domain.type.Type;
import project.software.domain.shop.domain.type.GlassesType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity(name = "tbl_shop")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = true)
    private String brandName;

    @Column(columnDefinition = "VARCHAR(256)", nullable = true)
    private String glassesName;

    @Column(columnDefinition = "VARCHAR(100)", nullable = true)
    private String description;

    @Column(nullable = true)
    private Long price;

    @Column(nullable = true)
    private Type type;

    @Column(nullable = true)
    private GlassesType glassesType;

}
