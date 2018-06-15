package org.vashonsd.AdventureGalley;

import org.vashonsd.AdventureGalley.Interactions.Actor;

/**
 * The Response class is sent back from the dispatch() method, and is mostly used to indicate if the Actor
 * that is handling the Message should continue to be the target of the raw input.
 */
public class Response {

    boolean persist;
    String text;
    Actor receiver;

    public Response(String text) {
        persist = false;
        this.text = text;
    }

    public Response(boolean persist, String text) {
        this.persist = persist;
        this.text = text;
    }

    public boolean isPersist() {
        return persist;
    }

    public void setPersist(boolean persist) {
        this.persist = persist;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Actor getReceiver() {
        return receiver;
    }

    public void setReceiver(Actor receiver) {
        this.receiver = receiver;
    }
}
