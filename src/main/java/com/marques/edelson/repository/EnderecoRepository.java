package com.marques.edelson.repository;

import com.marques.edelson.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
