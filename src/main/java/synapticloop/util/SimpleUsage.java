package synapticloop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleUsage {
	private static final String USAGE_TXT_UPPERCASE = "/USAGE.txt";
	private static final String HELP_TXT_UPPERCASE = "/HELP.txt";

	private static final String FATAL_COULD_NOT_FIND_USAGE = " [ FATAL ] Could not find the 'usage.txt' or 'USAGE.txt' on the classpath.\n  No instructions can be found.";
	private static final String FATAL_COULD_NOT_FIND_HELP = " [ FATAL ] Could not find the 'help.txt' or 'HELP.txt' on the classpath.\n  No instructions can be found.";

	/**
	 * Print out a message and then the usage instructions to the console.  If 
	 * the message is null, then it will not be printed.  This will look in the
	 * classpath for either a usage.txt or a USAGE.txt and print out the 
	 * contents.  If neither can be found, then a FATAL message will be printed
	 * to the console.
	 * 
	 * @param message The specific message to print to the console, or nothing if
	 *     null
	 * @param throwable A Throwable, which, if not null will will print out the 
	 *     stacktrace
	 */
	public static void usage(String message, Throwable throwable) {
		if(null != message) {
			System.out.println(String.format(" [ FATAL ] message was: %s", message));
		}

		if(null != throwable) {
			System.out.println("\n");
			throwable.printStackTrace();
			System.out.println("\n");
		}

		InputStream inputStream = SimpleUsage.class.getResourceAsStream(USAGE_TXT_UPPERCASE);
		if(null == inputStream) {
			inputStream = SimpleUsage.class.getResourceAsStream(USAGE_TXT_UPPERCASE.toLowerCase());
		}

		outputFile(inputStream, FATAL_COULD_NOT_FIND_USAGE);
	}

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
		usage(message, null);
	}


	/**
	 * Print out the instructional usage message.
	 */
	public static void usage() {
		usage(null, null);
	}

	public static void usage(Throwable throwable) {
		usage(null, throwable);
	}

	/**
	 * Print out the instructional usage message and System.exit with an exit 
	 * code of -1
	 */

	public static void usageAndExit() {
		usage(null, null);
		System.exit(-1);
	}

	public static void usageAndExit(Throwable throwable) {
		usage(null, throwable);
		System.exit(-1);
	}

	/**
	 * Print out the instructional usage message and System.exit with an exit 
	 * code of -1
	 * 
	 * @param message the message to print before the usage.txt
	 */
	public static void usageAndExit(String message) {
		usage(message, null);
		System.exit(-1);
	}

	public static void usageAndExit(String message, Throwable throwable) {
		usage(message, throwable);
		System.exit(-1);
	}

	/**
	 * Print out the instructional usage message and System.exit with the 
	 * provided exit code.
	 * 
	 * @param exitCode The exit code to System.exit with
	 */
	public static void usageAndExit(int exitCode) {
		usage(null, null);
		System.exit(exitCode);
	}

	public static void usageAndExit(int exitCode, Throwable throwable) {
		usage(null, throwable);
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
		usage(message, null);
		System.exit(exitCode);
	}

	public static void usageAndExit(String message, int exitCode, Throwable throwable) {
		usage(message, throwable);
		System.exit(exitCode);
	}

	/**
	 * Print out a message and then the help instructions to the console.  If 
	 * the message is null, then it will not be printed.  This will look in the
	 * classpath for either a help.txt or a USAGE.txt and print out the 
	 * contents.  If neither can be found, then a FATAL message will be printed
	 * to the console.
	 * 
	 * @param message The specific message to print to the console, or nothing if
	 *     null
	 * @param throwable A Throwable, which, if not null will will print out the 
	 *     stacktrace
	 */
	public static void help(String message, Throwable throwable) {
		if(null != message) {
			System.out.println(String.format(" [ FATAL ] message was: %s", message));
		} else {
			System.out.println(" [ FATAL ] error occurred:\n\n ");
		}
		if(null != throwable) {
			System.out.println("\nCaused by:\n");
			throwable.printStackTrace();
			System.out.println("\n");
		}

		InputStream inputStream = SimpleUsage.class.getResourceAsStream(HELP_TXT_UPPERCASE);
		if(null == inputStream) {
			inputStream = SimpleUsage.class.getResourceAsStream(HELP_TXT_UPPERCASE.toLowerCase());
		}

		outputFile(inputStream, FATAL_COULD_NOT_FIND_USAGE);
		outputFile(inputStream, FATAL_COULD_NOT_FIND_HELP);

	}

	/**
	 * Print out a message and then the help instructions to the console.  If 
	 * the message is null, then it will not be printed.  This will look in the
	 * classpath for either a help.txt or a USAGE.txt and print out the 
	 * contents.  If neither can be found, then a FATAL message will be printed
	 * to the console.
	 * 
	 * @param message The specific message to print to the console, or nothing if
	 * null
	 */
	public static void help(String message) {
		help(message, null);
	}


	/**
	 * Print out the instructional help message.
	 */
	public static void help() {
		help(null, null);
	}

	public static void help(Throwable throwable) {
		help(null, throwable);
	}

	/**
	 * Print out the instructional help message and System.exit with an exit 
	 * code of -1
	 */

	public static void helpAndExit() {
		help(null, null);
		System.exit(-1);
	}

	public static void helpAndExit(Throwable throwable) {
		help(null, throwable);
		System.exit(-1);
	}

	/**
	 * Print out the instructional help message and System.exit with an exit 
	 * code of -1
	 * 
	 * @param message the message to print before the help.txt
	 */
	public static void helpAndExit(String message) {
		help(message, null);
		System.exit(-1);
	}

	public static void helpAndExit(String message, Throwable throwable) {
		help(message, throwable);
		System.exit(-1);
	}

	/**
	 * Print out the instructional help message and System.exit with the 
	 * provided exit code.
	 * 
	 * @param exitCode The exit code to System.exit with
	 */
	public static void helpAndExit(int exitCode) {
		help(null, null);
		System.exit(exitCode);
	}

	public static void helpAndExit(int exitCode, Throwable throwable) {
		help(null, throwable);
		System.exit(exitCode);
	}

	/**
	 * Print out the passed in message and then the instructional help message 
	 * and System.exit with the provided exit code.
	 * 
	 * @param message the message to print before the help.txt
	 * @param exitCode The exit code to System.exit with
	 */
	public static void helpAndExit(String message, int exitCode) {
		help(message, null);
		System.exit(exitCode);
	}

	public static void helpAndExit(String message, int exitCode, Throwable throwable) {
		help(message, throwable);
		System.exit(exitCode);
	}

	private static void outputFile(InputStream inputStream, String errorMessage) {
		BufferedReader bufferedReader = null;

		if(null != inputStream) {
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			try {
				while((line = bufferedReader.readLine())  != null) {
					System.out.println(line);
				}
			} catch(IOException ex) {
				// do nothing
			} finally {
				if(null != bufferedReader) {
					try { bufferedReader.close(); } catch (IOException ex) { /* do nothing */}
				}
			}
		} else {
			// input stream is still null 
			System.out.println(errorMessage);
		}
	}

}
