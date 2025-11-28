package senai.controle.com.patrimonios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.controle.com.patrimonios.models.Patrimonio;
import senai.controle.com.patrimonios.repositories.PatrimonioRepository;

@Service
public class PatrimonioService {
    
    @Autowired
    public PatrimonioRepository patrimonioRepository;
    
     public Long count() {
        return patrimonioRepository.count();
    }
     public Patrimonio salvar(Patrimonio  carro){
        return patrimonioRepository.save(carro);
     }

     public boolean delete(Integer id){
      Patrimonio patrimonio = patrimonioRepository.findById(id).get();
      if(patrimonio!= null){
         patrimonioRepository.deleteById(id);
         return true;
      }
      return false;
   }

      public boolean update(Patrimonio Patrimonio) {
      patrimonioRepository.save(Patrimonio);
      return true;
   }
      public Patrimonio atualizar(Patrimonio Patrimonio, Integer id) {
      Patrimonio e = buscar(id);
      if (e != null) {
         Patrimonio.setId(id);
         return patrimonioRepository.save(Patrimonio);
      }
      return null;
   }
      public Patrimonio buscar(Integer id){
      return patrimonioRepository.findById(id).get();
   }

   public List<Patrimonio> Listar(){
      return patrimonioRepository.findAll();
   }
}
