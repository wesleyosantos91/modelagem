package com.example.modelagemdados.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class ParametroEntityId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "cod_idt_mode_noti_clie_segu", nullable = false, length = 16)
    private UUID codigoIdentificadorModelo;

    @EqualsAndHashCode.Include
    @Column(name = "nom_parm_noti_clie_segu", nullable = false, length = 50)
    private String nomeParamtro;

}