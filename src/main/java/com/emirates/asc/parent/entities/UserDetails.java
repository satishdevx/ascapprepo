//package com.emirates.asc.parent.entities;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//@NamedQuery(name = "User.findByEmail", query = "FROM UserDetails WHERE email = ?1 and password = ?2")
//@Entity
//@Table(name = "t_user_login")
////@NamedNativeQuery(name = "Author.findByEmail", query = "SELECT * FROM author WHERE user_email = ?", resultClass = UserDetails.class)
//public class UserDetails implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="user_id")
//    private Long userId ;
//	
//	@Column(name="user_email")
//    private String email;
//	
//	@Column(name="user_password")
//    private String password;
//
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//	
//}
