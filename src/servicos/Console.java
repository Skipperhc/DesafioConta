package servicos;

/**
 * An easy interface to read numbers and strings from
 * standard input
 *
 * @author Cay Horstmann
 * @version 1.10 10 Mar 1997
 */

public class Console {
    /**
     * print a prompt on the console but don't print a newline
     *
     * @param prompt the prompt string to display
     */

    public static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }

    /**
     * read a string from the console. The string is
     * terminated by a newline
     *
     * @return the input string (without the newline)
     */

    public static String readLine() {
        int ch;
        String r = "";
        boolean done = false;
        while (!done) {
            try {
                ch = System.in.read();
                if (ch < 0 || (char) ch == '\n')
                    done = true;
                else if ((char) ch != '\r') // weird--it used to do \r\n translation
                    r = r + (char) ch;
            } catch (java.io.IOException e) {
                done = true;
            }
        }
        return r;
    }

    /**
     * read a string from the console. The string is
     * terminated by a newline
     *
     * @param prompt the prompt string to display
     * @return the input string (without the newline)
     */

    public static String readLine(String prompt) {
        return readLine();
    }

    /**
     * read an integer from the console. The input is
     * terminated by a newline
     *
     * @param prompt the prompt string to display
     * @return the input value as an int
     * @throws NumberFormatException if bad input
     */

    public static int readInt() {
        while (true) {
            try {
                return Integer.valueOf
                        (readLine().trim()).intValue();
            } catch (NumberFormatException e) {
                System.out.println
                        ("Não deu certo, tente de novo!");
            }
        }
    }

    /**
     * read a floating point number from the console.
     * The input is terminated by a newline
     *
     * @param prompt the prompt string to display
     * @return the input value as a double
     * @throws NumberFormatException if bad input
     */

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println
                        ("Não deu certo, tente de novo!");
            }
        }
    }

    public static float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println
                        ("Não deu certo, tente de novo!");
            }
        }
    }
}