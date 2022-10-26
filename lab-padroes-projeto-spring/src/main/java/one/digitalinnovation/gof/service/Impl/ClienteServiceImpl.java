package one.digitalinnovation.gof.service.Impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    //TODO: Singleton: Injetar os componentes do Spring com @Autowired.
    //TODO: Strategy: Implementar os métodos definidos na interface.
    //TODO: Facede: Abstrair integrações com subsistemas, provendo uma interface simples.
    @Override
    public Iterable<Cliente> buscarTodos() {
        //FIXME: Buscar todos os Clientes.
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        //FIXME: Buscar Cliente por id.
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        //FIXME: Verificar se o Endereço do Cliente já existe (pelo CEP).
        //FIXME: Caso não exista, integrar com o ViaCEP e persistir o retorno.
        //FIXME: Inserir Cliente, vinculando o Endereço (novo ou existente).

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //FIXME: Buscar Cliente por ID, caso exista:
        //FIXME: Verificar se o Endereço do Cliente já existe (pelo CEP).
        //FIXME: Caso não exista, integrar com o ViaCEP e persistir o retorno.
        //FIXME: Alterar Cliente, vinculando o Endereço (novo ou existente).

    }

    @Override
    public void deletar(Long id) {
        //FIXME: Deletar Cliente por ID.
    }
}
