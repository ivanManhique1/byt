package behavioralPattern.CoR;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        IHandler additionHandler = new AdditionHandler();
        IHandler subtractionHandler = new SubtractionHandler();
        IHandler divisionHandler= new DivisionHandler();
        IHandler multiplicationHandler= new MultiplicationHandler();

        /**
         * I will make it circular...
         */
        additionHandler.setNextHandler(subtractionHandler);
        subtractionHandler.setNextHandler(divisionHandler);
        divisionHandler.setNextHandler(multiplicationHandler);
        multiplicationHandler.setNextHandler(additionHandler);

        OperationRequest additionRequest = new OperationRequest(5, 3, "+");
        OperationRequest subtractionRequest = new OperationRequest(10, 4, "-");
        OperationRequest multiplicationRequest = new OperationRequest(2, 6, "*");

        multiplicationHandler.handle(additionRequest);

        additionHandler.handle(subtractionRequest);
        additionHandler.handle(multiplicationRequest);

        Scanner in = new Scanner(System.in);
        processCmd(in, additionHandler);

    }

    private static void processCmd(Scanner in, IHandler handler){
        String cmd = "default";
        while (true){
            switch (cmd){
                case "quit" -> System.exit(0);
                default -> {
                          OperationRequest operationRequest=  makeRequest(in);
                          handler.handle(operationRequest);
                }
            }
            System.out.println("usage:\n - to quit:\n\ttype: <quit>\nto continue:\n\ttype anything.");
            cmd = in.next();
        }
    }

    private static OperationRequest makeRequest(Scanner in) {
        System.out.println("usage: <n1 n2 operation>");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        String operation = in.next();
        OperationRequest operationRequest = new OperationRequest(n1, n2, operation);
        return operationRequest;
    }
}
