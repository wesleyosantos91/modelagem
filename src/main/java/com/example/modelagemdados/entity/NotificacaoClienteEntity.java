package com.example.modelagemdados.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
@Entity(name = "tbgq8010_noti_clie_segu")
@Table(name = "tbgq8010_noti_clie_segu")
public class NotificacaoClienteEntity {

    @EmbeddedId
    private NotificacaoClienteId codigoIdentificador;

    @MapsId("codigoIdentificadorNoticacaoSeguro")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_idt_noti_segu", nullable = false)
    private NotificacaoEntity notificacao;

    @OneToMany(mappedBy = "notificacaoCliente")
    private List<SolicitacaoNotificacaoClienteEntity> notificacaoCliente = new ArrayList<>();

}