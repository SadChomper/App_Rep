package ConnectionOperateur;

import java.io.Serializable;

public class Operation implements Serializable{
	
	private int op1;
	private int op2;
	private int result;
	private char op;	//'+' '-' '*' '/'
	
	//Constructors
	public Operation (int op1, int op2, int result, char op) {
		super();
		this.op1 = op1;
		this.op2 = op2;
		this.result = result;
		this.op = op;
	}
	
	//getters + setters
	public int getOp1() {
		return op1;
	}

	public int getOp2() {
		return op2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public char getOp() {
		return op;
	}

	public void setOp(char op) {
		this.op = op;
	}
	
}
