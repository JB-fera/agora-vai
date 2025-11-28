package senai.controle.com.patrimonios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import senai.controle.com.patrimonios.models.Patrimonio;

import senai.controle.com.patrimonios.services.PatrimonioService;

@RestController
@RequestMapping("/Patrimonio")
public class PatrimonioController {
    
    @Autowired
    public PatrimonioService patrimonioService;

  @GetMapping("/count")
    public Long count(){
        return patrimonioService.count();
    }
    @PostMapping("/salvar")
    public Patrimonio salvar(@RequestBody Patrimonio patrimonio){
        return patrimonioService.salvar(patrimonio);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
    boolean deletou = patrimonioService.delete(id);
        if (deletou){
            return "user removido";
        }
        return " falha ao remover";
    }

   @PutMapping("/atualizar/{id}")
    public Patrimonio atualizar(@PathVariable Integer id, @RequestBody Patrimonio Patrimonio){
        return patrimonioService.atualizar(Patrimonio, id);
    }

    @GetMapping("/search/{id}")
    public Patrimonio buscar(@PathVariable Integer id){
        return patrimonioService.buscar(id);
    }
    @GetMapping("/listar")
    public List<Patrimonio> Listar(){
        return patrimonioService.Listar();

}


}