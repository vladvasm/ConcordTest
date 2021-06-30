package com.concord.springRestPostJSONTest.controller;

/**
 *
 * @author Vladimir
 */
import com.concord.springRestPostJSONTest.crypto.AES256;
import com.concord.springRestPostJSONTest.model.Person;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
	static Logger log=Logger.getLogger(PersonController.class);
	private static Person myPerson_1=new Person(1, "Test Testov");
	String originalString;
	String encryptingString;
	String decryptingString;

	@RequestMapping (value = "/person", consumes = "application/json;charset=UTF-8",
			produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Person getPerson(@RequestBody Person person) {
		originalString=person.toString();
		encryptingString=AES256.encrypt(originalString);
		decryptingString=AES256.decrypt(encryptingString);
		log.info("REQUEST BODY:\n=== encryption: "+encryptingString+"\n=== decryption: "+decryptingString);
		if (person.getId()==myPerson_1.getId()) {
			originalString=myPerson_1.toString();
			encryptingString=AES256.encrypt(originalString);
			decryptingString=AES256.decrypt(encryptingString);
			log.info("RESPONCE BODY:\n=== encryption: "+encryptingString+"\n=== decryption: "+decryptingString);
			return myPerson_1;
		}
		else {
			originalString="null";
			encryptingString=AES256.encrypt(originalString);
			decryptingString=AES256.decrypt(encryptingString);
			log.info("RESPONCE BODY:\n=== encryption: "+encryptingString+"\n=== decryption: "+decryptingString);
			return null;
		}
	}
}
