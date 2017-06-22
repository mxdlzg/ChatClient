package entity;

/**
 * Created by 廷江 on 2017/6/22.
 */
public class Person {
    private String user;
    private int index;
    private boolean selected;

    public Person() {
    }

    public Person(String user, int index) {
        this.user = user;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getUser() {
        return user;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

