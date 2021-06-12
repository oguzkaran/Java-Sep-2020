/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Character.isWhitespace;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static java.lang.Character.isLetter;

public final class StringUtil {
    private static final String ALPHABET_LOWER_TR;
    private static final String ALPHABET_LOWER_EN;
    private static final String ALPHABET_TR;
    private static final String ALPHABET_EN;

    static {
        ALPHABET_LOWER_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
        ALPHABET_LOWER_EN = "abcdefghijklmnopqrstuvwxyz";
        ALPHABET_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ" + ALPHABET_LOWER_TR;
        ALPHABET_EN = "ABCDEFGHIJKLMNOPQRSTUWXVYZ" + ALPHABET_LOWER_EN;
    }

    private StringUtil()
    {
    }

    public static String capitalize(String s)
    {
        return s.isEmpty() ? s : toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String changeCase(String s)
    {
        char [] c = new char[s.length()];

        for (int i = 0; i < c.length; ++i) {
            char ch = s.charAt(i);

            c[i] = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
        }

        return String.valueOf(c);
    }

    public static int countString(String s1, String s2)
    {
        int count = 0;

        for (int index = -1; (index = s1.indexOf(s2, index + 1)) != -1; ++count)
            ;

        return count;
    }

    public static int countStringIgnoreCase(String s1, String s2)
    {
        return countString(s1.toLowerCase(), s2.toLowerCase());
    }

    public static String getLetters(String s)
    {
        String str = "";
        int length = s.length();


        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);

            if (isLetter(c))
                str += c;
        }

