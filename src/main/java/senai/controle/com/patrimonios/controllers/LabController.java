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

import senai.controle.com.patrimonios.models.Lab;
import senai.controle.com.patrimonios.services.LabService;

@RestController
@RequestMapping("/Lab")
public class LabController {
    
    @Autowired
    public LabService labService;

  @GetMapping("/count")
    public Long count(){
        return labService.count();
    }
    @PostMapping("/salvar")
    public Lab salvar(@RequestBody Lab lab){
        return labService.salvar(lab);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
    boolean deletou = labService.delete(id);
        if (deletou){
            return "user removido";
        }
        return " falha ao remover";
    }

   @PutMapping("/atualizar/{id}")
    public Lab atualizar(@PathVariable Integer id, @RequestBody Lab Lab){
        return labService.atualizar(Lab, id);
    }

    @GetMapping("/search/{id}")
    public Lab buscar(@PathVariable Integer id){
        return labService.buscar(id);
    }
    @GetMapping("/listar")
    public List<Lab> Listar(){
        return labService.Listar();

}

}