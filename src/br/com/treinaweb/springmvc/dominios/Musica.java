package br.com.treinaweb.springmvc.dominios;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="mus_musicas")
public class Musica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mus_id")
	private Long id;

	@Column(name="mus_nome",nullable = false, length = 10)
	@Size(min = 3, max = 10 , message = "O nome da musica deve conter entre 3 e 10 caracteres.")
	@NotEmpty(message = "O nome � obrigatorio")
	@Null(message = "O nome � obrigatorio")
	private String Nome;

	@Column(name="mus_data_criacao",nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Null(message = "A data de cria��o � obrigat�ria")
	private Date dataCriacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "alb_id")
	private Album album;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	

	

}
