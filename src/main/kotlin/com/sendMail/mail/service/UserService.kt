package com.sendMail.mail.service

import com.sendMail.mail.domain.Confirmation
import com.sendMail.mail.domain.PdfSave
import com.sendMail.mail.domain.User
import com.sendMail.mail.repository.ConfirmationRespository
import com.sendMail.mail.repository.PdfRepository
import com.sendMail.mail.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class UserService(@Autowired val userRepository: UserRepository,
                  @Autowired val confirmationRespository: ConfirmationRespository,
                  @Autowired val pdfRepository: PdfRepository) {


    fun saveUser(user:User):User{
        if(userRepository.existsByEmail(user.email))
        {
            throw RuntimeException("Email already exists")
        }

        user.isEnabled = false
        userRepository.save(user)

        val confirmation = Confirmation(user=user)
        confirmationRespository.save(confirmation)



        return user


    }



    fun getUserByEmail(email:String):User{

        val user = userRepository.findByEmailIgnoreCase(email)

        return user
    }


    fun findUser(id:UUID):Confirmation{
        val confirmation = confirmationRespository.findByUserId(id)
        return confirmation
    }

    fun verifyToken(token:String):User{

        val confirmation = confirmationRespository.findByToken(token)
        val user = userRepository.findByEmailIgnoreCase(confirmation.user.email)
        user.let {
            it.isEnabled = true

            //Update User
            userRepository.save(it)

            //confirmationRespository.delete(confirmation)

            return user
        }


    }
}