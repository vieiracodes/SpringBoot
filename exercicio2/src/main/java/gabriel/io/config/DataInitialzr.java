package gabriel.io.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import gabriel.io.entity.Usuario;
import gabriel.io.repository.UsuarioRepository;

@Component
public class DataInitialzr implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		
		/*
		 * List<Usuario> : 
	 	 	Cria uma Lista da classe "Usuário"
		 
		 * usuarioRepository.findAll(): 
		    Busca todas as entidades do BD, adicionando-as a váriavel
		    "utilizadoresDoServiço"
		*/
		
		List<Usuario> utilizadoresDoServico = usuarioRepository.findAll();
		
		if(utilizadoresDoServico.isEmpty()) {
			
			//Cria um novo usuário
			Usuario pessoa = new Usuario();
			
			//Define os atributos desse usuário
			pessoa.setEmail("teste@gmail.com");
			pessoa.setName("Opa");
			
			//Salva a entidade no BD
			usuarioRepository.save(pessoa);
			
		}
		
		
	}
	
}
