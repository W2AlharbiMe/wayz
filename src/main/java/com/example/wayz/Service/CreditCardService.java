package com.example.wayz.Service;


import com.example.wayz.DTO.CreditCardDto;
import com.example.wayz.Model.CreditCard;
import com.example.wayz.Model.Student;
import com.example.wayz.Model.User;
import com.example.wayz.Repository.CreditCardRepository;
import com.example.wayz.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final StudentRepository studentRepository;

    public void addCard(Integer id, CreditCardDto creditCardDto){
        Student student1 = studentRepository.findStudentById(id);
        CreditCard creditCard = new CreditCard(null,creditCardDto.getNumber(),creditCardDto.getName(),creditCardDto.getCcv(),student1);
        String hash=new BCryptPasswordEncoder().encode(creditCard.getNumber());
        creditCard.setNumber(hash);
        creditCardRepository.save(creditCard);
    }



}