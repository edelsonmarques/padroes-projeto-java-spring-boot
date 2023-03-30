package com.marques.edelson.service.impl;

import com.marques.edelson.model.Cliente;
import com.marques.edelson.model.Endereco;
import com.marques.edelson.repository.ClienteRepository;
import com.marques.edelson.repository.EnderecoRepository;
import com.marques.edelson.service.ClienteService;
import com.marques.edelson.service.ViaCepServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    //Singleton: Injeção de dependência com o Spring @Autowired
    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;

    private ViaCepServiceClient cepServiceClient;

    @Autowired
    public ClienteServiceImpl(ViaCepServiceClient viaCepServiceClient,
                              EnderecoRepository enderecoRepository, ClienteRepository clienteRepository) {
        this.cepServiceClient = viaCepServiceClient;
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
    }


    @Override
    public Iterable<Cliente> buscarTodos() {
        //Buscar todos os clientes na base
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        //Busca apenas um cliente especifico
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void inserirCliente(Cliente cliente) {

        //Inseri um novo cliente na base
        salvarClientComCep(cliente);
    }

    @Override
    public void atualizarCliente(Long id, Cliente cliente) {

        //Atualiza alguma informação de um cliente
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

       if (clienteExistente.isPresent())
                this.salvarClientComCep(cliente);
    }

    @Override
    public void deletarCliente(Long id) {
        //Exclui da base um cliente especifico
        clienteRepository.deleteById(id);
    }

    private void salvarClientComCep(Cliente cliente) {

        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {

            Endereco novoEndereco = cepServiceClient.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
