package com.marques.edelson.service;

import com.marques.edelson.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    Client HTTP criado via OpenFeign para o consumo da API do https://viacep.com.br/

 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepServiceClient {

    //@GetMapping(value = "/{cep}/json/")
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
