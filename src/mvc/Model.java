package mvc;
import tools.Publisher;

public class Model extends Publisher{
    public void update(){
        notifySubscribers();
    }
}
