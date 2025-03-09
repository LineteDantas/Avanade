package dio.avanade.controller;

import dio.avanade.model.Loja;
import dio.avanade.servicos.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/loja")
@CrossOrigin(origins = "*")
public class LojaController {

    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> pesquisarPorId(@PathVariable Long id){
        return ResponseEntity.ok(lojaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Loja> salvar(@RequestBody Loja loja){

        var lojaNova =  lojaService.create(loja);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(lojaNova.getId())
                .toUri();
        return ResponseEntity.created(location).body(lojaNova);
    }

}
