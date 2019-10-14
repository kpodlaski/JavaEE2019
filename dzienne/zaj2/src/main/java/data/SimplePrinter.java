package data;

public class SimplePrinter {

    public String writeManyTimes(int howMany, String text){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<howMany; i++){
            sb.append(text);
            sb.append("<br/>");
        }
        return sb.toString();
    }
}
