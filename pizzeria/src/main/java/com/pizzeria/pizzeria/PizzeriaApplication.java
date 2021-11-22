package com.pizzeria.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@SpringBootApplication
public class PizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
		RedisClient redisClient = RedisClient.create("redis://Pablo:passworD1!@localhost:6379/1617124");
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();
		RedisAsyncCommands<String, String> asyncCommands = connection.async();

		String responseRedis = syncCommands.set("key", "Hello, Redis!");
		System.out.println(responseRedis);
		connection.close();
		redisClient.shutdown();
	}

}
