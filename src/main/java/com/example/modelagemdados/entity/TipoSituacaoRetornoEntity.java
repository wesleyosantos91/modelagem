package com.example.modelagemdados.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Entity(name = "Tbgq8015TipoSituRetoNoti")
@Table(name = "tbgq8015_tipo_situ_reto_noti")
public class TipoSituacaoRetornoEntity {

    @Id
    @Column(name = "cod_tipo_situ_reto_envo_noti", nullable = false, columnDefinition = "smallint")
    private Integer codigoIdentificador;

    @Column(name = "des_tipo_situ_reto_envo_noti", nullable = false, length = 100)
    private String desTipoSituRetoEnvoNoti;

    @OneToMany(mappedBy = "tipoSituacaoRetorno")
    private List<SolicitacaoNotificacaoClienteEntity> solicitacaoNotificacaoClientes = new ArrayList<>();

}