        return str;
    }

    public static String getLongestPalindrome(String text)
    {
        String result = "";

        int end = text.length();

        while (end != 0) {
            int begin = 0;

            while (begin != end) {
                String str = text.substring(begin++, end);

                if (str.length() > 1 && isPalindrome(str) && str.length() > result.length())
                    result = str;
            }

            --end;
        }

        return result;
    }

    public static String getRandomText(Random r, int n, String sourceText)
    {
        int length = sourceText.length();
        char [] c = new char[n];

        for (int i = 0; i < n; ++i)
            c[i] = sourceText.charAt(r.nextInt(length));

        return String.valueOf(c);
    }

    public static String getRandomTextTR(Random r, int n)
    {
        return getRandomText(r, n, ALPHABET_TR);
    }

    public static String getRandomTextTR(int n)
    {
        return getRandomTextTR(new Random(), n);
    }

    public static String [] getRandomTextsTR(Random r, int n, int minLength, int maxLength)
    {
        String [] texts = new String[n];

        for (int i = 0; i < n; ++i)
            texts[i] = getRandomTextTR(r, r.nextInt(maxLength - minLength) + minLength);

        return texts;
    }

    public static String getRandomTextEN(Random r, int n)
    {
        return getRandomText(r, n, ALPHABET_EN);
    }

    public static String getRandomTextEN(int n)
    {
        return getRandomTextEN(new Random(), n);
    }

    public static String [] getRandomTextsEN(Random r, int n, int minLength, int maxLength)
    {
        String [] texts = new String[n];

        for (int i = 0; i < n; ++i)
            texts[i] = getRandomTextEN(r, r.nextInt(maxLength - minLength) + minLength);

        return texts;
    }

    public static boolean isJavaIdentifier(String s)
    {
        if (s.equals("_"))
            return false; //Java 9 ve sonrası için kdeğişken kontrolü

        if (s.isBlank())
            return false;

        char ch = s.charAt(0);

        if (!Character.isJavaIdentifierStart(ch))
            return false;

        int length = s.length();

        for (int i = 1; i < length; ++i)
            if (!Character.isJavaIdentifierPart(s.charAt(i)))
                return false;

        return true;
    }

    public static boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char cLeft = toLowerCase(s.charAt(left));

            if (!isLetter(cLeft)) {
                ++left;
                continue;
            }

            char cRight = toLowerCase(s.charAt(right));

            if (!isLetter(cRight)) {
                --right;
                continue;
            }

            if (cLeft != cRight)
                return false;

            ++left;
            --right;
        }

        return true;
    }

    public static boolean isPangram(String text, String alphabet)
    {
        int length = alphabet.length();

        for (int i = 0; i < length; ++i)
            if (text.indexOf(alphabet.charAt(i)) == -1)
                return false;

        return true;
    }

    public static boolean isPangramEN(String s)
    {
        return isPangram(s.toLowerCase(), ALPHABET_LOWER_EN);
    }

    public static boolean isPangramTR(String s)
    {
        return isPangram(s.toLowerCase(), ALPHABET_LOWER_TR);
    }

    public static String join(ArrayList<String> list, String sep)
    {
        return join(list, 0, sep);
    }

    public static String join(ArrayList<String>  list, char sep)
    {
        return join(list, 0, sep);
    }

    public static String join(ArrayList<String>  list, int startIndex, char sep)
    {
        return join(list, startIndex, sep + "");
    }

    public static String join(ArrayList<String>  list, int startIndex, String sep)
    {
        String result = "";

        int size = list.size();

        for (int i = 0; i < size; ++i) {
            if (!result.isEmpty())
                result += sep;

            result += list.get(i);
        }

        return result;
    }

    public static String join(String [] str, char sep)
    {
        return join(str, 0, sep);
    }

    public static String join(String [] str, int startIndex, char sep)
    {
        return join(str, startIndex, sep + "");
    }

    public static String join(String [] str, int startIndex, String sep)
    {
        String result = "";

        int length = str.length;

        for (int i = startIndex; i < length; ++i) {
            if (!result.isEmpty())
                result += sep;

            result += str[i];
        }

        return result;
    }

    public static String join(String [] str, String sep)
    {
       return join(str, 0, sep);
    }

    public static String padLeading(String s, int length, char ch)
    {
        return length <= s.length() ? s : (ch + "").repeat(length - s.length()) + s;
    }

    public static String padLeading(String s, int length)
    {
        return padLeading(s, length, ' ');
    }

    public static String padTrailing(String s, int length, char ch)
    {
        return length <= s.length() ? s : s + (ch + "").repeat(length - s.length());
    }

    public static String padTrailing(String s, int length)
    {
        return padTrailing(s, length, ' ');
    }

    public static String removeWhiteSpaces(String s)
    {
        int length = s.length();
        String str = "";

        for (int i = 0; i < length; ++i) {
            char ch = s.charAt(i);

            if (!isWhitespace(ch))
                str += ch;
        }

        return str;
    }

    public static String reverse(String s)
    {
        char [] c = s.toCharArray();

        ArrayUtil.reverse(c);

        return String.valueOf(c);
    }

    public static String squeeze(String s1, String s2)
    {
        String str = "";
        int length = s1.length();

        for (int i = 0; i < length; ++i) {
            char ch = s1.charAt(i);
            if (!s2.contains(ch + ""))
                str += ch;
        }

        return str;
    }

    public static String trimLeading(String s)
    {
        int i;
        int length = s.length();

        for (i = 0; i < length && isWhitespace(s.charAt(i)); ++i)
            ;

        return s.substring(i);
    }

    public static String trimTrailing(String s)
    {
        int i;

        for (i = s.length() - 1; i >= 0 && isWhitespace(s.charAt(i)); --i)
            ;

        return s.substring(0, i + 1);
    }

    public static String wrapWith(String str, char ch)
    {
        return wrapWith(str, ch, false);
    }

    public static String wrapWith(String str, char ch, boolean trim)
    {
        return wrapWith(str, ch, ch, trim);
    }

    public static String wrapWith(String str, char chBegin, char chEnd)
    {
        return wrapWith(str, chBegin, chEnd, false);
    }

    public static String wrapWith(String str, char chBegin, char chEnd, boolean trim)
    {
        return String.format("%c%s%c", chBegin, trim ? str.trim() : str, chEnd);
    }


}
