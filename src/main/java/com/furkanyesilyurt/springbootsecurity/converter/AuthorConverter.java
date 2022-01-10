package com.furkanyesilyurt.springbootsecurity.converter;

import com.furkanyesilyurt.springbootsecurity.dto.AuthorDto;
import com.furkanyesilyurt.springbootsecurity.dto.AuthorRegisterDto;
import com.furkanyesilyurt.springbootsecurity.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorConverter {

    AuthorConverter INSTANCE = Mappers.getMapper(AuthorConverter.class);

    List<AuthorDto> convertAllAuthorsToAuthorDtos(List<Author> authors);
    Author convertAuthorRegisterDtoToAuthor(AuthorRegisterDto authorRegisterDto);
    AuthorRegisterDto convertAuthorToAuthorRegisterDto(Author author);
    AuthorDto convertAuthorToAuthorDto(Author author);

}
