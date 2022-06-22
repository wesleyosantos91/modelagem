package com.example.modelagemdados.entity;

import com.example.modelagemdados.enums.TipoSituacaoParametroEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.UUID;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbgq8012_parm_noti_clie_segu")
@IdClass(ParametroPK.class)
public class ParametroEntity {

    @Id
    @NotNull
    @Length(min = 3, max = 100)
    @Column(name = "nom_parm_noti_clie_segu", insertable = false, updatable = false)
    private String nomeParametro;

    @NotEmpty
    @Length(min = 3, max = 100)
    @Column(name = "des_parm_noti_clie_segu", length = 100, nullable = false)
    private String descricao;

    @Convert(converter = TipoSituacaoParametroEntity.Mapeador.class)
    @Column(name = "ind_parm_noti_clie_segu_ativ ", nullable = false, length = 1, columnDefinition = "CHAR(1)")
    private TipoSituacaoParametroEntity situacao;

    @JsonBackReference
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_idt_mode_noti_clie_segu", referencedColumnName = "cod_idt_mode_noti_clie_segu")
    private ModeloEntity modelo;

    @Column(name = "dat_hor_cria_rgto", updatable = false, nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "dat_hor_alte_rgto")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void onCreate() {
        this.dataInclusao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}