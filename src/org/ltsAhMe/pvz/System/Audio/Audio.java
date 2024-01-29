package org.ltsAhMe.pvz.System.Audio;
import jouvieje.bass.BassInit;
import jouvieje.bass.structures.HMUSIC;
import org.ltsAhMe.pvz.System.Audio.Music.MusicEnum;


import java.io.File;

import static jouvieje.bass.Bass.*;
import static jouvieje.bass.defines.BASS_MUSIC.BASS_MUSIC_RAMPS;


public class Audio {
    public static void init() {
        BassInit.loadLibraries();
        BASS_Init(-1, 44100, 0, null, null);
        MusicEnum.init();
    }

}
