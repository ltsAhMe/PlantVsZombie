package org.ltsAhMe.pvz.System.Audio.Music;

import jouvieje.bass.defines.BASS_MUSIC;
import jouvieje.bass.defines.BASS_POS;
import jouvieje.bass.structures.HMUSIC;
import org.ltsAhMe.pvz.PlantVsZombie;

import java.io.File;

import static jouvieje.bass.Bass.*;
public enum MusicEnum {

    Pack1Music(0),
    chooseYourPlant(122),
    MainPlantVsZombe(152);

    int pos;
    static HMUSIC hmusic;

    MusicEnum(int where){
        pos = where;
    }

    public void setPos(){
        BASS_ChannelSetPosition(hmusic.asInt(),pos, BASS_POS.BASS_POS_MUSIC_ORDER);
    }
    public static void play(){
        BASS_ChannelPlay(hmusic.asInt(), false);
    }
    public static void stop(){
        BASS_ChannelStop(hmusic.asInt());
    }

    public static void init(){

       hmusic = BASS_MusicLoad(false,PlantVsZombie.gameResDir+"sounds/mainmusic.mo3" ,0,0, BASS_MUSIC.BASS_MUSIC_RAMPS,0);
    }
}
