package CALab;

import mvc.Command;
import mvc.Model;

public class PopulateCommand extends Command {

    boolean randomly;
    public PopulateCommand(boolean randomly){
        this.randomly = randomly;
    }
    public void execute(Model model){
        Grid grid = (Grid) model;
        grid.populate(randomly);
    }
}
