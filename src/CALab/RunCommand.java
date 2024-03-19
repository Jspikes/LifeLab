package CALab;

import mvc.Command;
import mvc.Model;

public class RunCommand extends Command {

    int cycles;
    public RunCommand(int cycles){
        this.cycles = cycles;
    }
    public void execute(Model model){
        Grid grid = (Grid) model;
        grid.updateLoop(cycles);
    }
}
