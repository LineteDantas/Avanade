package dio.avanade.servicos.impl;

import dio.avanade.model.Loja;
import dio.avanade.repositorio.LojaRepository;
import dio.avanade.servicos.LojaService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LojaServiceImpl  implements LojaService {

    private final LojaRepository lojaRepository;

    public LojaServiceImpl(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    @Override
    public Loja findById(Long id) {
        return lojaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Loja create(Loja loja) {
       if(loja.getId() != null && lojaRepository.existsById(loja.getId())){
           throw new IllegalArgumentException("Loja ja cadastrada");
       }

        return lojaRepository.save(loja);
    }
}
