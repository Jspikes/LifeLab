package CALab;

import mvc.Command;
import mvc.Model;

public class ClearCommand extends Command {
    public void execute(Model model) {
        Grid grid = (Grid) model;
        grid.repopulate(false);
    }
}
