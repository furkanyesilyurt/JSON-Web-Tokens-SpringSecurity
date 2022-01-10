package com.furkanyesilyurt.springbootsecurity.service.entityService;

import com.furkanyesilyurt.springbootsecurity.converter.AuthorConverter;
import com.furkanyesilyurt.springbootsecurity.dao.IAuthorDal;
import com.furkanyesilyurt.springbootsecurity.dto.AuthorDto;
import com.furkanyesilyurt.springbootsecurity.dto.AuthorRegisterDto;
import com.furkanyesilyurt.springbootsecurity.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional //for deleteByLastName
@Service
@RequiredArgsConstructor
public class AuthorEntityService {

    private final IAuthorDal authorDal;

    public List<AuthorDto> findAll() {
        List<Author> authors = authorDal.findAll();
        List<AuthorDto> authorDtos = AuthorConverter.INSTANCE.convertAllAuthorsToAuthorDtos(authors);
        return authorDtos;
    }

    public List<AuthorDto> findByFirstName(String firstName) {
        List<Author> authors = authorDal.findByFirstName(firstName);
        List<AuthorDto> authorDtos = AuthorConverter.INSTANCE.convertAllAuthorsToAuthorDtos(authors);
        return authorDtos;
    }

    @Transactional
    public void deleteByLastName(String lastName){
        authorDal.deleteByLastName(lastName);
    }

    public AuthorRegisterDto saveAuthor(AuthorRegisterDto authorRegisterDto){
        var author = AuthorConverter.INSTANCE.convertAuthorRegisterDtoToAuthor(authorRegisterDto);
        author = authorDal.save(author);
        authorRegisterDto = AuthorConverter.INSTANCE.convertAuthorToAuthorRegisterDto(author);
        return authorRegisterDto;
    }

    public AuthorDto update(AuthorRegisterDto authorRegisterDto, Long id){
        var author = authorDal.findById(id).orElse(null);

        author.setFirstName(authorRegisterDto.getFirstName());
        author.setLastName(authorRegisterDto.getLastName());
        author.setEmail(authorRegisterDto.getEmail());
        author.setBirthday(authorRegisterDto.getBirthday());

        AuthorDto authorDto = AuthorConverter.INSTANCE.convertAuthorToAuthorDto(author);

        return authorDto;
    }
}
