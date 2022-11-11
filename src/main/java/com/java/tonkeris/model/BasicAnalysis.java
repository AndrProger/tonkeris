package com.java.tonkeris.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class BasicAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Double humidity;
    private Double natura;
    private String vitreous;
    private Integer classGrain;
    private String type;

    @Override
    public String toString() {
        return "BasicAnalysis{" +
                "id=" + id +
                ", humidity=" + humidity +
                ", natura=" + natura +
                ", vitreous='" + vitreous + '\'' +
                ", classGrain=" + classGrain +
                ", type='" + type + '\'' +
                '}';
    }


}
