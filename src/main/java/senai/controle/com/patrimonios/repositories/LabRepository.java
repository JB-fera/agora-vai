package senai.controle.com.patrimonios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senai.controle.com.patrimonios.models.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Integer>{
    
}