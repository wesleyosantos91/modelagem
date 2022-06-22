package com.example.modelagemdados.entity;

import com.example.modelagemdados.enums.TipoSituacaoModeloEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbgq8007_mode_noti_clie_segu")
public class ModeloEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "cod_idt_mode_noti_clie_segu", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID codigoIdentificador;

    @NotEmpty
    @Length(min = 3, max = 100)
    @Column(name = "nom_mode_noti_clie_segu ", length = 100, nullable = false)
    private String nome;

    @NotEmpty
    @Length(min = 3, max = 100)
    @Column(name = "des_mode_noti_clie_segu ", length = 100, nullable = false)
    private String descricao;

    @Convert(converter = TipoSituacaoModeloEntity.Mapeador.class)
    @Column(name = "ind_mode_noti_clie_segu_ativ", nullable = false, columnDefinition = "CHAR(1)")
    private TipoSituacaoModeloEntity situacao;

    @JsonManagedReference
    @OneToMany(mappedBy = "modelo", cascade = CascadeType.PERSIST)
    private List<ParametroEntity> parametros = new ArrayList<>();


    @OneToMany(mappedBy = "motor", cascade = CascadeType.PERSIST)
    private List<MotorCanalModeloEntity> motores = new ArrayList<>();

    @Column(name = "dat_hor_cria_rgto", nullable = false)
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