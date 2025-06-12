package project.software.domain.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.software.domain.shop.domain.type.ShopTag;
import project.software.domain.shop.domain.type.ShopType;
import project.software.infra.StringListConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "tbl_shop")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 단일 테이블 전략
@DiscriminatorColumn(name = "type") // 구분 컬럼 (GLASSES, LENS)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = true)
    private String brandName;

    @Column(columnDefinition = "VARCHAR(256)", nullable = true)
    private String glassesName;

    @Column(columnDefinition = "VARCHAR(200)", nullable = true)
    private String descriptionImage;

    @Column(nullable = true)
    private Long price;

    @Convert(converter = StringListConverter.class)
    private List<String> imageUrls = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private ShopType shopType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private ShopTag shopTag;

    private String groupId;
}
