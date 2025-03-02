package org.beni.restapi.repository;


import org.beni.restapi.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository  extends JpaRepository<Cours, Long> {
}
