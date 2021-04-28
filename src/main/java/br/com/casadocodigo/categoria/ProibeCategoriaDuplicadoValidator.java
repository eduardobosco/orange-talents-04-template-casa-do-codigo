package br.com.casadocodigo.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeCategoriaDuplicadoValidator implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaRequest request = (CategoriaRequest) target;
		
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());
		
		if (possivelCategoria.isPresent()) {
			errors.rejectValue("nome", "Esta categoria " + request.getNome()+ "  ja esta cadastrada");
			
		}
	}

}
