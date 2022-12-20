package q4;

import java.util.ArrayList;

class Event {
    String name, detail, ownerName;
    long typeId;

    public Event(String name, String detail, String ownerName, long typeId) {
        this.name = name;
        this.detail = detail;
        this.ownerName = ownerName;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}

class EventType {
    long id;
    String name;

    public EventType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EventTypeDoesNotExistsException extends Exception {
    public EventTypeDoesNotExistsException(String message) {
        super(message);
    }
}

public class q4 {
    public static Boolean isValid(long typeId, ArrayList<EventType> typeList) throws Exception {
        boolean f = false;
        for (EventType i : typeList) {
            if (i.id == typeId) {
                f = true;
            }
        }
        if (f)
            return true;
        throw new EventTypeDoesNotExistsException("No event type available with the given id");
    }

    public static void main(String[] args) {
        EventType e1 = new EventType(1,"Stage event");
        EventType e2 = new EventType(2, "Exhibition");
        EventType e3 = new EventType(3, "Sports meet");
        ArrayList<EventType> typeList = new ArrayList<EventType>(3);
        typeList.add(e1);
        typeList.add(e2);
        typeList.add(e3);
    }
}
