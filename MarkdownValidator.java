import java.util.regex.Pattern;

/**
 * The MarkdownValidator class provides functionality to validate if a given 
 * input string contains Markdown elements such as headers, lists, links, 
 * images, or code blocks. 
 * 
 * The validation is performed line by line using regular expressions 
 * to detect specific Markdown syntax patterns.
 * 
 * Example usage:
 * <pre>
 * String markdownInput = "# Header Example\nThis is a list:\n- Item 1\n- Item 2";
 * boolean isMarkdownValid = MarkdownValidator.execute(markdownInput);
 * System.out.println(isMarkdownValid); // Output: true
 * </pre>
 * 
 * Supported Markdown elements:
 * - Headers: Lines starting with `#` (1 to 6 levels).
 * - Lists: Unordered list items using `*`, `-`, or `+`.
 * - Links: Text wrapped in `[ ]` followed by a URL in `( )`.
 * - Images: Similar to links but start with `!`.
 * - Code blocks: Lines surrounded by triple backticks (` ``` `) or tildes (` ~~~ `).
 * 
 * @author phricardo.com
 * @version 1.0
 */
public class MarkdownValidator {

    private static final Pattern HEADER_PATTERN = Pattern.compile("^(#{1,6}\\s).+");
    private static final Pattern LIST_PATTERN = Pattern.compile("^(\\*|-|\\+)\\s.+");
    private static final Pattern LINK_PATTERN = Pattern.compile("\\[.+\\]\\(.+\\)");
    private static final Pattern IMAGE_PATTERN = Pattern.compile("!\\[.*\\]\\(.+\\)");
    private static final Pattern CODE_BLOCK_PATTERN = Pattern.compile("(`{3,}|~{3,}).+");

    /**
     * Validates whether the given input string contains any recognizable Markdown syntax.
     *
     * @param input the input string to validate; can contain multiple lines of text.
     * @return true if the input contains valid Markdown elements, false otherwise.
     */
    public static boolean execute(final String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        String[] lines = input.split("\n");

        for (String line : lines) {
            if (HEADER_PATTERN.matcher(line).find() ||
                LIST_PATTERN.matcher(line).find() ||
                LINK_PATTERN.matcher(line).find() ||
                IMAGE_PATTERN.matcher(line).find() ||
                CODE_BLOCK_PATTERN.matcher(line).find()) {
                return true;
            }
        }

        return false;
    }
}
