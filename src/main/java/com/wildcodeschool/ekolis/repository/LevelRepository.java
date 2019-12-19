package com.wildcodeschool.ekolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.ekolis.entities.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer>{

}
