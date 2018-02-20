package com.leadercoach.rest.services.delegate;

import java.util.Random;

/**
 * RandomIdGeneration is to generate randomid of 6 digits and preffixed by the
 * perameter passed.
 * 
 * @author codaglobal
 *
 */
public class RandomIdGeneration {
	public static String get(String prefix) {
		Random random = new Random();
		int randomInteger = random.nextInt(1000000);
		return prefix + randomInteger;
	}
}
