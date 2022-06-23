package com.example.modelagemdados.entity;

import java.io.Serializable;
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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class MotorCanalModeloId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "cod_cana_dtbc", nullable = false)
    private Integer codigoIdentificadorCanal;

    @EqualsAndHashCode.Include
    @Column(name = "cod_idt_moto_noti_clie_segu", nullable = false, length = 16)
    private UUID codigoIdentificadorMotor;

    @EqualsAndHashCode.Include
    @Column(name = "cod_idt_mode_noti_clie_segu", nullable = false, length = 16)
    private UUID codigoIdentificadorModelo;

}