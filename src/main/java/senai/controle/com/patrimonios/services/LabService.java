package senai.controle.com.patrimonios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.controle.com.patrimonios.models.Lab;
import senai.controle.com.patrimonios.repositories.LabRepository;

@Service
public class LabService {
    
    @Autowired
    public LabRepository labRepository;
    
     public Long count() {
        return labRepository.count();
    }
     public Lab salvar(Lab  carro){
        return labRepository.save(carro);
     }

     public boolean delete(Integer id){
      Lab lab = labRepository.findById(id).get();
      if(lab!= null){
         labRepository.deleteById(id);
         return true;
      }
      return false;
   }

      public boolean update(Lab Lab) {
      labRepository.save(Lab);
      return true;
   }
      public Lab atualizar(Lab Lab, Integer id) {
      Lab e = buscar(id);
      if (e != null) {
         Lab.setId(id);
         return labRepository.save(Lab);
      }
      return null;
   }
      public Lab buscar(Integer id){
      return labRepository.findById(id).get();
   }

   public List<Lab> Listar(){
      return labRepository.findAll();
   }


}
    

