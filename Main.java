import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int logInAttempt = 1;
        while(true){
            try{
                System.out.print("Enter your password: ");
                String userPassword = scanner.nextLine();

                if(userPassword.equals("password")){
                    System.out.println("Logged in");
                    System.exit(0);
                } else if (logInAttempt == 3) {
                    throw new PasswordLimitException("Password attempt limit reached");

                }

                logInAttempt++;
                throw new InvalidPasswordException("invalid password");
            }catch(PasswordLimitException | InvalidPasswordException error){
                System.out.println("Error caught: "+ error.getMessage());
                System.out.println();
                if (error instanceof PasswordLimitException) {
                    System.exit(0);
                }
            }
        }
    }
}