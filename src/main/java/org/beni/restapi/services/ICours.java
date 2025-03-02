package org.beni.restapi.services;

import org.beni.restapi.dto.CoursDto;

import java.util.List;

public interface ICours {
    CoursDto createCours(CoursDto coursDto);
    CoursDto getCoursById(long idCours);
    List<CoursDto> getAllCOurs();
    boolean deleteCours(long idCours);
    CoursDto updateCours(CoursDto coursDto);
}
