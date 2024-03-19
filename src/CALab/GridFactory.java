package CALab;

import mvc.*;

public class GridFactory implements AppFactory {

    @Override
    public Grid makeModel() {
        return null; //override me!
    }

    @Override
    public View makeView() {
        return new GridView(this.makeModel());
    }

    @Override
    public String getTitle() {
        return "Grid";
    }

    @Override
    public String[] getHelp() {
        String[] help = new String[4];
        help[0] = "Run1: Run a single iteration of the grid application.";
        help[1] = "Run50: Run 50 iterations of the grid application.";
        help[2] = "Populate: Randomly populate the grid with cells";
        help[3] = "Clear: Clear the grid, setting all cell statuses to 0";
        return help;
    }

    @Override
    public String about() {
        return "Spikes/Nassimi Softworks, 2024";
    }

    @Override
    public String[] getEditCommands() {
        String[] editCommands = new String[4];
        editCommands[0] = "Run 1";
        editCommands[1] = "Run 50";
        editCommands[2] = "Populate";
        editCommands[3] = "Clear";
        return editCommands;
    }

    @Override
    public Command makeEditCommand(String name) {
        return null;
    }
}
