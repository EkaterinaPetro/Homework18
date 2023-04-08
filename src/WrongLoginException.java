public class WrongLoginException extends RuntimeException {
    public WrongLoginException() {
        super("Неверный логин");
    }
}
