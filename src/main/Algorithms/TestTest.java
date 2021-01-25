import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestTest {


    public static void main(String[] args) {
        List<String> string = justifiedText();
        string.forEach(System.out::println);
    }
    public static List<String> justifiedText() {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxChar = 16;

        List<StringBuilder> justifiedText = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            //position of next word
            int last = index + 1;
            //greedy check to see where we need to cut the line in words array
            while(last < words.length) {
                if (words[last].length() + count + 1 > maxChar) {
                    break;
                }
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder sb = new StringBuilder();
            // minus 1 the last word takes count over 15 chars due to break above
            int totalSpacesNeededForThisLine = last - index - 1;
            if (last == words.length || totalSpacesNeededForThisLine == 0) {
                for(int i= index; i<last; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() -1);
                // minus 1 because extra space will be added above
                for (int i = sb.length(); i < maxChar; i++) {
                    sb.append(" ");
                }
            } else {
                // the spaces needed in a space to justify it evenly
                int spaces = (maxChar - count) / totalSpacesNeededForThisLine;
                // remainder spaces if we can not even distribute it
                int remainder = (maxChar - count) % totalSpacesNeededForThisLine;

                for (int i = index; i< last; i++) {
                    sb.append(words[i]);
                    //if not the very last word on line...
                    if (i < last - 1) {
                        int maxSpacesInserted = spaces + (remainder-- > 0 ? 1 : 0);
                        for (int j=0; j<=maxSpacesInserted; j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            justifiedText.add(sb);
            index = last;

        }
        return justifiedText.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }
}
