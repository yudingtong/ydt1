package util;

import java.util.Random;
import java.util.stream.DoubleStream;

public class Variance {

private static final Random rand = new Random();
private static final int MIN = 1;
private static final int MAX = 140;
private static final int POPULATION_SIZE = 30_000_000;
public static final int NUMBER_OF_RUNS = 20;

public static void main(String... args) {
double[] population = DoubleStream.generate(Variance::randInt).limit(POPULATION_SIZE).toArray();
System.out.println("方差="+varianceImperative(population));
}

public static int randInt() {
return rand.nextInt((MAX - MIN) + 1) + MIN;
}

public static double varianceImperative(double[] population) {

	double average = 0.0;

	for (double p : population) {

		average += p;

	}

	average /= population.length;


	double variance = 0.0;

	for (double p : population) {

		variance += (p - average) * (p - average);

	}

	return variance / population.length;

}

}
