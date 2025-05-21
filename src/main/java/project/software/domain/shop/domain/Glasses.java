package project.software.domain.shop.domain;

import lombok.Getter;
import project.software.domain.shop.domain.type.glasses.FrameMaterial;
import project.software.domain.shop.domain.type.glasses.FrameShape;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@DiscriminatorValue("GLASSES")
public class Glasses extends Shop {

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private FrameShape frameShape;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private FrameMaterial frameMaterial;

}
