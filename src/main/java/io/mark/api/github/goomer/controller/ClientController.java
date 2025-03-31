package io.mark.api.github.goomer.controller;

import io.mark.api.github.goomer.model.Client;
import io.mark.api.github.goomer.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody Client client) {
        clientService.create(client);
    }


}