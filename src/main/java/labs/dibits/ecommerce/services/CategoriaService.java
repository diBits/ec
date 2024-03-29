package labs.dibits.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labs.dibits.ecommerce.domain.Categoria;
import labs.dibits.ecommerce.repositories.CategoriaRepository;
import labs.dibits.ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		Categoria obj = repo.findById(id).orElse(null);
		if (obj == null) {
			
			throw new ObjectNotFoundException("Objeto inexistente! Id: "+id+
				", Pacote: "+ Categoria.class.getName());
		}
		return obj;
	}
	
}
