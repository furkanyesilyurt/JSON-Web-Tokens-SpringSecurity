package com.furkanyesilyurt.springbootsecurity.controller;

import com.furkanyesilyurt.springbootsecurity.dto.AuthorDto;
import com.furkanyesilyurt.springbootsecurity.dto.AuthorRegisterDto;
import com.furkanyesilyurt.springbootsecurity.service.entityService.AuthorEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorEntityService authorEntityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDto>> findAll() {
        var authorDtos = authorEntityService.findAll();
        return new ResponseEntity<>(authorDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDto>> findByFirstName(@PathVariable String firstName){
        var authorDtos = authorEntityService.findByFirstName(firstName);
        return new ResponseEntity<>(authorDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/lastName/{lastName}", method = RequestMethod.DELETE)
    public void deleteByLastName(@PathVariable String lastName){
        authorEntityService.deleteByLastName(lastName);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<AuthorRegisterDto> saveAuthor(@RequestBody AuthorRegisterDto authorRegisterDto){
        var respauthorRegisterDto = authorEntityService.saveAuthor(authorRegisterDto);
        return new ResponseEntity<>(respauthorRegisterDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AuthorDto> update(@RequestBody AuthorRegisterDto authorRegisterDto,@PathVariable Long id){
        var authorDto = authorEntityService.update(authorRegisterDto, id);
        return new ResponseEntity<>(authorDto, HttpStatus.OK);
    }

}
