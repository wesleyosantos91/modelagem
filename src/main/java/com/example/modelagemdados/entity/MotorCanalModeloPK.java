package com.example.modelagemdados.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MotorCanalModeloPK implements Serializable {

//    @NotNull
//    @Column(name = "cod_idt_moto_noti_clie_segu", nullable = false, insertable = false, updatable = false)
    private MotorEntity motor;

//    @NotNull
//    @Column(name = "cod_idt_mode_noti_clie_segu", nullable = false, insertable = false, updatable = false)
    private ModeloEntity modelo;

//    @NotNull
//    @Column(name = "cod_cana_dtbc", nullable = false, insertable = false, updatable = false)
    private Integer codigoIdentificadorCanal;
}
