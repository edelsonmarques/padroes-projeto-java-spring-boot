package com.marques.edelson.repository;

import com.marques.edelson.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
