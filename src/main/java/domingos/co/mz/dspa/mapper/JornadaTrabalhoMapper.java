package domingos.co.mz.dspa.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import domingos.co.mz.dspa.model.JornadaTrabalho;
import domingos.co.mz.dspa.model.dto.JornadaTrabalhoDTO;

@Component
public class JornadaTrabalhoMapper {

	public JornadaTrabalho toEntity(JornadaTrabalhoDTO dto) {
		JornadaTrabalho jornadaTrabalho = new JornadaTrabalho();
		jornadaTrabalho.setDescricao(dto.getDescricao());
		jornadaTrabalho.setId(dto.getId());

		return jornadaTrabalho;
	}

	public JornadaTrabalhoDTO toDTO(JornadaTrabalho jornadaTrabalho) {
		JornadaTrabalhoDTO dto = new JornadaTrabalhoDTO();
		dto.setDescricao(jornadaTrabalho.getDescricao());
		dto.setId(jornadaTrabalho.getId());

		return dto;
	}

	public List<JornadaTrabalhoDTO> toListDTO(List<JornadaTrabalho> jornadaTrabalhos) {
		List<JornadaTrabalhoDTO> listaDTO = new ArrayList<>();
		for (JornadaTrabalho jornadaTrabalho : jornadaTrabalhos) {
			listaDTO.add(toDTO(jornadaTrabalho));
		}
		return listaDTO;
	}
}
