package com.library.borrowmicroservice.services;

import com.library.borrowmicroservice.exceptions.BorrowCreationException;
import com.library.borrowmicroservice.exceptions.BorrowNotFoundException;
import com.library.borrowmicroservice.model.Borrow;
import com.library.borrowmicroservice.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowRepository borrowRepository;
    @Autowired
    BorrowMapper borrowMapper;




    @Override
    //Retrouver tous les emprunts d'un utilisateur
    public List<Borrow> findBorrowById (Long userID) {
        return borrowRepository.findAllById(userID);
    }

    @Override
    public Borrow getBorrow(Long id) {
        Borrow borrow = borrowRepository.getOne(id);
        if(borrow == null) throw new BorrowNotFoundException("L'emprunt recherché n'a pas été trouvé");
        return borrow;
    }


    @Override
    public Borrow createBorrow(BorrowDTO borrowDTO) {

        borrowDTO.setDateStart(LocalDateTime.now());
        borrowDTO.setDateEnd(LocalDateTime.now().plusDays(28));
        borrowDTO.setDateExtend(LocalDateTime.now().plusDays(56));

        if(borrowDTO.getUserID() == null) throw new BorrowCreationException("L'id de l'utilisateur doit être renseigné");
        if(borrowDTO.getBookID() == null) throw new BorrowCreationException("L'id de livre doit être renseigné");
        if(borrowDTO.getDateStart() == null) throw new BorrowCreationException("La date de l'emprunt doit être renseignée");
        if(borrowDTO.getDateEnd() == null) throw new BorrowCreationException("La date de fin de prêt ne peut pas être null");
        if(borrowDTO.getDateExtend() == null) throw new BorrowCreationException("La date d'extension du prêt ne peut pas être null");

        borrowDTO.setIsExtend(false);
        Borrow borrow = borrowMapper.borrowDtoToBorrow(borrowDTO);
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow extendBorrow(Long id) {
        Borrow borrow = getBorrow(id);
        if(borrow == null) throw new BorrowNotFoundException("Erreur lors de la mise à jour : le prêt n'existe pas ou n'a pas été retrouvé");
        if(borrow.getIsExtend()) throw new BorrowCreationException("Le prêt a déjà été étendu");
        borrow.setIsExtend(true);
        return borrowRepository.save(borrow);
    }

    @Override
    public void updateBorrow(BorrowDTO borrowDTO) {
        Borrow borrow = getBorrow(borrowDTO.getId());
        if(borrow == null) throw new BorrowNotFoundException("L'emprunt recherché n'a pas été trouvé");
        borrowMapper.updateBorrowFromBorrowDTO(borrowDTO,borrow);
        borrowRepository.save(borrow);
    }

    @Override
    public void deleteBorrow(Long id) {
        borrowRepository.deleteById(id);
    }
}
