package com.example.modelagemdados.entity;

import com.example.modelagemdados.enums.TipoSituacaoModeloEntity;
import com.example.modelagemdados.enums.TipoSituacaoMotorEntity;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
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
@Entity(name = "tbgq8009_moto_noti_clie_segu")
@Table(name = "tbgq8009_moto_noti_clie_segu")
public class MotorEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "cod_idt_moto_noti_clie_segu", nullable = false, length = 16, columnDefinition = "binary(16)")
    private UUID codigoIdentificador;

    @Column(name = "nom_moto_noti_clie_segu", nullable = false, length = 100)
    private String nome;

    @Column(name = "sig3stm", length = 3, columnDefinition = "CHAR(3)")
    private String siglaSistema;

    @Column(name = "dat_hor_cria_rgto", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name = "dat_hor_alte_rgto")
    private LocalDateTime dataAtualizacao;

    @Convert(converter = TipoSituacaoMotorEntity.Mapeador.class)
    @Column(name = "ind_moto_noti_clie_segu_ativ", nullable = false, columnDefinition = "char(1)")
    private TipoSituacaoMotorEntity situacao;

    @OneToMany(mappedBy = "motor")
    private List<MotorCanalModeloEntity> modelos = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        this.dataInclusao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

}