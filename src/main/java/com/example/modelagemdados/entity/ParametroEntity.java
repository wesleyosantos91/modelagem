package com.example.modelagemdados.entity;

import com.example.modelagemdados.enums.TipoSituacaoParametroEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
@Entity(name = "tbgq8012_parm_noti_clie_segu")
@Table(name = "tbgq8012_parm_noti_clie_segu")
public class ParametroEntity {

    @EmbeddedId
    private ParametroEntityId id;

    @MapsId("codigoIdentificadorModelo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_idt_mode_noti_clie_segu", nullable = false)
    private ModeloEntity modelo;

    @Column(name = "des_parm_noti_clie_segu", nullable = false, length = 100)
    private String descricao;

    @Column(name = "dat_hor_cria_rgto", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "dat_hor_alte_rgto")
    private LocalDateTime dataAtualizacao;

    @Convert(converter = TipoSituacaoParametroEntity.Mapeador.class)
    @Column(name = "ind_parm_noti_clie_segu_ativ", nullable = false, columnDefinition = "char(1)")
    private TipoSituacaoParametroEntity situacao;

    @PrePersist
    public void onCreate() {
        this.dataInclusao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

}