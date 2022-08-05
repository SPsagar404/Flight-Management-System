package com.axyya.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Passenger {
	
	@Id
	@GeneratedValue(generator = "passenger-id-gen")
    @GenericGenerator(name = "passenger-id-gen", 
      parameters = @Parameter(name = "prefix", value = "PS"), 
      strategy = "com.axyya.util.StringSequenceIdGenerator")
	private String id;
	
	@Column
	private String firstName;
	private String lastName;
	
	private String email;
	
	@OneToMany(mappedBy = "passenger" , cascade = CascadeType.ALL)
	private List<Booking> bookings;


}
