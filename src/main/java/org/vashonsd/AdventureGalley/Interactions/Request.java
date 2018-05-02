package org.vashonsd.AdventureGalley.Interactions;

/**
 * Created by andy on 5/1/18.
 */
public class Request {
    private String text;
    private String verb;

    public Request(String text, String verb) {
        this.text = text;
        this.verb = verb;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }
}
