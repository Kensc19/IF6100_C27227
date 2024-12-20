package ucr.ac.tarea_C27227.room.api.response;

import java.util.List;

public class JoinRoomResponse {
    private String id;
    private String name;
    private List<String> users;


    public JoinRoomResponse(String id, String name, List<String> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
