package org.ltsAhMe.pvz.System.Audio.sound;
import jouvieje.bass.defines.BASS_STREAM.*;
import static jouvieje.bass.Bass.*;
import jouvieje.bass.structures.HSTREAM;
import org.ltsAhMe.pvz.PlantVsZombie;

public enum SoundEnum {
    gravestonerumb("gravestone_rumble.ogg"),
    tap2("tap2.ogg"),
    tap("tap.ogg");
    HSTREAM hstream;
    SoundEnum(String name){
        hstream = BASS_StreamCreateFile(false,PlantVsZombie.gameResDir+"sounds/"+name,0,0,0);
    }

    public void play(){
        BASS_ChannelPlay(hstream.asInt(),false);
    }
    public void stop(){
        BASS_ChannelStop(hstream.asInt());
    }

}
