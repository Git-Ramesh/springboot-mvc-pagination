package com.rs.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee", schema = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee implements Serializable {
	private static final long serialVersionUID = 6478199952215422891L;

	
	public Employee(int empno, String name, String email) {
		super();
		this.empno = empno;
		this.name = name;
		this.email = email;
	}
	
	@Id
	@SequenceGenerator(name = "EMPLOYEE_ID_GEN", sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1, initialValue = 1, schema = "employee")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EMPLOYEE_ID_GEN")
	@Column(name = "id")
	private int id;
	@NaturalId
	@Column(name = "empno", unique = true, nullable = false)
	private int empno;
	@Column(name = "name")
	@Type(type = "string")
	private String name;
	@NaturalId
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	
}
