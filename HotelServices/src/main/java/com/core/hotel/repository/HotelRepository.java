package com.core.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.core.hotel.entity.Hotel;
import java.util.List;
import java.util.Optional;


public interface HotelRepository extends JpaRepository<Hotel, String> {
	
	
	Optional<List<Hotel>> findByName(String name);

}
