package com.sendMail.mail

import com.sendMail.mail.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class MailApplicationTests(@Autowired val userService: UserService) {



	@Test
	fun contextLoads() {
	}


	/*

	@Test
	@DisplayName( "Save user in database" )
	fun saveUserAndGetThemBackFromDatabase(){


		val user = User(UUID.randomUUID(),"Test","test@check.de",Info.STROM,true)
		userService.saveUser(user)

		val verify = userService.verifyToken(user.id.toString())

		Assertions.assertThat(verify).isNotNull
	}


	@Test
	@DisplayName( "Save user in database" )
	fun getThemBackFromDatabase(){
		val request = MockMvcRequestBuilders.get("/api/users?token=0026c78a-a433-49c3-8f48-df70251489f2")

		Assertions.assertThat(request).isNotNull
	}



	 */



}
