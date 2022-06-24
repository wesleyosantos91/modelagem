package com.example.modelagemdados.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Entity(name = "Tbgq8013SoliNotiClieSegu")
@Table(name = "tbgq8013_soli_noti_clie_segu")
public class SolicitacaoNotificacaoClienteEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "cod_idt_soli_noti_clie_segu", nullable = false, length = 32, columnDefinition = "varchar(32)")
    private String codigoIdentificador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "cod_idt_noti_segu", referencedColumnName = "cod_idt_noti_segu", nullable = false, columnDefinition = "varchar(32)"),
            @JoinColumn(name = "cod_idef_pess_clie", referencedColumnName = "cod_idef_pess_clie", nullable = false, columnDefinition = "varchar(32)")
    })
    private NotificacaoClienteEntity notificacaoCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "cod_cana_dtbc", referencedColumnName = "cod_cana_dtbc"),
            @JoinColumn(name = "cod_idt_moto_noti_clie_segu", referencedColumnName = "cod_idt_moto_noti_clie_segu"),
            @JoinColumn(name = "cod_idt_mode_noti_clie_segu", referencedColumnName = "cod_idt_mode_noti_clie_segu")
    })
    private MotorCanalModeloEntity motorCanalModelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo_situ_soli_noti")
    private TipoSituacaoSolicitacaoEntity codTipoSituSoliNoti;

    @Column(name = "dat_hor_soli_noti_clie_segu", nullable = false)
    private LocalDateTime datHorSoliNotiClieSegu;

    @Column(name = "cod_idef_reto_envo_noti_clie", length = 32, columnDefinition = "varchar(32)")
    private UUID codIdefRetoEnvoNotiClie;

    @Column(name = "dat_hor_reto_envo_noti_clie")
    private LocalDateTime datHorRetoEnvoNotiClie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo_situ_reto_envo_noti", columnDefinition = "smallint")
    private TipoSituacaoRetornoEntity tipoSituacaoRetorno;

}