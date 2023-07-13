package ir.mapsa.bank.utils;

public class BranchCodeGenerator {

    private static int codeGenerator=1000;

    public static String branchCodeGenerator(){

        return String.valueOf(codeGenerator++);

    }

}
