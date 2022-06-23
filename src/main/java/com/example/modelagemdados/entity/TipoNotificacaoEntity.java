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
@Entity(name = "tbgq8014_tipo_noti_clie_segu")
@Table(name = "tbgq8014_tipo_noti_clie_segu")
public class TipoNotificacaoEntity {

    @Id
    @Column(name = "cod_tipo_noti_clie_segu", nullable = false, columnDefinition = "smallint")
    private Integer codigoIdentificador;

    @Column(name = "nom_tipo_noti_clie_segu", nullable = false, length = 50)
    private String nomTipoNotiClieSegu;

    @OneToMany(mappedBy = "tipoNotificacao")
    private List<NotificacaoEntity> notificacoes = new ArrayList<>();

}