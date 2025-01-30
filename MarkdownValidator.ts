export class MarkdownValidator {
    private static readonly HEADER_PATTERN = /^(#{1,6}\s).+/;
    private static readonly LIST_PATTERN = /^(\*|-|\+)\s.+/;
    private static readonly LINK_PATTERN = /\[.+\]\(.+\)/;
    private static readonly IMAGE_PATTERN = /!\[.*\]\(.+\)/;
    private static readonly CODE_BLOCK_PATTERN = /(`{3,}|~{3,}).+/;

    /**
     * Validates whether the given input string contains any recognizable Markdown syntax.
     *
     * @param input - The input string to validate; can contain multiple lines of text.
     * @returns true if the input contains valid Markdown elements, false otherwise.
     */
    public static execute(input: string): boolean {
        if (!input || input.trim() === "") {
            return false;
        }

        const lines = input.split("\n");

        for (const line of lines) {
            if (
                this.HEADER_PATTERN.test(line) ||
                this.LIST_PATTERN.test(line) ||
                this.LINK_PATTERN.test(line) ||
                this.IMAGE_PATTERN.test(line) ||
                this.CODE_BLOCK_PATTERN.test(line)
            ) {
                return true;
            }
        }

        return false;
    }
}
