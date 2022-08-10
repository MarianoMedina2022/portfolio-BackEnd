package com.portfolio.medinamariano.Interface;

import com.portfolio.medinamariano.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersona();
    public void savePersona(Persona persona);
    public void deletePersona(Long id);
    public Persona findPersona(long id);
}
