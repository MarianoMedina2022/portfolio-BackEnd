package com.Portfolio.MedinaMariano.Interface;

import com.Portfolio.MedinaMariano.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersona();
    public void savePersona(Persona persona);
    public void deletePersona(Long id);
    public Persona findPersona(long id);
}
