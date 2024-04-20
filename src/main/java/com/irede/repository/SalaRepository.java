package com.irede.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irede.entity.Sala;

@Repository
public interface SalaRepository  extends JpaRepository<Sala, Long> {

	

}
