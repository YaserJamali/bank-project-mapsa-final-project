package ir.mapsa.bank.utils;

public class CustomerNumberGenerator {


    private static int numberGenerator=20000;

    public static String customerNumberGenerator(String branchCodeGenerator){

        return branchCodeGenerator+"BR"+numberGenerator++;
    }
}
