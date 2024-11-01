package model;

public abstract class Composition implements IComposition {
    protected String Title;

    public Composition(String title){
        this.Title = title;
    }

    public Composition(){}
    @Override
    public boolean isTitle(String title) {
        return !title.isEmpty();
    }

    public String getTitle() {
        return Title;
    }
}
