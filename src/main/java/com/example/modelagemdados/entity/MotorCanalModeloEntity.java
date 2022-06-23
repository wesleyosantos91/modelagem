package com.example.modelagemdados.entity;

import com.example.modelagemdados.enums.TipoSituacaoMotorCanalModeloModeloEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
@Entity(name = "tbgq8008_moto_cana_mode_noti")
@Table(name = "tbgq8008_moto_cana_mode_noti")
public class MotorCanalModeloEntity {

    @EmbeddedId
    private MotorCanalModeloId codigoIdentificador;

    @MapsId("codigoIdentificadorMotor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_idt_moto_noti_clie_segu", nullable = false)
    private MotorEntity motor;

    @MapsId("codigoIdentificadorModelo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_idt_mode_noti_clie_segu", nullable = false)
    private ModeloEntity modelo;

    @Column(name = "dat_hor_cria_rgto", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "dat_hor_alte_rgto")
    private LocalDateTime dataAtualizacao;

    @Convert(converter = TipoSituacaoMotorCanalModeloModeloEntity.Mapeador.class)
    @Column(name = "ind_moto_cana_mode_noti_ativ", nullable = false, columnDefinition = "char(1)")
    private TipoSituacaoMotorCanalModeloModeloEntity situacao;

    @OneToMany(mappedBy = "motorCanalModelo")
    private List<SolicitacaoNotificacaoClienteEntity> solicitacaoNotificacaoClientes = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        this.dataInclusao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

}