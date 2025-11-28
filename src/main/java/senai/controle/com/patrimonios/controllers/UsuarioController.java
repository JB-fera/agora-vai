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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import senai.controle.com.patrimonios.models.Usuario;

import senai.controle.com.patrimonios.services.UsuarioService;


@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;

  @GetMapping("/count")
    public Long count(){
        return usuarioService.count();
    }
    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
    boolean deletou = usuarioService.delete(id);
        if (deletou){
            return "user removido";
        }
        return " falha ao remover";
    }

   @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario Usuario){
        return usuarioService.atualizar(Usuario, id);
    }

    @GetMapping("/search/{id}")
    public Usuario buscar(@PathVariable Integer id){
        return usuarioService.buscar(id);
    }
    @GetMapping("/listar")
    public List<Usuario> Listar(){
        return usuarioService.Listar();

}

    @PostMapping
    public Usuario login(@RequestParam String nome, @RequestParam String senha){
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setSenha(senha);
        return usuarioService.login(u);
    }


}
