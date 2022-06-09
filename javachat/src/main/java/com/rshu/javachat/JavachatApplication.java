package com.rshu.javachat;

import com.rshu.javachat.storage.Chat;
import com.rshu.javachat.storage.DBInterlayer;
import com.rshu.javachat.storage.Message;
import com.rshu.javachat.storage.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavachatApplication {

	public static void main(String[] args) {
		DBInterlayer.init();
		DBTests();
		SpringApplication.run(JavachatApplication.class, args);
	}

	static void DBTests() {
		User user = new User("Alpha");
		System.out.println("login: " + user.getLogin());
		System.out.println("userId: " + user.getUserId());
		System.out.println("user first chat:");
		Chat chat = user.getChats().get(0);
		new Message(user, chat, "Ok, it must work");
		System.out.println("name: " + chat.getName());
		System.out.println("user first message:");
		System.out.println("content: " + user.getMessages().get(0).getContent());
		System.out.println("chat first user");
		System.out.println("login: " + chat.getUsers().get(0).getLogin());
		System.out.println("chat first message");
		System.out.println("login: " + chat.getMessages().get(0).getContent());
	}

}
