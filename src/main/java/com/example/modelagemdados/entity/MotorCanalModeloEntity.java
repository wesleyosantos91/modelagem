package com.example.modelagemdados.entity;

import com.example.modelagemdados.enums.TipoSituacaoModeloEntity;
import com.example.modelagemdados.enums.TipoSituacaoMotorCanalModeloModeloEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
@Entity(name = "tbgq8008_moto_cana_mode_noti")
@IdClass(MotorCanalModeloPK.class)
public class MotorCanalModeloEntity {

//    @EmbeddedId
//    private MotorCanalModeloPK motorCanalModeloPK;

    @Id
    @NotNull
    @Column(name = "cod_cana_dtbc", nullable = false, insertable = false, updatable = false)
    private Integer codigoIdentificadorCanal;

    @Convert(converter = TipoSituacaoMotorCanalModeloModeloEntity.Mapeador.class)
    @Column(name = "ind_moto_cana_mode_noti_ativ", nullable = false, columnDefinition = "CHAR(1)")
    private TipoSituacaoMotorCanalModeloModeloEntity situacao;

    @Column(name = "dat_hor_cria_rgto", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "dat_hor_alte_rgto")
    private LocalDateTime dataAtualizacao;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_idt_moto_noti_clie_segu", referencedColumnName = "cod_idt_moto_noti_clie_segu")
    private MotorEntity motor;


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_idt_mode_noti_clie_segu", referencedColumnName = "cod_idt_mode_noti_clie_segu")
    private ModeloEntity modelo;

    @PrePersist
    public void onCreate() {
        this.dataInclusao = LocalDateTime.now();
        this.situacao = TipoSituacaoMotorCanalModeloModeloEntity.ATIVO;
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
