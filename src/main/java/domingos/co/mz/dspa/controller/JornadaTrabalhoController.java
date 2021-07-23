package domingos.co.mz.dspa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domingos.co.mz.dspa.model.JornadaTrabalho;
import domingos.co.mz.dspa.model.dto.JornadaTrabalhoDTO;
import domingos.co.mz.dspa.service.JornadaService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
	@Autowired
	JornadaService jornadaService;

	@PostMapping
	public JornadaTrabalhoDTO createJornada(@RequestBody JornadaTrabalhoDTO dto) {
		return jornadaService.saveJornada(dto);
	}

	@GetMapping
	public List<JornadaTrabalhoDTO> getJornadaList() {
		return jornadaService.findAll();

	}

	@GetMapping("/{idJornada}")
	public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
		return ResponseEntity
				.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));

	}

	@PutMapping
	public JornadaTrabalhoDTO updateJornada(@RequestBody JornadaTrabalhoDTO dto) {
		return jornadaService.updateJornada(dto);
	}

	@DeleteMapping("/{idJornada}")
	public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
		try {
			jornadaService.deleteJornada(idJornada);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

	}

}
