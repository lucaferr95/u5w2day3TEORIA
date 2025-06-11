package it.epicode.u5w2day3TEORIA.Controller;

import it.epicode.u5w2day3TEORIA.Dto.StudenteDto;
import it.epicode.u5w2day3TEORIA.Exception.NotFoundException;
import it.epicode.u5w2day3TEORIA.Model.Studente;
import it.epicode.u5w2day3TEORIA.Service.StudenteService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/studenti")
public class StudenteController {
    @Autowired
    private StudenteService studenteService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Studente saveStudente(@RequestBody StudenteDto studenteDto) throws NotFoundException{
       return studenteService.saveStudente(studenteDto);
    }

    @GetMapping("")
    public List<Studente> getAllStudenti(){
        return studenteService.getAllStudenti();
    }

    @GetMapping("/{matricola}")
    public Studente getStudente(@PathVariable int matricola) throws NotFoundException {
        return studenteService.getStudente(matricola);
    }

    @PutMapping("/{matricola}")
    public Studente updateStudente(@PathVariable int matricola, @RequestBody StudenteDto studenteDto) throws NotFoundException {
        return studenteService.updateStudente(matricola,studenteDto);
    }

    @DeleteMapping("/{matricola}")
    public void deleteStudente(@PathVariable int matricola) throws NotFoundException {
        studenteService.deleteStudente(matricola);
    }
}
