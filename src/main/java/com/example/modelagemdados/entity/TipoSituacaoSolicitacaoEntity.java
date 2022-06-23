package com.example.modelagemdados.entity;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
@Entity(name = "tbgq8016_tipo_situ_soli_noti")
@Table(name = "tbgq8016_tipo_situ_soli_noti")
public class TipoSituacaoSolicitacaoEntity {

    @Id
    @Column(name = "cod_tipo_situ_soli_noti", nullable = false, columnDefinition = "smallint")
    private Integer codigoIdentificador;

    @Column(name = "nom_tipo_situ_soli_noti", nullable = false, length = 50)
    private String nome;

    @OneToMany(mappedBy = "tipoSituacaoSolicitacao")
    private List<NotificacaoEntity> notificacacoes = new ArrayList<>();

    @OneToMany(mappedBy = "codTipoSituSoliNoti")
    private List<SolicitacaoNotificacaoClienteEntity> solicitacaoNotificacaoClientes = new ArrayList<>();

}