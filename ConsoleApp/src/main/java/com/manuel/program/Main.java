package com.manuel.program;

public class Main {
	
	//private static UserCommand uCommand;
	private static RunProgram runProgram;

	public static void main(String[] args) {
		//uCommand = new UserCommand(scanner);
		runProgram = new RunProgram();
		runProgram.run();
	}

}
