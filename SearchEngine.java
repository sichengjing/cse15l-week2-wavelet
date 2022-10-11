import java.net.URI;

class SearchEngine implements NumberServer {
    ArrayList<String> arr = new ArrayList();
    ArrayList<String> ans = new ArrayList();

    public add(URI url){
        if (url.getPath().contains("/add?")) {
            String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                arr.add(parameters[1]);
            }
        }
    }
    
    public ArrayList search(URI url){
        if (url.getPath().contains("/search?")){
            String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                String sub = String.format(parameters[1]);
            }
            for(String s : arr){
                if(s.contains(sub)){
                    ans.add(s);
                }
                return ans;
            }
        }
    }
}