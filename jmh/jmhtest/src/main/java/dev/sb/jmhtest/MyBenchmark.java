package dev.sb.jmhtest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

	private final CalcHelper ch = new CalcHelper();
	private final Random r = new Random();

	@Benchmark
	public double testSqrt() {
		return ch.getSqrt(r.nextDouble());
	}

	@Benchmark
	public double testPow2() {
		return ch.getPower2(r.nextDouble());
	}

}
