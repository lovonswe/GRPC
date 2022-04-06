package user;

import com.nahid.grpc.User;
import com.nahid.grpc.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;

import java.sql.*;

public class UserService extends userImplBase {

    String url = "jdbc:mysql://localhost:3306/grpcservices1";
    String username = "root";
    String pass = "";

    //Class.forName("com.mysql.jdbc.Driver");
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement  statement = null;

    boolean isUserNameExists(String userName) throws SQLException {
        connection = DriverManager.getConnection(url, username, pass);
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = statement.executeQuery("SELECT * FROM `user` WHERE 1");

        while (resultSet.next()){
            if(resultSet.getString("User Name").equals(userName)){
                return true;
            }
        }
        return false;
    }

    boolean isEmailExists(String email) throws SQLException {
        connection = DriverManager.getConnection(url, username, pass);
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = statement.executeQuery("SELECT * FROM `user` WHERE 1");

        while (resultSet.next()){
            if(resultSet.getString("Email").equals(email)){
                return true;
            }
        }
        return false;
    }

    boolean isUserExists(String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, pass);

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = statement.executeQuery("SELECT * FROM `user` WHERE 1");

        while (resultSet.next()) {
            if (resultSet.getString("User Name").equals(userName) && resultSet.getString("Password").equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registration(User.RegistrationRequest request, StreamObserver<User.APIResponse> responseObserver) {
        //super.registration(request, responseObserver);
        System.out.println("Inside registration");

        String fullName = request.getFullName();
        String userName = request.getUserName();
        String phoneNumber = request.getPhoneNumber();
        String email = request.getEmail();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        try{
            if(isUserNameExists(userName)){
                System.out.println("UserName already exists.");
                response.setResponseCode(0).setResponseMessage("Try a new username, it's already exist.");
            }else if(isEmailExists(email)){
                System.out.println("This email already exists.");
                response.setResponseCode(1).setResponseMessage("Try a new email, it's already exist.");
            }else{
                statement.executeUpdate("INSERT INTO `user`(`Full Name`, `User Name`, `Phone Number`, `Email`, `Password`) VALUES ('"+fullName+"','"+userName+"','"+phoneNumber+"','"+email+"','"+password+"')");
                System.out.println("Registration Successful.");
                response.setResponseCode(2).setResponseMessage("Registration Successful.");
            }
           // statement.executeUpdate("INSERT INTO `user`(`Full Name`, `User Name`, `Phone Number`, `Email`, `Password`) VALUES ('"+fullName+"','"+userName+"','"+phoneNumber+"','"+email+"','"+password+"')");
           // System.out.println("Registration successfully done");
        }catch (Exception e){
            e.printStackTrace();
        }
        //User.APIResponse.Builder response = User.APIResponse.newBuilder();
        //response.setResponseCode(0).setResponseMessage("Registration Successful");

        System.out.println();

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        //super.login(request, responseObserver);
        System.out.println("An user is goint to login.");

        String username = request.getUsername();
        String password = request.getPassword();


        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        //response.setResponseCode(0).setResponseMessage("Login Successful");

        try{
            if(isUserExists(username, password)){
                response.setResponseCode(0).setResponseMessage("Login Successful");
                System.out.println("Login successful.");
            }
            else{
                response.setResponseCode(1).setResponseMessage("Invalid username or password, try with correct info.");
                System.out.println("Unsuccessful logging attempt");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        //super.logout(request, responseObserver);
        System.out.println("A user has logged out...");

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        response.setResponseMessage("You Have been logged out...\n").setResponseCode(000);

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
