package com.asset.management.model;

public class User {
	 private Integer id;
	 private String username;
	 private String firstname;
	 private String lastname;
	 
	 public User() {
	  super();
	 }
	 
	 public User(Integer id, String username, String firstname, String lastname) {
	  super();
	  this.id = id;
	  this.username = username;
	  this.firstname = firstname;
	  this.lastname = lastname;
	 }

	 public Integer getId() {
	  return id;
	 }
	 public void setId(Integer id) {
	  this.id = id;
	 }
	 public String getUsername() {
	  return username;
	 }
	 public void setUsername(String username) {
	  this.username = username;
	 }
	 public String getFirstname() {
	  return firstname;
	 }
	 public void setFirstname(String firstname) {
	  this.firstname = firstname;
	 }
	 public String getLastname() {
	  return lastname;
	 }
	 public void setLastname(String lastname) {
	  this.lastname = lastname;
	 }
	}
