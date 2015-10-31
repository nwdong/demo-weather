package test.weather.common;

/**
 * 
 * it's defined for customized exception information.
 * 
 * @author William Dong
 *
 */
public class AppException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

		public AppException(String message) {
	        super(message);
	    }

}
