package br.com.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.autor.AutorRepository;
import br.com.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid LivroRequest form) {
		Livro livro = form.converter(livroRepository, autorRepository, categoriaRepository);
		livroRepository.save(livro);
	}

	@GetMapping
	public List<LivroResponse> listar () {
		List<Livro> livros = livroRepository.findAll();
		return LivroResponse.converter(livros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroResponse> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new LivroResponse(livro.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
