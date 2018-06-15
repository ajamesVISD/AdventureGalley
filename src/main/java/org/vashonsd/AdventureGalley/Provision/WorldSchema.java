package org.vashonsd.AdventureGalley.Provision;

import java.util.*;

public class WorldSchema {

    ArrayList rooms;
    ArrayList map;
    Properties properties;
    List<TraversalSchema> traversalSchemas;

    public WorldSchema() {
        rooms = new ArrayList<RoomSchema>();
        traversalSchemas = new ArrayList<>();
    }

    public List<RoomSchema> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList rooms) {
        this.rooms = rooms;
    }

    public ArrayList<TraversalSchema> getMap() {
        return map;
    }

    public void setMap(ArrayList map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Map properties) {
        Properties p = new Properties();
        p.putAll(properties);
        this.properties = p;
    }

    public List<TraversalSchema> getTraversalSchemas() {
        return traversalSchemas;
    }

    public void setTraversalSchemas(List<TraversalSchema> traversalSchemas) {
        this.traversalSchemas = traversalSchemas;
    }

    public void deserialize() {
        ArrayList<RoomSchema> newRooms = new ArrayList<>();
        for(Map room : (List<Map>)rooms) {
            RoomSchema rs = new RoomSchema();
            rs.setDescription((String)room.get("description"));
            rs.setName((String)room.get("name"));
            rs.setUuid((String)room.get("uuid"));
            if(room.containsKey("items")) {
                for (Map item : (List<Map>) room.get("items")) {
                    ItemSchema is = new ItemSchema();
                    is.setTypeName((String) item.get("name"));
                    if (item.containsKey("splash")) {
                        is.setSplash((String) item.get("splash"));
                    }
                    if (item.containsKey("receiver")) {
                        is.setReceiver((Boolean) item.get("receiver"));
                    }
                    if (item.containsKey("visible")) {
                        is.setVisibility((Boolean) item.get("visisble"));
                    }
                    if (item.containsKey("type")) {
                        is.setType((String) item.get("type"));
                    }
                    rs.items.add(is);
                }
            }
            newRooms.add(rs);
        }
        rooms = newRooms;
        for(Map startRoom : (List<Map>)map) {
            for(Map connectedRoom : (List<Map>)startRoom.get("connected")) {
                TraversalSchema traversalSchema = new TraversalSchema(
                        (String)startRoom.get("name"),
                        (String)connectedRoom.get("room"));
                if (connectedRoom.containsKey("direction")) {
                    traversalSchema.setDirection((String)connectedRoom.get("direction"));
                }
                if (connectedRoom.containsKey("description")) {
                    traversalSchema.setDescription((String)connectedRoom.get("description"));
                }
                if (connectedRoom.containsKey("splash")) {
                    traversalSchema.setSplash((String)connectedRoom.get("splash"));
                }
                traversalSchemas.add(traversalSchema);
            }
        }
    }

    public class RoomSchema {
        String name;
        String uuid;
        String description;
        List<ItemSchema> items;

        public RoomSchema() {
            items = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<ItemSchema> getItems() {
            return items;
        }

        public void setItems(ArrayList items) {
            this.items = items;
        }
    }

    public class ItemSchema {
        private String typeName;
        private String splash;
        private boolean visibility = true;
        private boolean receiver = true;
        private String type;

        public ItemSchema() {
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getSplash() {
            return splash;
        }

        public void setSplash(String splash) {
            this.splash = splash;
        }

        public boolean isVisibility() {
            return visibility;
        }

        public void setVisibility(boolean visibility) {
            this.visibility = visibility;
        }

        public boolean isReceiver() {
            return receiver;
        }

        public void setReceiver(boolean receiver) {
            this.receiver = receiver;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public class TraversalSchema {
        private String startingRoom;
        private String toRoom;
        private String direction;
        private String description;
        private String splash;

        public TraversalSchema(String startingRoom, String toRoom) {
            this.startingRoom = startingRoom;
            this.toRoom = toRoom;
        }

        public TraversalSchema(String startingRoom, String toRoom, String direction, String description, String splash) {
            this.startingRoom = startingRoom;
            this.toRoom = toRoom;
            this.direction = direction;
            this.description = description;
            this.splash = splash;
        }

        public String getStartingRoom() {
            return startingRoom;
        }

        public void setStartingRoom(String startingRoom) {
            this.startingRoom = startingRoom;
        }

        public String getToRoom() {
            return toRoom;
        }

        public void setToRoom(String toRoom) {
            this.toRoom = toRoom;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSplash() {
            return splash;
        }

        public void setSplash(String splash) {
            this.splash = splash;
        }
    }
}
