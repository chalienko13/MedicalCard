package com.chalienko.medcard.domain.model;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


import javax.persistence.*;

@Entity
@Table(name = "users")
@Transactional
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "second_name")
	private String secondName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role")
	private Role role;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_department")
	private Department department;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Examination> examinations;


	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "doctor")
	private List<Patient> patients;

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public User() {

	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User(String userName, String password, String firstName, String lastName, String secondName, Role role,
				List<Examination> examinations) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.secondName = secondName;
		this.role = role;
		this.examinations = examinations;
	}

	public User(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.secondName = user.getSecondName();
		this.role = user.getRole();
		this.examinations = user.getExaminations();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}
}