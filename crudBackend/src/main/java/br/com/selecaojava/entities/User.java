package br.com.selecaojava.entities;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
public class User {
	@Id
	@GeneratedValue
    private Long id;

	@NotNull
    private String nome;

	@CPF
	@Column(unique = true)
	private String cpf;

	@Email
	private String email;

	private String sexo;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datanascimento;

	private String naturalidade;

	private String nacionalidade;

	@Embedded
	@NotNull
	private Endereco endereco;

	public User() {
	}

	public User(@NotNull String nome, @CPF String cpf, @Email String email, String sexo, @NotNull Date datanascimento, String naturalidade, String nacionalidade, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.sexo = sexo;
		this.datanascimento = datanascimento;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				", email='" + email + '\'' +
				", sexo='" + sexo + '\'' +
				", datanascimento=" + datanascimento +
				", naturalidade='" + naturalidade + '\'' +
				", nacionalidade='" + nacionalidade + '\'' +
				", endereco=" + endereco +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
