package mvc;

public abstract class Command {
    public Model model;
    public abstract void execute(Model model);
}
