package org.beni.restapi.services;


import org.beni.restapi.dto.ProfDto;

import java.util.List;

public interface IProf {
    ProfDto createProf(ProfDto profDto);
    ProfDto getProfById(Long id);
    List<ProfDto> getAllProf();
    boolean deleteProfById(Long id);
    ProfDto updateProf(ProfDto profDto);

}
