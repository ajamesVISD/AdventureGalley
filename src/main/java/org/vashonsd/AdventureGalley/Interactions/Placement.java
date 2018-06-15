package org.vashonsd.AdventureGalley.Interactions;

public class Placement {
    private Actor actor;
    private boolean visible;
    private boolean receiver;
    private String splash;

    public Placement(Actor actor, String splash, boolean visible, boolean receiver) {
        this.actor = actor;
        this.splash = splash;
        this.visible = visible;
        this.receiver = receiver;
    }

    public Placement(Actor actor) {
        this.actor = actor;
        this.splash = actor.getSplash();
        visible = true;
        receiver = true;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isReceiver() {
        return receiver;
    }

    public void setReceiver(boolean receiver) {
        this.receiver = receiver;
    }

    public String getSplash() {
        return splash;
    }

    public void setSplash(String splash) {
        this.splash = splash;
    }
}
