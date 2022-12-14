package one.digitalinnovation.gof.service.Impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    // Strategy: Implementar os métodos definidos na interface.
    // Facede: Abstrair integrações com subsistemas, provendo uma interface simples.
    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar Cliente por id.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    /**
     * Verificar se o Endereço do Cliente já existe (pelo CEP).
     * Caso não exista, integrar com o ViaCEP e persistir o retorno.
     * Inserir Cliente, vinculando o Endereço (novo ou existente).
     * @param cliente
     */
    @Override
    public void inserir(Cliente cliente) {
        // Verificar se o Endereço do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        // Inserir Cliente, vinculando o Endereço (novo ou existente).
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    /**
     * Buscar Cliente por ID, caso exista: inserir(Cliente)
     *
     * @param id
     * @param cliente
     */
    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            // Verificar se o Endereço do Cliente já existe (pelo CEP).
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            // Alterar Cliente, vinculando o Endereço (novo ou existente).
            inserir(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        clienteRepository.deleteById(id);
    }
}
