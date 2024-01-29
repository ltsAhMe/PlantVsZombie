package org.ltsAhMe.pvz.Rander.Room;

import org.ltsAhMe.pvz.gamePack.rooms.gameUI.GameLoading;
import org.ltsAhMe.pvz.gamePack.rooms.gameUI.MainMenu;
import org.ltsAhMe.pvz.gamePack.rooms.gameUI.popconImg;

public class RoomMana {
   public static int nowRoom=0;
    static BaseRoom[] rooms = new BaseRoom[10];

    public static void init(){
        a(new popconImg());
        a(new GameLoading());
        a(new MainMenu());
    }
    public static void Rander(){
        if (rooms[nowRoom].Done){
            if (rooms[nowRoom].nextRoom == -1){
                nowRoom++;
            }else {
                nowRoom = rooms[nowRoom].nextRoom;
            }
        }
        rooms[nowRoom].Rander();
    }

    private static void a(BaseRoom room){
        rooms[getNull()] = room;
    }
    private static int getNull(){
        for (int i=0;i<rooms.length;i++){
            if (rooms[i] == null){
                return i;
            }
        }
        return rooms.length;
    }
}
