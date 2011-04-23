package nz.artedungeon.common;

import com.rsbuddy.event.events.MessageEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Taylor
 * Date: 4/23/11
 * Time: 4:17 PM
 * Package: nz.artedungeon.common;
 */
public abstract class PuzzlePlugin extends Plugin
{
    protected boolean canSolve = true;
    protected boolean solved;

    public abstract String getStatus();

    public abstract boolean isValid();

    public abstract String getAuthor();

    public abstract String getName();

    public abstract int loop();

    /**
     * Is puzzle possible to be completed
     *
     * @return boolean true if possible
     */
    public boolean isPossible() {
        return canSolve;
    }

    /**
     * Is puzzle solved
     *
     * @return boolean true if solved
     */
    public boolean isSolved() {
        return solved;
    }

    public void messageReceived(MessageEvent messageEvent) {
        String txt = messageEvent.getMessage();
        if (txt.contains("You need a"))
            canSolve = false;
        else if (txt.contains("hear a click") ||
                 txt.contains("now unlocked") ||
                 txt.contains("act of simply") ||
                 txt.contains("challenge room has already"))
            solved = true;

    }
}