package service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.InputStream;

/**
 * Handles background and battle music playback.
 * Supports both file paths and classpath resources (recommended: WAV / PCM 16-bit).
 */
public final class MusicManager {
    private static Clip bgmClip;
    private static Clip battleClip;

    // ===== Public API =====

    /** Starts looping background music. */
    public static void startBgm(String path) {
        bgmClip = playLoop(path, bgmClip);
    }

    /** Stops the background music. */
    public static void stopBgm() {
        stopClip(bgmClip);
        bgmClip = null;
    }

    /** Starts looping battle music. */
    public static void startBattle(String path) {
        battleClip = playLoop(path, battleClip);
    }

    /** Stops the battle music. */
    public static void stopBattle() {
        stopClip(battleClip);
        battleClip = null;
    }

    /**
     * Switches from background music to battle music.
     * Stops the BGM, then starts the battle track.
     */
    public static void switchToBattle(String battlePath) {
        stopBgm();
        startBattle(battlePath);
    }

    /**
     * Switches from battle music back to background music.
     * Stops the battle track, then resumes the BGM.
     */
    public static void switchToBgm(String bgmPath) {
        stopBattle();
        startBgm(bgmPath);
    }

    /**
     * Adjusts the BGM volume.
     * Range: -80.0f (mute) to +6.0f (max)
     */
    public static void setBgmVolume(float db) {
        setVolume(bgmClip, db);
    }

    /**
     * Adjusts the battle music volume.
     * Range: -80.0f (mute) to +6.0f (max)
     */
    public static void setBattleVolume(float db) {
        setVolume(battleClip, db);
    }

    // ===== Internal Methods =====

    /** Plays a looping audio clip, closing the old one if necessary. */
    private static Clip playLoop(String pathOrRes, Clip old) {
        stopClip(old);
        try {
            AudioInputStream ais = openAudio(pathOrRes);
            if (ais == null) {
                System.err.println("Audio not found: " + pathOrRes);
                return null;
            }
            Clip c = AudioSystem.getClip();
            c.open(ais);
            c.loop(Clip.LOOP_CONTINUOUSLY);
            c.start();
            return c;
        } catch (Exception e) {
            System.err.println("Audio playback failed: " + e.getMessage());
            return null;
        }
    }

    /** Safely stops and closes an audio clip. */
    private static void stopClip(Clip c) {
        try {
            if (c != null) {
                c.stop();
                c.flush();
                c.close();
            }
        } catch (Exception ignore) {
        }
    }

    /** Sets the master volume (gain) of a clip. */
    private static void setVolume(Clip c, float db) {
        try {
            if (c != null && c.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                ((FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN)).setValue(db);
            }
        } catch (Exception ignore) {
        }
    }

    /**
     * Opens an audio input stream.
     * Supports either a direct file path or a classpath resource.
     */
    private static AudioInputStream openAudio(String pathOrRes) {
        try {
            File f = new File(pathOrRes);
            if (f.exists()) return AudioSystem.getAudioInputStream(f);
        } catch (Exception ignore) {
        }

        try {
            String p = pathOrRes.startsWith("/") ? pathOrRes : "/" + pathOrRes;
            InputStream in = MusicManager.class.getResourceAsStream(p);
            if (in != null) return AudioSystem.getAudioInputStream(in);
        } catch (Exception ignore) {
        }
        return null;
    }
}