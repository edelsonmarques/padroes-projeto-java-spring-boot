package com.marques.edelson.service;

import com.marques.edelson.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserirCliente(Cliente cliente);

    void atualizarCliente(Long id, Cliente cliente);

    void deletarCliente(Long id);
}
