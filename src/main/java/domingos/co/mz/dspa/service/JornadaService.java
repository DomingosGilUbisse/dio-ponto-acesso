package domingos.co.mz.dspa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domingos.co.mz.dspa.mapper.JornadaTrabalhoMapper;
import domingos.co.mz.dspa.model.JornadaTrabalho;
import domingos.co.mz.dspa.model.dto.JornadaTrabalhoDTO;
import domingos.co.mz.dspa.repository.JornadaRepository;

@Service
public class JornadaService {

	@Autowired
	private JornadaRepository jornadaRepository;

	@Autowired
	private JornadaTrabalhoMapper mapper;

	public JornadaTrabalhoDTO saveJornada(JornadaTrabalhoDTO dto) {
		return mapper.toDTO(jornadaRepository.save(mapper.toEntity(dto)));
	}

	public List<JornadaTrabalhoDTO> findAll() {
		List<JornadaTrabalho> jornadaTrabalhos = jornadaRepository.findAll();
		return mapper.toListDTO(jornadaTrabalhos);
	}

	public Optional<JornadaTrabalho> getById(Long idJornada) {
		return jornadaRepository.findById(idJornada);
	}

	public JornadaTrabalhoDTO updateJornada(JornadaTrabalhoDTO dto) {
		return mapper.toDTO(jornadaRepository.save(mapper.toEntity(dto)));
	}

	public void deleteJornada(Long idJornada) {
		jornadaRepository.deleteById(idJornada);
	}
}
