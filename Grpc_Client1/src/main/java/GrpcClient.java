import com.nahid.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class GrpcClient {
    public static void main(String args[]){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 1092).usePlaintext().build();
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        Scanner scr = new Scanner(System.in);

        while(true) {

            System.out.println("\nEnter 0 to Sign up" + "\t\t\t" + "Enter 1 to Sign in" + "\t\t\t" + "Enter 2 to log out");
            System.out.println("-------------------" + "\t\t\t" + "-------------------" + "\t\t\t" + "------------------");

            String command = scr.nextLine();
            if (command.equals("2")) {
                Empty emptyMessage = Empty.newBuilder().build();
                //User.APIResponse logout = userStub.logout(emptyMessage);
                APIResponse logout = userStub.logout(emptyMessage);
                System.out.println(logout.getResponseMessage());
                break;
            }
            if (command.equals("0")) {
                System.out.print("Email: ");
                String email = scr.nextLine();

                System.out.print("User Name: ");
                String userName = scr.nextLine();

                System.out.print("Password: ");
                String password = scr.nextLine();

                System.out.print("Phone Number: ");
                String phoneNumber = scr.nextLine();

                System.out.print("Full Name: ");
                String fullName = scr.nextLine();

                RegistrationRequest registration = RegistrationRequest.newBuilder().setEmail(email).setUserName(userName).setPassword(password).setFullName(fullName).setPhoneNumber(phoneNumber).build();

                APIResponse regResponse = userStub.registration(registration);
                System.out.println(regResponse.getResponseMessage());

            } else if (command.equals("1")) {
                System.out.print("User Name: ");
                String userName = scr.nextLine();

                System.out.print("Password: ");
                String password = scr.nextLine();

                LoginRequest loginRequest = LoginRequest.newBuilder().setUsername(userName).setPassword(password).build();
                APIResponse response = userStub.login(loginRequest);
                System.out.println(response.getResponseMessage());

            } else {
                System.out.println("[Invalid command. Try again...]");
            }

        }
    }
}
