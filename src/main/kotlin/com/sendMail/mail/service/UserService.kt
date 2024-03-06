package com.sendMail.mail.service

import com.sendMail.mail.domain.Confirmation
import com.sendMail.mail.domain.User
import com.sendMail.mail.repository.ConfirmationRespository
import com.sendMail.mail.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService(@Autowired val userRepository: UserRepository,
                  @Autowired val confirmationRespository: ConfirmationRespository) {


    fun saveUser(user:User):User{
        if(userRepository.existsByEmail(user.email))
        {
            throw RuntimeException("Email already exists")
        }

        user.isEnabled = false
        userRepository.save(user)

        val confirmation = Confirmation(user=user)
        confirmationRespository.save(confirmation)

       //Send email to user



        return user


    }

    fun verifyToken(token:String):Boolean{

        val confirmation = confirmationRespository.findByToken(token)
        val user = userRepository.findByEmailIgnoreCase(confirmation.user.email)
        user.let {
            it.isEnabled = true

            //Update User
            userRepository.save(it)

            //confirmationRespository.delete(confirmation)

            return true
        }


    }
}