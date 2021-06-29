package br.edu.usj.ads.pw.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@CrossOrigin
public class ReservaController {

    @Autowired
    ReservaRepository reservaRepository;


    @GetMapping(value="/")
    public List<Reserva> getIndex() {
        List<Reserva> lista = reservaRepository.findAll();
        return lista;        
    }

    @GetMapping(value="/detalhes/{id}")
    public Reserva getDetalhes(@PathVariable Long id) {
        Reserva reserva = new Reserva();
        reserva = reservaRepository.findById(id).get();
        return reserva;
    } 
    
    @PostMapping(value="/adicionar")
    public Reserva postAdicionar(@RequestBody Reserva reserva) {
        Reserva reservaNova = reservaRepository.save(reserva);
        return reservaNova;
    }

    @GetMapping(value="/deletar/{id}")
    public void getDeletar(@PathVariable Long id) {
        reservaRepository.deleteById(id);       
    }

}
