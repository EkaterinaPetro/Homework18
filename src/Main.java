import java.util.regex.Pattern;

public class Main {

    private static final Pattern patternLogin = Pattern.compile("^\\w{1,20}$");
    private static final Pattern patternPassword = Pattern.compile("^\\w{1,19}$");
    public static boolean checkInformation(String login, String password, String confirmPassword) {
        if (!patternLogin.matcher(login).find()) {
            throw new WrongLoginException();
        }

        if (!patternPassword.matcher(password).find()) {
            throw new WrongPasswordException();
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
        return true;
    }

    public static void main(String[] args) {

        try {
            checkInformation("Login1_1", "fgekRvj73", "fgekRvj73");
            System.out.println("Ошибок нет");
        } catch (WrongLoginException loginException) {
            System.out.println("Обработали ошибку логина");
        } catch (WrongPasswordException passwordException) {
            System.out.println("Обработали ошибку пароля");
        }
    }
}