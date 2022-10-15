import java.net.URI;
import java.util.ArrayList;
import java.util.List;

class QueryHandler implements URLHandler {

    List<String> s = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Number: %d", s.size());
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if ("s".equals(parameters[0])) {
                    s.add(parameters[1]);
                    return String.format("List add %s!", parameters[1]);
                }
            }else if (url.getPath().contains("/search")){
                String[] parameters = url.getQuery().split("=");
                String returnS = "";
                if ("s".equals(parameters[0])){
                    for (String s1 : s) {
                        if(s1.contains(parameters[1])){
                            returnS += (" AND "+s1);
                        }
                    }
                }
                if (returnS.startsWith(" AND ")){
                    returnS = returnS.substring(5);
                }
                return String.format("List is %s!", returnS);
            }
            return "404 Not Found!";
        }
    }
}
