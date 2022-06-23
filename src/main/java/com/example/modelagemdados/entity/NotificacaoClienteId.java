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
public class NotificacaoClienteId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "cod_idt_noti_segu", nullable = false, length = 16)
    private UUID codigoIdentificadorNoticacaoSeguro;

    @EqualsAndHashCode.Include
    @Column(name = "cod_idef_pess_clie", nullable = false, length = 16)
    private UUID codigoIdentificadorPessoaCliente;

}