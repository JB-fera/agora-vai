package senai.controle.com.patrimonios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.controle.com.patrimonios.models.Usuario;

import senai.controle.com.patrimonios.repositories.UsuarioRepository;

@Service
public class UsuarioService {

        @Autowired
    public UsuarioRepository usuarioRepository;

     public Usuario login(Usuario usuario){
        Usuario u = usuarioRepository.findByNome("nome");
        if(u != null && u.getSenha().equals(usuario.getSenha())){
            return u;
        }
        return null;
    }

        public Long count() {
        return usuarioRepository.count();
    }
     public Usuario salvar(Usuario  carro){
        return usuarioRepository.save(carro);
     }

     public boolean delete(Integer id){
      Usuario usuario = usuarioRepository.findById(id).get();
      if(usuario!= null){
         usuarioRepository.deleteById(id);
         return true;
      }
      return false;
   }

      public boolean update(Usuario Usuario) {
      usuarioRepository.save(Usuario);
      return true;
   }
      public Usuario atualizar(Usuario Usuario, Integer id) {
      Usuario e = buscar(id);
      if (e != null) {
         Usuario.setId(id);
         return usuarioRepository.save(Usuario);
      }
      return null;
   }
      public Usuario buscar(Integer id){
      return usuarioRepository.findById(id).get();
   }

   public List<Usuario> Listar(){
      return usuarioRepository.findAll();
   }
    
}
