package config;


public class InvalidMemberPasswordException extends MemberException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMemberPasswordException() {
    }

    public InvalidMemberPasswordException(String message) {
        super(message);
    }

    public InvalidMemberPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMemberPasswordException(Throwable cause) {
        super(cause);
    }
}
