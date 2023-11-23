package behavioralPattern.CoR;

public class DivisionHandler implements IHandler{

    private IHandler nextHandler;

    @Override
    public void handle(OperationRequest operationRequest) {
        if( operationRequest.getOperation().equals("/")){
            int result = operationRequest.getN1() / operationRequest.getN2();
            System.out.printf("%d / %d = %d\n", operationRequest.getN1(), operationRequest.getN2(), result);
        } else {
            nextHandler.handle(operationRequest);
        }
    }

    @Override
    public void setNextHandler(IHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
