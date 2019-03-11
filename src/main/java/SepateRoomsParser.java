public class SepateRoomsParser implements Parser {

    public String[] parse(String strToParse, int separatorIndex) {
        String[] parsedElements = new String[3];
        parsedElements[0] = strToParse.substring(0,separatorIndex);
        parsedElements[1] = strToParse.substring(separatorIndex,separatorIndex+1);
        parsedElements[2] = strToParse.substring(separatorIndex+1);
        return parsedElements;
    }
}
