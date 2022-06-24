package com.example.modelagemdados.entity;

import com.example.modelagemdados.enums.TipoSituacaoModeloEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
import org.hibernate.annotations.GenericGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "tbgq8007_mode_noti_clie_segu")
@Table(name = "tbgq8007_mode_noti_clie_segu")
public class ModeloEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2")
    @Column(name = "cod_idt_mode_noti_clie_segu", nullable = false, length = 32, columnDefinition = "varchar(32)")
    private String codigoIdentificadorModelo;

    @Column(name = "nom_mode_noti_clie_segu", nullable = false, length = 100)
    private String nome;

    @Column(name = "des_mode_noti_clie_segu", length = 100)
    private String descricao;

    @Column(name = "dat_hor_cria_rgto", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "dat_hor_alte_rgto")
    private LocalDateTime dataAtualizacao;

    @Convert(converter = TipoSituacaoModeloEntity.Mapeador.class)
    @Column(name = "ind_mode_noti_clie_segu_ativ", nullable = false, columnDefinition = "char(1)")
    private TipoSituacaoModeloEntity situacao;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.PERSIST)
    private List<ParametroEntity> parametros = new ArrayList<>();

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.PERSIST)
    private List<MotorCanalModeloEntity> motores = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        this.dataInclusao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

}