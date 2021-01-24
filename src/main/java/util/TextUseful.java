package util;

public class TextUseful {
    public static boolean validateTextSize(String text, int maxLength){
        return (text.length() <= maxLength && text.length() > 0);
    }
}
