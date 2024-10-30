package exception;

public class AlreadyRequestingException extends Exception {
	private static final long serialVersionUID = 1L;

	public AlreadyRequestingException() {
		super("이미 심사 중입니다.");
	}
}
