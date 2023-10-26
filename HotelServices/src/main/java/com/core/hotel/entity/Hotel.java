package com.core.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name ="hotel_service")
public class Hotel {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;

}
