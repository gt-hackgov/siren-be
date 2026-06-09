package com.siren.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_alertas")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Insira o evento_id")
    private Long evento_id;

    @NotBlank(message = "Insira o canal")
    private String canal;

    @NotBlank(message = "Insira a mensagem")
    private String mensagem;

    @NotEmpty(message = "Insira a lista de destinatários")
    private List<String> destinatarios;

    @NotBlank(message = "Insira o status_envio")
    private String status_envio;

    @NotBlank(message = "Insira a data_envio")
    private LocalDateTime data_envio;

    @NotBlank(message = "Insira o nivel_urgencia")
    private Integer nivel_urgencia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Long evento_id) {
        this.evento_id = evento_id;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<String> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getStatus_envio() {
        return status_envio;
    }

    public void setStatus_envio(String status_envio) {
        this.status_envio = status_envio;
    }

    public LocalDateTime getData_envio() {
        return data_envio;
    }

    public void setData_envio(LocalDateTime data_envio) {
        this.data_envio = data_envio;
    }

    public Integer getNivel_urgencia() {
        return nivel_urgencia;
    }

    public void setNivel_urgencia(Integer nivel_urgencia) {
        this.nivel_urgencia = nivel_urgencia;
    }
}
