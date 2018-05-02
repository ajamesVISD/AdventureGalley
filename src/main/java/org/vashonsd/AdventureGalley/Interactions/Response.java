package org.vashonsd.AdventureGalley.Interactions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 5/1/18.
 */
public class Response {
    private String text;
    private boolean keepAlive;
    private List<Actor> payload;

    public Response(String text, boolean keepAlive) {
        this.text = text;
        this.keepAlive = keepAlive;
        payload = new ArrayList<Actor>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public void addToPayload(Actor a) {
        payload.add(a);
    }
}
