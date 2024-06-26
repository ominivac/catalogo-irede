package com.irede.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irede.entity.Filme;


@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
