package com.example.modelagemdados.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "tbgq8011_noti_segu")
@Table(name = "tbgq8011_noti_segu")
public class NotificacaoEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "cod_idt_noti_segu", nullable = false, length = 32, columnDefinition = "varchar(32)")
    private String codigoIdentificador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo_noti_clie_segu", columnDefinition = "smallint")
    private TipoNotificacaoEntity tipoNotificacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo_situ_soli_noti", columnDefinition = "smallint")
    private TipoSituacaoSolicitacaoEntity tipoSituacaoSolicitacao;

    @OneToMany(mappedBy = "notificacao")
    private List<NotificacaoClienteEntity> notificacaoClientes = new ArrayList<>();

}