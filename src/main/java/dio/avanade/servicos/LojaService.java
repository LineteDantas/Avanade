package dio.avanade.servicos;
import dio.avanade.model.Loja;

public interface LojaService {

    Loja findById(Long id);

    Loja create(Loja loja);

}
