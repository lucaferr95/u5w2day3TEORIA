package it.epicode.u5w2day3TEORIA.Service;

import it.epicode.u5w2day3TEORIA.Dto.StudenteDto;
import it.epicode.u5w2day3TEORIA.Exception.NotFoundException;
import it.epicode.u5w2day3TEORIA.Model.Studente;
import it.epicode.u5w2day3TEORIA.Model.Universita;
import it.epicode.u5w2day3TEORIA.Repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class StudenteService {
    @Autowired
    StudenteRepository studenteRepository;

    @Autowired
    private UniversitaService universitaService;

    public Studente saveStudente (StudenteDto studenteDto) throws NotFoundException{
        //contiene solo nome, cognome, dataNascita e universitaid
        Universita universita= universitaService.getUniversita(studenteDto.getUniversitaId());
        Studente studente= new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataNascita(studenteDto.getDataNascita());
        studente.setUniversita(universita);
        return studenteRepository.save(studente);
    }

    public List<Studente> getAllStudenti(){
        return studenteRepository.findAll();
    }

    public Studente getStudente(int matricola) throws NotFoundException{
        return studenteRepository.findById(matricola).
                orElseThrow(() -> new NotFoundException("Studente con matricola " + matricola + " non presente "));
    }

    public  Studente updateStudente(int matricola, StudenteDto studenteDto) throws NotFoundException {
        Studente studenteDaAggiornare= getStudente(matricola); //ci ritorna uno studente se lo trova, altrimenti un'eccezione+

        studenteDaAggiornare.setNome(studenteDto.getNome());
        studenteDaAggiornare.setCognome(studenteDto.getCognome());
        studenteDaAggiornare.setDataNascita(studenteDto.getDataNascita());
        /*
        nel dto io ho anche universitaid, quindi devo verificare se l'id dell'universita collegato
        allo studente sul db è diversa dall'id dell'uni nel dto;
        se sono differenti, lo studente ha cambiato uni e quindi
        vado a cercare questa nuova universita sul db e se la trovo
        la setto sullo studente da aggiornare
         */
        if (studenteDaAggiornare.getUniversita().getId()!=studenteDto.getUniversitaId()){
            Universita universita= universitaService.getUniversita(studenteDto.getUniversitaId());
            studenteDaAggiornare.setUniversita(universita);
        }
        return studenteRepository.save(studenteDaAggiornare);
    }
    public  void deleteStudente(int matricola) throws NotFoundException {
        Studente studenteDaCancellare= getStudente(matricola);

        studenteRepository.delete(studenteDaCancellare);
    }
}
