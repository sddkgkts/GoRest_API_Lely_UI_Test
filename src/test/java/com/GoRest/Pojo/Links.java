
package com.GoRest.Pojo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Links {

    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("current")
    @Expose
    private String current;
    @SerializedName("next")
    @Expose
    private String next;

    /**
     * No args constructor for use in serialization
     */
    public Links() {
    }

    /**
     * @param next
     * @param current
     * @param previous
     */
    public Links(Object previous, String current, String next) {
        super();
        this.previous = previous;
        this.current = current;
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Links withPrevious(Object previous) {
        this.previous = previous;
        return this;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public Links withCurrent(String current) {
        this.current = current;
        return this;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Links withNext(String next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Links.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("previous");
        sb.append('=');
        sb.append(((this.previous == null) ? "<null>" : this.previous));
        sb.append(',');
        sb.append("current");
        sb.append('=');
        sb.append(((this.current == null) ? "<null>" : this.current));
        sb.append(',');
        sb.append("next");
        sb.append('=');
        sb.append(((this.next == null) ? "<null>" : this.next));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.next == null) ? 0 : this.next.hashCode()));
        result = ((result * 31) + ((this.current == null) ? 0 : this.current.hashCode()));
        result = ((result * 31) + ((this.previous == null) ? 0 : this.previous.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return ((((this.next == rhs.next) || ((this.next != null) && this.next.equals(rhs.next))) && ((this.current == rhs.current) || ((this.current != null) && this.current.equals(rhs.current)))) && ((this.previous == rhs.previous) || ((this.previous != null) && this.previous.equals(rhs.previous))));
    }

}
