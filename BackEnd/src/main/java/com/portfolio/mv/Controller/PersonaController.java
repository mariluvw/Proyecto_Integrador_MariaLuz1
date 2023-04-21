
package com.portfolio.mv.Controller;

import com.portfolio.mv.Entity.Persona;
import com.portfolio.mv.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
    @Autowired private IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return getIpersonaService().getPersona();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        getIpersonaService().savePersona(persona);
        return "La persona fue creada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        getIpersonaService().deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg) {
        Persona persona = getIpersonaService().findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        getIpersonaService().savePersona(persona);
        return persona;
    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return getIpersonaService().findPersona((long)3);
    }

    /**
     * @return the ipersonaService
     */
    public IPersonaService getIpersonaService() {
        return ipersonaService;
    }

    /**
     * @param ipersonaService the ipersonaService to set
     */
    public void setIpersonaService(IPersonaService ipersonaService) {
        this.ipersonaService = ipersonaService;
    }
}
