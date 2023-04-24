
package com.portfolio.mv.Controller;

import com.portfolio.mv.Dto.dtoPersona;
import com.portfolio.mv.Entity.Persona;
import com.portfolio.mv.Security.Controller.Mensaje;
import com.portfolio.mv.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontend-95a85.web.app")
@RequestMapping("/personas")

public class PersonaController {
     @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("el ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("la educacion ha sido eliminada"), HttpStatus.OK);
    }
    
    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(personaService.existsByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getDescripcion());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("la educacion ha sido creada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no debe estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("La persona ha sido actualizada"), HttpStatus.OK);
    }
    
    
}
    
