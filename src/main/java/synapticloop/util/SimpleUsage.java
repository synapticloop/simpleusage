package synapticloop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleUsage {
	private static final String USAGE_TXT_LOWERCASE = "/usage.txt";
	private static final String USAGE_TXT_UPPERCASE = "/USAGE.txt";

	private static final String FATAL_COULD_NOT_FIND_USAGE = "[ FATAL ] Could not find the 'usage.txt' or 'USAGE.txt' on the classpath.\n  No instructions can be found.";

	/**
	 * Print out a message and then the usage instructions to the console.  If 
	 * the message is null, then it will not be printed.  This will look in the
	 * classpath for either a usage.txt or a USAGE.txt and print out the 
	 * contents.  If neither can be found, then a FATAL message will be printed
	 * to the console.
	 * 
	 * @param message The specific message to print to the console, or nothing if
	 * null
	 */
	public static void usage(String message) {
		if(null != message) {
			System.out.println(message);
		}

		InputStream inputStream = SimpleUsage.class.getResourceAsStream(USAGE_TXT_LOWERCASE);
		if(null == inputStream) {
			inputStream = SimpleUsage.class.getResourceAsStream(USAGE_TXT_UPPERCASE);
		}

		BufferedReader bufferedReader = null;

		if(null != inputStream) {
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			try {
				while((line = bufferedReader.readLine())  != null) {
					System.out.println(line);
				}
			} catch(IOException ex) {
				System.out.println(FATAL_COULD_NOT_FIND_USAGE);
			} finally {
				if(null != bufferedReader) {
					try { bufferedReader.close(); } catch (IOException ex) { /* do nothing */}
				}
			}
		} else {
			// input stream is still null 
			System.out.println(FATAL_COULD_NOT_FIND_USAGE);
		}
	}

	/**
	 * Print out the instructional usage message.
	 */
	public static void usage() {
		usage(null);
	}

	/**
	 * Print out the instructional usage message and System.exit with an exit 
	 * code of -1
	 */
	
	public static void usageAndExit() {
		usage(null);
		System.exit(-1);
	}

	/**
	 * Print out the instructional usage message and System.exit with an exit 
	 * code of -1
	 * 
	 * @param message the message to print before the usage.txt
	 */
	public static void usageAndExit(String message) {
		usage(message);
		System.exit(-1);
	}

	/**
	 * Print out the instructional usage message and System.exit with the 
	 * provided exit code.
	 * 
	 * @param exitCode The exit code to System.exit with
	 */
	public static void usageAndExit(int exitCode) {
		usage(null);
		System.exit(exitCode);
	}

	/**
	 * Print out the passed in message and then the instructional usage message 
	 * and System.exit with the provided exit code.
	 * 
	 * @param message the message to print before the usage.txt
	 * @param exitCode The exit code to System.exit with
	 */
	public static void usageAndExit(String message, int exitCode) {
		usage(message);
		System.exit(exitCode);
	}

}
