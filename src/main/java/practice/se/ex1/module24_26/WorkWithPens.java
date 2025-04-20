package practice.se.ex1.module24_26;

public class WorkWithPens {
    private Pencil pencil;
    private InkBrush inkBrush;

    public Pencil getPencil() {
        return pencil;
    }

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }

    public InkBrush getInkBrush() {
        return inkBrush;
    }

    public void setInkBrush(InkBrush inkBrush) {
        this.inkBrush = inkBrush;
    }

    public void writeWithPencil() {
        pencil.write();
    }

    public void writeWithInkBrush() {
        inkBrush.write();
    }
}
