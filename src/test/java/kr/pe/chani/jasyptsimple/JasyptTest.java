package kr.pe.chani.jasyptsimple;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JasyptTest .class)
public class JasyptTest {

	@Value("${jasypt.encryptor.password}")
	private String encryptKey;

	@Test
    public void encryptDecryptTest() {
		String text = "plain-text"; // Git에 접속하는 패스워드

		StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
		jasypt.setPassword(encryptKey); // Jasypt를 이용하여 암호화하는 키 (프로퍼티의 jasypt.encryptor.password)
		jasypt.setAlgorithm("PBEWithMD5AndDES"); // Jasypt를 이용한 암호화 알고리즘

		String encryptedText = jasypt.encrypt(text);
		System.out.println("enc : " + encryptedText);
		String decryptedText = jasypt.decrypt(encryptedText);
		System.out.println("dec : " + decryptedText);
    }
}