package behavioralPattern.CoR;

public class OperationRequest {

    private int n1;
    private int n2;
    private String operation;

    public OperationRequest(int n1, int n2, String operation) {
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public String getOperation() {
        return operation;
    }
}
