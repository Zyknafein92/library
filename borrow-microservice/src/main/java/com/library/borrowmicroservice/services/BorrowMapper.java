package com.library.borrowmicroservice.services;

import com.library.borrowmicroservice.model.Borrow;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BorrowMapper {

    BorrowDTO borrowToBorrowDTO(Borrow borrow);

    Borrow borrowDtoToBorrow(BorrowDTO borrowDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateBorrowFromBorrowDTO(BorrowDTO borrowDTO, @MappingTarget Borrow borrow);
}