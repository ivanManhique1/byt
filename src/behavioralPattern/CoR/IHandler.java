package behavioralPattern.CoR;

public interface IHandler {
    void handle(OperationRequest operationRequest);
    void setNextHandler(IHandler nextHandler);
}
