package com.juniormiqueletti.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Securities {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Description is required.")
	@Size(max = 60, message = "The description cannot contains more than 60 characters.")
	private String description;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Due Date is required.")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@NotNull(message = "Value is required.")
	@DecimalMin(value = "0.01", message = "The value cannot be lower than 0,01.")
	@DecimalMax(value = "9999999999.99", message = "The value cannot be greater than 9.999.999.999,99.")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal value;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date duDate) {
		this.dueDate = duDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Securities other = (Securities) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	public boolean isPending(){
		return this.status.equals(Status.PENDING);
	}

}
